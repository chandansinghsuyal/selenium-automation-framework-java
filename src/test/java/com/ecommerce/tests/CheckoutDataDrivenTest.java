package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CheckoutDataDrivenTest extends BaseTest {
    @DataProvider(name = "checkoutData")
    public Iterator<Object[]> checkoutDataProvider() throws IOException {
        List<Map<String, Object>> data = JsonUtil.readJson("resources/checkoutdata.json", List.class);
        return data.stream().map(row -> new Object[]{row.get("product"), row.get("quantity")}).iterator();
    }

    @Test(dataProvider = "checkoutData")
    public void testCheckoutDataDriven(String productName, int quantity) {
        HomePage home = new HomePage(driver);
        home.searchProduct(productName);
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        driver.get("https://demo.nopcommerce.com/cart");
        CartPage cart = new CartPage(driver);
        cart.updateQuantity(String.valueOf(quantity));
        driver.get("https://demo.nopcommerce.com/checkout");
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.completeCheckout();
        Assert.assertTrue(checkout.getOrderConfirmationMessage().contains("Your order has been successfully processed!"), "Order not confirmed for: " + productName);
    }
} 