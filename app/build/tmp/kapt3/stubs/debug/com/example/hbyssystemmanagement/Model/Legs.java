package com.example.hbyssystemmanagement.Model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR \u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'\u00a8\u0006("}, d2 = {"Lcom/example/hbyssystemmanagement/Model/Legs;", "", "()V", "distance", "Lcom/example/hbyssystemmanagement/Model/Distance;", "getDistance", "()Lcom/example/hbyssystemmanagement/Model/Distance;", "setDistance", "(Lcom/example/hbyssystemmanagement/Model/Distance;)V", "duration", "Lcom/example/hbyssystemmanagement/Model/Duration;", "getDuration", "()Lcom/example/hbyssystemmanagement/Model/Duration;", "setDuration", "(Lcom/example/hbyssystemmanagement/Model/Duration;)V", "end_address", "", "getEnd_address", "()Ljava/lang/String;", "setEnd_address", "(Ljava/lang/String;)V", "end_location", "Lcom/example/hbyssystemmanagement/Model/Location;", "getEnd_location", "()Lcom/example/hbyssystemmanagement/Model/Location;", "setEnd_location", "(Lcom/example/hbyssystemmanagement/Model/Location;)V", "start_address", "getStart_address", "setStart_address", "start_location", "getStart_location", "setStart_location", "steps", "Ljava/util/ArrayList;", "Lcom/example/hbyssystemmanagement/Model/Steps;", "getSteps", "()Ljava/util/ArrayList;", "setSteps", "(Ljava/util/ArrayList;)V", "app_debug"})
public final class Legs {
    @org.jetbrains.annotations.NotNull()
    private com.example.hbyssystemmanagement.Model.Distance distance;
    @org.jetbrains.annotations.NotNull()
    private com.example.hbyssystemmanagement.Model.Duration duration;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String end_address = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String start_address = "";
    @org.jetbrains.annotations.NotNull()
    private com.example.hbyssystemmanagement.Model.Location end_location;
    @org.jetbrains.annotations.NotNull()
    private com.example.hbyssystemmanagement.Model.Location start_location;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.hbyssystemmanagement.Model.Steps> steps;
    
    public Legs() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hbyssystemmanagement.Model.Distance getDistance() {
        return null;
    }
    
    public final void setDistance(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.Model.Distance p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hbyssystemmanagement.Model.Duration getDuration() {
        return null;
    }
    
    public final void setDuration(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.Model.Duration p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEnd_address() {
        return null;
    }
    
    public final void setEnd_address(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStart_address() {
        return null;
    }
    
    public final void setStart_address(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hbyssystemmanagement.Model.Location getEnd_location() {
        return null;
    }
    
    public final void setEnd_location(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.Model.Location p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hbyssystemmanagement.Model.Location getStart_location() {
        return null;
    }
    
    public final void setStart_location(@org.jetbrains.annotations.NotNull()
    com.example.hbyssystemmanagement.Model.Location p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.hbyssystemmanagement.Model.Steps> getSteps() {
        return null;
    }
    
    public final void setSteps(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.hbyssystemmanagement.Model.Steps> p0) {
    }
}