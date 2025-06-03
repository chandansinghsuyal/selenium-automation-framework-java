package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoginDataDrivenTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Iterator<Object[]> loginDataProvider() throws IOException {
        List<Map<String, String>> data = JsonUtil.readJson("resources/logindata.json", List.class);
        return data.stream().map(row -> new Object[]{row.get("email"), row.get("password"), row.get("expected")}).iterator();
    }

    @Test(dataProvider = "loginData")
    public void testLoginDataDriven(String email, String password, String expected) {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.login(email, password);
        if ("success".equals(expected)) {
            Assert.assertTrue(driver.getPageSource().contains("Log out"), "Login should succeed for: " + email);
        } else {
            Assert.assertTrue(login.getErrorMessage().contains("Login was unsuccessful"), "Login should fail for: " + email);
        }
    }
} 