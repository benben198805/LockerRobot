package LockerRobot;

import LockerRobot.exception.WrongSizeException;
import org.junit.Assert;
import org.junit.Test;

public class SuperLockerRobotTest {

    @Test
    public void should_save_bag_for_custom() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();

        Ticket ticket = superLockerRobot.save(new Bag(BoxSize.SIZE_L.getValue()));

        Assert.assertNotNull(ticket);
    }

    @Test(expected = WrongSizeException.class)
    public void should_throw_exception_when_save_L_bag() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();

        superLockerRobot.save(new Bag(BoxSize.SIZE_M.getValue()));
    }
}
