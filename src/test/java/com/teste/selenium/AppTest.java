package com.teste.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static WebDriver driver;

    /**
     * Rigorous Test :-)
     */

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/workspaces/TesteSelenium/msedgedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void shouldAnswerWithTrue() {
        // 1 | open | /wiki/Main_Page |
        driver.get("https://bulbapedia.bulbagarden.net/wiki/Main_Page");
        // 2 | setWindowSize | 974x1032 |
        driver.manage().window().setSize(new Dimension(974, 1032));
        // 3 | click | linkText=By Name |
        driver.findElement(By.linkText("By Name")).click();
        // 4 | click | linkText=Bulbasaur |
        driver.findElement(By.linkText("Bulbasaur")).click();
        assertTrue(driver.getCurrentUrl() == "ss");
    }

    @AfterAll
    public static void destroy() {
        driver.quit();
    }
}
