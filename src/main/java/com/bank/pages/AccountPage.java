package com.bank.pages;

import com.bank.utility.Utility;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;

public class AccountPage extends Utility {

    By deposit= By.xpath("//button[@ng-class ='btnClass2']");

    By accountField = By.xpath("//input[@ng-model ='amount']");
    By depositTab = By.xpath("//button[@type ='submit']");

    By successfulText = By.xpath("//span[@ng-show ='message']");

    By withDrawlTab =By.xpath("//div/button[@ng-click='withdrawl()']");
    By withdrawAmountField= By.xpath("//div/input[@type='number']");

    By withdrawButton = By.xpath("//div/form/button[@type='submit']");
    public void clickDeposit() {
        clickOnElement(deposit);
    }
    public void enterAmount(String amount){

        sendTextToElement(accountField,amount);
    }
    public void clickOnDeposit() {
        clickOnElement(depositTab);
    }
    public String getDepositText(){
        return getTextFromElement(successfulText);
    }
    public void clickWithDrawlTab(){
        clickOnElement(withDrawlTab);
    }
    public void clickAndEnterWithdrawField(String amount){
        sendTextToElement(withdrawAmountField,amount);
    }
    public void clickWithdrawButton(){
        clickOnElement(withdrawButton);
    }
    public String getWithdrawSuccessfulMessage(){
        return   getTextFromElement(successfulText);
    }
    }
