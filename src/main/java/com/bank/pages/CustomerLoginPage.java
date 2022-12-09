package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility {

    By customLogin = By.xpath("//button[@ng-click ='customer()']");

    public void clickCustomerLogin(){
        clickOnElement(customLogin);
    }
}
