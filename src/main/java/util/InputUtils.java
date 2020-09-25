package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtils {

    public static String getLine() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Incorrect input format");
        }
    }

    public static double getDouble() {
        return Double.parseDouble(getLine());
    }

    public static int getInt() {
        return Integer.parseInt(getLine());
    }
}
