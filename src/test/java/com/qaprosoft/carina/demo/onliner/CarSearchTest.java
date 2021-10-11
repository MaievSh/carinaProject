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

public class CarSearchTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarSearchTest.class);

    @BeforeClass
    public void firstStep() {
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.openСarMarketPage();
    }


    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    @XlsDataSourceParameters(path = "xls/market.xlsx", sheet = "TestMarket", dsUid = "TUID", dsArgs = "Country,District,City")
    public void chooseCar(String Country, String District, String City) {
        CarMarketPageOnliner carMarketPageOnliner = new CarMarketPageOnliner(getDriver());
        carMarketPageOnliner.getCountriesField();
        carMarketPageOnliner.сlickCountry(Country);
        carMarketPageOnliner.getDistrictField();
        carMarketPageOnliner.clickDistrict(District);
        carMarketPageOnliner.getCityField();
        carMarketPageOnliner.clickCity(City);
        carMarketPageOnliner.scrollToCarCompleteSetBody();
        carMarketPageOnliner.getCarCompleteBody();
        carMarketPageOnliner.clickCarBody(CarMarketPageOnliner.CarCompleteSetBody.Внедорожник);
        carMarketPageOnliner.clickCarBody(CarMarketPageOnliner.CarCompleteSetBody.Лимузин);
        carMarketPageOnliner.getCarCompleteEngine();
        carMarketPageOnliner.clickCarEngine(CarMarketPageOnliner.CarCompleteSetEngine.Бензин);
        carMarketPageOnliner.getEngineType();
        carMarketPageOnliner.clickCarAnotherSpec(CarMarketPageOnliner.AnotherSpecificationOfCar.Автоматическая);
        carMarketPageOnliner.clickCarAnotherSpec(CarMarketPageOnliner.AnotherSpecificationOfCar.Передний);
        carMarketPageOnliner.scrollToCarCompleteSetCondition();
        carMarketPageOnliner.getCarCompleteCondition();
        carMarketPageOnliner.clickCarCondition(CarMarketPageOnliner.CarCompleteSetCondition.пробегом);
        carMarketPageOnliner.getCarCompleteCondition();
        carMarketPageOnliner.clickSeller(CarMarketPageOnliner.Seller.Частное);
        carMarketPageOnliner.clickAdditionalCarSpec(CarMarketPageOnliner.AdditionalCarSpec.Растаможен);
        Assert.assertTrue(carMarketPageOnliner.getPresentItems().isElementPresent(), "Car is not choosing!");
    }
}