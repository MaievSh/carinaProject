package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatalogPageOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPageOnliner.class);

    @FindBy(xpath = "//span[@class='button-style button-style_another button-style_base offers-form__button']")
    private ExtendedWebElement popupCity;

    public CatalogPageOnliner(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void clickYeas(){
        popupCity.clickIfPresent();
    }
}