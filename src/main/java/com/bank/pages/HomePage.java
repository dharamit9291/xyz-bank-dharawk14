package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By homebutton = By.xpath("//button[contains(text(),'Home')]");

    public void clickHomepage(){
        clickOnElement(homebutton);
    }

}
