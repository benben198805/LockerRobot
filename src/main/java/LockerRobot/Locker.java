package LockerRobot;

import LockerRobot.exception.NoBagException;
import LockerRobot.exception.WrongSizeException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Locker {
    private final String size;
    Map<UUID, Bag> bags = new HashMap<>();

    public Locker(String size) {
        this.size = size;
    }

    public UUID save(Bag bag) {
        if(!bag.getSize().equals(size)){
            throw new WrongSizeException();
        }
        UUID uuid = UUID.randomUUID();
        bags.put(uuid, bag);
        return uuid;
    }

    public Bag take(UUID uuid) {
        if (bags.containsKey(uuid)) {
            return bags.remove(uuid);
        }
        throw new NoBagException();
    }
}
