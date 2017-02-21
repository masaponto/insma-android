package com.example.masato.insumaapisample.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by masato on 17/02/21.
 */

public class UserMoveInfo {

    @SerializedName("userid")
    private String userId;

    @SerializedName("x")
    private double x;

    @SerializedName("y")
    private double y;

    @SerializedName("destination")
    private String destination;


    public UserMoveInfo(String userID, double x, double y, String destination) {
        this.userId = userID;
        this.x = x;
        this.y = y;
        this.destination = destination;
    }

}
