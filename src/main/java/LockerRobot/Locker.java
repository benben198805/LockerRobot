package LockerRobot;

import LockerRobot.exception.NoBagException;
import LockerRobot.exception.WrongSizeException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private final String size;
    Map<Ticket, Bag> bags = new HashMap<>();

    public Locker(String size) {
        this.size = size;
    }

    public Ticket save(Bag bag) {
        if(!bag.getSize().equals(size)){
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
}
