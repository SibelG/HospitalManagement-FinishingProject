package com.example.hbyssystemmanagement.Interface;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/example/hbyssystemmanagement/Interface/ApiInterface;", "", "sendNotification", "Lretrofit2/Call;", "Lcom/example/hbyssystemmanagement/Model/MyResponse;", "body", "Lcom/example/hbyssystemmanagement/Model/DataMessage;", "app_debug"})
public abstract interface ApiInterface {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "fcm/send")
    @retrofit2.http.Headers(value = {"Content-Type:application/json", "Authorization:key=AAAAnbpawK8:APA91bGGrGC7S4Sdd-O3_VtJXU354j8cjYzGiB8Ni7ktWBzX4a8bj3rcrmK6zExJtnpdTtIykZGB4m3H-9eNFPpIpvv_twL6FEF7zIHmpRxHfR54JrqKldnIs2fs40YKpAINbiaiLXy9"})
    public abstract retrofit2.Call<com.example.hbyssystemmanagement.Model.MyResponse> sendNotification(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Body()
    com.example.hbyssystemmanagement.Model.DataMessage body);
}