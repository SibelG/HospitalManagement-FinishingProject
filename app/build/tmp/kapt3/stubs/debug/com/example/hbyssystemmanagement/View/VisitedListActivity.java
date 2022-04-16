package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/hbyssystemmanagement/View/VisitedListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mDisposable", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "nameTxt", "Landroid/widget/EditText;", "getNameTxt", "()Landroid/widget/EditText;", "setNameTxt", "(Landroid/widget/EditText;)V", "places", "Ljava/util/ArrayList;", "Lcom/example/hbyssystemmanagement/Model/Place;", "Lkotlin/collections/ArrayList;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "handleResponse", "", "placeList", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"})
public final class VisitedListActivity extends androidx.appcompat.app.AppCompatActivity {
    public android.widget.EditText nameTxt;
    private final io.reactivex.rxjava3.disposables.CompositeDisposable mDisposable = null;
    private java.util.ArrayList<com.example.hbyssystemmanagement.Model.Place> places;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private java.util.HashMap _$_findViewCache;
    
    public VisitedListActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getNameTxt() {
        return null;
    }
    
    public final void setNameTxt(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void handleResponse(java.util.List<com.example.hbyssystemmanagement.Model.Place> placeList) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}