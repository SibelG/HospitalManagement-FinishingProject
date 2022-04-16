package com.example.hbyssystemmanagement.Service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/example/hbyssystemmanagement/Service/MyFirebaseService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getMAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setMAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "onNewToken", "", "s", "", "refreshToken", "RefreshToken", "app_debug"})
public final class MyFirebaseService extends com.google.firebase.messaging.FirebaseMessagingService {
    public com.google.firebase.auth.FirebaseAuth mAuth;
    
    public MyFirebaseService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getMAuth() {
        return null;
    }
    
    public final void setMAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @java.lang.Override()
    public void onNewToken(@org.jetbrains.annotations.NotNull()
    java.lang.String s) {
    }
    
    public final void refreshToken(@org.jetbrains.annotations.Nullable()
    java.lang.String RefreshToken) {
    }
}