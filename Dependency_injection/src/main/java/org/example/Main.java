package org.example;

public class Main {
    public static void main(String[] args) {

        Dollar dollar = new Dollar("USD", 1.06);
        Sterling sterling = new Sterling("GBP",1.14);
        Euro euro = new Euro("EUR", 1);

        CurrencyConverter currencyConverter = CurrencyConverter.getInstance();
        Book book = new Book("ThisBook", 100);

        currencyConverter.setCurrency(dollar);
        System.out.println(currencyConverter.convertPrice(book));

        currencyConverter.setCurrency(sterling);
        System.out.println(currencyConverter.convertPrice(book));

        currencyConverter.setCurrency(euro);
        System.out.println(currencyConverter.convertPrice(book));

    }
}