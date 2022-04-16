package com.example.hbyssystemmanagement.View;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/example/hbyssystemmanagement/View/SignUpActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mDatabase", "Lcom/google/firebase/database/DatabaseReference;", "getMDatabase", "()Lcom/google/firebase/database/DatabaseReference;", "setMDatabase", "(Lcom/google/firebase/database/DatabaseReference;)V", "goToLogin", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "registerUser", "sendEmailVerification", "app_debug"})
public final class SignUpActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.google.firebase.database.DatabaseReference mDatabase;
    private final java.lang.String TAG = "FirebaseEmailPassword";
    private com.google.firebase.auth.FirebaseAuth mAuth;
    private java.util.HashMap _$_findViewCache;
    
    public SignUpActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getMDatabase() {
        return null;
    }
    
    public final void setMDatabase(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void goToLogin(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void registerUser(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void sendEmailVerification() {
    }
}