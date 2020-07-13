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
    public void should_save_M_bag() {
        LockerRobotManager lockerRobotManager = new LockerRobotManager();

        Assert.assertNotNull(lockerRobotManager.save(new Bag(BoxSize.SIZE_M)));
    }

    @Test
    public void should_save_L_bag() {
        LockerRobotManager lockerRobotManager = new LockerRobotManager();

        Assert.assertNotNull(lockerRobotManager.save(new Bag(BoxSize.SIZE_L)));
    }
}
