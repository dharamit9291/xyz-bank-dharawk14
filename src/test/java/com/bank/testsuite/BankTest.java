package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import javafx.scene.control.Tab;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {

    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();

    OpenAccountPage openAccountPage = new OpenAccountPage();

    CustomerLoginPage customerLoginPage = new CustomerLoginPage();

    CustomersPage customersPage = new CustomersPage();

    AccountPage accountPage = new AccountPage();


    @Test
    public void bankManagerShouldAddCustomerSuccessfully() {
        bankManagerLoginPage.bankManagerLoginClick();
        addCustomerPage.addCustomerTab();
        addCustomerPage.enterFirstNameTab("Ram");
        addCustomerPage.enterLastName("Lakhan");
        addCustomerPage.postCode("HA0 1AB");
        addCustomerPage.addCustomerButton();
        Assert.assertEquals(addCustomerPage.getTextFromPopup().substring(0, 27), "Customer added successfully", "Not matching");
        addCustomerPage.acceptPopup();
    }

    @Test//(dependsOnMethods = {"bankManagerShouldAddCustomerSuccessfully"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        bankManagerShouldAddCustomerSuccessfully();
        homePage.clickHomepage();
        bankManagerLoginPage.bankManagerLoginClick();
        openAccountPage.openAccountTab();
        openAccountPage.clickCustomerName();
        openAccountPage.selectCustomer("ram lakhan");
        openAccountPage.clickCurrency();
        openAccountPage.selectCurrency("pound");
        openAccountPage.clickProcess();
        System.out.println(openAccountPage.switchToPopup());
        Assert.assertEquals(openAccountPage.switchToPopup().substring(0,28),"Account created successfully", "Not Matching");
        openAccountPage.acceptPopup();
    }

    @Test
    public void customerShouldLoginAndLogoutSuceessfully() {
       bankManagerShouldOpenAccountSuccessfully();
        homePage.clickHomepage();
        customerLoginPage.clickCustomerLogin();
        customersPage.clickOnName();
        customersPage.selectYourName("Ram Lakhan");
        customersPage.clickLoginTab();
        Assert.assertEquals(customersPage.getNameText(),"Ram Lakhan","Not Matching");
        Assert.assertEquals(customersPage.getLogOutText(),"Logout","Not Matching");
        customersPage.clickLogOutTab();

    }

    @Test
    public void customerShouldDepositMoneySuccessfully() {
        bankManagerShouldOpenAccountSuccessfully();
        homePage.clickHomepage();
        customerLoginPage.clickCustomerLogin();
        customersPage.clickOnName();
        customersPage.selectYourName("Ram Lakhan");
        customersPage.clickLoginTab();
        //click on "Deposit" Tab
        accountPage.clickDeposit();
      //  Enter amount 100
        accountPage.enterAmount("100");
      //  click on "Deposit" Button
        accountPage.clickOnDeposit();
      //  verify message "Deposit Successful"*/
        Assert.assertEquals(accountPage.getDepositText(),"Deposit Successful");
    }

    @Test
    public void customerShouldWithdrawMoneySuccessfully() {
        customerShouldDepositMoneySuccessfully();
        homePage.clickHomepage();
        customerLoginPage.clickCustomerLogin();
        customersPage.clickOnName();
        customersPage.selectYourName("Ram Lakhan");
        customersPage.clickLoginTab();
      //  click on "Withdrawl" Tab
        accountPage.clickWithDrawlTab();
      //  Enter amount 50
        accountPage.clickAndEnterWithdrawField("50");
      //  click on "Deposit" Button
        accountPage.clickWithdrawButton();
      //  verify message "Transaction Successful"
        Assert.assertEquals(accountPage.getWithdrawSuccessfulMessage(),"Transaction successful");
    }
}
