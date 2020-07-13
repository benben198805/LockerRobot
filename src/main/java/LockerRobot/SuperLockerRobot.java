package LockerRobot;

import LockerRobot.exception.NoLockerException;
import LockerRobot.exception.WrongSizeException;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

public class SuperLockerRobot extends LockerRobot {

    public SuperLockerRobot() {
        this.lockers = Lists.newArrayList(new Locker(BoxSize.SIZE_L));
    }

    public SuperLockerRobot(List<Locker> lockers) {
        if (lockers.size() == 0) {
            throw new NoLockerException();
        }
        if (!lockers.stream().allMatch(locker -> locker.getSize().equals(BoxSize.SIZE_L))) {
            throw new WrongSizeException();
        }
        this.lockers = lockers;
    }

    @Override
    public Ticket save(Bag bag) {
        Locker lowCountLocker = lockers.stream().min(Comparator.comparing(Locker::getCount)).get();
        return lowCountLocker.save(bag);
    }

}
