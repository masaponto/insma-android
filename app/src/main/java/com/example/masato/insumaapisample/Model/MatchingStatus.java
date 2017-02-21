package com.example.masato.insumaapisample.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by masato on 17/02/22.
 */

public class MatchingStatus {

    @SerializedName("status")
    private boolean status;

    public boolean getStatus() {
        return status;
    }

}
