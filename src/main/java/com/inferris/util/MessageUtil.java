package com.inferris.util;

public class MessageUtil {
    public static void sendMessage(String message) {
        System.out.println(message);
    }

    public static void sendMessage(int message) {
        System.out.println(message);
    }

    public static void sendMessage(Messages message) {
        System.out.println(message.getName());
    }

    public static void sendMessage(Messages message, boolean menuReady) {
        if (menuReady) {
            System.out.println(message.getName(true));
        } else {
            sendMessage(message);
        }
    }
}
