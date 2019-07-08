package com.learning.problems.callcenter;

public class Call {
    /** minimal rank of employee who can handle this call
     */
    private Rank rank;

    /**
     * Person who's calling
     */
    private Caller caller;
    /**
     * Employee who's handling call
     */
    private Employee handler;


    public Call(Caller caller){
        rank = Rank.RESPONDENT;
        this.caller = caller;
    }

    /** Set employee who's handling call.
     * @param handler
     */
    public void setHandler(Employee handler){
        this.handler = handler;
    }

    public void reply(String message){
        //TODO
    }

    public Rank getRank(){
        //TODO
        return rank;
    }

    public void setRank(Rank rank){
        this.rank = rank;
    }

    public Rank incrementRank(){
        //TODO
        return null;
    }

    public void disconnect(){
        //TODO
    }
}
