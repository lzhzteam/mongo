package com.achd.mongo.Utilities;

import java.math.BigDecimal;

public class NumberUtils {

    public static Double getTwoDecimalPlace(Double number) {
        BigDecimal b = new BigDecimal(number);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String getScale(Long number1, Long number2) {
        Long step = Long.min(number1, number2);
        for (int i = 2; i <= step; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                number1 /= i;
                number2 /= i;
                step /= i;
            }
        }

        return number1 + " : " + number2;
    }
}
