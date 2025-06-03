package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.WishlistPage;
import com.ecommerce.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class WishlistDataDrivenTest extends BaseTest {
    @DataProvider(name = "wishlistData")
    public Iterator<Object[]> wishlistDataProvider() throws IOException {
        List<List<String>> data = ExcelUtil.readExcel("resources/testdata.xlsx", "WishlistData");
        // Skip header row
        return data.stream().skip(1).map(row -> row.toArray(new Object[0])).iterator();
    }

    @Test(dataProvider = "wishlistData")
    public void testAddToWishlistDataDriven(String productName) {
        HomePage home = new HomePage(driver);
        home.searchProduct(productName);
        ProductPage product = new ProductPage(driver);
        product.addToWishlist();
        Assert.assertTrue(product.getSuccessMessage().contains("The product has been added to your wishlist"), "Add to wishlist failed for: " + productName);
    }
} 