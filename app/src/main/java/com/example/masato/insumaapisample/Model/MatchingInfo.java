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
    private int uniqueId;

    public MatchingInfo(int matchingpointId, int uniqueId) {
        this.matchingpointId = matchingpointId;
        this.uniqueId = uniqueId;
    }

    public int getMatchingpointID() {
        return matchingpointId;
    }

    public int getUniqueID() {
        return uniqueId;
    }
}
