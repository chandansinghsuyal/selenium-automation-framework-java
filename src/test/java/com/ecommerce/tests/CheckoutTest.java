package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
    public void testCheckoutProcess() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Apple MacBook Pro 13-inch");
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        driver.get("https://demo.nopcommerce.com/cart");
        driver.get("https://demo.nopcommerce.com/checkout");
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.completeCheckout();
        Assert.assertTrue(checkout.getOrderConfirmationMessage().contains("Your order has been successfully processed!"), "Order not confirmed");
    }
} 