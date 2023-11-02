package com.amigoscode.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * In imperative programming, us a developers, have to declare every single detail about the implementation.
 */
public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Martin", Gender.MALE),
                new Person("Johanna", Gender.FEMALE)
        );

        // Imperative approach: if we want to find out how many female persons are in people:
        System.out.println("\nImperative approach:");
        List<Person> females = new ArrayList<>();

        // We need to specify HOW we are going to get what we need.
        for (Person person : people){
            if (Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person person : females){
            System.out.println(person);
        }

        // Declarative approach. Here we are not creating the list, not adding. We are just telling WHAT we want
        System.out.println("\nDeclarative approach:");
        List<Person> female2 = people  // Original List
                .stream() // Converting people list into a stream
                .filter(person -> person.gender.equals(Gender.FEMALE)) // Filter the person that we need
                .toList(); // Convert the result into a list.

        female2.forEach(System.out::println);
        System.out.println("\nPredicate example: ");
        // Predicate: A predicate represents a boolean-valued function that takes one argument. For example:
        Predicate<Person> personPredicate = person -> person.gender.equals(Gender.FEMALE);
    //  Accept Person type    Name          Argument  boolean predicate

        // So, i can use the predicate like this:

        people.stream()
                .filter(personPredicate)
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
