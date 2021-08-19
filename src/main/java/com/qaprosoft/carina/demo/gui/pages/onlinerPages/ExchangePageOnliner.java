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

public class ExchangePageOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangePageOnliner.class);
    public ExchangePageOnliner(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    @FindBy(xpath = "//span[@class='_u js-currency-amount']")
    private ExtendedWebElement exchangeIcon;
    @FindBy(xpath = "//input[@id='amount-in']")
    private ExtendedWebElement amountInField;

    public void clickExchangeIcon(){
      exchangeIcon.click();
    }
    public ExtendedWebElement getAmountInField(){
        return amountInField;
    }


}
