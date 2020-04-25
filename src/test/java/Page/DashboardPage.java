package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement firstCardNum = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardNum = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    String cardElementBtn = "[data-test-id=action-deposit]";


    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public Integer getFirstCardBalance() {
        String firstCard = firstCardNum.getText();

        String stringBalance = firstCard.substring(firstCard.indexOf(":") + 1, firstCard.indexOf("р.") - 1).trim();
        return Integer.parseInt(stringBalance);
    }

    public Integer getSecondCardBalance() {
        String secondCard = secondCardNum.getText();

        String stringBalance = secondCard.substring(secondCard.indexOf(":") + 1, secondCard.indexOf("р.") - 1).trim();
        return Integer.parseInt(stringBalance);
    }

    public MoneyTransferPage pushMakeDepositFirstAccount() {

        firstCardNum.$(cardElementBtn).click();
        return new MoneyTransferPage();
    }

    public MoneyTransferPage pushMakeDepositSecondAccount() {

        secondCardNum.$(cardElementBtn).click();
        return new MoneyTransferPage();
    }


}
