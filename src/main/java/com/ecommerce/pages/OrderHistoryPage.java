package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage extends BasePage {
    private By orderList = By.cssSelector("div.order-list");
    private By orderDetailsButton = By.cssSelector("button.order-details-button");

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderListDisplayed() {
        return driver.findElement(orderList).isDisplayed();
    }

    public void viewOrderDetails() {
        driver.findElement(orderDetailsButton).click();
    }
} 