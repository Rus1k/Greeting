package com.rasulov.greeting;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.ResourceBundle;

public class GreetingTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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
    public void testMorningTimeRuLocale() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_ru", new Locale("ru", "RU"));
        Greeting.displayValues(resourceBundle, 7);
        Assert.assertTrue(outContent.toString().contains("Доброе утро, мир!"));
    }
    @Test
    public void testMorningTimeEnLocale() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_en", new Locale("en", "EN"));
        Greeting.displayValues(resourceBundle, 7);
        Assert.assertTrue(outContent.toString().contains("Good morning, World!"));
    }
    @Test
    public void testDayTimeRuLocale() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_ru", new Locale("ru", "RU"));
        Greeting.displayValues(resourceBundle, 11);
        Assert.assertTrue(outContent.toString().contains("Добрый день, мир!"));
    }
    @Test
    public void testDayTimeEnLocale() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_en", new Locale("en", "EN"));
        Greeting.displayValues(resourceBundle, 13);
        Assert.assertTrue(outContent.toString().contains("Good day, World!"));
    }
    @Test
    public void testEveningTimeRuLocale() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_ru", new Locale("ru", "RU"));
        Greeting.displayValues(resourceBundle, 19);
        Assert.assertTrue(outContent.toString().contains("Добрый вечер, мир!"));
    }
    @Test
    public void testEveningTimeEnLocale() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_en", new Locale("en", "EN"));
        Greeting.displayValues(resourceBundle, 21);
        Assert.assertTrue(outContent.toString().contains("Good evening, World!"));
    }
    @Test
    public void testNightTimeRuLocale() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_ru", new Locale("ru", "RU"));
        Greeting.displayValues(resourceBundle, 4);
        Assert.assertTrue(outContent.toString().contains("Доброй ночи, мир!"));
    }
    @Test
    public void testNightTimeEnLocale() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label_en", new Locale("en", "EN"));
        Greeting.displayValues(resourceBundle, 23);
        Assert.assertTrue(outContent.toString().contains("Good night, World!"));
    }
    // to be continued
}
