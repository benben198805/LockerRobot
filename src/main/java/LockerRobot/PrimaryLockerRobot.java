package LockerRobot;

public class PrimaryLockerRobot {
    private final Locker locker;

    public PrimaryLockerRobot() {
        this.locker = new Locker(BoxSize.SIZE_M.getValue());
    }

    public Ticket save(Bag bag) {
        return this.locker.save(bag);
    }
}
