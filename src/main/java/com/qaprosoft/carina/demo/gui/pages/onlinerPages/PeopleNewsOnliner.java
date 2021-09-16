package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PeopleNewsOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleNewsOnliner.class);

    public PeopleNewsOnliner(WebDriver driver) {
        super(driver);
        setPageURL("https://people.onliner.by/");
    }

    @FindBy(xpath = "//a[contains(@href, '/zagranica')][@class='news-rubrics__link js-rubric ']")
    private ExtendedWebElement abroadPageBtn;
    @FindBy(xpath = "//a[@class='news-tiles__stub']")
    private List<ExtendedWebElement> newsAboutPeoplePreview;

    @FindBy(xpath = "//div[@class='news-header__part news-header__part_2']")
    private ExtendedWebElement newsAuthor;

    public void abroadPage(){
        abroadPageBtn.click();
    }

    public void clickAnyNewsAboutPeople(){
        newsAboutPeoplePreview.get(15).click();
    }

    public ExtendedWebElement getNewsAuthor() {
        return newsAuthor;
    }
}
