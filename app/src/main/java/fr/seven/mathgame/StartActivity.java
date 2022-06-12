package fr.seven.mathgame;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.OAuthProvider;

import java.util.Objects;

public class StartActivity extends AppCompatActivity {
    static Boolean initialized = true;
    static FirebaseAuth firebaseAuth;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        FirebaseUser fUser;
        FirebaseApp.initializeApp(/*context=*/ this);
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(
                SafetyNetAppCheckProviderFactory.getInstance());
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            findViewById(R.id.constlayout).setVisibility(View.VISIBLE);
        }
        else {
            System.out.println("Already connected");
            start_application(null);
        }
    }



    public void connectViaGithub(View view){
        OAuthProvider.Builder provider = OAuthProvider.newBuilder("github.com");
        Task<AuthResult> pendingResultTask = firebaseAuth.getPendingAuthResult();
        if (pendingResultTask != null) {
            pendingResultTask
                    .addOnSuccessListener(
                            new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    System.out.println("Signed in as "+ Objects.requireNonNull(authResult.getUser()).getDisplayName());
                                    System.out.println("PP: "+authResult.getUser().getPhotoUrl());
                                    FirebaseUser fUser = authResult.getUser();
                                    sharedPreferences.edit().putString("UserUID",fUser.getUid());
                                    sharedPreferences.edit().putString("UserDisplayName",fUser.getDisplayName());
                                    sharedPreferences.edit().putString("UserPhoto", String.valueOf(fUser.getPhotoUrl()));
                                    start_application(null);

                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    System.out.println("Login failed :(");
                                    System.out.println(e);
                                }
                            });
        } else {
            firebaseAuth.startActivityForSignInWithProvider(/* activity= */ this, provider.build())
                    .addOnSuccessListener(
                            new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    FirebaseUser fUser = authResult.getUser();
                                    System.out.println("Signed in as "+ Objects.requireNonNull(authResult.getUser()).getDisplayName());
                                    System.out.println("PP: "+authResult.getUser().getPhotoUrl());
                                    fUser = authResult.getUser();

                                    start_application(null);                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    System.out.println("Login failed :(");
                                    System.out.println(e);

                                }
                            });
        }
    }

    public void start_application(View view){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
