package test;

import com.sun.tools.javac.util.Assert;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Data.DataHelper;
import Page.LoginPage;

class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {

        val loginPage = new LoginPage();
        loginPage.openLoginPage();

        val authInfo = DataHelper.getAuthInfo();

        val verificationPage = loginPage.validLogin(authInfo);

        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);

        val originFirstCardValue = dashBoardPage.getFirstCardBalance();
        val originSecondCardValue = dashBoardPage.getSecondCardBalance();

        val moneyTransferPage = dashBoardPage.pushMakeDepositFirstAccount();

        val transferInfo = DataHelper.getRandomValueTransferInfo(Math.abs(originSecondCardValue), DataHelper.SECOND_ACCOUNT);

        val dashBoardPage2 = moneyTransferPage.setAmountAndCard(transferInfo);

        val actualFirstCardBalance = dashBoardPage2.getFirstCardBalance();
        val actualSecondCardBalance = dashBoardPage2.getSecondCardBalance();

        Assertions.assertEquals(originFirstCardValue + transferInfo.getAmount(), actualFirstCardBalance);
        Assertions.assertEquals(originSecondCardValue - transferInfo.getAmount(), actualSecondCardBalance);

    }
    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {

        val loginPage = new LoginPage();
        loginPage.openLoginPage();

        val authInfo = DataHelper.getAuthInfo();

        val verificationPage = loginPage.validLogin(authInfo);

        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);

        val originFirstCardValue = dashBoardPage.getFirstCardBalance();
        val originSecondCardValue = dashBoardPage.getSecondCardBalance();

        val moneyTransferPage = dashBoardPage.pushMakeDepositFirstAccount();

        val transferInfo = DataHelper.getSecondTransferInfo();

        /*Assertions.assertTrue(originSecondCardValue > transferInfo.getAmount());
        /Правильнее было бы сделать проверку на этом этапе*/

        val dashBoardPage2 = moneyTransferPage.setAmountAndCard(transferInfo);

        val actualFirstCardBalance = dashBoardPage2.getFirstCardBalance();
        val actualSecondCardBalance = dashBoardPage2.getSecondCardBalance();

        Assertions.assertEquals(originFirstCardValue + transferInfo.getAmount(), actualFirstCardBalance);
        Assertions.assertTrue(actualSecondCardBalance > 0);
        Assertions.assertEquals(originSecondCardValue - transferInfo.getAmount(), actualSecondCardBalance);

    }

}

