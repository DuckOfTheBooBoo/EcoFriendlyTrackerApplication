package edu.group3.ecofriendlytracker;

/**
 *
 * @author altaf
 */
public class Form {
    public String category = "";
    public String subCategory = "";
    public String specific = "";
    public double calcMetric = 0.0;
    public double emissionTotal;
    
    public boolean validate() {
        if (category.isEmpty() || category.equals("-")) return false;
        if (subCategory.isEmpty() || subCategory.equals("-")) return false;
        if (specific.isEmpty() || specific.equals("-")) return false;
        if (calcMetric <= 0.0) return false;
        
        return true;
    }
    
    public void print() {
        System.out.println(String.format("%s %s %s %s", this.category, this.subCategory, this.specific, this.calcMetric));
    }
}
