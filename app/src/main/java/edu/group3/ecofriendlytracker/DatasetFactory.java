package edu.group3.ecofriendlytracker;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.util.HashMap;
import java.util.Date;

/**
 *
 * @author altaf
 */
public class DatasetFactory {
    public static DefaultPieDataset weeklyChartDataset(Activity[] activities) {
        // Classify
        HashMap<String, Double> emissionSummary = new HashMap<>();
        
        // Populate with empty values
        for(Activity activity : activities) {
            // Construct key
            String key = String.format("%s (%s)", activity.subCategory(), activity.specificCategory());
            emissionSummary.put(key, 0.0);
        }
        
        // Sum
        for(Activity activity : activities) {
            String key = String.format("%s (%s)", activity.subCategory(), activity.specificCategory());
            double emission = emissionSummary.get(key);
            emission += activity.emissionTotal();
            emissionSummary.put(key, emission);
        }
        
        DefaultPieDataset weeklyDataset = new DefaultPieDataset();
        for(String key : emissionSummary.keySet()) {
            weeklyDataset.setValue(key, emissionSummary.get(key));
        }
        
        return weeklyDataset;
    }
    
    public static DefaultCategoryDataset dailyChartDataset(Activity[] activities, Date date) {
        // Construct dataset untuk bar chart daily dengan date yang ditentukan
        return null; // Remove this
    }
}
