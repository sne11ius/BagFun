package com.example;

public final class Main {

    public static void main(final String[] args) {
        System.out.println("MapBackedBag");
        testBag(new MapBackedBag<String>());
        System.out.println("-----");
        System.out.println("FakedBag");
        testBag(new FakedBag<String>());
        System.out.println("-----");
        System.out.println("TreeSetBackedBag");
        testBag(new TreeSetBackedBag<String>());
    }

    private static void testBag(final Bag<String> testBag) {
        testBag.add("asd");
        testBag.add("asd");
        testBag.add("asd");
        testBag.add("asd");
        testBag.add("123");

        System.out.println(testBag.find("asd"));
        System.out.println(testBag.findAll("asd"));
        System.out.println(testBag.find("123"));
        System.out.println(testBag.findAll("123"));
        System.out.println(testBag.find("not there"));

        testBag.remove("asd");
        testBag.remove("123");

        System.out.println(testBag.find("asd"));
        System.out.println(testBag.findAll("asd"));
        System.out.println(testBag.find("123"));
        System.out.println(testBag.findAll("123"));
        System.out.println(testBag.find("not there"));

        testBag.remove("asd");
        testBag.remove("asd");
        testBag.remove("asd");
        testBag.remove("asd");

        System.out.println(testBag.find("asd"));
        System.out.println(testBag.findAll("asd"));
        System.out.println(testBag.find("123"));
        System.out.println(testBag.findAll("123"));
        System.out.println(testBag.find("not there"));
    }

}
