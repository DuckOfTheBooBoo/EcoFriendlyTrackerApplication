package edu.group3.ecofriendlytracker;

/**
 *
 * @author altaf
 */
public record Activity(
    int id, 
    String category, 
    String subCategory, 
    String specificCategory,
    double calcMetric, 
    double emissionTotal
) {}