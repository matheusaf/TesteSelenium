package com.teste.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/workspaces/TesteSelenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://bulbapedia.bulbagarden.net/wiki/Main_Page");
        // 2 | setWindowSize | 974x1032 |
        driver.manage().window().setSize(new Dimension(974, 1032));
        // 3 | click | linkText=By Name |
        driver.findElement(By.linkText("By Name")).click();
        // 4 | click | linkText=Bulbasaur |
        driver.findElement(By.linkText("Bulbasaur")).click();
        System.out.println(driver.getTitle());
    }

}
