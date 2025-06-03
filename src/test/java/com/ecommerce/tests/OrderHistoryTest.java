package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.OrderHistoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderHistoryTest extends BaseTest {
    @Test
    public void testViewOrderHistory() {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.login(config.getProperty("validUserEmail"), config.getProperty("validUserPassword"));
        driver.get("https://demo.nopcommerce.com/order/history");
        OrderHistoryPage orderHistory = new OrderHistoryPage(driver);
        Assert.assertTrue(orderHistory.isOrderListDisplayed(), "Order list not displayed");
    }

    @Test
    public void testViewOrderDetails() {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.login(config.getProperty("validUserEmail"), config.getProperty("validUserPassword"));
        driver.get("https://demo.nopcommerce.com/order/history");
        OrderHistoryPage orderHistory = new OrderHistoryPage(driver);
        orderHistory.viewOrderDetails();
        Assert.assertTrue(driver.getPageSource().contains("Order Information"), "Order details not displayed");
    }
} 