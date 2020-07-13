package LockerRobot;

import LockerRobot.exception.NoLockerException;
import LockerRobot.exception.WrongSizeException;
import com.google.common.collect.Lists;

import java.util.List;

public class PrimaryLockerRobot extends LockerRobot {
    private int curIndex = 0;

    public PrimaryLockerRobot() {
        this.lockers = Lists.newArrayList(new Locker(BoxSize.SIZE_M));
    }

    public PrimaryLockerRobot(List<Locker> lockers) {
        if (lockers.size() == 0) {
            throw new NoLockerException();
        }
        if (!lockers.stream().allMatch(locker -> locker.getSize().equals(BoxSize.SIZE_M))) {
            throw new WrongSizeException();
        }
        this.lockers = lockers;
    }

    @Override
    public Ticket save(Bag bag) {
        int cur = curIndex % lockers.size();
        curIndex++;
        return lockers.get(cur).save(bag);
    }
}
