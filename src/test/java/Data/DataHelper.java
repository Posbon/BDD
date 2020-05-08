package Data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
    public static final String FIRST_ACCOUNT="5559 0000 0000 0001" ;
    public static final String SECOND_ACCOUNT="5559 0000 0000 0002" ;

    private DataHelper() {
    }

    @Value
    public static class TransferInfo {
        private Integer amount;
        private String fromCard;
    }


    public static TransferInfo getRandomValueTransferInfo(Integer maxValue,String fromCard) {
        return new TransferInfo(new Random().nextInt(maxValue),fromCard);
    }


    public static TransferInfo getFirstTransferInfo() {
        return new TransferInfo(20000, SECOND_ACCOUNT);
    }

    public static TransferInfo getSecondTransferInfo() {
        return new TransferInfo(5400, FIRST_ACCOUNT);
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }


    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

}
