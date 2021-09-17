package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ApartmentPageOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApartmentPageOnliner.class);

    @FindBy(xpath = "//span[@class='project-navigation__sign'][contains(text(),'Аренда')]")
    private ExtendedWebElement rentBtn;
    @FindBy(xpath = "//span[@class='filter__item-inner'][contains(text(),'Квартира')]")
    private ExtendedWebElement onlyApartBtn;
    @FindBy(xpath = "//span[@class='filter__item-inner'][contains(text(),'1')]")
    private ExtendedWebElement oneBedApartBtn;
    @FindBy(xpath = "//span[@class='filter__item-inner'][contains(text(),'2')]")
    private ExtendedWebElement twoBedApartBtn;
    @FindBy(xpath = "//input[@id='search-filter-price-to']")
    private ExtendedWebElement priceField;
    @FindBy(xpath = "//span[@class='filter__item-inner'][contains(text(),'Только собственник')]")
    private ExtendedWebElement ownersBtn;
    @FindBy(xpath = "//div[@class='dropdown__value'][contains(text(),'Метро')]")
    private ExtendedWebElement metroBtn;
    @FindBy(xpath = "//li[@class='dropdown__item'][contains(text(),'Возле метро')]")
    private ExtendedWebElement nearMetroBtn;
    @FindBy(xpath = "//div[@class='dropdown dropdown_manual dropdown_no-arrow']")
    private ExtendedWebElement cityOrStreetBtn;
    @FindBy(xpath = "//li[@class='dropdown__item'][contains(text(),'Минск')]")
    private ExtendedWebElement chooseCity;
    @FindBy(xpath = "//div[@class='leaflet-marker-icon map-marker-cluster leaflet-zoom-animated leaflet-interactive']")
    private List<ExtendedWebElement> apartmentRedDot;
    @FindBy(xpath = "//a[@class='classified classified_single']")
    private ExtendedWebElement apartmentChoose;
    @FindBy(xpath = "//span[@class='apartment-bar__value'][contains(text(),'Собственник')]")
    private ExtendedWebElement ownerText;


    public ApartmentPageOnliner(WebDriver driver) {
        super(driver);
        setPageURL("https://r.onliner.by/ak/");
    }

    public void clickRent(){
      rentBtn.click();
    }

    public void clickApart(){
        onlyApartBtn.click();
    }

    public void chooseBedInApart(){
        oneBedApartBtn.click();
        twoBedApartBtn.click();
    }


    public void inputPrice(String price){
        priceField.click();
        priceField.sendKeys(Keys.DELETE);
        priceField.type(price);
    }

    public void chooseOnlyOwners(){
        ownersBtn.click();
    }

    public void nearMetroChoose(){
        metroBtn.click();
        nearMetroBtn.click();

    }

    public void inputCity(){
        cityOrStreetBtn.click();
        chooseCity.click();
    }

    public void clickAnyDot(){
        apartmentRedDot.get(50).click();
    }

    public void apartmentChoose(){
        apartmentChoose.click();
    }

    public ExtendedWebElement getOwnerText() {
        return ownerText;
    }
}

