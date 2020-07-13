package LockerRobot;

import LockerRobot.exception.WrongSizeException;

public class LockerRobotManager {
    private final Locker locker;
    private final PrimaryLockerRobot primaryLockerRobot;
    private final SuperLockerRobot superLockerRobot;

    public LockerRobotManager() {
        this.locker = new Locker(BoxSize.SIZE_S);
        this.primaryLockerRobot = new PrimaryLockerRobot();
        this.superLockerRobot = new SuperLockerRobot();
    }

    public Ticket save(Bag bag) {
        Ticket ticket;
        switch (bag.getSize()) {
            case SIZE_S:
                ticket = locker.save(bag);
                break;
            case SIZE_M:
                ticket = primaryLockerRobot.save(bag);
                break;
            case SIZE_L:
                ticket = superLockerRobot.save(bag);
                break;
            default:
                throw new WrongSizeException();
        }
        return ticket;
    }

    public Bag take(Ticket ticket) {
        Bag bag;
        switch (ticket.getSize()) {
            case SIZE_S:
                bag = locker.take(ticket);
                break;
            case SIZE_M:
                bag = primaryLockerRobot.take(ticket);
                break;
            case SIZE_L:
                bag = superLockerRobot.take(ticket);
                break;
            default:
                throw new WrongSizeException();
        }
        return bag;
    }
}
