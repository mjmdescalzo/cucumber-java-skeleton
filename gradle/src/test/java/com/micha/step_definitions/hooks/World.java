package com.micha.step_definitions.hooks;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class World {

    public WebDriver driver;
    public Properties executionProperties;
    public Scenario scenario;

}
