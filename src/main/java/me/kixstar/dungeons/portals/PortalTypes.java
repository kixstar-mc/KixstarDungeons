package me.kixstar.dungeons.portals;

public enum PortalTypes {
    TEST(new String[]{});

    private String[] variations;

    PortalTypes(String[] variations) {
        this.variations = variations;
    }
}
