package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.HomePageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.VerificationOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class LogInByEmail implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogInByEmail.class);
    private final String user = VerificationOnliner.getUser("properties","user");
    private final String password = VerificationOnliner.getPassword("properties","password");
    @Test()
    @MethodOwner(owner = "Aleksandra")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})

    public void LogIn() {
        HomePageOnliner homePage = new HomePageOnliner(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
       /* homePage.logIn();
        homePage.enterEmailField("bogbogdanovbog@gmail.com");
        homePage.enterPasswordField("567567Qwer");
        homePage.pressEnterBtn();*/
        homePage.logIn();
        VerificationOnliner verification = new VerificationOnliner(getDriver());
        verification.setDBSignificance("properties", "user", user, "password", password);
        String loginProp = verification.getUser("properties", "user");
        String passwordProp = verification.getPassword("properties", "password");
        homePage.getEmailField().type(loginProp);
        homePage.getPassField().type(passwordProp);
        homePage.pressEnterBtn();
        homePage.getUserImageBtn().click();
        Assert.assertTrue(homePage.getUserImageBtn().isElementPresent(),"Log in success");
    }
}