package LockerRobot;

import java.util.UUID;

public class Ticket {
    private final UUID uuid;
    private BoxSize size;

    public Ticket(BoxSize size) {
        this.uuid = UUID.randomUUID();
        this.size = size;
    }

    public BoxSize getSize() {
        return size;
    }
}
