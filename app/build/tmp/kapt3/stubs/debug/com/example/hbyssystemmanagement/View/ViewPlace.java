package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0004H\u0002J\u0012\u00109\u001a\u0004\u0018\u0001062\u0006\u0010:\u001a\u000206H\u0002J\u0012\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010,\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001a\u0010/\u001a\u000200X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u0006?"}, d2 = {"Lcom/example/hbyssystemmanagement/View/ViewPlace;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "PLACE_PICKER_REQUEST", "", "btnDirection", "Landroid/widget/Button;", "getBtnDirection", "()Landroid/widget/Button;", "setBtnDirection", "(Landroid/widget/Button;)V", "btnShowMap", "getBtnShowMap", "setBtnShowMap", "mPlace", "Lcom/example/hbyssystemmanagement/Model/PlaceDetail;", "getMPlace", "()Lcom/example/hbyssystemmanagement/Model/PlaceDetail;", "setMPlace", "(Lcom/example/hbyssystemmanagement/Model/PlaceDetail;)V", "mService", "Lcom/example/hbyssystemmanagement/Interface/NearByApi;", "getMService$app_debug", "()Lcom/example/hbyssystemmanagement/Interface/NearByApi;", "setMService$app_debug", "(Lcom/example/hbyssystemmanagement/Interface/NearByApi;)V", "openNow", "Landroid/widget/TextView;", "getOpenNow", "()Landroid/widget/TextView;", "setOpenNow", "(Landroid/widget/TextView;)V", "openWeek", "getOpenWeek", "setOpenWeek", "photo", "Landroid/widget/ImageView;", "getPhoto", "()Landroid/widget/ImageView;", "setPhoto", "(Landroid/widget/ImageView;)V", "placeAdress", "getPlaceAdress", "setPlaceAdress", "placeName", "getPlaceName", "setPlaceName", "rating_bar", "Landroid/widget/RatingBar;", "getRating_bar", "()Landroid/widget/RatingBar;", "setRating_bar", "(Landroid/widget/RatingBar;)V", "getPhotoOfPlaces", "", "photo_reference", "maxWidth", "getPlaceDetailUrl", "place_id", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ViewPlace extends androidx.appcompat.app.AppCompatActivity {
    public com.example.hbyssystemmanagement.Interface.NearByApi mService;
    @org.jetbrains.annotations.Nullable()
    private com.example.hbyssystemmanagement.Model.PlaceDetail mPlace;
    public android.widget.TextView placeName;
    public android.widget.TextView placeAdress;
    public android.widget.TextView openNow;
    public android.widget.Button btnShowMap;
    public android.widget.Button btnDirection;
    public android.widget.ImageView photo;
    public android.widget.RatingBar rating_bar;
    public android.widget.TextView openWeek;
    private final int PLACE_PICKER_REQUEST = 3;
    private java.util.HashMap _$_findViewCache;
    
    public ViewPlace() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hbyssystemmanagement.Interface.NearByApi getMService$app_debug() {
        return null;
    }
    
    public final void setMService$app_debug(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.Interface.NearByApi p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.Model.PlaceDetail getMPlace() {
        return null;
    }
    
    public final void setMPlace(@org.jetbrains.annotations.Nullable()
    com.example.hbyssystemmanagement.Model.PlaceDetail p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPlaceName() {
        return null;
    }
    
    public final void setPlaceName(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPlaceAdress() {
        return null;
    }
    
    public final void setPlaceAdress(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getOpenNow() {
        return null;
    }
    
    public final void setOpenNow(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getBtnShowMap() {
        return null;
    }
    
    public final void setBtnShowMap(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getBtnDirection() {
        return null;
    }
    
    public final void setBtnDirection(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getPhoto() {
        return null;
    }
    
    public final void setPhoto(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RatingBar getRating_bar() {
        return null;
    }
    
    public final void setRating_bar(@org.jetbrains.annotations.NotNull()
    android.widget.RatingBar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getOpenWeek() {
        return null;
    }
    
    public final void setOpenWeek(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.lang.String getPlaceDetailUrl(java.lang.String place_id) {
        return null;
    }
    
    private final java.lang.String getPhotoOfPlaces(java.lang.String photo_reference, int maxWidth) {
        return null;
    }
}