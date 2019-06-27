package com.gradpro.home_automation.smarthomeautomation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signin extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText emailt;
    EditText passwordt;
    String password;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signin);
        Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
        emailt = (EditText) findViewById(R.id.emailfield22);
        passwordt = (EditText) findViewById(R.id.passwordfield22);
         Button logbut = (Button) findViewById(R.id.loginbutton2);
        mAuth = FirebaseAuth.getInstance();
        /*logbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(signin.this, home1.class);
                startActivity(s);
            }
        });*/
        email=emailt.getText().toString();
        password=passwordt.getText().toString();
        if (!email.isEmpty()&&!password.isEmpty()) {
            logbut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(signin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Intent succ = new Intent(signin.this, home1.class);
                                startActivity(succ);

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getApplicationContext(), "wrong username or password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
            });




    }
        else {
            // If sign in fails, display a message to the user.
            Toast.makeText(getApplicationContext(), "wrong user", Toast.LENGTH_SHORT).show();
        }
}}