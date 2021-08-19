package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class FleaMarketPageOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(FleaMarketPageOnliner.class);

    public FleaMarketPageOnliner(WebDriver driver) {
        super(driver);
        setPageURL("https://baraholka.onliner.by/");
    }
}