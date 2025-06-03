package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartNegativeTest extends BaseTest {
    @Test
    public void testUpdateCartWithZeroQuantity() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Apple MacBook Pro 13-inch");
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        driver.get("https://demo.nopcommerce.com/cart");
        CartPage cart = new CartPage(driver);
        cart.updateQuantity("0");
        Assert.assertTrue(cart.getEmptyCartMessage().contains("Your Shopping Cart is empty!"), "Cart should be empty after setting quantity to zero");
    }

    @Test
    public void testUpdateCartWithNegativeQuantity() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Apple MacBook Pro 13-inch");
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        driver.get("https://demo.nopcommerce.com/cart");
        CartPage cart = new CartPage(driver);
        cart.updateQuantity("-1");
        Assert.assertTrue(driver.getPageSource().contains("Quantity must be positive"), "Negative quantity error not shown");
    }
} 