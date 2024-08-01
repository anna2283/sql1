package page;

import com.codeborne.selenide.SelenideElement;
import data.AuthInfo;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement inputName = $("[data-test-id=login] input");
    private final SelenideElement inputPassword = $("[data-test-id=password] input");
    private final SelenideElement submitButton = $("[data-test-id=action-login]");
    private final SelenideElement errorMsg = $("[data-test-id=error-notification]");
    private final String incorrectAuthMsg = "Неверно указан логин или пароль";

    private void login(AuthInfo info) {
        inputName.setValue(info.getLogin());
        inputPassword.setValue(info.getPassword());
        submitButton.click();
    }

    public VerificationPage validLogin(AuthInfo info) {
        login(info);
        return new VerificationPage();
    }

    public void invalidLogin(AuthInfo info) {
        login(info);
        errorMsg.shouldBe(visible).shouldHave(text(incorrectAuthMsg));
    }
}
