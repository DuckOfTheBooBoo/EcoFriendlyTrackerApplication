package edu.group3.ecofriendlytracker;

import java.sql.*;
import java.util.*;


import static java.lang.Class.forName;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kanda gtg
 */
public class DatabasesConnection {
    String host = "jdbc:mysql://localhost:3306/eftappdb";
    String username = "root";
    String password = "GoodTime221";

    Connection connection;

    // kalo kepake nantinya -k
    Statement statement;
    ResultSet resultSet;


//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//    }
    
    public Activity[] getActivitiesAWeek(LocalDate date) {
        // Get week range from date
        Activity[] activities = null;
        List<LocalDate> week = new ArrayList<>();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        
        int daysToMonday = (dayOfWeek.getValue() - DayOfWeek.MONDAY.getValue() + 7) % 7;
        
        LocalDate monday = date.minusDays(daysToMonday);
        
        for (int i = 0; i < 7; i++) {
            week.add(monday.plusDays(i));
        }
             
        String startDate = week.get(0).toString();
        String endDate = week.get(6).toString();
        
        String query = "CALL get_activities_week(?, ?);";
        
        ResultSet resultSet = null;
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            
            resultSet = statement.executeQuery();
            
            activities = ActivityHelper.activityFromResultSet(resultSet);
        } catch (SQLException e) {
            Logger.getLogger(DatabasesConnection.class.getName()).log(Level.SEVERE, null, e);              
        }
        return activities;
    }


    public List<String> getCategories() throws SQLException {
        List<String> categories = new ArrayList<>();
        String query = "SELECT category_name FROM category";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                categories.add(resultSet.getString("category_name"));
            }
        }
        return categories;
    }

    public List<String> getSubCategories(String category) throws SQLException {
        List<String> subCategories = new ArrayList<>();
            String query = "SELECT sc.sub_category_name " +
                    "FROM sub_category sc " +
                    "JOIN category c ON sc.category_id = c.category_id " +
                    "WHERE c.category_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    subCategories.add(resultSet.getString("sub_category_name"));
                }
            }
        }
        return subCategories;
    }

    public List<String> getSpecificOptions(String subCategory) throws SQLException {
        List<String> specificOptions = new ArrayList<>();
        String query = "SELECT specific_cat_name FROM specific_category " +
                "WHERE sub_category_id = (SELECT sub_category_id FROM sub_category WHERE sub_category_name = ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, subCategory);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    specificOptions.add(resultSet.getString("specific_cat_name"));
                }
            }
        }
        return specificOptions;
    }
    
    private int getCategoryId(String category) {
        int categoryId = 0;
        String query = String.format("SELECT get_category_id('%s') as category_id;", category);
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                categoryId = resultSet.getInt("category_id");
            }
        } catch (SQLException e) {
            Logger.getLogger(DatabasesConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return categoryId;
    }
    
    private int getSubCategoryId(String subCategory) {
        int subCategoryId = 0;
        String query = String.format("SELECT get_sub_category_id('%s') as sub_category_id;", subCategory);
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                subCategoryId = resultSet.getInt("sub_category_id");
            }
        } catch (SQLException e) {
            Logger.getLogger(DatabasesConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return subCategoryId;
    }
    
    private int getSpecificCategoryId(String specificCategory) {
        int specificCategoryId = 0;
        String query = String.format("SELECT get_category_id('%s') as specific_cat_id;", specificCategory);
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                specificCategoryId = resultSet.getInt("specific_cat_id");
            }
        } catch (SQLException e) {
            Logger.getLogger(DatabasesConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return specificCategoryId;
    }
    
    public boolean createNewTask(Form form) {
        int categoryId = getCategoryId(form.category);
        int subCategoryId = getSubCategoryId(form.subCategory);
        int specificCategoryId = getSpecificCategoryId(form.specific);
        
        String query = "INSERT INTO activity (category_id, sub_category_id, specific_cat_id, calculation_metric, emission_total) VALUES (?,?,?,?,?);";
        
        try(PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setInt(1, categoryId);
            statement.setInt(2, subCategoryId);
            statement.setInt(3, specificCategoryId);
            statement.setDouble(4, form.calcMetric);
            statement.setDouble(5, form.emissionTotal);
            statement.execute();
        } catch (SQLException e) {
            Logger.getLogger(DatabasesConnection.class.getName()).log(Level.SEVERE, null, e);   
            return false;
        }
        
        return true;
    }
    
    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(host, username, password);
    }

}
