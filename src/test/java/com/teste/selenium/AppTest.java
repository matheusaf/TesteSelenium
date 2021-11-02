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
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void shouldAnswerWithTrue() {
        // 1 | open | /wiki/Main_Page |
        driver.get("https://bulbapedia.bulbagarden.net/wiki/Main_Page");
        // 2 | setWindowSize | 974x1032 |
        driver.manage().window().setSize(new Dimension(974, 1032));
        // 3 | click | linkText=By Name |
        // driver.findElement(By.linkText("By Name")).click();
	driver.findElement(By.xpath("html/body/div[1]/nav/ul[1]/li[2]/ul/li[2]/ul/li[3]/a"));
        // 4 | click | linkText=Bulbasaur |
        // driver.findElement(By.linkText("Bulbasaur")).click();
	driver.findElement(By.cssSelector("h1")).getText();

	String jpnOriginalName = driver.findElement(By.cssSelector("spantitle='Bulbasaur (Pokémon)'] b")).getText();
	assertTrue(jpnOriginalName == "フシギダネ");

	String originalName = driver.findElement(By.cssSelector("//*[@id='mw-content-text']/div/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/i")).getText();
	assertTrue(originalName == "Fushigidane");

	assertTrue(driver.getCurrentUrl() == "https://bulbapedia.bulbagarden.net/wiki/Bulbasaur_(Pokémon)");
 
    }

    @AfterAll
    public static void destroy() {
        driver.quit();
    }
}


