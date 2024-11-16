package Lesson;

import Users.Client;

public class Booking{
    private int id;
    private Client mainClient;
    private Client legalGuardian;
    private Offering offering;

    public Booking(int id, Client mainClient, Offering offering){
        this.id = id;
        this.mainClient = mainClient;
        this.offering = offering;
    }

    public void addLegalGuardian(Client legalGuardian){
        this.legalGuardian = legalGuardian;
    }

    public int getID(){
        return id;
    }

    public Client getClient(){
        return mainClient;
    }

    public Offering getOffering(){
        return offering;
    }
}