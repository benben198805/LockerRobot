package LockerRobot;

import LockerRobot.exception.NoLockerException;
import LockerRobot.exception.NotFoundBagException;
import LockerRobot.exception.WrongSizeException;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperLockerRobot {
    private final List<Locker> lockers;

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

    public Ticket save(Bag bag) {
        Locker lowCountLocker = lockers.stream().min(Comparator.comparing(Locker::getSize)).get();
        return lowCountLocker.save(bag);
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
