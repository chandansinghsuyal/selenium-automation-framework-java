package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterNegativeTest extends BaseTest {
    @Test
    public void testRegistrationWithMismatchedPasswords() {
        HomePage home = new HomePage(driver);
        home.clickRegister();
        RegisterPage register = new RegisterPage(driver);
        register.selectGender("male");
        register.enterFirstName("Mismatch");
        register.enterLastName("User");
        String email = "mismatch" + System.currentTimeMillis() + "@example.com";
        register.enterEmail(email);
        register.enterPassword("Test@1234");
        register.enterConfirmPassword("Test@5678");
        register.clickRegister();
        Assert.assertTrue(driver.getPageSource().contains("The password and confirmation password do not match."), "Mismatched password error not shown");
    }
} 