package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0014J\u0012\u0010-\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(\u00a8\u00061"}, d2 = {"Lcom/example/hbyssystemmanagement/View/ShowCommentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "database", "Lcom/google/firebase/database/FirebaseDatabase;", "getDatabase", "()Lcom/google/firebase/database/FirebaseDatabase;", "setDatabase", "(Lcom/google/firebase/database/FirebaseDatabase;)V", "doctorId", "", "getDoctorId", "()Ljava/lang/String;", "setDoctorId", "(Ljava/lang/String;)V", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "manager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "ref", "Lcom/google/firebase/database/DatabaseReference;", "getRef", "()Lcom/google/firebase/database/DatabaseReference;", "setRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "refreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getRefreshLayout", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "setRefreshLayout", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ShowCommentViewHolder", "app_debug"})
public final class ShowCommentActivity extends androidx.appcompat.app.AppCompatActivity {
    public androidx.recyclerview.widget.RecyclerView recyclerView;
    public androidx.recyclerview.widget.RecyclerView.LayoutManager manager;
    public com.google.firebase.database.FirebaseDatabase database;
    public com.google.firebase.database.DatabaseReference ref;
    public androidx.swiperefreshlayout.widget.SwipeRefreshLayout refreshLayout;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String doctorId = "";
    private final com.google.firebase.auth.FirebaseAuth mAuth = null;
    private java.util.HashMap _$_findViewCache;
    
    public ShowCommentActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    public final void setRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView.LayoutManager getManager() {
        return null;
    }
    
    public final void setManager(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.LayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.FirebaseDatabase getDatabase() {
        return null;
    }
    
    public final void setDatabase(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.FirebaseDatabase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getRef() {
        return null;
    }
    
    public final void setRef(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.swiperefreshlayout.widget.SwipeRefreshLayout getRefreshLayout() {
        return null;
    }
    
    public final void setRefreshLayout(@org.jetbrains.annotations.NotNull()
    androidx.swiperefreshlayout.widget.SwipeRefreshLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDoctorId() {
        return null;
    }
    
    public final void setDoctorId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull()
    android.content.Context newBase) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/example/hbyssystemmanagement/View/ShowCommentActivity$ShowCommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/hbyssystemmanagement/View/ShowCommentActivity;Landroid/view/View;)V", "userComment", "Landroid/widget/EditText;", "getUserComment", "()Landroid/widget/EditText;", "setUserComment", "(Landroid/widget/EditText;)V", "userEmail", "getUserEmail", "setUserEmail", "userRating", "Landroid/widget/RatingBar;", "getUserRating", "()Landroid/widget/RatingBar;", "setUserRating", "(Landroid/widget/RatingBar;)V", "app_debug"})
    public final class ShowCommentViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.EditText userEmail;
        @org.jetbrains.annotations.NotNull()
        private android.widget.EditText userComment;
        @org.jetbrains.annotations.NotNull()
        private android.widget.RatingBar userRating;
        
        public ShowCommentViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.EditText getUserEmail() {
            return null;
        }
        
        public final void setUserEmail(@org.jetbrains.annotations.NotNull()
        android.widget.EditText p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.EditText getUserComment() {
            return null;
        }
        
        public final void setUserComment(@org.jetbrains.annotations.NotNull()
        android.widget.EditText p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RatingBar getUserRating() {
            return null;
        }
        
        public final void setUserRating(@org.jetbrains.annotations.NotNull()
        android.widget.RatingBar p0) {
        }
    }
}