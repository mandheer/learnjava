package com.learning.problems.callcenter;

public enum Rank {
    RESPONDENT("respondent"),
    MANAGER("manager"),
    DIRECTOR("director");

    private String rank;
    Rank(String rank) {
        this.rank = rank;
    }

    public Rank getRank(String rank){
        for(Rank r:Rank.values()){
            if(r.rank.equals(rank)) return r;
        }
        return null;
    }

    public String getRankVal(){
        return rank;
    }
}
