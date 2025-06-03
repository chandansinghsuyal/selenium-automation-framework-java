package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderHistoryNegativeTest extends BaseTest {
    @Test
    public void testOrderHistoryWithNoOrders() {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        // Use a user with no orders (update config or hardcode for demo)
        login.login("noorders@example.com", "Test@1234");
        driver.get("https://demo.nopcommerce.com/order/history");
        Assert.assertTrue(driver.getPageSource().contains("No orders"), "No orders message not shown for user with no orders");
    }
} 