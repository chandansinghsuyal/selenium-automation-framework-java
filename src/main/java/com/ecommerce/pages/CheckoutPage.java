package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private By billingContinueButton = By.xpath("//button[@onclick='Billing.save()']");
    private By shippingContinueButton = By.xpath("//button[@onclick='Shipping.save()']");
    private By shippingMethodContinueButton = By.xpath("//button[@onclick='ShippingMethod.save()']");
    private By paymentMethodContinueButton = By.xpath("//button[@onclick='PaymentMethod.save()']");
    private By paymentInfoContinueButton = By.xpath("//button[@onclick='PaymentInfo.save()']");
    private By confirmOrderButton = By.xpath("//button[@onclick='ConfirmOrder.save()']");
    private By orderConfirmationMessage = By.cssSelector("div.title strong");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void completeCheckout() {
        driver.findElement(billingContinueButton).click();
        driver.findElement(shippingContinueButton).click();
        driver.findElement(shippingMethodContinueButton).click();
        driver.findElement(paymentMethodContinueButton).click();
        driver.findElement(paymentInfoContinueButton).click();
        driver.findElement(confirmOrderButton).click();
    }

    public String getOrderConfirmationMessage() {
        return driver.findElement(orderConfirmationMessage).getText();
    }
} 