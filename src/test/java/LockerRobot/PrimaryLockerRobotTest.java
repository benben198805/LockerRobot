package LockerRobot;

import LockerRobot.exception.WrongSizeException;
import org.junit.Assert;
import org.junit.Test;

public class PrimaryLockerRobotTest {

    @Test
    public void should_save_bag_for_custom() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();

        Ticket ticket = primaryLockerRobot.save(new Bag(BoxSize.SIZE_M.getValue()));

        Assert.assertNotNull(ticket);
    }

    @Test(expected = WrongSizeException.class)
    public void should_throw_exception_when_save_L_bag() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();

        primaryLockerRobot.save(new Bag(BoxSize.SIZE_L.getValue()));
    }
}
