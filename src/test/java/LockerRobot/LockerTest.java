package LockerRobot;

import LockerRobot.exception.NoBagException;
import LockerRobot.exception.WrongSizeException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LockerTest {

    @Test
    public void should_return_key_when_save_s_bag_for_s_locker() {
        Locker locker = new Locker(BoxSize.SIZE_S.getValue());

        Ticket ticket = locker.save(new Bag(BoxSize.SIZE_S.getValue()));

        Assert.assertNotNull(ticket);
    }

    @Test
    public void should_return_bag_when_take_bag_by_uuid() {
        Locker locker = new Locker(BoxSize.SIZE_S.getValue());
        Bag bag = new Bag(BoxSize.SIZE_S.getValue());

        Ticket ticket = locker.save(bag);

        Assert.assertEquals(bag, locker.take(ticket));
    }

    @Test(expected = NoBagException.class)
    public void should_throw_exception_when_bag_already_take() {
        Locker locker = new Locker(BoxSize.SIZE_S.getValue());
        Bag bag = new Bag(BoxSize.SIZE_S.getValue());
        Ticket uuid = locker.save(bag);

        locker.take(uuid);
        locker.take(uuid);
    }

    @Test
    public void should_return_key_when_save_m_bag_for_m_locker() {
        Locker locker = new Locker(BoxSize.SIZE_M.getValue());

        assertNotNull("should return uuid for bag", locker.save(new Bag(BoxSize.SIZE_M.getValue())));
    }

    @Test
    public void should_return_key_when_save_l_bag_for_l_locker() {
        Locker locker = new Locker(BoxSize.SIZE_L.getValue());

        assertNotNull("should return uuid for bag", locker.save(new Bag(BoxSize.SIZE_L.getValue())));
    }

    @Test(expected = WrongSizeException.class)
    public void should_throw_exception_when_save_l_bag_for_s_locker() {
        Locker locker = new Locker(BoxSize.SIZE_S.getValue());

        assertNotNull("should return uuid for bag", locker.save(new Bag(BoxSize.SIZE_L.getValue())));
    }
}
