package com.example.hbyssystemmanagement.Model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b\u00a8\u0006\u001d"}, d2 = {"Lcom/example/hbyssystemmanagement/Model/MyResponse;", "", "()V", "canonical_ids", "", "getCanonical_ids", "()I", "setCanonical_ids", "(I)V", "failure", "getFailure", "setFailure", "multicast_id", "", "getMulticast_id", "()Ljava/lang/Long;", "setMulticast_id", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "results", "", "Lcom/example/hbyssystemmanagement/Model/Result;", "getResults", "()Ljava/util/List;", "setResults", "(Ljava/util/List;)V", "success", "getSuccess", "setSuccess", "app_debug"})
public final class MyResponse {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long multicast_id = 0L;
    private int success = 0;
    private int failure = 0;
    private int canonical_ids = 0;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.example.hbyssystemmanagement.Model.Result> results;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getMulticast_id() {
        return null;
    }
    
    public final void setMulticast_id(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    public final int getSuccess() {
        return 0;
    }
    
    public final void setSuccess(int p0) {
    }
    
    public final int getFailure() {
        return 0;
    }
    
    public final void setFailure(int p0) {
    }
    
    public final int getCanonical_ids() {
        return 0;
    }
    
    public final void setCanonical_ids(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.hbyssystemmanagement.Model.Result> getResults() {
        return null;
    }
    
    public final void setResults(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.hbyssystemmanagement.Model.Result> p0) {
    }
    
    public MyResponse() {
        super();
    }
}