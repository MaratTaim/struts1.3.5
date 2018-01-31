package com.epam.testapp.util;

public class ParseDate {

    public static String parse(String date, int i) {
        String[] sp;
        String ch = "-";
        String ch2 = "/";
        switch (i) {
            case 1:
                sp = date.split(ch);
                date = sp[2] + ch2 + sp[1] + ch2 + sp[0];
                break;
            case 2:
                sp = date.split(ch2);
                date = sp[2] + ch + sp[1] + ch + sp[0];
                break;
        }
        return date;

    }
}