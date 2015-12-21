package com.rasulov.greeting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.ResourceBundle;

public class GreetingTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testMorningTimeRuLocale() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_ru", new Locale("ru", "RU"));
        Greeting.displayValues(resourceBundle, 7);
        Assert.assertTrue(outContent.toString().contains("Доброе утро, мир!"));
    }

    @Test
    public void testMorningTimeEnLocale() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_en", new Locale("en", "EN"));
        Greeting.displayValues(resourceBundle, 7);
        Assert.assertTrue(outContent.toString().contains("Good morning, World!"));
    }

    @Test
    public void testDayTimeRuLocale() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_ru", new Locale("ru", "RU"));
        Greeting.displayValues(resourceBundle, 11);
        Assert.assertTrue(outContent.toString().contains("Добрый день, мир!"));
    }

    @Test
    public void testDayTimeEnLocale() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_en", new Locale("en", "EN"));
        Greeting.displayValues(resourceBundle, 13);
        Assert.assertTrue(outContent.toString().contains("Good day, World!"));
    }

    @Test
    public void testEveningTimeRuLocale() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_ru", new Locale("ru", "RU"));
        Greeting.displayValues(resourceBundle, 19);
        Assert.assertTrue(outContent.toString().contains("Добрый вечер, мир!"));
    }

    @Test
    public void testEveningTimeEnLocale() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_en", new Locale("en", "EN"));
        Greeting.displayValues(resourceBundle, 21);
        Assert.assertTrue(outContent.toString().contains("Good evening, World!"));
    }

    @Test
    public void testNightTimeRuLocale() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_ru", new Locale("ru", "RU"));
        Greeting.displayValues(resourceBundle, 4);
        Assert.assertTrue(outContent.toString().contains("Доброй ночи, мир!"));
    }

    @Test
    public void testNightTimeEnLocale() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_en", new Locale("en", "EN"));
        Greeting.displayValues(resourceBundle, 23);
        Assert.assertTrue(outContent.toString().contains("Good night, World!"));
    }

    @Test
    public void testNightTimeEnLocaledFalse() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_en", new Locale("en", "EN"));
        Greeting.displayValues(resourceBundle, 4);
        Assert.assertFalse(outContent.toString().contains("Доброй ночи, мир!"));
    }

    @Test
    public void testDayTimeEnLocaleFalse() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_ru", new Locale("ru", "RU"));
        Greeting.displayValues(resourceBundle, 13);
        Assert.assertFalse(outContent.toString().contains("Good day, World!"));
    }
}
