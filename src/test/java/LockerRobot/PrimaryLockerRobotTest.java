package LockerRobot;

import LockerRobot.exception.NoLockerException;
import LockerRobot.exception.WrongSizeException;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

public class PrimaryLockerRobotTest {

    @Test
    public void should_save_bag_for_custom() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();

        Ticket ticket = primaryLockerRobot.save(new Bag(BoxSize.SIZE_M));

        Assert.assertNotNull(ticket);
    }

    @Test(expected = WrongSizeException.class)
    public void should_throw_exception_when_save_L_bag() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();

        primaryLockerRobot.save(new Bag(BoxSize.SIZE_L));
    }

    @Test
    public void should_save_bag_for_multi_lockers() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_M), new Locker(BoxSize.SIZE_M)));

        Ticket ticket = primaryLockerRobot.save(new Bag(BoxSize.SIZE_M));

        Assert.assertNotNull(ticket);
    }

    @Test(expected = NoLockerException.class)
    public void should_throw_exception_when_save_bag_for_multi_lockers() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList());

        primaryLockerRobot.save(new Bag(BoxSize.SIZE_M));
    }

    @Test
    public void should_get_bag_for_multi_lockers() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_M), new Locker(BoxSize.SIZE_M)));

        Bag bag1 = new Bag(BoxSize.SIZE_M);
        Ticket ticket1 = primaryLockerRobot.save(bag1);

        Bag bag2 = new Bag(BoxSize.SIZE_M);
        Ticket ticket2 = primaryLockerRobot.save(bag2);

        Assert.assertEquals(bag2, primaryLockerRobot.take(ticket2));
        Assert.assertEquals(bag1, primaryLockerRobot.take(ticket1));
    }
}
