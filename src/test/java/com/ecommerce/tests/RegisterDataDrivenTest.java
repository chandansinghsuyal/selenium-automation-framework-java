package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class RegisterDataDrivenTest extends BaseTest {
    @DataProvider(name = "registerData")
    public Iterator<Object[]> registerDataProvider() throws IOException {
        List<List<String>> data = ExcelUtil.readExcel("resources/testdata.xlsx", "RegisterData");
        // Skip header row
        return data.stream().skip(1).map(row -> row.toArray(new Object[0])).iterator();
    }

    @Test(dataProvider = "registerData")
    public void testRegisterDataDriven(String firstName, String lastName, String email, String password, String confirmPassword, String gender) {
        HomePage home = new HomePage(driver);
        home.clickRegister();
        RegisterPage register = new RegisterPage(driver);
        register.selectGender(gender);
        register.enterFirstName(firstName);
        register.enterLastName(lastName);
        register.enterEmail(email);
        register.enterPassword(password);
        register.enterConfirmPassword(confirmPassword);
        register.clickRegister();
        Assert.assertTrue(register.getResultMessage().contains("Your registration completed"), "Registration failed for: " + email);
    }
} 