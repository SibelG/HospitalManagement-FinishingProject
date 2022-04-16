package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0002J\u0012\u00104\u001a\u00020/2\b\u00105\u001a\u0004\u0018\u000106H\u0014R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00068"}, d2 = {"Lcom/example/hbyssystemmanagement/View/SectionList;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "FirebaseRecyclerAdapter", "Lcom/firebase/ui/database/FirebaseRecyclerAdapter;", "Lcom/example/hbyssystemmanagement/Model/Section;", "Lcom/example/hbyssystemmanagement/View/SectionList$SectionViewHolder;", "getFirebaseRecyclerAdapter", "()Lcom/firebase/ui/database/FirebaseRecyclerAdapter;", "setFirebaseRecyclerAdapter", "(Lcom/firebase/ui/database/FirebaseRecyclerAdapter;)V", "SearchSectionArrayList", "Ljava/util/ArrayList;", "adapter", "Lcom/example/hbyssystemmanagement/adapters/SectionAdapter;", "getAdapter", "()Lcom/example/hbyssystemmanagement/adapters/SectionAdapter;", "setAdapter", "(Lcom/example/hbyssystemmanagement/adapters/SectionAdapter;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "mSearchText", "Landroid/widget/EditText;", "getMSearchText", "()Landroid/widget/EditText;", "setMSearchText", "(Landroid/widget/EditText;)V", "recyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "refreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getRefreshLayout", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "setRefreshLayout", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "sectionArrayList", "sectionRef", "Lcom/google/firebase/database/DatabaseReference;", "target", "Lcom/squareup/picasso/Target;", "getTarget", "()Lcom/squareup/picasso/Target;", "setTarget", "(Lcom/squareup/picasso/Target;)V", "getData", "", "getDataFromFirestore", "getSearchData", "searchText", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "SectionViewHolder", "app_debug"})
public final class SectionList extends androidx.appcompat.app.AppCompatActivity {
    private com.google.firebase.auth.FirebaseAuth auth;
    private com.google.firebase.firestore.FirebaseFirestore db;
    private androidx.recyclerview.widget.RecyclerView recyclerview;
    private com.google.firebase.database.DatabaseReference sectionRef;
    private java.util.ArrayList<com.example.hbyssystemmanagement.Model.Section> sectionArrayList;
    private java.util.ArrayList<com.example.hbyssystemmanagement.Model.Section> SearchSectionArrayList;
    public com.firebase.ui.database.FirebaseRecyclerAdapter<com.example.hbyssystemmanagement.Model.Section, com.example.hbyssystemmanagement.View.SectionList.SectionViewHolder> FirebaseRecyclerAdapter;
    public android.widget.EditText mSearchText;
    @org.jetbrains.annotations.Nullable()
    private com.squareup.picasso.Target target;
    public androidx.swiperefreshlayout.widget.SwipeRefreshLayout refreshLayout;
    @org.jetbrains.annotations.Nullable()
    private com.example.hbyssystemmanagement.adapters.SectionAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    public SectionList() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.firebase.ui.database.FirebaseRecyclerAdapter<com.example.hbyssystemmanagement.Model.Section, com.example.hbyssystemmanagement.View.SectionList.SectionViewHolder> getFirebaseRecyclerAdapter() {
        return null;
    }
    
    public final void setFirebaseRecyclerAdapter(@org.jetbrains.annotations.NotNull()
    com.firebase.ui.database.FirebaseRecyclerAdapter<com.example.hbyssystemmanagement.Model.Section, com.example.hbyssystemmanagement.View.SectionList.SectionViewHolder> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getMSearchText() {
        return null;
    }
    
    public final void setMSearchText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.adapters.SectionAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable()
    com.example.hbyssystemmanagement.adapters.SectionAdapter p0) {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/example/hbyssystemmanagement/View/SectionList$SectionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mview", "Landroid/view/View;", "(Landroid/view/View;)V", "getMview", "()Landroid/view/View;", "setMview", "sectionImage", "Landroid/widget/ImageView;", "getSectionImage", "()Landroid/widget/ImageView;", "setSectionImage", "(Landroid/widget/ImageView;)V", "sectionName", "Landroid/widget/TextView;", "getSectionName", "()Landroid/widget/TextView;", "setSectionName", "(Landroid/widget/TextView;)V", "app_debug"})
    public static final class SectionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.view.View mview;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView sectionName;
        @org.jetbrains.annotations.Nullable()
        private android.widget.ImageView sectionImage;
        
        public SectionViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View mview) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getMview() {
            return null;
        }
        
        public final void setMview(@org.jetbrains.annotations.NotNull()
        android.view.View p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getSectionName() {
            return null;
        }
        
        public final void setSectionName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.ImageView getSectionImage() {
            return null;
        }
        
        public final void setSectionImage(@org.jetbrains.annotations.Nullable()
        android.widget.ImageView p0) {
        }
    }
}