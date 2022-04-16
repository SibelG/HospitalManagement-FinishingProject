package com.example.hbyssystemmanagement.Helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J.\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J$\u0010\u0016\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/example/hbyssystemmanagement/Helper/NotificationHelper;", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "manager", "Landroid/app/NotificationManager;", "getManager", "()Landroid/app/NotificationManager;", "setManager", "(Landroid/app/NotificationManager;)V", "createChannel", "", "getBuilder", "Landroid/app/Notification$Builder;", "title", "", "body", "contentIntent", "Landroid/app/PendingIntent;", "soundUri", "Landroid/net/Uri;", "getBuilderApp", "Companion", "app_debug"})
public final class NotificationHelper extends android.content.ContextWrapper {
    @org.jetbrains.annotations.Nullable()
    private android.app.NotificationManager manager;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.hbyssystemmanagement.Helper.NotificationHelper.Companion Companion = null;
    private static final java.lang.String CHANNEL_ID = "com.example.hbyssystemmanagement.Appointment";
    private static final java.lang.String CHANNEL_NAME = "AppointmentApp";
    
    public NotificationHelper(@org.jetbrains.annotations.Nullable()
    android.content.Context base) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.app.NotificationManager getManager() {
        return null;
    }
    
    public final void setManager(@org.jetbrains.annotations.Nullable()
    android.app.NotificationManager p0) {
    }
    
    private final void createChannel() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Notification.Builder getBuilder(@org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String body, @org.jetbrains.annotations.Nullable()
    android.app.PendingIntent contentIntent, @org.jetbrains.annotations.Nullable()
    android.net.Uri soundUri) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Notification.Builder getBuilderApp(@org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String body, @org.jetbrains.annotations.Nullable()
    android.net.Uri soundUri) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/hbyssystemmanagement/Helper/NotificationHelper$Companion;", "", "()V", "CHANNEL_ID", "", "CHANNEL_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}