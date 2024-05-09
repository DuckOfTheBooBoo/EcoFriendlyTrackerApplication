package edu.group3.ecofriendlytracker;

import java.time.LocalDate;

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
    double emissionTotal,
    LocalDate dateCreated
) {}