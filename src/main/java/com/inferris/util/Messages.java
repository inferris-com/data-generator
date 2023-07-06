package com.inferris.util;

public enum Messages {
    EXIT("Exit", 0),
    PLAYER_DATA_GENERATOR("Player Data Generation", 1),
    FRIEND_GENERATOR("Friend Generation", 2),
    USERNAME_UUID_GENERATOR("Username & UUID Generation", 3),
    PRESS_ENTER_TO_GENERATE("Press enter to generate", -1),
    PRESS_ENTER_TO_EXIT("Press enter to exit to menu", -1),
    DIVIDER("---------------------------------", -1);

    private final String name;
    private final int menuIndex;

    Messages(String name, int menuIndex) {
        this.name = name;
        this.menuIndex = menuIndex;
    }

    public String getName() {
        return name;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public String getName(boolean menuReady) {
        if (menuReady) {
            return getMenuIndex() + ". " + getName();
        } else {
            return getName();
        }
    }
}
