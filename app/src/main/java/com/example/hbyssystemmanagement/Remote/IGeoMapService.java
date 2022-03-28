package com.example.hbyssystemmanagement.Remote;

import retrofit2.Call;
import retrofit2.http.Url;

public interface IGeoMapService {

    Call<String> getAddress(@Url String url);
}
