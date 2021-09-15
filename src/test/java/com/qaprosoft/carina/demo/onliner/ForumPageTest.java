package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.ForumPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForumPageTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForumPageTest.class);


    @BeforeMethod
    public void openForumPage(){
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.clickOnForumBtn();
        Assert.assertEquals(homePage.getTitle(),"Форум onliner.by - Главная страница","Exchange page is not opened!");
    }

    @Test()
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void openLostAndFoundPage(){
        ForumPageOnliner forumPage = new ForumPageOnliner((getDriver()));
        forumPage.open();
        Assert.assertTrue(forumPage.isPageOpened(), "Forum page is not opened");
        forumPage.lostAndFoundPage();
        forumPage.clickNextBtn();
        forumPage.clickPreviousBtn();
        Assert.assertTrue(forumPage.getTimeMessage().isElementPresent());

    }

}
