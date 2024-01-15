package com.micha.pages;

import com.micha.step_definitions.hooks.World;
import org.openqa.selenium.By;

import static org.testng.Assert.assertFalse;

public class LoginPage extends BasePage {

    private String url;

    private final By customerLoginLbl = By.xpath("//h2[text() = 'Customer Login']");
    private final By usernameFld = By.xpath("//input[@name = 'username']");
    private final By passwordFld = By.xpath("//input[@name = 'password']");
    private final By loginBtn = By.xpath("//input[@value= 'Log In']");

    public LoginPage(World world) {
        super(world);

        String environment = executionProperties.getProperty("environment");
        assertFalse(environment.equalsIgnoreCase(""));

        switch (environment.toLowerCase()) {
            case "production":
                logger.info("Executing in production environment.");
                this.url = executionProperties.getProperty("prod_url");
            case "uat":
                logger.info("Executing in production environment.");
                this.url = executionProperties.getProperty("uat_url");
            case "sit":
            default:
                logger.info("Executing in production environment.");
                this.url = executionProperties.getProperty("sit_url");
        }
    }

    public void loadPage() {
        driver.get(url);
    }

    public boolean waitUntilPageIsDisplayed() {
        return wait.until(driver -> {
            try {
                return driver.findElement(customerLoginLbl).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void enterCredentials(String username, String password) {
        wait.until(driver -> driver.findElement(usernameFld)).sendKeys(username);
        wait.until(driver -> driver.findElement(passwordFld)).sendKeys(password);
        wait.until(driver -> driver.findElement(loginBtn)).click();
    }
}
