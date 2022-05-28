package com.example.hbyssystemmanagement.Service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/hbyssystemmanagement/Service/FirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "NOTIFICATION_CHANNEL_ID", "", "getNOTIFICATION_CHANNEL_ID", "()Ljava/lang/String;", "setNOTIFICATION_CHANNEL_ID", "(Ljava/lang/String;)V", "NOTIFICATION_ID", "", "getNOTIFICATION_ID", "()I", "TAG", "getNotificationIcon", "onMessageReceived", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "showNotification", "context", "Landroid/content/Context;", "title", "message", "app_debug"})
public final class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    private final java.lang.String TAG = "FireBaseMessagingService";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String NOTIFICATION_CHANNEL_ID = "com.example.hbyssystemmanagement.Service";
    private final int NOTIFICATION_ID = 100;
    
    public FirebaseMessagingService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNOTIFICATION_CHANNEL_ID() {
        return null;
    }
    
    public final void setNOTIFICATION_CHANNEL_ID(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getNOTIFICATION_ID() {
        return 0;
    }
    
    @java.lang.Override()
    public void onMessageReceived(@org.jetbrains.annotations.NotNull()
    com.google.firebase.messaging.RemoteMessage remoteMessage) {
    }
    
    public final void showNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    private final int getNotificationIcon() {
        return 0;
    }
}