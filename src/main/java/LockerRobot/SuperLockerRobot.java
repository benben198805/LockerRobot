package LockerRobot;

public class SuperLockerRobot {
    private final Locker locker;

    public SuperLockerRobot() {
        this.locker = new Locker(BoxSize.SIZE_L.getValue());
    }

    public Ticket save(Bag bag) {
        return this.locker.save(bag);
    }
}