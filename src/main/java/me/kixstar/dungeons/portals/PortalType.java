package me.kixstar.dungeons.portals;

public class PortalType {
    private final PortalTypes type;
    private final String variation;

    public PortalType(PortalTypes type, String variation) {
        this.type = type;
        this.variation = variation;
    }

    public PortalTypes getType() {
        return type;
    }

    public String getVariation() {
        return variation;
    }
}
