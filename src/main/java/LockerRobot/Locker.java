package LockerRobot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Locker {
    Map<UUID, Bag> bags = new HashMap<>();

    public UUID save(Bag bag) {
        UUID uuid = UUID.randomUUID();
        bags.put(uuid, bag);
        return uuid;
    }
}
