package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.CarMarketPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarSearchTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarSearchTest.class);

    @Test()
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})

    public void chooseCar(){

        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.openСarMarketPage();
        CarMarketPageOnliner carMarketPageOnliner = new CarMarketPageOnliner(getDriver());
        carMarketPageOnliner.getCountriesField().click();
        carMarketPageOnliner.clickCountry(CarMarketPageOnliner.BelarusCountry.Могилевская.getCountry());
        carMarketPageOnliner.getDistrictField().click();
        carMarketPageOnliner.clickDistrict(CarMarketPageOnliner.BelarusCountry.Могилевская);
        carMarketPageOnliner.getCityField().click();
        carMarketPageOnliner.clickCity(CarMarketPageOnliner.BelarusCountry.Могилевская.getCity().get(2));
        Assert.assertEquals(getDriver().getTitle(),"Автобарахолка - покупка, продажа автомобилей","Car market page is not opened!");
    }
}