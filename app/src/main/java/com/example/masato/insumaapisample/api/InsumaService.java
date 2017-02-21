package com.example.masato.insumaapisample.api;

import com.example.masato.insumaapisample.Model.MatchingInfo;
import com.example.masato.insumaapisample.Model.MatchingPointId;
import com.example.masato.insumaapisample.Model.MatchingStatus;
import com.example.masato.insumaapisample.Model.MatchingUsers;
import com.example.masato.insumaapisample.Model.UserMoveInfo;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by masato on 17/02/21.
 */

public interface InsumaService {

    @POST("/startmatching")
    Observable<MatchingInfo> matchingInfo(@Body UserMoveInfo userMoveInfo);

    @POST("/endmatching")
    Observable<MatchingStatus> endMatching(@Body MatchingInfo matchingInfo);

    @POST("/getnumberofpeople")
    Observable<MatchingUsers> getNumberOfPeople(@Body MatchingPointId matchingPointId);

}

