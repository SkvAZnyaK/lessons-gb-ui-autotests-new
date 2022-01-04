package ru.gb.lessons.Lesson8.Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ShippingPage extends BasicElementsPage {

    private SelenideElement pageHeading = $x("//h1[@class='page-heading']");
    private SelenideElement cgvCheckBtn = $(By.id("cgv"));
    private SelenideElement proceedBtn = $x("//button[@name='processCarrier']");

    @Step("Убедиться что загрузилась страница доставки")
    public ShippingPage checkProceedToShipping(){
        assertThat(pageHeading.getText()).as("Не удалось перейти к выбору метода доставки").isEqualTo("SHIPPING");
        return this;
    }

    @Step("Поставить галочку в чекбоксе I agree to the terms of service and will adhere to them unconditionally.")
    public ShippingPage clickAgree(){
        cgvCheckBtn.click();
        return this;
    }

    @Step("Нажать кнопку Proceed to checkout")
    public PaymentMethodPage clickProceed(){
        proceedBtn.click();
        return page(PaymentMethodPage.class);
    }
}
