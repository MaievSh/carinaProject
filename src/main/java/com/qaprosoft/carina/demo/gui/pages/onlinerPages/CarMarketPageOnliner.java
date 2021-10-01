package com.qaprosoft.carina.demo.gui.pages.onlinerPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(xpath = "//div[@class = 'input-style__faux'][contains(text(),'Все страны')]/following-sibling::div[@class='input-style__real']")
    private ExtendedWebElement countriesField;
    @FindBy(xpath = "//div[@class = 'dropdown-style__checkbox-sign']" + "[contains(text(),"+"'%s')]")
    private ExtendedWebElement chooseCountry;
    @FindBy(xpath = "//div[@class = 'input-style__faux']" + "[contains(text(),'Все области')]" + "/following-sibling::div[@class='input-style__real']")
    private ExtendedWebElement districtField;
    @FindBy(xpath = "//div[@class = 'dropdown-style__checkbox-sign']" + "[contains(text(),'%s')]")
    private ExtendedWebElement chooseDistrict;
    @FindBy(xpath = "//div[@class = 'input-style__faux']" + "[contains(text(),'Все города')]" + "/following-sibling::div[@class='input-style__real']")
    private ExtendedWebElement cityField;
    @FindBy(xpath = "//div[@class = 'dropdown-style__checkbox-sign']" + "[contains(text(),'%s')]")
    private ExtendedWebElement chooseCity;


    public ExtendedWebElement getCountriesField() {
        return countriesField;
    }

    public enum BelarusCountry {
        Минская("Беларусь",Arrays.asList("Минск","Березино","Бобр","Борисов","Вилейка","Воложин",
                "Городея","Дзержинск","Жодино","Заславль","Зеленый Бор","Ивенец","Клецк","Копыль","Крупки","Логойск","Любань","Марьина Горка",
                "Молодечно","Мядель","Несвиж","Слуцк","Смолевичи","Солигорск","Старые Дороги","Столбцы","Узда","Фаниполь", "Червень")),
        Брестская("Беларусь",Arrays.asList("Антополь", "Барановичи", "Белоозерск", "Береза", "Высокое", "Ганцевичи", "Городище", "Давид-Городок", "Домачево",
        "Дрогичин", "Жабинка", "Иваново", "Ивацевичи", "Каменец", "Кобрин", "Коссово", "Лунинец", "Ляховичи", "Малорита", "Микашевичи", "Пинск", "Пружаны", "Столин")),
        Витебская("Беларусь",Arrays.asList("Витебск", "Барань", "Бегомль", "Бешенковичи", "Богушевск", "Браслав", "Верхнедвинск", "Ветрино",
                "Видзы", "Воропаево", "Глубокое", "Городок", "Дисна", "Докшицы", "Друя", "Дубровно", "Езерище", "Лепель", "Лиозно", "Миоры", "Новолукомль",
                "Новополоцк", "Орша", "Полоцк", "Поставы", "Россоны", "Сенно", "Толочин", "Ушачи", "Чашники", "Шарковщина", "Шумилино")),
        Гомельская("Беларусь",Arrays.asList("Гомель", "Белицк", "Большевик", "Брагин", "Буда-Кошелево", "Василевичи", "Васильевка", "Ветка",
                "Добруш", "Ельск", "Житковичи", "Жлобин","Калинковичи", "Корма", "Лельчицы", "Лоев", "Мозырь", "Наровля", "Октябрьский", "Петриков",
                "Речица", "Рогачев", "Светлогорск", "Туров", "Хойники", "Чечерск")),
        Гродненская("Беларусь",Arrays.asList("Гродно", "Березовка", "Большая Берестовица", "Волковыск", "Вороново", "Дятлово", "Желудок","Зельва",
                "Ивье", "Козловщина", "Кореличи", "Лида", "Мосты", "Новогрудок", "Островец", "Ошмяны", "Свислочь", "Скидель", "Слоним", "Сморгонь", "Щучин")),
        Могилевская("Беларусь",Arrays.asList("Могилев", "Белыничи", "Бобруйск", "Быхов", "Глуск", "Глуша", "Горки", "Гродзянка", "Елизово", "Кировск",
                "Климовичи", "Кличев", "Костюковичи", "Краснополье", "Кричев", "Круглое", "Мстиславль", "Осиповичи", "Славгород", "Хотимск", "Чаусы", "Чериков", "Шклов"));

        String country;
        List<String> city;
        BelarusCountry(String country,List<String> city){
           this.country = country;
            this.city = city;
        }

        public String getCountry(){
            return country;
        }


        public List<String> getCity(){
            return city;
        }
    }

    public void clickCountry(String country){
        chooseCountry.format(country).click();
    }

    public ExtendedWebElement getDistrictField(){
        return districtField;
    }

    public void clickDistrict(BelarusCountry district){
        chooseDistrict.format(district).click();
    }

    public ExtendedWebElement getCityField(){
        return cityField;
    }

    public void clickCity(String city){
        chooseCity.format(city).click();
    }
}