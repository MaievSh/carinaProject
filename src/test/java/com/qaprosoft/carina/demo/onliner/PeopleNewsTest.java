package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.ForumPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.PeopleNewsOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PeopleNewsTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleNewsTest.class);

    @BeforeClass
    public void openPeopleNewsPage(){
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.clickOnPeopleBtn();
        Assert.assertTrue(homePage.getActivePeopleBtn().isElementPresent(),"People news page is not opened!");
    }

    @Test()
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void chooseNews(){
        PeopleNewsOnliner peopleNewsPage = new PeopleNewsOnliner(getDriver());
        peopleNewsPage.open();
        peopleNewsPage.abroadPage();
        peopleNewsPage.clickAnyNewsAboutPeople();
        Assert.assertTrue(peopleNewsPage.getNewsAuthor().isElementPresent());

    }
}
