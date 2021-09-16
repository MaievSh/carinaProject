package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ForumPageOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForumPageOnliner.class);

    public ForumPageOnliner(WebDriver driver) {
        super(driver);
        setPageURL("https://forum.onliner.by/");
    }

    @FindBy(xpath = "//a[contains(@href, '/viewtopic.php?t=358736')][contains(text(), 'Бюро находок')]")
    private ExtendedWebElement lostAndFoundPageBtn;
    @FindBy(xpath = "//a[contains(@href, '/viewtopic.php?t=358736')][contains(text(), 'Бюро находок')]")
    private ExtendedWebElement nextPageBtn;
    @FindBy(xpath = "//li[@class='page-next']//parent::a[@href='./viewtopic.php?t=358736&start=20']")
    private List<ExtendedWebElement> nextBtn;
    @FindBy(xpath = "//li[@class='page-prev']//parent::a[@href='./viewtopic.php?t=358736&start=0']")
    private List<ExtendedWebElement> previousBtn;
    @FindBy(xpath = "//a[@class='hr'][contains(text(), '1')]")
    private ExtendedWebElement timeMessage;

    public void lostAndFoundPage(){
        lostAndFoundPageBtn.click();
    }

    public void clickNextBtn(){
        nextBtn.get(0).click();
    }

    public void clickPreviousBtn(){
        previousBtn.get(0).click();
    }

    public ExtendedWebElement getTimeMessage(){
        return timeMessage;
    }
}
