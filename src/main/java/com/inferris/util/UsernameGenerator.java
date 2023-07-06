package com.inferris.util;

import java.util.Random;

public class UsernameGenerator {
    private static final String[] ADJECTIVES = {
            "Happy", "Lucky", "Sunny", "Cool", "Brave", "Gentle", "Clever", "Witty",
            "Smart", "Charming", "Daring", "Energetic", "Funny", "Genuine", "Gracious",
            "Honest", "Inventive", "Joyful", "Kind", "Polite", "Radiant", "Strong", "Vibrant",
            "Adventurous", "Creative", "Enthusiastic", "Generous", "Harmonious", "Intelligent", "Magical",
            "Nurturing", "Optimistic", "Passionate", "Resourceful", "Sincere", "Talented", "Unforgettable",
            "Versatile", "Whimsical", "Xtraordinary", "Youthful", "Zesty", "Elegant", "Fearless",
            "Graceful", "Hopeful", "Inspiring", "Jubilant", "Kindhearted", "Lively", "Majestic"
    };

    private static final String[] NOUNS = {
            "Cat", "Dog", "Bird", "Tiger", "Elephant", "Dolphin", "Lion", "Monkey",
            "Butterfly", "Squirrel", "Panda", "Owl", "Kangaroo", "Giraffe", "Rabbit",
            "Fox", "Horse", "Peacock", "Wolf", "Zebra", "Koala", "Penguin", "Gorilla",
            "Cheetah", "Leopard", "Duck", "Swan", "Octopus", "Seahorse", "Jaguar", "Panther",
            "Parrot", "Rhino", "Sloth", "Snake", "Turtle", "Eagle", "Hawk", "Hummingbird",
            "Orca", "Shark", "Starfish", "Whale", "Gazelle", "Walrus", "Antelope", "Armadillo",
            "Camel", "Capybara", "Chameleon", "Chipmunk", "Cobra", "Crab", "Dingo"
    };

    private static final int MAX_NUMBER = 9999;

    public static String generateUsername() {
        Random random = new Random();
        String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)];
        String noun = NOUNS[random.nextInt(NOUNS.length)];
        int number = random.nextInt(MAX_NUMBER + 1);
        return adjective + noun + number;
    }
}
