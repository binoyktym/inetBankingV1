package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.testCases.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass
{

    @Test
    public void loginTest() throws IOException
    {

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Entered User Name");

        lp.setPassword(password);
        logger.info("Entered Password");

        lp.clickSubmit();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        } else
        {
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
    }

}
