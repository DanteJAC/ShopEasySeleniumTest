package com.shopeasy;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FormInputTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private List<String> logs = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        logs.add("🔧 Navegador iniciado correctamente.");
    }

    @Test
    public void testNumericInputField() {
        logs.add("🚀 Iniciando prueba de campo numérico...");
        driver.get("https://the-internet.herokuapp.com/inputs");
        logs.add("🌐 Página cargada.");

        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
        inputField.clear();
        inputField.sendKeys("12345");

        String actualValue = inputField.getAttribute("value");
        logs.add("✍️ Valor ingresado: 12345");
        logs.add("🔍 Valor detectado en el campo: " + actualValue);

        Assertions.assertEquals("12345", actualValue, "❌ El campo no contiene el valor esperado.");
        logs.add("✅ Prueba completada exitosamente.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logs.add("🛑 Navegador cerrado.");
        }
        HtmlReportGenerator.generateReport("FormInputTest", logs);
    }
}
