package com.rasulov.greeting;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class Greeting {
    public static final String MORNING = "my.morning";
    public static final String DAY = "my.day";
    public static final String EVENING = "my.evening";
    public static final String NIGHT = "my.night";
    private static final String RESOURCE_LABEL = "label";


    public static void greetingService() {
        Locale defaultLocale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_LABEL, defaultLocale);
        displayValues(resourceBundle);
    }

    public static void displayValues(ResourceBundle bundle) {

        LocalTime time = LocalTime.now();
        int hour = time.getHour();

        if (hour >= 6 && hour < 9) {
            System.out.println(bundle.getString(MORNING));
        }
        if (hour >= 9 && hour < 19) {
            System.out.println(bundle.getString(DAY));
        }
        if (hour >= 19 && hour < 23) {
            System.out.println(bundle.getString(EVENING));
        }
        if (hour < 6 || hour == 23) {
            System.out.println(bundle.getString(NIGHT));
        }
    }
}

