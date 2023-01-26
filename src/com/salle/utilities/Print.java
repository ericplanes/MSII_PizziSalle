package com.salle.utilities;

import java.awt.Color;

import jconsole.*;

public class Print {

    private JConsole console;

    public Print(JConsole console) {
        this.console = console;
    }

    public void readKey() {
        console.readKey();
    }

    public void clear() {
        console.clear();
    }

    public void space(int spaces) {
        for (int i = 0; i < spaces; i++) {
            console.println();
        }
    }

    public void printTitle(String message) {
        int extraChar = ConstantUtilities.consoleHorizontal - message.length();
        console.clear();

        for (int num = 0; num < (extraChar / 2); num++) {
            printYELLOW("-");
        }

        printYELLOW(message.toUpperCase());

        for (int num = 0; num < ((extraChar / 2) - 1); num++) {
            printYELLOW("-");
        }

        space(1);
    }

    public void printErrorMessage(String message) {
        console.clear();
        printErrorTitle("AN ERROR HAS OCURRED");
        console.setForegroundColor(Color.RED);
        console.print(message + "\n\n" + "Click to go back.\n");
        console.resetColor();
        console.readKey();
        console.clear();
    }

    public void printErrorTitle(String message) {
        int extraChar = ConstantUtilities.consoleHorizontal - message.length();

        for (int num = 0; num < (extraChar / 2); num++) {
            printRED("-");
        }

        printRED(message.toUpperCase());

        for (int num = 0; num < ((extraChar / 2) - 1); num++) {
            printRED("-");
        }

        space(1);
    }

    public void printBLACK(String message) {
        console.setForegroundColor(Color.BLACK);
        console.print(message);
        console.resetColor();
    }

    public void printBLUE(String message) {
        console.setForegroundColor(Color.BLUE);
        console.print(message);
        console.resetColor();
    }

    public void printCYAN(String message) {
        console.setForegroundColor(Color.CYAN);
        console.print(message);
        console.resetColor();
    }

    public void printDarkGRAY(String message) {
        console.setForegroundColor(Color.DARK_GRAY);
        console.print(message);
        console.resetColor();
    }

    public void printGRAY(String message) {
        console.setForegroundColor(Color.GRAY);
        console.print(message);
        console.resetColor();
    }

    public void printGREEN(String message) {
        console.setForegroundColor(Color.GREEN);
        console.print(message);
        console.resetColor();
    }

    public void printLightGRAY(String message) {
        console.setForegroundColor(Color.LIGHT_GRAY);
        console.print(message);
        console.resetColor();
    }

    public void printMAGENTA(String message) {
        console.setForegroundColor(Color.MAGENTA);
        console.print(message);
        console.resetColor();
    }

    public void printORANGE(String message) {
        console.setForegroundColor(Color.ORANGE);
        console.print(message);
        console.resetColor();
    }

    public void printPINK(String message) {
        console.setForegroundColor(Color.PINK);
        console.print(message);
        console.resetColor();
    }

    public void printRED(String message) {
        console.setForegroundColor(Color.RED);
        console.print(message);
        console.resetColor();
    }

    public void printWHITE(String message) {
        console.setForegroundColor(Color.WHITE);
        console.print(message);
        console.resetColor();
    }

    public void printYELLOW(String message) {
        console.setForegroundColor(Color.YELLOW);
        console.print(message);
        console.resetColor();
    }

    public String readBLACK() {
        console.setForegroundColor(Color.BLACK);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readBLUE() {
        console.setForegroundColor(Color.BLUE);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readCYAN() {
        console.setForegroundColor(Color.CYAN);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readDarkGRAY() {
        console.setForegroundColor(Color.DARK_GRAY);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readGRAY() {
        console.setForegroundColor(Color.GRAY);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readGREEN() {
        console.setForegroundColor(Color.GREEN);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readLigthGRAY() {
        console.setForegroundColor(Color.LIGHT_GRAY);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readMAGENTA() {
        console.setForegroundColor(Color.MAGENTA);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readORANGE() {
        console.setForegroundColor(Color.ORANGE);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readPINK() {
        console.setForegroundColor(Color.PINK);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readRED() {
        console.setForegroundColor(Color.RED);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readWHITE() {
        console.setForegroundColor(Color.WHITE);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }

    public String readYELLOW() {
        console.setForegroundColor(Color.YELLOW);
        String answer = console.readString();
        console.resetColor();
        return answer;
    }
}
