package com.jah.isp.original;

public class RobotWorker implements Worker {

    @Override
    public void work() { System.out.println("Robot working..."); }

    @Override
    public void eat() {
        
        throw new UnsupportedOperationException("Robots do not eat!");
    }

    @Override
    public void attendMeeting() {
        throw new UnsupportedOperationException("Robots do not attend meetings!");
    }

    @Override
    public void writeCode() { System.out.println("Robot writing code..."); }

    @Override
    public void manageTeam() {
        throw new UnsupportedOperationException("Robots do not manage teams!");
    }
}
