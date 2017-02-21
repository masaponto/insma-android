package com.example.masato.insumaapisample.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by masato on 17/02/22.
 */

public class MatchingUsers {

    @SerializedName("users")
    private ArrayList<MatchingUser> users;

    public ArrayList<MatchingUser> getUsers() {
        return users;
    }

}

