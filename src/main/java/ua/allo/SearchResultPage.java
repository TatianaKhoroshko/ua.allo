package ua.allo;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    public String searchResultTitle() {
        return $(".product-view__header h1").getText();
    }
}
