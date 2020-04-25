package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement firstCardNum = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardNum = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    String cardElementBtn = "[data-test-id=action-deposit]";
//    private SelenideElement firstCardTransferButton = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']"."[data-test-id=action-deposit]");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public Integer getFirstCardBalance() {
        String firstCard = firstCardNum.getText();
//        String firstCard = $(By.cssSelector("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']")).getText();
        String stringBalance = firstCard.substring(firstCard.indexOf(":") + 1, firstCard.indexOf("р.") - 1).trim();
        return Integer.parseInt(stringBalance);
    }

    public Integer getSecondCardBalance() {
        String secondCard = secondCardNum.getText();
//        String secondCard = $(By.cssSelector("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']")).getText();
        String stringBalance = secondCard.substring(secondCard.indexOf(":") + 1, secondCard.indexOf("р.") - 1).trim();
        return Integer.parseInt(stringBalance);
    }

    public MoneyTransferPage pushMakeDepositFirstAccount() {
        //        $(By.cssSelector("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']")).$(By.cssSelector("[data-test-id=action-deposit]")).click();
        firstCardNum.$(cardElementBtn).click();
        return new MoneyTransferPage();
    }

    public MoneyTransferPage pushMakeDepositSecondAccount() {
        //        $(By.cssSelector("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']")).$(By.cssSelector("[data-test-id=action-deposit]"));
        secondCardNum.$(cardElementBtn).click();
        return new MoneyTransferPage();
    }


}
