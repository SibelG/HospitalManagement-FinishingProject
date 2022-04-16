package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010/\u001a\u0002002\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0010\u00104\u001a\u0002002\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/example/hbyssystemmanagement/View/SendMessageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "data", "Ljava/util/ArrayList;", "Lcom/example/hbyssystemmanagement/Model/Message;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "databaseReference", "Lcom/google/firebase/database/DatabaseReference;", "getDatabaseReference", "()Lcom/google/firebase/database/DatabaseReference;", "setDatabaseReference", "(Lcom/google/firebase/database/DatabaseReference;)V", "doctorId", "", "getDoctorId", "()Ljava/lang/String;", "setDoctorId", "(Ljava/lang/String;)V", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLinearLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "mainActivityRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getMainActivityRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMainActivityRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "sendMessageButton", "Landroid/widget/ImageView;", "getSendMessageButton", "()Landroid/widget/ImageView;", "setSendMessageButton", "(Landroid/widget/ImageView;)V", "sendText", "Landroid/widget/EditText;", "getSendText", "()Landroid/widget/EditText;", "setSendText", "(Landroid/widget/EditText;)V", "getMessageFirebase", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "sendData", "app_debug"})
public final class SendMessageActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.database.DatabaseReference databaseReference;
    public androidx.recyclerview.widget.RecyclerView mainActivityRecyclerView;
    public androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.example.hbyssystemmanagement.Model.Message> data;
    public android.widget.EditText sendText;
    public android.widget.ImageView sendMessageButton;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String doctorId = "";
    private java.util.HashMap _$_findViewCache;
    
    public SendMessageActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.database.DatabaseReference getDatabaseReference() {
        return null;
    }
    
    public final void setDatabaseReference(@org.jetbrains.annotations.Nullable()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getMainActivityRecyclerView() {
        return null;
    }
    
    public final void setMainActivityRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.LinearLayoutManager getLinearLayoutManager() {
        return null;
    }
    
    public final void setLinearLayoutManager(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.LinearLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.example.hbyssystemmanagement.Model.Message> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.example.hbyssystemmanagement.Model.Message> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getSendText() {
        return null;
    }
    
    public final void setSendText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getSendMessageButton() {
        return null;
    }
    
    public final void setSendMessageButton(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDoctorId() {
        return null;
    }
    
    public final void setDoctorId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void sendData(java.lang.String doctorId) {
    }
    
    private final void getMessageFirebase(java.lang.String doctorId) {
    }
}