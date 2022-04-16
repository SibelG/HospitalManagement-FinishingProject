package com.example.hbyssystemmanagement.roomdb;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\n"}, d2 = {"Lcom/example/hbyssystemmanagement/roomdb/PlaceDao;", "", "delete", "Lio/reactivex/rxjava3/core/Completable;", "place", "Lcom/example/hbyssystemmanagement/Model/Place;", "getAll", "Lio/reactivex/rxjava3/core/Flowable;", "", "insert", "app_debug"})
public abstract interface PlaceDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Place")
    public abstract io.reactivex.rxjava3.core.Flowable<java.util.List<com.example.hbyssystemmanagement.Model.Place>> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Insert()
    public abstract io.reactivex.rxjava3.core.Completable insert(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.Model.Place place);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Delete()
    public abstract io.reactivex.rxjava3.core.Completable delete(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.Model.Place place);
}