package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test
    public void testAddToCart() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Apple MacBook Pro 13-inch");
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        Assert.assertTrue(product.getSuccessMessage().contains("The product has been added to your shopping cart"), "Add to cart failed");
    }

    @Test
    public void testUpdateCartQuantity() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Apple MacBook Pro 13-inch");
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        driver.get("https://demo.nopcommerce.com/cart");
        CartPage cart = new CartPage(driver);
        cart.updateQuantity("2");
        Assert.assertTrue(driver.getPageSource().contains("Quantity: 2"), "Cart quantity not updated");
    }

    @Test
    public void testRemoveFromCart() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Apple MacBook Pro 13-inch");
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        driver.get("https://demo.nopcommerce.com/cart");
        CartPage cart = new CartPage(driver);
        cart.removeFromCart();
        Assert.assertTrue(cart.getEmptyCartMessage().contains("Your Shopping Cart is empty!"), "Cart not empty after removal");
    }
} 