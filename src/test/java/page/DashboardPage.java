package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement dashboard = $("[data-test-id=dashboard]");

    public DashboardPage() {
        dashboard.shouldBe(visible).shouldHave(text("Личный кабинет"));
    }
}
