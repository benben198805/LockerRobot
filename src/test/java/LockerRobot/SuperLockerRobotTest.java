package LockerRobot;

import LockerRobot.exception.NoLockerException;
import LockerRobot.exception.NotFoundBagException;
import LockerRobot.exception.WrongSizeException;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

public class SuperLockerRobotTest {
    @Test
    public void should_save_bag_for_custom() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();

        Ticket ticket = superLockerRobot.save(new Bag(BoxSize.SIZE_L));

        Assert.assertNotNull(ticket);
    }

    @Test(expected = WrongSizeException.class)
    public void should_throw_exception_when_save_M_bag() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();

        superLockerRobot.save(new Bag(BoxSize.SIZE_M));
    }

    @Test
    public void should_save_bag_for_multi_lockers() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_L), new Locker(BoxSize.SIZE_L)));

        Ticket ticket = superLockerRobot.save(new Bag(BoxSize.SIZE_L));

        Assert.assertNotNull(ticket);
    }

    @Test(expected = NoLockerException.class)
    public void should_throw_exception_when_save_bag_for_multi_lockers() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Lists.newArrayList());

        superLockerRobot.save(new Bag(BoxSize.SIZE_L));
    }

    @Test
    public void should_get_bag_for_multi_lockers() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_L), new Locker(BoxSize.SIZE_L)));

        Bag bag1 = new Bag(BoxSize.SIZE_L);
        Ticket ticket1 = superLockerRobot.save(bag1);

        Bag bag2 = new Bag(BoxSize.SIZE_L);
        Ticket ticket2 = superLockerRobot.save(bag2);

        Assert.assertEquals(bag2, superLockerRobot.take(ticket2));
        Assert.assertEquals(bag1, superLockerRobot.take(ticket1));
    }

    @Test(expected = NotFoundBagException.class)
    public void should_throw_exception_when_take_bag_twice() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_L), new Locker(BoxSize.SIZE_L)));

        Bag bag1 = new Bag(BoxSize.SIZE_L);
        Ticket ticket1 = superLockerRobot.save(bag1);

        Bag bag2 = new Bag(BoxSize.SIZE_L);
        superLockerRobot.save(bag2);

        superLockerRobot.take(ticket1);
        superLockerRobot.take(ticket1);
    }

    @Test(expected = WrongSizeException.class)
    public void should_throw_exception_when_init_super_locker_robot_with_l_locker() {
        new SuperLockerRobot(Lists.newArrayList(new Locker(BoxSize.SIZE_M), new Locker(BoxSize.SIZE_L)));
    }
}
