package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {
    @Test
    public void testUpdateProfile() {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.login(config.getProperty("validUserEmail"), config.getProperty("validUserPassword"));
        driver.get("https://demo.nopcommerce.com/customer/info");
        ProfilePage profile = new ProfilePage(driver);
        profile.updateFirstName("UpdatedFirstName");
        profile.updateLastName("UpdatedLastName");
        profile.saveProfile();
        Assert.assertTrue(profile.getSuccessMessage().contains("The customer info has been updated successfully."), "Profile not updated");
    }
} 