package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.JSDemo.JavaScriptUtil;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.VerificationOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class FlashingElementsDemo implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlashingElementsDemo.class);



    @Test
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public  void demo(){

        HomePageOnliner homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        homePageOnliner.demo();
    }
}
