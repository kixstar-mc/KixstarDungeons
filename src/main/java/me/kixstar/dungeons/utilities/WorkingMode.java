package me.kixstar.dungeons.utilities;

public enum WorkingMode {
    DUNGEON_MANAGER,
    PORTAL_MANAGER;

    public static boolean isValidWorkingMode(String str_to_check) {
        for (WorkingMode working_mode : WorkingMode.values()) {
            if (working_mode.name().equalsIgnoreCase(str_to_check)) {
                return true;
            }
        }

        return false;
    }
}
