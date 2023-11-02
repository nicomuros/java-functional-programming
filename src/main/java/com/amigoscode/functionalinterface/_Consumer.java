package com.amigoscode.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer martin = new Customer("Martin", "2604333333");

        // Normal Java
        System.out.println("\n~~ Normal Java ~~");
        System.out.println();
        greetCustomer(martin);

        // Consumer Functional interface
        System.out.println("\n~~ Consumer ~~");
        greetCustomerConsumer.accept(martin);

        // BiConsumer Functional Interface
        System.out.println("\n ~~ BiConsumer - TRUE ~~");
        greetCustomerConsumerv2.accept(martin, true);
        System.out.println("\n ~~ BiConsumer - FALSE ~~");
        greetCustomerConsumerv2.accept(martin, false);
    }

    // Accept Customer, and is void.
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.name + ", your phone number is: " + customer.phone);

    // Accept Customer and Boolean. Void
    static BiConsumer<Customer, Boolean> greetCustomerConsumerv2 =
            (customer, showPhone) ->
                    System.out.println(
                            "Hello " + customer.name
                                    + ", your phone number is: "
                                    + (showPhone ? customer.phone : "********"));

    // Normal Java
    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.name + ", your phone number is: " + customer.phone);
    }
    static class Customer{
        private final String name;
        private final String phone;

        public Customer(String name, String phone){
            this.name = name;
            this.phone = phone;
        }
    }
}
