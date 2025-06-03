package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    private By firstNameInput = By.id("FirstName");
    private By lastNameInput = By.id("LastName");
    private By saveButton = By.name("save-info-button");
    private By successMessage = By.cssSelector("div.result");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void updateFirstName(String firstName) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void updateLastName(String lastName) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void saveProfile() {
        driver.findElement(saveButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
} 