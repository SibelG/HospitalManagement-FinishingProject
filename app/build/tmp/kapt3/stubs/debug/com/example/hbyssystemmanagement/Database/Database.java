package com.example.hbyssystemmanagement.Database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000f\u001a\u00020\bJ\u0018\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0011j\b\u0012\u0004\u0012\u00020\n`\u0012H\u0007J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/example/hbyssystemmanagement/Database/Database;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)V", "addFavourites", "", "item", "Lcom/example/hbyssystemmanagement/Model/Favourites;", "deleteFavourites", "doctorId", "", "UserEmail", "deleteToCart", "getAllFavlist", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isFavourite", "", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "p1", "", "p2", "Companion", "Database", "app_debug"})
public final class Database extends android.database.sqlite.SQLiteOpenHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.hbyssystemmanagement.Database.Database.Companion Companion = null;
    private static final java.lang.String DBname = "EntityDb.db";
    private static final int dbVersion = 1;
    private static final java.lang.String table = "Favourites";
    
    public Database(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase.CursorFactory factory) {
        super(null, null, null, 0);
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db, int p1, int p2) {
    }
    
    public final void addFavourites(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.Model.Favourites item) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"Range"})
    public final java.util.ArrayList<com.example.hbyssystemmanagement.Model.Favourites> getAllFavlist() {
        return null;
    }
    
    public final void deleteFavourites(@org.jetbrains.annotations.Nullable()
    java.lang.String doctorId, @org.jetbrains.annotations.Nullable()
    java.lang.String UserEmail) {
    }
    
    public final boolean isFavourite(@org.jetbrains.annotations.Nullable()
    java.lang.String doctorId, @org.jetbrains.annotations.Nullable()
    java.lang.String UserEmail) {
        return false;
    }
    
    public final void deleteToCart() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/hbyssystemmanagement/Database/Database$Companion;", "", "()V", "DBname", "", "dbVersion", "", "table", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}