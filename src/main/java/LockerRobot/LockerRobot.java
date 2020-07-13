package LockerRobot;

import LockerRobot.exception.NotFoundBagException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class LockerRobot {
    protected List<Locker> lockers;

    public List<Integer> getLockersCount() {
        return this.lockers.stream().map(Locker::getCount).collect(Collectors.toList());
    }

    public abstract Ticket save(Bag bag);

    public Bag take(Ticket ticket) {
        Optional<Locker> first = this.lockers.stream().filter(locker1 -> locker1.contains(ticket)).findFirst();
        if (first.isEmpty()) {
            throw new NotFoundBagException();
        }
        Locker locker = first.get();
        return locker.take(ticket);
    }
}
