package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.CartPage;
import com.ecommerce.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CartDataDrivenTest extends BaseTest {
    @DataProvider(name = "cartData")
    public Iterator<Object[]> cartDataProvider() throws IOException {
        List<List<String>> data = ExcelUtil.readExcel("resources/testdata.xlsx", "CartData");
        // Skip header row
        return data.stream().skip(1).map(row -> row.toArray(new Object[0])).iterator();
    }

    @Test(dataProvider = "cartData")
    public void testAddToCartDataDriven(String productName, String quantity) {
        HomePage home = new HomePage(driver);
        home.searchProduct(productName);
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        driver.get("https://demo.nopcommerce.com/cart");
        CartPage cart = new CartPage(driver);
        cart.updateQuantity(quantity);
        Assert.assertTrue(driver.getPageSource().contains("Quantity: " + quantity), "Cart quantity not updated for: " + productName);
    }
} 