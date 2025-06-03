package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test
    public void testUserRegistration() {
        HomePage home = new HomePage(driver);
        home.clickRegister();
        RegisterPage register = new RegisterPage(driver);
        register.selectGender("male");
        register.enterFirstName("John");
        register.enterLastName("Doe");
        String email = "test" + System.currentTimeMillis() + "@example.com";
        register.enterEmail(email);
        register.enterPassword("Test@1234");
        register.enterConfirmPassword("Test@1234");
        register.clickRegister();
        Assert.assertTrue(register.getResultMessage().contains("Your registration completed"), "Registration failed");
    }
} 