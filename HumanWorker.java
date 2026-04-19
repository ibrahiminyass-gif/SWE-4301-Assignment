package com.jah.isp.original;

public class HumanWorker implements Worker {

    @Override
    public void work() { System.out.println("Human working..."); }

    @Override
    public void eat() { System.out.println("Human eating..."); }

    @Override
    public void attendMeeting() { System.out.println("Human attending meeting..."); }

    @Override
    public void writeCode() { System.out.println("Human writing code..."); }

    @Override
    public void manageTeam() { System.out.println("Human managing team..."); }
}
