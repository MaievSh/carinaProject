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
import java.util.List;

public class ServicesPageOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServicesPageOnliner.class);

    public ServicesPageOnliner(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

//   @FindBy(xpath = "//div[@class='service-interaction__state service-interaction__state_initial service-interaction__state_disabled service-interaction__state_disabled_alter']")
//    private ExtendedWebElement activeCheckBox;

    @FindBy(xpath = "//span[@class='i-checkbox service-form__checkbox service-form__checkbox_base']//span[@class='i-checkbox__faux']")
    private List <ExtendedWebElement> activeCheckBox;

    public void clickActiveCheckBox(){
        activeCheckBox.get(2).click();
    }
}