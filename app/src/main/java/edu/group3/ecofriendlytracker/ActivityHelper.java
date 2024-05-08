package edu.group3.ecofriendlytracker;

/**
 *
 * @author altaf
 */
public class ActivityHelper {
    public static Object[] activityToArray(Activity activity) {
        return new Object[] {activity.category(), activity.subCategory(), activity.specificCategory(), activity.additionalOption(), activity.calcMetric(), activity.emissionTotal()};
    }
    
    public static Activity[] activityFromResultSet() {
        // Implementasi mengubah hasil query database ke object java, yaitu Activity array
        return null;
    }
}
