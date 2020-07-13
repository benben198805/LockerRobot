package LockerRobot;

import java.util.UUID;

public class Ticket {
    private final UUID uuid;

    public Ticket() {
        this.uuid = UUID.randomUUID();
    }
}
