package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0002J \u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/hbyssystemmanagement/View/ViewAppointmentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "Appointment_date", "", "Appointment_time", "BookedAPKey", "doctorID", "mApiInterface", "Lcom/example/hbyssystemmanagement/Interface/ApiInterface;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mDatabase", "Lcom/google/firebase/database/DatabaseReference;", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "slot", "UpdateToken", "", "alertDialog", "changeSlotToTime", "appointment_time", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "sendAppointmentStatusUser", "sendNotification", "usertoken", "title", "message", "AppointmentViewHolder", "app_debug"})
public final class ViewAppointmentActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.appcompat.widget.Toolbar mToolbar;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private java.lang.String BookedAPKey = "";
    private java.lang.String Appointment_date;
    private java.lang.String slot;
    private java.lang.String Appointment_time;
    private java.lang.String doctorID;
    private final com.google.firebase.database.DatabaseReference mDatabase = null;
    private final com.google.firebase.auth.FirebaseAuth mAuth = null;
    private com.example.hbyssystemmanagement.Interface.ApiInterface mApiInterface;
    private java.util.HashMap _$_findViewCache;
    
    public ViewAppointmentActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    private final void UpdateToken() {
    }
    
    private final void sendNotification(java.lang.String usertoken, java.lang.String title, java.lang.String message) {
    }
    
    private final void sendAppointmentStatusUser() {
    }
    
    private final void alertDialog() {
    }
    
    private final void changeSlotToTime(java.lang.String appointment_time) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lcom/example/hbyssystemmanagement/View/ViewAppointmentActivity$AppointmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/hbyssystemmanagement/View/ViewAppointmentActivity;Landroid/view/View;)V", "appointmentDate", "Landroid/widget/TextView;", "getAppointmentDate", "()Landroid/widget/TextView;", "setAppointmentDate", "(Landroid/widget/TextView;)V", "appointmentTime", "getAppointmentTime", "setAppointmentTime", "editButton", "Landroid/widget/Button;", "getEditButton", "()Landroid/widget/Button;", "setEditButton", "(Landroid/widget/Button;)V", "name", "getName", "setName", "removeButton", "getRemoveButton", "setRemoveButton", "specializationTV", "getSpecializationTV", "setSpecializationTV", "app_debug"})
    public final class AppointmentViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView name;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView specializationTV;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView appointmentTime;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView appointmentDate;
        @org.jetbrains.annotations.NotNull()
        private android.widget.Button removeButton;
        @org.jetbrains.annotations.NotNull()
        private android.widget.Button editButton;
        
        public AppointmentViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getName() {
            return null;
        }
        
        public final void setName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getSpecializationTV() {
            return null;
        }
        
        public final void setSpecializationTV(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getAppointmentTime() {
            return null;
        }
        
        public final void setAppointmentTime(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getAppointmentDate() {
            return null;
        }
        
        public final void setAppointmentDate(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Button getRemoveButton() {
            return null;
        }
        
        public final void setRemoveButton(@org.jetbrains.annotations.NotNull()
        android.widget.Button p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Button getEditButton() {
            return null;
        }
        
        public final void setEditButton(@org.jetbrains.annotations.NotNull()
        android.widget.Button p0) {
        }
    }
}