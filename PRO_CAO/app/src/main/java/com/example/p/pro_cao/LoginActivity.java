package com.example.p.pro_cao;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private String mLogin;
    private String mPassword;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    //    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

      /*  if (user != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else {
            setContentView(R.layout.activity_login);
            Button singIn = (Button) findViewById(R.id.singIn); // кнопка авторизации
            EditText login = (EditText) findViewById(R.id.login), password = (EditText) findViewById(R.id.password);

            singIn.setOnClickListener(new OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View v) {
                    mLogin = ((EditText) findViewById(R.id.login)).getText().toString();
                    mPassword = ((EditText) findViewById(R.id.password)).getText().toString();
                    if ("".equals(mLogin) || "".equals(mPassword)) {
                        Toast.makeText(getApplicationContext(), "Одно из полей не заполненно. Пожалуйста, заполните все поля и повторите отправку", Toast.LENGTH_LONG).show();
                    } else {
                        singInUser();
                    }

                }
            });
*/
            Button singUp = (Button) findViewById(R.id.singUp); // кнопка регистрации
            singUp.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
            });
        }






    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void singInUser() {
        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // sing in

                } else {
                    //sing out
                }
            }
        };

        mAuth.signInWithEmailAndPassword(mLogin, mPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()  {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //Toast.makeText(getApplicationContext(), "Авторизация успешна", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    intent.putExtra("PARAM", 1);

                    startActivity(intent);
                    finish();
                    /*Fragment fragment = new Tasks();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);*/

                } else {
                    Toast.makeText(getApplicationContext(), "Авторизация провалена", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
