package ua.allo;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public void searchFor(String searchProduct) {
        $("#search-form__input").val(searchProduct).pressEnter();
    }
}
