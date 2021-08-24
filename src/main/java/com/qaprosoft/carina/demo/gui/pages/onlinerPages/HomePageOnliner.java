package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageOnliner extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageOnliner.class);

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private ExtendedWebElement searchField;
  /*  @FindBy(xpath = "//div[@class='search__suggests']")
    private ExtendedWebElement searchField1;*/
    @FindBy(xpath = "//span[contains(text(), 'Каталог')]")
    private ExtendedWebElement catalogPage;
    @FindBy(xpath = "//a[@class='b-main-navigation__link']//parent::span[contains(text(),'Автобарахолка')]")
    private ExtendedWebElement carMarketPage;
    @FindBy(xpath = "//a[@class='b-main-navigation__link']//parent::span[contains(text(),'Барахолка')]")
    private ExtendedWebElement fleaMarketPage;
    @FindBy(xpath = "//iframe[@class = 'modal-iframe']")
    private ExtendedWebElement frame;
    @FindBy(xpath = "//div[@class='result__item result__item_product']//parent::a[@class='product__title-link'][contains(text(),'Смартфон Apple iPhone 12 64GB (зеленый)')]")
    private ExtendedWebElement chooseItem;
    @FindBy(xpath = "//a[contains(text(),'В корзину')]")
    private ExtendedWebElement addToCart;
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
    chooseItem.click();
    }

    public void inCart(){
        addToCart.click();
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

    public ExtendedWebElement getIframe(){
        return frame;
    }
}