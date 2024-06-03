package com.example.converter;

public class DecimalConverter {


    public static String toBinary(int decimal) {
        String binary = "";
        while (decimal > 0) {
            binary = (decimal % 2) + binary;
            decimal /= 2;
        }
        return binary.isEmpty() ? "0" : binary;
    }


    public static String toOctal(int decimal) {
        String octal = "";
        while (decimal > 0) {
            octal = (decimal % 8) + octal;
            decimal /= 8;
        }
        return octal.isEmpty() ? "0" : octal;
    }


    public static String toHexadecimal(int decimal) {
        String hexadecimal = "";
        while (decimal > 0) {
            int remainder = decimal % 16;
            if (remainder < 10)
                hexadecimal = (char) (remainder + '0') + hexadecimal;
            else
                hexadecimal = (char) (remainder - 10 + 'A') + hexadecimal;
            decimal /= 16;
        }
        return hexadecimal.isEmpty() ? "0" : hexadecimal;
    }
}

