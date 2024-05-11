package edu.group3.ecofriendlytracker;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author altaf
 */
public class DateHelper {
    public static List<LocalDate> getDaysOfWeek(LocalDate date) {
        List<LocalDate> week = new ArrayList<>();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        
        int daysToMonday = (dayOfWeek.getValue() - DayOfWeek.MONDAY.getValue() + 7) % 7;
        
        LocalDate monday = date.minusDays(daysToMonday);
        
        for (int i = 0; i < 7; i++) {
            week.add(monday.plusDays(i));
        }
        
        return week;
    }
    
    public static LocalDate getSundayFromPreviousWeek(LocalDate date) {
        // Return sunday of the previous week
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        // Check if date is sunday
        if(dayOfWeek.getValue() == DayOfWeek.SUNDAY.getValue()) {
            return date.minusDays(7);
        }
        
        int daysToMonday = (dayOfWeek.getValue() - DayOfWeek.MONDAY.getValue() + 7) % 7;        
        return date.minusDays(daysToMonday + 1);
    }
    
    public static LocalDate getMondayFromNextWeek(LocalDate date) {
        // Return monday of the next week
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        // Check if date is monday
        if(dayOfWeek.getValue() == DayOfWeek.MONDAY.getValue()) {
            return date.plusDays(7);
        }
        
        int daysToMonday = (DayOfWeek.MONDAY.getValue() - dayOfWeek.getValue() + 7) % 7;
        return date.plusDays(daysToMonday);
    }
}
