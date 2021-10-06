package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.CarMarketPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataProviderCarSearchTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataProviderCarSearchTest.class);


    @BeforeClass
    public void firstStep(){
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.openСarMarketPage();
    }

    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "Aleksandra")
    @XlsDataSourceParameters(path = "xls/market.xlsx", sheet = "Sheet 1", dsUid = "TUID", dsArgs = "Country,District,City")
    public void choosePlace(String Country, String District, String City) throws InterruptedException {
        CarMarketPageOnliner carMarketPageOnliner = new CarMarketPageOnliner(getDriver());
        carMarketPageOnliner.getCountriesField();
        carMarketPageOnliner.сlickCountry1(Country);
        carMarketPageOnliner.getDistrictField();
        carMarketPageOnliner.clickDistrict1(District);
        carMarketPageOnliner.getCityField();
        carMarketPageOnliner.clickCity1(City);
        Assert.assertTrue(carMarketPageOnliner.getPresentItems().isElementPresent(),"Car is not choosing!");
    }
}
