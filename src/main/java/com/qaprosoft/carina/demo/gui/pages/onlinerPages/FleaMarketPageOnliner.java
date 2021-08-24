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

public class FleaMarketPageOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(FleaMarketPageOnliner.class);

    @FindBy(xpath = "//span[@class = 'project-navigation__sign'][contains(text(), 'Мои объявления')]")
    private ExtendedWebElement myAdsButton;
    @FindBy(xpath = "//span[@class = 'project-navigation__sign'][contains(text(), 'Объявления, в которых я участвую')]")
    private ExtendedWebElement myAdsParticipateButton;
    @FindBy(xpath = "//span[@class = 'project-navigation__sign'][contains(text(), 'Новое за 24 часа')]")
    private ExtendedWebElement newAdsButton;

    public FleaMarketPageOnliner(WebDriver driver) {
        super(driver);
        setPageURL("https://baraholka.onliner.by/");
    }

    public void myAds(){
        myAdsButton.click();
    }

    public void myAdsParticipate(){
        myAdsParticipateButton.click();
    }

    public void newAds(){
        newAdsButton.click();
    }
}