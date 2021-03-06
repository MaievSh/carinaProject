package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.JSDemo.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HomePageOnliner extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageOnliner.class);

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private ExtendedWebElement searchField;
    @FindBy(xpath = "//span[@class='b-main-navigation__text'][contains(text(), 'Каталог')]")
    private ExtendedWebElement catalogPage;
    @FindBy(xpath = "//span[@class='b-main-navigation__text']//parent::span[contains(text(),'Автобарахолка')]")
    private ExtendedWebElement carMarketPage;
    @FindBy(xpath = "//a[@class='b-main-navigation__link']//parent::span[contains(text(),'Барахолка')]")
    private ExtendedWebElement fleaMarketPage;
    @FindBy(xpath = "//iframe[@class = 'modal-iframe']")
    private ExtendedWebElement frame;
    @FindBy(xpath = "//div[@class='result__item result__item_product']")
    private List <ExtendedWebElement> chooseItem;
    @FindBy(xpath = "//a[@class='button-style button-style_base-alter product-aside__item-button button-style_expletive']")
    private List <ExtendedWebElement> addToCart;
    @FindBy(xpath = "//a[@class='auth-bar__item auth-bar__item--cart']")
    private ExtendedWebElement cartButton;
    @FindBy(xpath = "//div[contains(text(),'Вход')]")
    private ExtendedWebElement logButton;
    @FindBy(xpath = "//input[@placeholder=\"Ник или e-mail\"]")
    private ExtendedWebElement emailField;
    @FindBy(xpath = "//input[@placeholder=\"Пароль\"]")
    private ExtendedWebElement passwordField;
    @FindBy(xpath = "//*[@type='submit'][contains(text(), 'Войти')]")
    private ExtendedWebElement enterBtn;
    @FindBy(xpath = "//span[@class='b-main-navigation__text']//parent::span[contains(text(),'Услуги')]")
    private ExtendedWebElement servicesPage;
    @FindBy(xpath = "//div[@class = 'b-top-profile__image js-header-user-avatar']")
    private ExtendedWebElement userImageBtn;
    @FindBy(xpath = "//span[@class='b-main-navigation__text'][contains(text(), 'Форум')]")
    private ExtendedWebElement forumBtn;
    @FindBy(xpath = "//header[@class='b-main-page-blocks-header-2 cfix']//parent::a[contains(@href, 'https://people.onliner.by')][contains(text(), 'Люди')]")
    private ExtendedWebElement peopleBtn;
    @FindBy(xpath = "//li[@class='project-navigation__item project-navigation__item_primary project-navigation__item_active']//parent::span[@class='project-navigation__sign'][contains(text(), 'Люди')]")
    private ExtendedWebElement activePeopleBtn;
    @FindBy(xpath = "//span[@class='b-main-navigation__text'][contains(text(),'Дома и квартиры')]")
    private ExtendedWebElement homeAndApartBtn;
    @FindBy(xpath = "//span[@class='button-style button-style_another button-style_base offers-form__button']")
    private ExtendedWebElement popupCity;
    @FindBy(xpath = "//li[@class='b-top-navigation-informers__item top-informer-weather js-weather-widget']")
    private ExtendedWebElement weatherBtn;
    @FindBy(xpath = "//a[@class='b-main-page-tabs__item b-main-page-tabs__item_active'][contains(text(),'Новости')]")
    private ExtendedWebElement sportFrameNewsActive;
    @FindBy(xpath = "//a[@class='b-main-page-tabs__item'][contains(text(),'Новости')]")
    private ExtendedWebElement sportFrameNews;
    @FindBy(xpath = "//a[@class='b-main-page-tabs__item'][contains(text(),'Футбол')]")
    private ExtendedWebElement sportFrameFootball;
    @FindBy(xpath = "//a[@class='b-main-page-tabs__item'][contains(text(),'Хоккей')]")
    private ExtendedWebElement sportFrameHockey;
    @FindBy(xpath = "//a[@class='b-main-page-tabs__item'][contains(text(),'Баскетбол')]")
    private ExtendedWebElement sportFrameBasketball;




    public HomePageOnliner(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void searchItem(String item){
        searchField.click();
        searchField.type(item);
    }
    public void openCatalogPage(){
    catalogPage.click();
    }


    public void openСarMarketPage(){
        carMarketPage.click();
    }
    public FleaMarketPageOnliner clickOnFleaMarketBtn(){
        fleaMarketPage.click();
        return new FleaMarketPageOnliner(getDriver());
    }

    public void chooseItemInCatalog (){
    chooseItem.get(0).click();

    }

    public void inCart(){
        addToCart.get(0).click();
        popupCity.clickIfPresent();
        cartButton.click();
    }

  public void logIn(){
        logButton.click();
    }

    public void pressEnterBtn(){
        enterBtn.click();
    }

    public ExtendedWebElement getEmailField(){
        return emailField;
    }

    public ExtendedWebElement getPassField(){
        return passwordField;
    }

    public void clickServicesPage(){
        servicesPage.click();
    }

    public ExtendedWebElement getUserImageBtn(){
       return userImageBtn;
    }

    public void getIframe(){
        frame.getDriver().switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'modal-iframe']")));
    }

    public ForumPageOnliner clickOnForumBtn(){
        forumBtn.click();
        return new ForumPageOnliner(getDriver());
    }

    public PeopleNewsOnliner clickOnPeopleBtn(){
        peopleBtn.click();
        return new PeopleNewsOnliner(getDriver());
    }

    public ExtendedWebElement getActivePeopleBtn(){
        return activePeopleBtn;
    }

    public ApartmentPageOnliner hoverHomeAndApartBtn(){
        homeAndApartBtn.click();
        return new ApartmentPageOnliner(getDriver());
    }

    public WeatherPageOnliner openWeatherPage(){
        weatherBtn.click();
        return new WeatherPageOnliner(getDriver());
    }

    public void setSportFrame(){
        sportFrameFootball.click();
        sportFrameHockey.click();
        sportFrameBasketball.click();
        sportFrameNews.click();
    }
    public ExtendedWebElement getSportFrameNewsActive(){
        return sportFrameNewsActive;
    }

    public void demo(){
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//*[@id='userbar']/div[2]/div/div/div[1]"));
        JavaScriptUtil.flashElement(element,driver);
        driver.close();
    }

}