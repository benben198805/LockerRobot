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

    @Test
    public void should_save_m_m_l_s_bag_and_take_s_l_m_m_bag() {
        LockerRobotManager lockerRobotManager = new LockerRobotManager();

        Bag bag1 = new Bag(BoxSize.SIZE_L);
        Ticket ticket1 = lockerRobotManager.save(bag1);

        Bag bag2 = new Bag(BoxSize.SIZE_M);
        Ticket ticket2 = lockerRobotManager.save(bag2);

        Bag bag3 = new Bag(BoxSize.SIZE_M);
        Ticket ticket3 = lockerRobotManager.save(bag3);

        Bag bag4 = new Bag(BoxSize.SIZE_S);
        Ticket ticket4 = lockerRobotManager.save(bag4);

        Assert.assertEquals(bag4, lockerRobotManager.take(ticket4));
        Assert.assertEquals(bag1, lockerRobotManager.take(ticket1));
        Assert.assertEquals(bag2, lockerRobotManager.take(ticket2));
        Assert.assertEquals(bag3, lockerRobotManager.take(ticket3));
    }
}
