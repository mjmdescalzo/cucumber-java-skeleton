package com.micha.step_definitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.testng.Assert.assertFalse;
import com.micha.helper.PropertiesHelper;

public class Hooks {

    private Scenario scenario;
    private World world;
    private final Logger logger = LogManager.getLogger(this.getClass().getName());

    public Hooks(World world) {
        this.world = world;
    }

    @Before
    public void setupScenario(Scenario scenario) {
        this.scenario = scenario;
        this.world.scenario = scenario;
        setupProperties();
        setupWebDriver();
    }

    @After
    public void tearDownWebDriver() {
        if (world.driver != null) {
            world.driver.quit();
        }
    }

    private void setupWebDriver() {

        String browser = world.executionProperties.getProperty("browser").trim().toLowerCase();
        assertFalse(browser.equalsIgnoreCase(""));

        WebDriver driver;

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        world.driver = driver;
        world.driver.manage().window().maximize();
    }

    private void setupProperties() {
        world.executionProperties  = PropertiesHelper.loadPropertiesFile("execution.properties");
    }
}
