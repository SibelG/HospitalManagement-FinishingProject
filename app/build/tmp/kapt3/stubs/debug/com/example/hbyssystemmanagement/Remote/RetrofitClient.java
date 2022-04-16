package com.example.hbyssystemmanagement.Remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/hbyssystemmanagement/Remote/RetrofitClient;", "", "()V", "BaseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "GoogleBaseUrl", "getGoogleBaseUrl", "setGoogleBaseUrl", "getRetrofit", "Lretrofit2/Retrofit;", "getGetRetrofit", "()Lretrofit2/Retrofit;", "googleRetrofit", "getGoogleRetrofit", "retrofit", "app_debug"})
public final class RetrofitClient {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.hbyssystemmanagement.Remote.RetrofitClient INSTANCE = null;
    private static retrofit2.Retrofit retrofit;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String BaseUrl = "https://fcm.googleapis.com/";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String GoogleBaseUrl = "https://maps.googleapis.com/";
    
    private RetrofitClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBaseUrl() {
        return null;
    }
    
    public final void setBaseUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGoogleBaseUrl() {
        return null;
    }
    
    public final void setGoogleBaseUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit getGetRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final retrofit2.Retrofit getGoogleRetrofit() {
        return null;
    }
}