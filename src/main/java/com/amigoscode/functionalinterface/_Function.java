package com.amigoscode.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        // Function. Takes 1, Produces 1 result
        System.out.println("\n~~ Function. Takes 1, produces 1. ~~");

        int start = 1;
        System.out.println("First number = " + start);

        int increment = incrementByOneFunction.apply(start);
        System.out.println("incrementByOne.apply(" + start + ") = " + increment);

        int multiply = multiplyByTenFunction.apply(increment);
        System.out.println("multiplyByTen.apply(" + increment + ") = " + multiply);

        int incrementAndMultiply = addByOneAndThenMultiplyByTen.apply(start);
        System.out.println("addByOneAndThenMultiplyByTen.apply(" + start + ") = " + incrementAndMultiply);

        // BiFunction. Takes 2, Produces 1
        System.out.println("\n~~ BiFunction. Takes 2, produces 1. ~~");
        int res = incrementByOneAndMultiply.apply(1, 100);
        System.out.println("incrementByOneAndMultiply.apply(1, 100) = " + res);

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    static Function<Integer, Integer> addByOneAndThenMultiplyByTen =
            incrementByOneFunction.andThen(multiplyByTenFunction);

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply =
            (numToIncrement, numToMultiply)
                    -> (numToIncrement + 1) * numToMultiply;
}
