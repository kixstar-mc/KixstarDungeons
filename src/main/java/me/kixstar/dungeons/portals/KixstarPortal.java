package me.kixstar.dungeons.portals;

import java.util.*;

public class KixstarPortal {
    private Vector location;
    private PortalType type;
    private UUID uuid;

    public KixstarPortal(Vector location, PortalType type) {
        this.location = location;
        this.type = type;
        this.uuid = UUID.randomUUID();
    }

    public Vector getLocation() {
        return location;
    }

    public PortalType getType() {
        return type;
    }

    public UUID getUUID() {
        return uuid;
    }
}
