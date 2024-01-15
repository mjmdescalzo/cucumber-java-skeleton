package com.micha.pages;

import com.micha.helper.PropertiesHelper;
import com.micha.step_definitions.hooks.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

public class BasePage {

    protected final WebDriver driver;
    protected final Wait<WebDriver> wait;

    protected final Logger logger = LogManager.getLogger(this.getClass().getName());
    protected Properties executionProperties;
    protected World world;

    public BasePage(World world) {
        this.driver = world.driver;
        this.world = world;

        wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(60)).
                pollingEvery(Duration.ofMillis(500)).
                ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

        executionProperties = PropertiesHelper.loadPropertiesFile("execution.properties");
    }
}
