package com.evilgeniuses.condorlabs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventClient {

    @GET("eventsnext.php")
    Call<EventListModel> getEvents(
            @Query("id") String id
    );


}
