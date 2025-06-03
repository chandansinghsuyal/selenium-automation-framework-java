package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProfilePage;
import com.ecommerce.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProfileDataDrivenTest extends BaseTest {
    @DataProvider(name = "profileData")
    public Iterator<Object[]> profileDataProvider() throws IOException {
        List<Map<String, String>> data = JsonUtil.readJson("resources/profiledata.json", List.class);
        return data.stream().map(row -> new Object[]{row.get("firstName"), row.get("lastName")}).iterator();
    }

    @Test(dataProvider = "profileData")
    public void testProfileUpdateDataDriven(String firstName, String lastName) {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.login(config.getProperty("validUserEmail"), config.getProperty("validUserPassword"));
        driver.get("https://demo.nopcommerce.com/customer/info");
        ProfilePage profile = new ProfilePage(driver);
        profile.updateFirstName(firstName);
        profile.updateLastName(lastName);
        profile.saveProfile();
        Assert.assertTrue(profile.getSuccessMessage().contains("The customer info has been updated successfully."), "Profile not updated for: " + firstName + " " + lastName);
    }
} 