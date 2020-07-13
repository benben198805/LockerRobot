package LockerRobot;

import LockerRobot.exception.NoBagException;
import LockerRobot.exception.WrongSizeException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private final BoxSize size;
    Map<Ticket, Bag> bags = new HashMap<>();

    public Locker(BoxSize size) {
        this.size = size;
    }

    public BoxSize getSize() {
        return size;
    }

    public Ticket save(Bag bag) {
        if (!bag.getSize().equals(size)) {
            throw new WrongSizeException();
        }
        Ticket ticket = new Ticket();
        bags.put(ticket, bag);
        return ticket;
    }

    public Bag take(Ticket ticket) {
        if (bags.containsKey(ticket)) {
            return bags.remove(ticket);
        }
        throw new NoBagException();
    }

    public boolean contains(Ticket ticket) {
        return bags.containsKey(ticket);
    }
}
