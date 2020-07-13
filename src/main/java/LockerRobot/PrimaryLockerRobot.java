package LockerRobot;

import LockerRobot.exception.NoLockerException;
import LockerRobot.exception.NotFoundBagException;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public class PrimaryLockerRobot {
    private final List<Locker> lockers;
    private int curIndex = 0;

    public PrimaryLockerRobot() {
        this.lockers = Lists.newArrayList(new Locker(BoxSize.SIZE_M));
    }

    public PrimaryLockerRobot(List<Locker> lockers) {
        if (lockers.size() == 0) {
            throw new NoLockerException();
        }
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) {
        int cur = curIndex % lockers.size();
        curIndex++;
        return lockers.get(cur).save(bag);
    }

    public Bag take(Ticket ticket) {
        Optional<Locker> first = this.lockers.stream().filter(locker1 -> locker1.contains(ticket)).findFirst();
        if (first.isEmpty()) {
            throw new NotFoundBagException();
        }
        Locker locker = first.get();
        return locker.take(ticket);
    }
}
