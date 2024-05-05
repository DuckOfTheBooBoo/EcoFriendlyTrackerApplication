package edu.group3.ecofriendlytracker;

/**
 *
 * @author altaf
 */
public class Form {
    public String category;
    public String subCategory;
    public String specific;
    public String additionalOption = "";
    public double calcMetric;
    
    public boolean validate() {
        if (category.isEmpty() || category.equals("-")) return false;
        if (subCategory.isEmpty() || subCategory.equals("-")) return false;
        if (specific.isEmpty() || specific.equals("-")) return false;
        if ((additionalOption.isEmpty() || additionalOption == null) && specific.contains("LPG")) return false;
        if (calcMetric < 0.0) return false;
        
        return true;
    }
}
