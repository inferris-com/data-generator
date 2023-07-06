package com.inferris;

import com.inferris.util.Messages;
import com.inferris.util.MessageUtil;
import com.inferris.util.UsernameGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DataGenerator {

    public static void main(String[] args) {
        //test
        Scanner scanner = new Scanner(System.in);

        while (true) {
            MessageUtil.sendMessage("Select an option:");
            MessageUtil.sendMessage(Messages.PLAYER_DATA_GENERATOR, true);
            MessageUtil.sendMessage(Messages.FRIEND_GENERATOR, true);
            MessageUtil.sendMessage(Messages.USERNAME_UUID_GENERATOR, true);
            MessageUtil.sendMessage(Messages.EXIT, true);

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1 -> generatePlayerData(scanner);
                case 2 -> generateFriendData(scanner);
                case 3 -> generateUsernameUUID(scanner);
                case 0 -> {
                    MessageUtil.sendMessage("Exiting the program...");
                    scanner.close();
                    return;
                }
                default -> MessageUtil.sendMessage("Invalid option. Please try again.");
            }

            MessageUtil.sendMessage(Messages.DIVIDER);
        }
    }

    private static void generateUsernameUUID(Scanner scanner){
        MessageUtil.sendMessage(Messages.USERNAME_UUID_GENERATOR);
        MessageUtil.sendMessage(Messages.PRESS_ENTER_TO_GENERATE);
        scanner.next();

        MessageUtil.sendMessage("UUID: " + UUID.randomUUID());
        MessageUtil.sendMessage("Username: " + UsernameGenerator.generateUsername() + "\n");
        MessageUtil.sendMessage("Press enter to exit to menu");
        scanner.nextLine();
    }

    private static void generatePlayerData(Scanner scanner) {
        MessageUtil.sendMessage(Messages.PLAYER_DATA_GENERATOR.getName());
        MessageUtil.sendMessage("Enter the target UUID: ");
        String uuid = scanner.nextLine();

        MessageUtil.sendMessage("Enter the username: ");
        String username = scanner.nextLine();

        MessageUtil.sendMessage("Enter the staff rank: ");
        int staffRank = scanner.nextInt();

        MessageUtil.sendMessage("Enter the donor rank: ");
        int donorRank = scanner.nextInt();

        MessageUtil.sendMessage("Enter the other rank: ");
        int otherRank = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        MessageUtil.sendMessage("Enter the bio: ");
        String bio = scanner.nextLine();

        MessageUtil.sendMessage("Enter the pronouns: ");
        String pronouns = scanner.nextLine();

        MessageUtil.sendMessage("Enter the registration date (YYYY,MM,DD): ");
        String[] registrationDateParts = scanner.nextLine().split(",");
        int year = Integer.parseInt(registrationDateParts[0]);
        int month = Integer.parseInt(registrationDateParts[1]);
        int day = Integer.parseInt(registrationDateParts[2]);

        MessageUtil.sendMessage("Enter the coins balance: ");
        int coinsBalance = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String hsetCommand = "HSET playerdata " + uuid + " \"{\\\"registry\\\":{\\\"uuid\\\":\\\"" + uuid +
                "\\\",\\\"username\\\":\\\"" + username + "\\\"},\\\"rank\\\":{\\\"staff\\\":" + staffRank +
                ",\\\"donor\\\":" + donorRank + ",\\\"other\\\":" + otherRank + "},\\\"profile\\\":{\\\"bio\\\":\\\"" +
                bio + "\\\",\\\"pronouns\\\":\\\"" + pronouns + "\\\",\\\"registrationDate\\\":["
                + year + "," + month + "," + day + "]},\\\"coins\\\":{\\\"balance\\\":" + coinsBalance +
                "},\\\"channel\\\":\\\"NONE\\\"," +
                "\\\"vanishState\\\":\\\"DISABLED\\\",\\\"currentServer\\\":\\\"INFERRIS\\\"}\"";

        MessageUtil.sendMessage("Generated HSET command:");
        MessageUtil.sendMessage(hsetCommand + "\n");
        MessageUtil.sendMessage(Messages.PRESS_ENTER_TO_EXIT);
        scanner.nextLine();
    }

    private static void generateFriendData(Scanner scanner) {
        MessageUtil.sendMessage(Messages.FRIEND_GENERATOR);
        MessageUtil.sendMessage("Enter the target UUID: ");
        String uuid = scanner.nextLine();

        List<String> friendsList = new ArrayList<>();
        String friendUUID;

        while (true) {
            MessageUtil.sendMessage("Enter a UUID for the friendsList (leave empty to finish): ");
            friendUUID = scanner.nextLine();

            if (friendUUID.isEmpty()) {
                break;
            }

            friendsList.add(friendUUID);
        }

        StringBuilder hsetCommandBuilder = new StringBuilder();
        hsetCommandBuilder.append("HSET friends ").append(uuid).append(" \"{\\\"friendsList\\\": [");

        for (int i = 0; i < friendsList.size(); i++) {
            hsetCommandBuilder.append("\\\"").append(friendsList.get(i)).append("\\\"");

            if (i < friendsList.size() - 1) {
                hsetCommandBuilder.append(",");
            }
        }

        hsetCommandBuilder.append("],\\\"pendingFriendsList\\\": []}\"");

        String hsetCommand = hsetCommandBuilder.toString();

        MessageUtil.sendMessage("Generated HSET command:");
        MessageUtil.sendMessage(hsetCommand);
    }
}