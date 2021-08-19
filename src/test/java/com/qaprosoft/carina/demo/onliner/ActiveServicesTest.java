package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.ExchangePageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.ServicesPageOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class ActiveServicesTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActiveServicesTest.class);

    @Test()
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})

    public void chooseActiveServices() {
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.clickServicesPage();
        ServicesPageOnliner activeServices = new ServicesPageOnliner(getDriver());
        activeServices.clickActiveCheckBox();
        Assert.assertEquals(getDriver().getTitle(),"Заказы на услуги","Services page is not opened!");
    }
}
