package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001AB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002J\u0012\u00106\u001a\u0002042\b\u00107\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00108\u001a\u0002042\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\b\u0010;\u001a\u000204H\u0014J\b\u0010<\u001a\u000204H\u0002J \u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020(X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020.X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/example/hbyssystemmanagement/View/ViewAppointmentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "Appointment_date", "", "Appointment_time", "BookedAPKey", "channel", "Landroid/app/NotificationChannel;", "getChannel", "()Landroid/app/NotificationChannel;", "setChannel", "(Landroid/app/NotificationChannel;)V", "channelId", "description", "doctorID", "doctorList", "Ljava/util/ArrayList;", "Lcom/example/hbyssystemmanagement/Model/Booked_Appointments;", "Lkotlin/collections/ArrayList;", "getDoctorList", "()Ljava/util/ArrayList;", "setDoctorList", "(Ljava/util/ArrayList;)V", "mApiInterface", "Lcom/example/hbyssystemmanagement/Interface/ApiInterface;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mDatabase", "Lcom/google/firebase/database/DatabaseReference;", "mPatientDatabase", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "manager", "Landroid/app/NotificationManager;", "getManager", "()Landroid/app/NotificationManager;", "setManager", "(Landroid/app/NotificationManager;)V", "notificationBuilder", "Landroid/app/Notification$Builder;", "getNotificationBuilder", "()Landroid/app/Notification$Builder;", "setNotificationBuilder", "(Landroid/app/Notification$Builder;)V", "notoficationId", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestCode", "slot", "UpdateToken", "", "alertDialog", "changeSlotToTime", "appointment_time", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "sendAppointmentStatusUser", "sendNotification", "usertoken", "title", "message", "AppointmentViewHolder", "app_debug"})
public final class ViewAppointmentActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.appcompat.widget.Toolbar mToolbar;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private java.lang.String BookedAPKey = "";
    private java.lang.String Appointment_date;
    private java.lang.String slot;
    private java.lang.String Appointment_time;
    private java.lang.String doctorID;
    public java.util.ArrayList<com.example.hbyssystemmanagement.Model.Booked_Appointments> doctorList;
    public android.app.NotificationManager manager;
    public android.app.NotificationChannel channel;
    public android.app.Notification.Builder notificationBuilder;
    private final java.lang.String channelId = " com.example.hbyssystemmanagement.View";
    private final java.lang.String description = "Notification Sample Description";
    private final int notoficationId = 1001;
    private final int requestCode = 1002;
    private final com.google.firebase.database.DatabaseReference mDatabase = null;
    private final com.google.firebase.auth.FirebaseAuth mAuth = null;
    private com.example.hbyssystemmanagement.Interface.ApiInterface mApiInterface;
    private final com.google.firebase.database.DatabaseReference mPatientDatabase = null;
    private java.util.HashMap _$_findViewCache;
    
    public ViewAppointmentActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.hbyssystemmanagement.Model.Booked_Appointments> getDoctorList() {
        return null;
    }
    
    public final void setDoctorList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.hbyssystemmanagement.Model.Booked_Appointments> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.NotificationManager getManager() {
        return null;
    }
    
    public final void setManager(@org.jetbrains.annotations.NotNull()
    android.app.NotificationManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.NotificationChannel getChannel() {
        return null;
    }
    
    public final void setChannel(@org.jetbrains.annotations.NotNull()
    android.app.NotificationChannel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Notification.Builder getNotificationBuilder() {
        return null;
    }
    
    public final void setNotificationBuilder(@org.jetbrains.annotations.NotNull()
    android.app.Notification.Builder p0) {
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