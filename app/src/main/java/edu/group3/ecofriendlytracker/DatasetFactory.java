package edu.group3.ecofriendlytracker;

import java.time.LocalDate;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.util.HashMap;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

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
            String key = String.format("%s", activity.subCategory());
            emissionSummary.put(key, 0.0);
        }
        
        // Sum
        for(Activity activity : activities) {
            String key = String.format("%s", activity.subCategory());
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
    
    public static DefaultCategoryDataset dailyChartDataset(Activity[] activities, LocalDate date) {
        // Construct dataset untuk bar chart daily dengan date yang ditentukan
        HashMap<String, Double> dailyEmissionMap = new HashMap<>();
        double emissionTotal = 0.0;
        
        // Populate map
        for (Activity activity : activities) {
            if(activity.dateCreated().isEqual(date)) {
                dailyEmissionMap.put(activity.subCategory(), 0.0);
            }
        }
        
        for (Activity activity : activities) {
            if(activity.dateCreated().isEqual(date)) {
                emissionTotal += activity.emissionTotal();
                
                double emission = dailyEmissionMap.get(activity.subCategory());
                dailyEmissionMap.put(activity.subCategory(), emission + activity.emissionTotal());
            }
        }
        
        // Generate sum of emission produced           
        DefaultCategoryDataset dailyDataset = new DefaultCategoryDataset();
        dailyDataset.addValue(5.57, "Average Emission Per Capita in 2021", "Average Emission Per Capita in 2021");

        for(String key : dailyEmissionMap.keySet()) {
            double emission = dailyEmissionMap.get(key);
            dailyDataset.addValue(emission, key, date.toString());
        }
        
        return dailyDataset;
    }
}
