package LockerRobot;

import org.junit.Assert;
import org.junit.Test;

public class LockerRobotManagerTest {
    @Test
    public void should_save_s_bag() {
        LockerRobotManager lockerRobotManager = new LockerRobotManager();

        Assert.assertNotNull(lockerRobotManager.save(new Bag(BoxSize.SIZE_S)));
    }

    @Test
    public void should_save_m_bag() {
        LockerRobotManager lockerRobotManager = new LockerRobotManager();

        Assert.assertNotNull(lockerRobotManager.save(new Bag(BoxSize.SIZE_M)));
    }

    @Test
    public void should_save_L_bag() {
        LockerRobotManager lockerRobotManager = new LockerRobotManager();

        Assert.assertNotNull(lockerRobotManager.save(new Bag(BoxSize.SIZE_L)));
    }

    @Test
    public void should_take_s_bag() {
        LockerRobotManager lockerRobotManager = new LockerRobotManager();

        Bag bag = new Bag(BoxSize.SIZE_S);
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertEquals(bag, lockerRobotManager.take(ticket));
    }

    @Test
    public void should_take_m_bag() {
        LockerRobotManager lockerRobotManager = new LockerRobotManager();

        Bag bag = new Bag(BoxSize.SIZE_M);
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertEquals(bag, lockerRobotManager.take(ticket));
    }

    @Test
    public void should_take_l_bag() {
        LockerRobotManager lockerRobotManager = new LockerRobotManager();

        Bag bag = new Bag(BoxSize.SIZE_L);
        Ticket ticket = lockerRobotManager.save(bag);

        Assert.assertEquals(bag, lockerRobotManager.take(ticket));
    }
}
