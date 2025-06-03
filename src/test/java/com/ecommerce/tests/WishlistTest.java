package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {
    @Test
    public void testAddToWishlist() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Apple MacBook Pro 13-inch");
        ProductPage product = new ProductPage(driver);
        product.addToWishlist();
        Assert.assertTrue(product.getSuccessMessage().contains("The product has been added to your wishlist"), "Add to wishlist failed");
    }

    @Test
    public void testRemoveFromWishlist() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Apple MacBook Pro 13-inch");
        ProductPage product = new ProductPage(driver);
        product.addToWishlist();
        driver.get("https://demo.nopcommerce.com/wishlist");
        WishlistPage wishlist = new WishlistPage(driver);
        wishlist.removeFromWishlist();
        Assert.assertTrue(wishlist.getEmptyWishlistMessage().contains("The wishlist is empty!"), "Wishlist not empty after removal");
    }
} 