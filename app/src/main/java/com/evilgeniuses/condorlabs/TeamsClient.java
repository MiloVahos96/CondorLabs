package com.evilgeniuses.condorlabs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamsClient {
    @GET("lookup_all_teams.php?id=4335")
    Call< TeamListModel > getTeams();
}
