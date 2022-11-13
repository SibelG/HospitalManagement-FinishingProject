package com.example.hbyssystemmanagement.Model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u0004\u0018\u00010\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u0016\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0010\u0010$\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\'R\u0016\u0010(\u001a\u0004\u0018\u00010\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\b\u00a8\u0006."}, d2 = {"Lcom/example/hbyssystemmanagement/Model/Results;", "", "()V", "business_status", "", "getBusiness_status", "()Ljava/lang/String;", "setBusiness_status", "(Ljava/lang/String;)V", "formatted_phone_number", "getFormatted_phone_number", "setFormatted_phone_number", "geometry", "Lcom/example/hbyssystemmanagement/Model/Geometry;", "getGeometry$app_debug", "()Lcom/example/hbyssystemmanagement/Model/Geometry;", "icon", "id", "name", "getName$app_debug", "opening_hours", "Lcom/example/hbyssystemmanagement/Model/OpeningHours;", "getOpening_hours$app_debug", "()Lcom/example/hbyssystemmanagement/Model/OpeningHours;", "photos", "", "Lcom/example/hbyssystemmanagement/Model/Photos;", "getPhotos$app_debug", "()[Lcom/example/hbyssystemmanagement/Model/Photos;", "setPhotos$app_debug", "([Lcom/example/hbyssystemmanagement/Model/Photos;)V", "[Lcom/example/hbyssystemmanagement/Model/Photos;", "place_id", "getPlace_id$app_debug", "rating", "getRating$app_debug", "reference", "scope", "types", "[Ljava/lang/String;", "vicinity", "getVicinity$app_debug", "website", "getWebsite", "setWebsite", "toString", "app_debug"})
public final class Results {
    @org.jetbrains.annotations.Nullable()
    private com.example.hbyssystemmanagement.Model.Photos[] photos;
    private final java.lang.String id = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String place_id = null;
    private final java.lang.String icon = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String vicinity = null;
    private final java.lang.String scope = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String rating = null;
    private java.lang.String[] types;
    private final java.lang.String reference = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.hbyssystemmanagement.Model.OpeningHours opening_hours = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.hbyssystemmanagement.Model.Geometry geometry = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String formatted_phone_number;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String business_status;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String website;
    
    public Results() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.Model.Photos[] getPhotos$app_debug() {
        return null;
    }
    
    public final void setPhotos$app_debug(@org.jetbrains.annotations.Nullable()
    com.example.hbyssystemmanagement.Model.Photos[] p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPlace_id$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getVicinity$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRating$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.Model.OpeningHours getOpening_hours$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.Model.Geometry getGeometry$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFormatted_phone_number() {
        return null;
    }
    
    public final void setFormatted_phone_number(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBusiness_status() {
        return null;
    }
    
    public final void setBusiness_status(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWebsite() {
        return null;
    }
    
    public final void setWebsite(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
}