package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.ExchangePageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.FleaMarketPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class FleaMarketPageTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FleaMarketPageTest.class);

    @Test()
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})

    public void FleaMarketPage() {
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        FleaMarketPageOnliner fleaMarket = new FleaMarketPageOnliner(getDriver());
        homePage.clickOnFleaMarketBtn();
        Assert.assertEquals(getDriver().getTitle(),"Барахолка onliner.by - Главная страница","Flea market page is not opened!");
    }
}

