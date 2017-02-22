package com.example.masato.insumaapisample.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by masato on 17/02/22.
 */

public class MatchingUser {

    @SerializedName("id")
    private int uniqueId;

    @SerializedName("destination")
    private String destination;

    public int getUniqueId() {
        return uniqueId;
    }

    public String getDestination() {
        return destination;
    }
}
