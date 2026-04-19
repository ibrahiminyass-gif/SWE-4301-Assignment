package com.jah.isp.refactored;

public class Developer implements Workable, Eatable, Meetable, Codeable {

    @Override
    public void work()         { System.out.println("Developer working..."); }

    @Override
    public void eat()          { System.out.println("Developer eating..."); }

    @Override
    public void attendMeeting(){ System.out.println("Developer attending meeting..."); }

    @Override
    public void writeCode()    { System.out.println("Developer writing code..."); }
}
