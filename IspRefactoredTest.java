package com.jah.isp.refactored;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IspRefactoredTest {

    @Test
    void developer_shouldImplementAllRequiredInterfaces() {
        Developer dev = new Developer();

        assertInstanceOf(Workable.class, dev);
        assertInstanceOf(Eatable.class, dev);
        assertInstanceOf(Meetable.class, dev);
        assertInstanceOf(Codeable.class, dev);
    }

    @Test
    void developer_shouldNotImplementManageable() {
        Developer dev = new Developer();
        assertFalse(dev instanceof Manageable,
            "Developers do not manage teams");
    }

    @Test
    void developer_workShouldNotThrow() {
        Developer dev = new Developer();
        assertDoesNotThrow(dev::work);
        assertDoesNotThrow(dev::eat);
        assertDoesNotThrow(dev::attendMeeting);
        assertDoesNotThrow(dev::writeCode);
    }

    @Test
    void manager_shouldImplementAllRequiredInterfaces() {
        Manager mgr = new Manager();

        assertInstanceOf(Workable.class, mgr);
        assertInstanceOf(Eatable.class, mgr);
        assertInstanceOf(Meetable.class, mgr);
        assertInstanceOf(Manageable.class, mgr);
    }

    @Test
    void manager_shouldNotImplementCodeable() {
        Manager mgr = new Manager();
        assertFalse(mgr instanceof Codeable,
            "Managers do not write code");
    }

    @Test
    void robot_shouldOnlyImplementWorkableAndCodeable() {
        RobotWorker robot = new RobotWorker();

        assertInstanceOf(Workable.class, robot);
        assertInstanceOf(Codeable.class, robot);
    }

    @Test
    void robot_shouldNotImplementBiologicalInterfaces() {
        RobotWorker robot = new RobotWorker();

        assertFalse(robot instanceof Eatable,   "Robots do not eat");
        assertFalse(robot instanceof Meetable,  "Robots do not attend meetings");
        assertFalse(robot instanceof Manageable,"Robots do not manage teams");
    }

    @Test
    void robot_workAndCodeShouldNotThrow() {
        RobotWorker robot = new RobotWorker();
        assertDoesNotThrow(robot::work);
        assertDoesNotThrow(robot::writeCode);
    }
}
