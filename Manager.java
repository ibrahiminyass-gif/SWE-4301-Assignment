package com.jah.isp.refactored;

public class Manager implements Workable, Eatable, Meetable, Manageable {

    @Override
    public void work()         { System.out.println("Manager working..."); }

    @Override
    public void eat()          { System.out.println("Manager eating..."); }

    @Override
    public void attendMeeting(){ System.out.println("Manager attending meeting..."); }

    @Override
    public void manageTeam()   { System.out.println("Manager managing team..."); }
}
