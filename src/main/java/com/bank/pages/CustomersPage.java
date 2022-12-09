package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomersPage extends Utility {

    By clickName = By.xpath("//select[@ng-model ='custId']");
    By login = By.xpath("//button[@class ='btn btn-default']");
    By myNameText = By.xpath("//span[@class ='fontBig ng-binding']");
    By logout = By.xpath("//button[@class ='btn logout']");

    By logoutTab = By.xpath("//button[@class ='btn logout']");
    public void clickOnName(){
        clickOnElement(clickName);
    }

    public void selectYourName(String myname){
        List<WebElement> listOfNames = driver.findElements(By.xpath("//option[@ng-repeat ='cust in Customers']"));
        for (WebElement name:listOfNames) {
            if (name.getText().equalsIgnoreCase(myname)){
                name.click();
            }

        }


    }
    public void clickLoginTab(){
        clickOnElement(login);
    }

    public String getNameText(){
        return getTextFromElement(myNameText);
    }

    public String getLogOutText(){
        return getTextFromElement(logout);
    }
    public void clickLogOutTab(){
        clickOnElement(logoutTab);
    }

}
