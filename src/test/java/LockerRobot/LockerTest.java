package LockerRobot;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

public class LockerTest {
    @Test
    public void should_return_key_when_save_s_bag_for_s_locker() {
        Locker locker = new Locker("S");

        assertNotNull("should return uuid for bag", locker.save(new Bag("S")));
    }

    @Test
    public void should_return_bag_when_take_bag_by_uuid() {
        Locker locker = new Locker("S");
        Bag bag = new Bag("S");

        UUID uuid = locker.save(bag);

        Assert.assertEquals(bag, locker.take(uuid));
    }

    @Test(expected = NoBagException.class)
    public void should_throw_exception_when_bag_already_take() {
        Locker locker = new Locker("S");
        Bag bag = new Bag("S");
        UUID uuid = locker.save(bag);

        locker.take(uuid);
        locker.take(uuid);
    }

    @Test
    public void should_return_key_when_save_m_bag_for_m_locker() {
        Locker locker = new Locker("M");

        assertNotNull("should return uuid for bag", locker.save(new Bag("M")));
    }

    @Test
    public void should_return_key_when_save_l_bag_for_l_locker() {
        Locker locker = new Locker("L");

        assertNotNull("should return uuid for bag", locker.save(new Bag("L")));
    }
}
