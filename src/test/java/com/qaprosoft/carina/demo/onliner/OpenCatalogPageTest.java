package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.CarMarketPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.CatalogPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class OpenCatalogPageTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenCatalogPageTest.class);

    @Test()
    @MethodOwner(owner = "Aleksandra")
    @TestLabel(name = "feature", value = {"web", "regression"})

    public void catalogPage() {
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        CatalogPageOnliner catalogPage = new CatalogPageOnliner(getDriver());
        homePage.openCatalogPage();
        Assert.assertEquals(getDriver().getTitle(),"Каталог Onliner","Catalog page is not opened!");
    }
}