package com.rasulov.greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class Greeting {

    static Logger logger = LoggerFactory.getLogger(Greeting.class);

    public static final String MORNING = "my.morning";
    public static final String DAY = "my.day";
    public static final String EVENING = "my.evening";
    public static final String NIGHT = "my.night";
    private static final String RESOURCE_LABEL = "label";

    public static void greetingService() {

        logger.info("Start project !!!");

        Locale defaultLocale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_LABEL, defaultLocale);

        logger.info("Setting default user locale. language = " + defaultLocale.getLanguage()
                + ", country = " + defaultLocale.getCountry());

        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        displayValues(resourceBundle, hour );
    }

    public static void displayValues(ResourceBundle bundle, int hour) {


        logger.info("using LocalTime get the current time to bring greetings. hour = " + hour);

        if (hour >= 6 && hour < 9) {
            System.out.println(bundle.getString(MORNING));
            logger.info("a message is received from the resource and posts\n" +
                    "displays text morning greetings!");
        }
        if (hour >= 9 && hour < 19) {
            System.out.println(bundle.getString(DAY));
            logger.info("a message is received from the resource and posts\n" +
                    "displays text day greetings!");
        }
        if (hour >= 19 && hour < 23) {
            System.out.println(bundle.getString(EVENING));
            logger.info("a message is received from the resource and posts\n" +
                    "displays text evening greetings!");
        }
        if (hour < 6 || hour == 23) {
            System.out.println(bundle.getString(NIGHT));
            logger.info("a message is received from the resource and posts\n" +
                    "displays text night greetings!");
        }

        logger.info("program is completed WITHOUT error !!!");
    }
}

