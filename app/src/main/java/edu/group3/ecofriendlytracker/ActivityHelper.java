package edu.group3.ecofriendlytracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author altaf
 */
public class ActivityHelper {
    public static Object[] activityToArray(Activity activity) {
        return new Object[] {activity.category(), activity.subCategory(), activity.specificCategory(), activity.calcMetric(), activity.emissionTotal()};
    }
    
    public static Form activityToForm(Activity activity) {
        Form form = new Form();
        form.category = activity.category();
        form.subCategory = activity.subCategory();
        form.specific = activity.specificCategory();
        form.calcMetric = activity.calcMetric();
        form.emissionTotal = activity.emissionTotal();
        
        return form;
    }
    
    public static Activity[] activityFromResultSet(ResultSet resultSet) throws SQLException {
        // Implementasi mengubah hasil query database ke object java, yaitu Activity array
        List<Activity> activityList = new ArrayList<>();
        while(resultSet.next()) {
            int activityId = resultSet.getInt("activity_id");
            String categoryName = resultSet.getString("category_name");
            String subCategoryName  = resultSet.getString("sub_category_name");
            String specificCatName = resultSet.getString("specific_cat_name");
            double calcMetric = resultSet.getDouble("calculation_metric");
            double emissionTotal = resultSet.getDouble("emission_total");
            LocalDate dateCreated = resultSet.getDate("date_created").toLocalDate();
            Activity activity = new Activity(
                    activityId,
                    categoryName,
                    subCategoryName,
                    specificCatName,
                    calcMetric,
                    emissionTotal,
                    dateCreated
            );
            activityList.add(activity);
        }
        
        return activityList.toArray(new Activity[activityList.size()]);
    }
}
