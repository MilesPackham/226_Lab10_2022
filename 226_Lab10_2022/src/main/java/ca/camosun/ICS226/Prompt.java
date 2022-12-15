package ca.camosun.ICS226;

import java.io.*;
import java.util.Scanner;

/**
 * class for prompting the user
 */
public class Prompt {

    /**
     * empty constructor
     */
    private Prompt(){}

    private static final String GET = "G";
    private static final String PUT = "P";
    private static final String CLEAR = "C";
    private static final String OPTIONS = "Please select an option:\n" + 
    GET + " to get the board\n" +
    PUT + "[layer][column][row][token] to put a token on the board\n" +
    CLEAR + " to clear the board\n" + "Request";

    private static Scanner sc = new Scanner(System.in);

    /**
     * outputs a prompt to the console and returns the input
     * @param prompt the prompt to be sent
     * @return the user input
     */
    private static String sendPrompt(String prompt) {
        System.out.print(prompt + ": ");
        String message = sc.next();
        return message;
    }

    /**
     * Prompts the user for the client connection information
     * @return an array of the server address and port
     */
    public static String[] getClientArgs() {
        return new String[] {
            System.console().readLine("Enter server address: "),
            System.console().readLine("Enter server port: ")
        };
    }

    /**
     * prompts the user for an input
     * @return the user input
     */
    public static String getUserInput() {
        return sendPrompt(OPTIONS);
    }
}