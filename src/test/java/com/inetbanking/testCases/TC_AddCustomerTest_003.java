package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClass{

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp= new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Entered Username");
        lp.setPassword(password);
        logger.info("Entered Password");
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addcust=new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();
        logger.info("Entering... Customer Details.....");
        //addcust.custClosePopup();
        addcust.custName("Pavan");
        addcust.custgender("male");
        addcust.custdob("10","15","1985");
        Thread.sleep(3000);
        addcust.custaddress("INDIA");
        addcust.custcity("HYD");
        addcust.custstate("AP");
        addcust.custpinno("5000074");
        addcust.custtelephoneno("987890091");
        addcust.custemailid(randomString()+"@gmail.com");
        addcust.custpassword("abcdef");
        addcust.custsubmit();
        Thread.sleep(3000);
        logger.info("Entered ... Customer Details....");

        logger.info("Validation started.....");
        if(driver.getPageSource().contains("Customer Registered Successfully!!!")){
            Assert.assertTrue(true);
            logger.info("Customer Added Successfully");
        }else{
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
            logger.info("Customer not added Successfully");
        }
    }


}
