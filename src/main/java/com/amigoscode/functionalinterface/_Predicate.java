package com.amigoscode.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNotEmpty.and(doesPhoneStartWithPlus).test("+54"));
    }

    static Predicate<String> isPhoneNotEmpty =
            phone -> !phone.isEmpty();

    static Predicate<String> doesPhoneStartWithPlus =
            phone -> phone.startsWith("+");


}
