package com.example.okanaydin.needit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private  Button multeci, bagisci, signup;
    private EditText e_email, e_password;
    private TextView forgetPassword;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //FirebaseAuth sınıfının referans olduğu nesneleri kullanabilmek için getInstance methodunu kullanıyoruz.
        auth = FirebaseAuth.getInstance();

        multeci=(Button) findViewById(R.id.ButtonMulteci);
        bagisci=(Button) findViewById(R.id.ButtonBagisci);
        signup=(Button) findViewById(R.id.ButtonSignUp);
        e_email=(EditText) findViewById(R.id.EditEmail);
        e_password=(EditText) findViewById(R.id.EditPassword);
        forgetPassword=(TextView) findViewById(R.id.TextForgot);

        //Geçerli bir yetkilendirme olup olmadığını kontrol ediyoruz.
        if(auth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }


        multeci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e_email.getText().toString();
                final String parola = e_password.getText().toString();

                //Email girilmemiş ise kullanıcıyı uyarıyoruz.
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Lütfen emailinizi giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Parola girilmemiş ise kullanıcıyı uyarıyoruz.
                if (TextUtils.isEmpty(parola)) {
                    Toast.makeText(getApplicationContext(), "Lütfen parolanızı giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Firebase üzerinde kullanıcı doğrulamasını başlatıyoruz
                //Eğer giriş başarılı olursa task.isSuccessful true dönecek ve MainActivity e geçilecek
                auth.signInWithEmailAndPassword(email, parola)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                }
                                else {
                                    Log.e("Giriş Hatası",task.getException().getMessage());
                                }
                            }
                        });

            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgetPassword.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });



    }
}
