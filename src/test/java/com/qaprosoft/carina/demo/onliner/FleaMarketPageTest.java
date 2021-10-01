package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.ExchangePageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.FleaMarketPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.VerificationOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class FleaMarketPageTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FleaMarketPageTest.class);
    private final String user = VerificationOnliner.getUser("properties","user");
    private final String password = VerificationOnliner.getPassword("properties","password");

    @BeforeMethod
    public void LogIn(){
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.logIn();
        VerificationOnliner verification = new VerificationOnliner(getDriver());
        verification.setDBSignificance("properties", "user", user, "password", password);
        String loginProp = verification.getUser("properties", "user");
        String passwordProp = verification.getPassword("properties", "password");
        homePage.getEmailField().type(loginProp);
        homePage.getPassField().type(passwordProp);
        homePage.pressEnterBtn();
        homePage.getUserImageBtn().click();
        Assert.assertTrue(homePage.getUserImageBtn().isElementPresent(),"Log in success");
    }

    @BeforeMethod
    public void fleaMarketPage() {
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        FleaMarketPageOnliner fleaMarket = new FleaMarketPageOnliner(getDriver());
        homePage.clickOnFleaMarketBtn();
        Assert.assertEquals(getDriver().getTitle(),"Барахолка onliner.by - Главная страница","Flea market page is not opened!");
    }

    @Test()
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void myAdsPage(){
    FleaMarketPageOnliner fleaMarket = new FleaMarketPageOnliner(getDriver());
    fleaMarket.myAds();
        Assert.assertEquals(getDriver().getTitle(),"Поиск - Барахолка onliner.by","Flea market page is not opened!");
    }

    @Test()
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void myAdsParticipatePage(){
        FleaMarketPageOnliner fleaMarket = new FleaMarketPageOnliner(getDriver());
        fleaMarket.myAdsParticipate();
        Assert.assertEquals(getDriver().getTitle(),"Поиск - Барахолка onliner.by","Flea market page is not opened!");
    }

    @Test()
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void newAdsPage(){
        FleaMarketPageOnliner fleaMarket = new FleaMarketPageOnliner(getDriver());
        fleaMarket.newAds();
        Assert.assertEquals(getDriver().getTitle(),"Поиск - Барахолка onliner.by","Flea market page is not opened!");
    }

}

