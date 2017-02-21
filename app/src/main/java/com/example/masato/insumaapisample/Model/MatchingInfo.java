package com.example.masato.insumaapisample.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by masato on 17/02/21.
 */

public class MatchingInfo {
    @SerializedName("matchingpoint")
    @Expose
    private int matchingpointId;

    @SerializedName("uniqueid")
    @Expose
    private String uniqueId;

    public MatchingInfo(int matchingpointId, String uniqueId) {
        this.matchingpointId = matchingpointId;
        this.uniqueId = uniqueId;
    }

    public int getMatchingpointID() {
        return matchingpointId;
    }

    public String getUniqueID() {
        return uniqueId;
    }
}
