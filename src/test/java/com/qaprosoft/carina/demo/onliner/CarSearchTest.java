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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CarSearchTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarSearchTest.class);

    @BeforeClass
    public void firstStep(){
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.openСarMarketPage();
    }


    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    @XlsDataSourceParameters(path = "xls/market.xlsx", sheet = "Sheet 1", dsUid = "TUID", dsArgs = "Country,District,City")
    public void chooseCar(String Country, String District, String City) throws InterruptedException{
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
        pause(5);
        carMarketPageOnliner.clickCarBody(CarMarketPageOnliner.CarCompleteSetBody.Лимузин);
        pause(5);
        carMarketPageOnliner.getCarCompleteEngine();
        carMarketPageOnliner.clickCarEngine(CarMarketPageOnliner.CarCompleteSetEngine.Бензин);
        pause(5);
        carMarketPageOnliner.scrollToCarCompleteSetCondition();
        carMarketPageOnliner.getCarCompleteCondition();
        carMarketPageOnliner.clickCarCondition(CarMarketPageOnliner.CarCompleteSetCondition.пробегом);
        pause(5);
        Assert.assertTrue(carMarketPageOnliner.getPresentItems().isElementPresent(),"Car is not choosing!");
    }
}