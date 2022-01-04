package ru.gb.lessons.Lesson8.Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartPage extends BasicElementsPage {

    private SelenideElement pageHeading = $x("//h1[@class='page-heading']");
    private SelenideElement proceedToCheckoutBtn = $x("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");

    @Step("Убедиться что загрузилась страница корзины")
    public ShoppingCartPage checkProceedToCart (){
        assertThat(pageHeading.getText()).as("Не удалось открыть корзину").contains("SHOPPING-CART SUMMARY");
        return this;
    }

    @Step("Нажать кнопку Proceed to checkout")
    public AddressesPage clickProceedToCheckout (){
        proceedToCheckoutBtn.click();
        return page(AddressesPage.class);
    }
}
