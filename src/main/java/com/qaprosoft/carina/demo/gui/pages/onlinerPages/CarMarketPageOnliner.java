package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CarMarketPageOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarMarketPageOnliner.class);

    public CarMarketPageOnliner (WebDriver driver) {
        super(driver);
        setPageURL("https://ab.onliner.by");
    }
   /* public CarMarketPageOnliner (WebDriver driver) {
        super(driver);
        setPageURL("https://ab.onliner.by/city/berezino");
    }*/

    @FindBy(xpath = "//div[@class = 'input-style__faux'][contains(text(),'Все страны')]")
    private ExtendedWebElement countriesField;
    @FindBy(xpath = "//div[@class = 'dropdown-style__checkbox-sign'][contains(text(),'Беларусь')]")
    private ExtendedWebElement chooseCountry;
    @FindBy(xpath = "//div[@class = 'input-style__faux'][contains(text(),'Все области')]")
    private ExtendedWebElement districtField;
    @FindBy(xpath = "//div[@class = 'dropdown-style__checkbox-sign'][contains(text(),'Минская обл.')]")
    private ExtendedWebElement chooseDistrict;
    @FindBy(xpath = "//div[@class = 'input-style__faux'][contains(text(),'Все города')]")
    private ExtendedWebElement cityField;
    @FindBy(xpath = "//div[@class = 'dropdown-style__checkbox-sign'][contains(text(),'Березино')]")
    private ExtendedWebElement chooseCity;

    public ExtendedWebElement getCountriesField(){
       return countriesField;
    }

    public void clickCountry(){
        chooseCountry.click();
    }

    public ExtendedWebElement getDistrictField(){
        return districtField;
    }

    public void clickDistrict(){
        chooseDistrict.click();
    }

    public ExtendedWebElement getCityField(){
        return cityField;
    }

    public void clickCity(){
        chooseCity.click();
    }
}