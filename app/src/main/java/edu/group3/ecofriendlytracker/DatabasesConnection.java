package edu.group3.ecofriendlytracker;

import java.sql.*;
import java.util.*;


import static java.lang.Class.forName;

/**
 *
 * @author kanda gtg
 */
public class DatabasesConnection {
    String host = "jdbc:mysql://localhost:3306/eftappdb";
    String username = "root";
    String password = "";

    Connection connection;

    // kalo kepake nantinya -k
    Statement statement;
    ResultSet resultSet;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
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

    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(host, username, password);
    }

}
