package com.guru99.pages;

import commonLibs.implementation.ElementControl;
import org.openqa.selenium.WebDriver;

public class BaseUse {

    WebDriver driver;

    public ElementControl elementControl;

    public BaseUse(WebDriver driver)
    {
        this.driver = driver;

        elementControl = new ElementControl(); //driver removed
    }
}
