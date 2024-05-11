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
}
