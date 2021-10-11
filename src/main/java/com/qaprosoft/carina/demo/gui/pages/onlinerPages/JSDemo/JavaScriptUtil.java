package com.qaprosoft.carina.demo.gui.pages.onlinerPages.JSDemo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.pages.onlinerPages.CarMarketPageOnliner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaScriptUtil{
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaScriptUtil.class);

    public static void flashElement(WebElement element, WebDriver driver){
        String bgColor = element.getCssValue("backGroundColor");

        for (int i = 0; i < 50; i++){
            changeColor("#000000",element,driver);
            changeColor(bgColor,element,driver);
        }
        }

        public  static void changeColor(String color,WebElement element,WebDriver driver){
            JavascriptExecutor js = ((JavascriptExecutor)driver) ;
            js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        }


