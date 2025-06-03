package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testValidLogin() {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.login(config.getProperty("validUserEmail"), config.getProperty("validUserPassword"));
        // Assert user is logged in by checking logout link or user account
        Assert.assertTrue(driver.getPageSource().contains("Log out"), "Login failed");
    }

    @Test
    public void testInvalidLogin() {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.login("invalid@example.com", "wrongpassword");
        Assert.assertTrue(login.getErrorMessage().contains("Login was unsuccessful"), "Error message not displayed");
    }
} 