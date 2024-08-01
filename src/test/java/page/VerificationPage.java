package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement inputCode = $("[data-test-id=code] input");
    private final SelenideElement submitButton = $("[data-test-id=action-verify]");
    private final SelenideElement errorNotification = $("[data-test-id=error-notification]");
    private final String incorrectCodeNotification = "Неверно указан код! Попробуйте ещё раз";
    private final String limitNotification = "Ошибка!";

    public VerificationPage() {
        inputCode.shouldBe(visible);
    }

    private void verify(String verificationCode) {
        inputCode.setValue(verificationCode);
        submitButton.click();
    }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return new DashboardPage();
    }

    public void invalidVerify(String verificationCode) {
        verify(verificationCode);
        errorNotification
                .shouldBe(visible)
                .shouldHave(text(incorrectCodeNotification));
    }

    public void overLimitVerify(String verificationCode) {
        verify(verificationCode);
        errorNotification
                .shouldBe(visible)
                .shouldHave(text(limitNotification));
    }
}
