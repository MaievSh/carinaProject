package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherPageOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherPageOnliner.class);

    @FindBy(xpath = "//a[@class='js-weather-city']")
    private ExtendedWebElement changeCityBtn;
    @FindBy(xpath = "//a[@data-wmoid='26666']")
    private ExtendedWebElement chooseCityBtn;
    @FindBy(xpath = "//small[@class='b-weather-legalnote']")
    private ExtendedWebElement infoAboutPage;

    public WeatherPageOnliner(WebDriver driver) {
        super(driver);
        setPageURL("https://pogoda.onliner.by/");
    }

    public void changeCity(){
        changeCityBtn.click();
        chooseCityBtn.click();
    }

    public ExtendedWebElement getInfoAboutPage(){
        return infoAboutPage;
    }

}
