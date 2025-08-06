package com.shopeasy;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginTest {

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
    public void testLoginSuccess() {
        logs.add("🚀 Iniciando prueba de login exitoso...");
        driver.get("https://the-internet.herokuapp.com/login");
        logs.add("🌐 Página cargada.");

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        logs.add("✅ Mensaje de éxito detectado: " + successMessage.getText());
    }

    @Test
    public void testLoginFailure() {
        logs.add("🚀 Iniciando prueba de login fallido...");
        driver.get("https://the-internet.herokuapp.com/login");
        logs.add("🌐 Página cargada.");

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameField.sendKeys("invalidUser");
        passwordField.sendKeys("invalidPassword");
        loginButton.click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        logs.add("✅ Mensaje de error detectado: " + errorMessage.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logs.add("🛑 Navegador cerrado.");
        }
        HtmlReportGenerator.generateReport("LoginTest", logs);
    }
}
