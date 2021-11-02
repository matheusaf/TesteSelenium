package com.teste.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

/**
 * Unit test for simple App.
 * 1. Instalar o Selenium IDE (extensão para navegador)
 * 2. Elaborar um roteiro de casos de testes utilizando a técnica caixa-preta para um site de sua preferência
 * 3. Gravar a sequencia de passos de teste (utilize o primeiro caso de teste definido)
 * 4. Executar a sequencia gravada para verificar se os testes estão acontecendo corretamente
 * 5. Exportar o teste para Junit
 * 6. Criar um projeto Java (Maven) para realizar os testes (rode o mesmo teste gravado para validar se está tudo funcionando)
 * 7. Implemente no código do projeto o restante dos casos de teste
 * 8. Disponibilize, como evidência, os passos de teste gravados com o Selenium IDE (Tela do Selenium IDE com os passos e com a execução do teste “OK”)
 * 9. Disponibilize o código Java do projeto de teste
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
        driver.findElement(By.id("searchInput")).sendKeys("bulbasaur" + Keys.ENTER);

        // WebElement isSearchBarClickable = new WebDriverWait(driver, 10)
        //     .until(ExpectedConditions.elementToBeClickable(
        //         By.id("searchInput")
        //     )
        // );
        
        // isSearchBarClickable.sendKeys("bulbasaur" + Keys.ENTER);
    
    	String jpnOriginalName = driver.findElement(By.cssSelector("span[lang='ja'] b")).getText();
    	assertTrue(jpnOriginalName.equals("フシギダネ"));

    	String originalName = driver.findElement(By.cssSelector("span[lang='ja'] ~ i")).getText();
    	assertTrue(originalName.equalsIgnoreCase("fushigidane"));

    	assertTrue(driver.getCurrentUrl().equals("https://bulbapedia.bulbagarden.net/wiki/Bulbasaur_(Pok%C3%A9mon)"));

    }

    @AfterAll
    public static void destroy() {
        driver.quit();
    }
}


