package LockerRobot;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LockerTest {
    @Test
    public void should_return_key_when_save_bag() {
        Locker locker = new Locker();
        assertNotNull("should return uuid for bag", locker.save(new Bag()));
    }
}
