package ua.allo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {
    @BeforeEach
    void openPage() {
        open("https://allo.ua/");
    }

    @Test
    void searchProductByTitleAndAddToCard() {
        var productName = "Xiaomi Watch S1 Black";

        $("#search-form__input").val(productName).pressEnter();
        $(".product-view__header h1").shouldHave(text(productName));
        $("#product-buy-button").click();

        $(".v-modal__cmp-header span").shouldHave(text("Кошик"));
        $$("[class = 'products__list']").shouldHave(size(1));
        $(".product-item__wrap .wrap").shouldHave(text(productName));
    }

    @Test
    void searchProductByTitleTest(){
        var productName = "Xiaomi Watch S1 Black";
        new HomePage().searchFor(productName);
        var actualResultTitle = new SearchResultPage().searchResultTitle();
        Assertions.assertEquals(productName,actualResultTitle);
    }
}
