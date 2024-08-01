package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {

    private static Faker faker = new Faker(Locale.ENGLISH);

    public static AuthInfo getValidAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getInvalidAuthInfo() {
        return new AuthInfo(generateLogin(), generatePassword());
    }

    public static String generateLogin() {
        return faker.name().firstName();
    }

    public static String generatePassword() {
        return faker.witcher().character();
    }

    public static String generateVerificationCode() {
        return faker.numerify("######");
    }
}
