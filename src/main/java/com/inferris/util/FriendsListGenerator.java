package com.inferris.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FriendsListGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> friendsList = new ArrayList<>();
        String uuid;

        do {
            System.out.print("Enter UUID for friendsList (press enter to finish): ");
            uuid = scanner.nextLine();
            if (!uuid.isEmpty()) {
                friendsList.add(uuid);
            }
        } while (!uuid.isEmpty());

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\"friendsList\": [");
        for (int i = 0; i < friendsList.size(); i++) {
            if (i > 0) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\"").append(friendsList.get(i)).append("\"");
        }
        jsonBuilder.append("],\"pendingFriendsList\": []}");

        String json = jsonBuilder.toString().replace("\"", "\\\"");

        String hsetCommand = "hset friends 7d16b15d-bb22-4a6d-80db-6213b3d75007 \"" + json + "\"";
        System.out.println("Generated hset command:");
        System.out.println(hsetCommand);

        scanner.close();
    }
}
