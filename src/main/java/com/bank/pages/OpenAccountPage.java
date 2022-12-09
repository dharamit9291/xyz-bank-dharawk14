package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenAccountPage extends Utility {

    By openAccount = By.xpath("//button[@ng-class = 'btnClass2']");

    By customerName = By.xpath("//select[@id = 'userSelect']");
    By listOfCustomer = By.xpath("//option[@ng-repeat= 'cust in Customers']");
    By currencyTab = By.xpath("//select[@id = 'currency']");

    By listOfCurrency = By.xpath("//select[@id = 'currency']//option");

    By processButton = By.xpath("//button[@type = 'submit']");


    public void openAccountTab() {
        clickOnElement(openAccount);
    }

    public void clickCustomerName() {
        clickOnElement(customerName);
    }

    public void selectCustomer(String customerName) {
        List<WebElement> selectedName = driver.findElements(listOfCustomer);
        for (WebElement name : selectedName) {
            if (name.getText().equalsIgnoreCase(customerName)) {
                name.click();
            }

        }
    }

    public void clickCurrency() {
        clickOnElement(currencyTab);
    }

    public void selectCurrency(String enterCurrency) {
        List<WebElement> currency = driver.findElements(listOfCurrency);
        for (WebElement pound : currency) {
            if (pound.getText().equalsIgnoreCase(enterCurrency)) {
                pound.click();
            }
        }
    }

    public void clickProcess() {
        clickOnElement(processButton);
    }

    public String switchToPopup() {
        return getTextFromAlert();
    }

    public void acceptPopup() {
        switchToAcceptAlert();

    }
}
