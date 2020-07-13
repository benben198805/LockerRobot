package LockerRobot;

import LockerRobot.exception.NoLockerException;
import com.google.common.collect.Lists;

import java.util.List;

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
        return lockers.get(cur).save(bag);
    }
}
