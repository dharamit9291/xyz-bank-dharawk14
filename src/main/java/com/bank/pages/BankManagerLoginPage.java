package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class BankManagerLoginPage extends Utility {

    By BankManagerLogin = By.xpath("//button[@ng-click = 'manager()']");


    public void bankManagerLoginClick(){
        clickOnElement(BankManagerLogin);
    }


}
