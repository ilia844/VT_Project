package com.lowcostairline.reader;

import java.util.Scanner;

public class Reader {
    private static Scanner scanner = new Scanner(System.in);

    private Reader() {
    }

    public static int nextInt() {

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;

    }

    public static String nextString(){

        String value;
        if (scanner.hasNext()) {
            value = scanner.next();
            return value;
        }
        return null;
    }
}