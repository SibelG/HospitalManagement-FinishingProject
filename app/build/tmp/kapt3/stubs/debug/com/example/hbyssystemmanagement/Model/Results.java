package com.example.hbyssystemmanagement.Model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\fR\u0013\u0010!\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR\u0013\u0010#\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\fR\u0013\u0010%\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\fR\u001b\u0010\'\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0013\u0010+\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\f\u00a8\u0006."}, d2 = {"Lcom/example/hbyssystemmanagement/Model/Results;", "", "()V", "geometry", "Lcom/example/hbyssystemmanagement/Model/Geometry;", "getGeometry", "()Lcom/example/hbyssystemmanagement/Model/Geometry;", "setGeometry", "(Lcom/example/hbyssystemmanagement/Model/Geometry;)V", "icon", "", "getIcon", "()Ljava/lang/String;", "id", "getId", "name", "getName", "opening_hours", "Lcom/example/hbyssystemmanagement/Model/OpeningHours;", "getOpening_hours", "()Lcom/example/hbyssystemmanagement/Model/OpeningHours;", "setOpening_hours", "(Lcom/example/hbyssystemmanagement/Model/OpeningHours;)V", "photos", "", "Lcom/example/hbyssystemmanagement/Model/Photos;", "getPhotos", "()[Lcom/example/hbyssystemmanagement/Model/Photos;", "setPhotos", "([Lcom/example/hbyssystemmanagement/Model/Photos;)V", "[Lcom/example/hbyssystemmanagement/Model/Photos;", "place_id", "getPlace_id", "rating", "getRating", "reference", "getReference", "scope", "getScope", "types", "getTypes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "vicinity", "getVicinity", "toString", "app_debug"})
public final class Results {
    @org.jetbrains.annotations.Nullable()
    private com.example.hbyssystemmanagement.Model.Photos[] photos;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String place_id = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String icon = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String vicinity = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String scope = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String rating = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String[] types = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String reference = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.hbyssystemmanagement.Model.OpeningHours opening_hours;
    public com.example.hbyssystemmanagement.Model.Geometry geometry;
    
    public Results() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.Model.Photos[] getPhotos() {
        return null;
    }
    
    public final void setPhotos(@org.jetbrains.annotations.Nullable()
    com.example.hbyssystemmanagement.Model.Photos[] p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPlace_id() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getVicinity() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getScope() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRating() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String[] getTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReference() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.Model.OpeningHours getOpening_hours() {
        return null;
    }
    
    public final void setOpening_hours(@org.jetbrains.annotations.Nullable()
    com.example.hbyssystemmanagement.Model.OpeningHours p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hbyssystemmanagement.Model.Geometry getGeometry() {
        return null;
    }
    
    public final void setGeometry(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.Model.Geometry p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
}