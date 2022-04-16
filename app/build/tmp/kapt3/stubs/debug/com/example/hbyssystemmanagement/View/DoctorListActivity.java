package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0002J\u0012\u00104\u001a\u00020/2\b\u00105\u001a\u0004\u0018\u000106H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00067"}, d2 = {"Lcom/example/hbyssystemmanagement/View/DoctorListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/hbyssystemmanagement/adapters/DoctorAdapter;", "getAdapter", "()Lcom/example/hbyssystemmanagement/adapters/DoctorAdapter;", "setAdapter", "(Lcom/example/hbyssystemmanagement/adapters/DoctorAdapter;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "backHome", "Landroid/widget/ImageView;", "getBackHome", "()Landroid/widget/ImageView;", "setBackHome", "(Landroid/widget/ImageView;)V", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "doctorArrayList", "Ljava/util/ArrayList;", "Lcom/example/hbyssystemmanagement/View/Model/Doctor;", "Lkotlin/collections/ArrayList;", "doctorRef", "Lcom/google/firebase/database/DatabaseReference;", "mSearchText", "Landroid/widget/EditText;", "getMSearchText", "()Landroid/widget/EditText;", "setMSearchText", "(Landroid/widget/EditText;)V", "recyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "refreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getRefreshLayout", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "setRefreshLayout", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "searchdoctorArrayList", "target", "Lcom/squareup/picasso/Target;", "getTarget", "()Lcom/squareup/picasso/Target;", "setTarget", "(Lcom/squareup/picasso/Target;)V", "getData", "", "getDataFromFirestore", "getSearchData", "searchText", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class DoctorListActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.firebase.auth.FirebaseAuth auth;
    private com.google.firebase.firestore.FirebaseFirestore db;
    private com.google.firebase.database.DatabaseReference doctorRef;
    private androidx.recyclerview.widget.RecyclerView recyclerview;
    private java.util.ArrayList<com.example.hbyssystemmanagement.View.Model.Doctor> doctorArrayList;
    private java.util.ArrayList<com.example.hbyssystemmanagement.View.Model.Doctor> searchdoctorArrayList;
    public android.widget.EditText mSearchText;
    public android.widget.ImageView backHome;
    @org.jetbrains.annotations.Nullable()
    private com.squareup.picasso.Target target;
    public androidx.swiperefreshlayout.widget.SwipeRefreshLayout refreshLayout;
    public com.example.hbyssystemmanagement.adapters.DoctorAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    public DoctorListActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getMSearchText() {
        return null;
    }
    
    public final void setMSearchText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getBackHome() {
        return null;
    }
    
    public final void setBackHome(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.squareup.picasso.Target getTarget() {
        return null;
    }
    
    public final void setTarget(@org.jetbrains.annotations.Nullable()
    com.squareup.picasso.Target p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.swiperefreshlayout.widget.SwipeRefreshLayout getRefreshLayout() {
        return null;
    }
    
    public final void setRefreshLayout(@org.jetbrains.annotations.NotNull()
    androidx.swiperefreshlayout.widget.SwipeRefreshLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hbyssystemmanagement.adapters.DoctorAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.adapters.DoctorAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getData() {
    }
    
    private final void getSearchData(java.lang.String searchText) {
    }
    
    private final void getDataFromFirestore() {
    }
}