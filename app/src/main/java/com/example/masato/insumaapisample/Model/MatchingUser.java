package com.example.masato.insumaapisample.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by masato on 17/02/22.
 */

public class MatchingUser {

    @SerializedName("id")
    private String uniqueId;

    @SerializedName("destination")
    private String destination;

    public String getUniqueId() {
        return uniqueId;
    }

    public String getDestination() {
        return destination;
    }
}
