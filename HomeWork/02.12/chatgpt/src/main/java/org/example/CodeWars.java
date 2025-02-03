package org.example;

public class CodeWars {
    public class Kata {

        static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        public static String rot13(String str) {
            String[] symbols = str.split("");
            String newString ="";

            for(String symbol: symbols){
                if(symbol.matches("[a-z]")){
                    symbol = String.valueOf(
                            alphabet.charAt(
                                    (alphabet.indexOf(symbol.toLowerCase())+13) > alphabet.length()
                                    ? (alphabet.indexOf(symbol.toLowerCase())+13) - alphabet.length()
                                    : alphabet.indexOf(symbol.toLowerCase())+13
                    ));
                } else if(symbol.matches("[A-Z]")){
                    symbol = String.valueOf(
                            alphabet.charAt(
                                    (alphabet.indexOf(symbol.toLowerCase())+13) > alphabet.length()
                                            ? (alphabet.indexOf(symbol.toLowerCase())+13) - alphabet.length()
                                            : alphabet.indexOf(symbol.toLowerCase())+13
                            )).toUpperCase();
                }
                newString+=symbol;
            }


            return newString;
        }
    }
}
