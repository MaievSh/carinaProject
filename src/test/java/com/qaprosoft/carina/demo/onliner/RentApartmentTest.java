package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.ApartmentPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RentApartmentTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RentApartmentTest.class);

    @Test
    public void openPeopleNewsPage(){
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.hoverHomeAndApartBtn();
        ApartmentPageOnliner apartmentPage = new ApartmentPageOnliner(getDriver());
        apartmentPage.clickRent();
        apartmentPage.clickApart();
        apartmentPage.chooseBedInApart();
        apartmentPage.inputPrice("500");
        apartmentPage.chooseOnlyOwners();
        apartmentPage.nearMetroChoose();
        apartmentPage.inputCity();
        apartmentPage.clickAnyDot();
        apartmentPage.apartmentChoose();
        Assert.assertTrue(apartmentPage.getOwnerText().isElementPresent(),"Apartment description page is not opened!");
    }
}
