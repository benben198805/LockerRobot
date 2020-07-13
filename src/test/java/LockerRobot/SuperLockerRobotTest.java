package LockerRobot;

import LockerRobot.exception.NoLockerException;
import LockerRobot.exception.NotFoundBagException;
import LockerRobot.exception.WrongSizeException;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SuperLockerRobotTest {
    @Test
    public void should_save_bag_for_custom() {
        LockerRobot lockerRobot = new SuperLockerRobot();

        Ticket ticket = lockerRobot.save(new Bag(BoxSize.SIZE_L));

        Assert.assertNotNull(ticket);
    }

    @Test(expected = WrongSizeException.class)
    public void should_throw_exception_when_save_M_bag() {
        LockerRobot lockerRobot = new SuperLockerRobot();

        lockerRobot.save(new Bag(BoxSize.SIZE_M));
    }

    @Test
    public void should_save_bag_for_multi_lockers() {
        LockerRobot lockerRobot = new SuperLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_L), new Locker(BoxSize.SIZE_L)));

        Ticket ticket = lockerRobot.save(new Bag(BoxSize.SIZE_L));

        Assert.assertNotNull(ticket);
    }

    @Test(expected = NoLockerException.class)
    public void should_throw_exception_when_save_bag_for_multi_lockers() {
        LockerRobot lockerRobot = new SuperLockerRobot(Lists.newArrayList());

        lockerRobot.save(new Bag(BoxSize.SIZE_L));
    }

    @Test
    public void should_get_bag_for_multi_lockers() {
        LockerRobot lockerRobot = new SuperLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_L), new Locker(BoxSize.SIZE_L)));

        Bag bag1 = new Bag(BoxSize.SIZE_L);
        Ticket ticket1 = lockerRobot.save(bag1);

        Bag bag2 = new Bag(BoxSize.SIZE_L);
        Ticket ticket2 = lockerRobot.save(bag2);

        Assert.assertEquals(bag2, lockerRobot.take(ticket2));
        Assert.assertEquals(bag1, lockerRobot.take(ticket1));
    }

    @Test(expected = NotFoundBagException.class)
    public void should_throw_exception_when_take_bag_twice() {
        LockerRobot lockerRobot = new SuperLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_L), new Locker(BoxSize.SIZE_L)));

        Bag bag1 = new Bag(BoxSize.SIZE_L);
        Ticket ticket1 = lockerRobot.save(bag1);

        Bag bag2 = new Bag(BoxSize.SIZE_L);
        lockerRobot.save(bag2);

        lockerRobot.take(ticket1);
        lockerRobot.take(ticket1);
    }

    @Test(expected = WrongSizeException.class)
    public void should_throw_exception_when_init_super_locker_robot_with_l_locker() {
        new SuperLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_M), new Locker(BoxSize.SIZE_L)));
    }
    
    @Test
    public void should_get_bag_for_multi_lockers_by_min() {
        LockerRobot lockerRobot = new SuperLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_L), new Locker(BoxSize.SIZE_L)));

        Bag bag1 = new Bag(BoxSize.SIZE_L);
        lockerRobot.save(bag1);

        List<Integer> lockersCount = lockerRobot.getLockersCount();
        Assert.assertEquals(lockersCount, Lists.newArrayList(1, 0));

        Bag bag2 = new Bag(BoxSize.SIZE_L);
        lockerRobot.save(bag2);

        lockersCount = lockerRobot.getLockersCount();
        Assert.assertEquals(lockersCount, Lists.newArrayList(1, 1));
    }
}
