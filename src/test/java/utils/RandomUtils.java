package utils;

import java.security.SecureRandom;

public final class RandomUtils {

    private RandomUtils(){}

    public static String getRandomString(int length) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            stringBuilder.append(AB.charAt(secureRandom.nextInt(AB.length())));
        }
        return stringBuilder.toString();
    }

    public static String getRandomEmail(){
        return getRandomString(12) + "@email.com";
    }
}
