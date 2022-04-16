package com.example.hbyssystemmanagement.Model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086.\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010#\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0013\u0010%\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0013\u0010\'\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0013\u0010)\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u001b\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c\u00a2\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0013\u0010/\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0013\u00101\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0013\u00103\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0013\u00105\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006\u00a8\u00067"}, d2 = {"Lcom/example/hbyssystemmanagement/Model/Result;", "", "()V", "adr_address", "", "getAdr_address", "()Ljava/lang/String;", "formatted_address", "getFormatted_address", "formatted_phone_number", "getFormatted_phone_number", "geometry", "Lcom/example/hbyssystemmanagement/Model/Geometry;", "getGeometry", "()Lcom/example/hbyssystemmanagement/Model/Geometry;", "icon", "getIcon", "id", "getId", "international_phone_number", "getInternational_phone_number", "name", "getName", "opening_hours", "Lcom/example/hbyssystemmanagement/Model/OpeningHours;", "getOpening_hours", "()Lcom/example/hbyssystemmanagement/Model/OpeningHours;", "photos", "", "Landroid/provider/Contacts$Photos;", "getPhotos", "()[Landroid/provider/Contacts$Photos;", "setPhotos", "([Landroid/provider/Contacts$Photos;)V", "[Landroid/provider/Contacts$Photos;", "place_id", "getPlace_id", "rating", "getRating", "reference", "getReference", "scope", "getScope", "types", "getTypes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "url", "getUrl", "utc_offset", "getUtc_offset", "vicinity", "getVicinity", "website", "getWebsite", "app_debug"})
public final class Result {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String icon = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String place_id = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String scope = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String website = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String international_phone_number = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String adr_address = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String url = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String reference = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.hbyssystemmanagement.Model.Geometry geometry = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.hbyssystemmanagement.Model.OpeningHours opening_hours = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String utc_offset = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String id = null;
    public android.provider.Contacts.Photos[] photos;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String vicinity = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String formatted_address = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String formatted_phone_number = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String rating = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String[] types = null;
    
    public Result() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPlace_id() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getScope() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWebsite() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getInternational_phone_number() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAdr_address() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReference() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.Model.Geometry getGeometry() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hbyssystemmanagement.Model.OpeningHours getOpening_hours() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUtc_offset() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.provider.Contacts.Photos[] getPhotos() {
        return null;
    }
    
    public final void setPhotos(@org.jetbrains.annotations.NotNull()
    android.provider.Contacts.Photos[] p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getVicinity() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFormatted_address() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFormatted_phone_number() {
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
}