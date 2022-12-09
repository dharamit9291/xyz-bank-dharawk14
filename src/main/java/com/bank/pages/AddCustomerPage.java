package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class AddCustomerPage extends Utility {


    By AddCustomer = By.xpath("//button[@ng-class = 'btnClass1']");

    By enterFirstName = By.xpath("//input[@ng-model = 'fName']");
    By enterLastName = By.xpath("//input[@ng-model = 'lName']");

    By postCode = By.xpath("//input[@ng-model = 'postCd']");

    By clickAddCustomer = By.xpath("//button[@class = 'btn btn-default']");
    public void addCustomerTab(){
        clickOnElement(AddCustomer);
    }

    public void enterFirstNameTab(String name){
        sendTextToElement(enterFirstName,name);
    }

    public void enterLastName(String lname){
    sendTextToElement(enterLastName,lname);
    }

    public void postCode(String pin){
        sendTextToElement(postCode,pin);
    }
    public void addCustomerButton(){
        clickOnElement(clickAddCustomer);
    }
    public String getTextFromPopup(){
        return getTextFromAlert();
    }

    public void acceptPopup(){
        switchToAcceptAlert();
    }
}
