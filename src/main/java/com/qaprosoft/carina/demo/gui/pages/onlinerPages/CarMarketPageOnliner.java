package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class CarMarketPageOnliner extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarMarketPageOnliner.class);

    public CarMarketPageOnliner(WebDriver driver) {
        super(driver);
        setPageURL("https://ab.onliner.by");
    }


    @FindBy(xpath = "//div[@class='input-style__real']")
    private List <ExtendedWebElement> dataField;
    @FindBy(xpath = "//div[@class ='dropdown-style__checkbox-text']//div[text()='%s']")
    private ExtendedWebElement chooseCountry;
    @FindBy(xpath = "//div[@class = 'input-style__faux']" + "[contains(text(),'Все области')]" + "/following-sibling::div[@class='input-style__real']")
    private ExtendedWebElement districtField;
    @FindBy(xpath = "//div[@class = 'dropdown-style__checkbox-sign']" + "[contains(text(),'%s')]")
    private ExtendedWebElement chooseDistrict;
    @FindBy(xpath = "//div[@class = 'input-style__faux']" + "[contains(text(),'Все города')]" + "/following-sibling::div[@class='input-style__real']")
    private ExtendedWebElement cityField;
    @FindBy(xpath = "//div[@class='dropdown-style__checkbox-text']//div[text()='%s']")
    private ExtendedWebElement chooseCity;
    @FindBy(xpath = "//div[@class='vehicle-form__tag-item']")
    private ExtendedWebElement presentItems;
    @FindBy(xpath = "//div[@class='dropdown-style__checkbox-sign'][contains(text(),'%s')]")
    private ExtendedWebElement carBody;
    @FindBy(xpath = "//span[@class='vehicle-form__checkbox-sign'][contains(text(),'Гибрид')]")
    private  ExtendedWebElement engineType;
    @FindBy(xpath = "//span[@class='vehicle-form__checkbox-sign'][contains(text(),'Газобаллонное')]")
    private  ExtendedWebElement engineType1;
    @FindBy(xpath = "//div[@class='vehicle-form__checkbox-sign'][contains(text(),'%s')]")
    private  ExtendedWebElement specificationAnother;
    @FindBy(xpath = "//span[@class='vehicle-form__checkbox-sign'][contains(text(),'%s')]")
    private  ExtendedWebElement specificationAdditional;





    public void scrollToCarCompleteSetBody(){
        WebElement Element = driver.findElement(By.xpath("//div[@class='vehicle-form__label-title'][text()='Тип кузова']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public void scrollToCarCompleteSetCondition(){
        WebElement Element = driver.findElement(By.xpath("//div[@class='vehicle-form__label-title'][text()='Состояние автомобиля']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public void getCountriesField() {
        dataField.get(0).click();
    }

    public enum CarCompleteSetBody {
        Седан,
        Внедорожник,
        Универсал,
        Хетчбэк,
        Лифтбэк,
        Минивэн,
        Микроавтобус,
        Купе,
        Фургон,
        Пикап,
        Кабриолет,
        Лимузин
    }

    public enum CarCompleteSetEngine {
        Бензин,
        Дизель,
        Электро
    }

    public enum CarCompleteSetCondition {
        Новый,
        пробегом,
        Аварийный
    }

    public enum AnotherSpecificationOfCar {
        Автоматическая,
        Механическая,
        Передний,
        Задний,
        Полный
    }
    public enum Seller {
        Частное,
        Автохаус,
        Автодилер
    }

    public enum AdditionalCarSpec {
       На,
        Растаможен,
        Ручное
    }


    public void getCarCompleteBody(){

        dataField.get(6).click();
    }

    public void getDistrictField(){
        dataField.get(1).click();
    }

    public void clickCarBody(CarCompleteSetBody body){
       carBody.format(body).click();
    }

    public void clickCarAnotherSpec(AnotherSpecificationOfCar specification){
      specificationAnother.format(specification).click();
    }

    public void clickSeller(Seller seller){
        specificationAnother.format(seller).click();
    }

    public void clickAdditionalCarSpec(AdditionalCarSpec addCarSpec){
        specificationAdditional.format(addCarSpec).click();
    }

    public void clickCarEngine(CarCompleteSetEngine engine){
        carBody.format(engine).click();
    }

    public void clickCarCondition(CarCompleteSetCondition condition){
        carBody.format(condition).click();
    }

    public void getCarCompleteEngine(){
        dataField.get(7).click();
    }

    public void getCarCompleteCondition(){
        dataField.get(8).click();
    }

    public void getCityField(){
      dataField.get(2).click();
    }

    public void сlickCountry(String country){
      chooseCountry.format(country).click();
    }
    public void clickDistrict(String district){
        chooseDistrict.format(district).click();
    }
    public void clickCity(String city){
        chooseCity.format(city).click();
    }

    public ExtendedWebElement getPresentItems() {
        return presentItems;
    }

    public void getEngineType() {
        engineType.click();
        engineType.click();
        engineType1.click();
    }
}