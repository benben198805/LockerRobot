package LockerRobot;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

public class LockerTest {
    @Test
    public void should_return_key_when_save_bag() {
        Locker locker = new Locker();

        assertNotNull("should return uuid for bag", locker.save(new Bag()));
    }

    @Test
    public void should_return_bag_when_take_bag_by_uuid() {
        Locker locker = new Locker();
        Bag bag = new Bag();

        UUID uuid = locker.save(bag);

        Assert.assertEquals(bag, locker.take(uuid));
    }

    @Test(expected = NoBagException.class)
    public void should_throw_exception_when_bag_already_take() {
        Locker locker = new Locker();
        Bag bag = new Bag();
        UUID uuid = locker.save(bag);

        locker.take(uuid);
        locker.take(uuid);
    }
}