package com.example.masato.insumaapisample.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by masato on 17/02/22.
 */

public class MatchingPointId {

    @SerializedName("matchingpoint")
    private int matchingPoint;

    public MatchingPointId(int matchingPoint) {
        this.matchingPoint = matchingPoint;
    }

}
