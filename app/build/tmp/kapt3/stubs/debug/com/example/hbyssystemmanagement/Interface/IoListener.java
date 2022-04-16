package com.example.hbyssystemmanagement.Interface;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&\u00a8\u0006\n"}, d2 = {"Lcom/example/hbyssystemmanagement/Interface/IoListener;", "", "onLocationFailureListener", "", "message", "", "onLocationSuccessListener", "latLngs", "", "Lcom/example/hbyssystemmanagement/Model/HospitalCoordinat;", "app_debug"})
public abstract interface IoListener {
    
    public abstract void onLocationSuccessListener(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.hbyssystemmanagement.Model.HospitalCoordinat> latLngs);
    
    public abstract void onLocationFailureListener(@org.jetbrains.annotations.NotNull()
    java.lang.String message);
}