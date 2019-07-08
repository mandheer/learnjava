package com.learning.problems.callcenter;

public abstract class Employee {
    private Call currentCall = null;
    protected Rank rank;

    public Employee(){

    }

    /** Start the conversation
     * @param call
     */
    public void receiveCall(Call call){

    }

    /** The issue is resolved.
     * Close the call.
     */
    public void callCompleted(){

    }

    /** The issue is not resolved.
     * Escalate the call.
     */
    public void escalateAndReassign(){

    }

    /** Assign a new call to employee if employee is free.
     */
    public boolean assignNewCall(){
        //TODO to be implemented
        return false;
    }

    /** Returns whether or not the employee is free.
     */
    public boolean isFree(){
        return currentCall == null;
    }

    public Rank getRank(){
        return rank;
    }
}
