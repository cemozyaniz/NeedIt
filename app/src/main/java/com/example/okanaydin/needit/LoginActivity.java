package com.example.okanaydin.needit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private  Button multeci, bagisci, signup;
    private EditText e_email, e_password;
    private TextView forgetPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        multeci=(Button) findViewById(R.id.ButtonMulteci);
        bagisci=(Button) findViewById(R.id.ButtonBagisci);
        signup=(Button) findViewById(R.id.ButtonSignUp);
        e_email=(EditText) findViewById(R.id.EditEmail);
        e_password=(EditText) findViewById(R.id.EditPassword);
        forgetPassword=(TextView) findViewById(R.id.TextForgot);



        multeci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = e_email.getText().toString();
                final String password = e_password.getText().toString();

                //Email girilmemiş ise kullanıcıyı uyarıyoruz.
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Lütfen emailinizi giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Parola girilmemiş ise kullanıcıyı uyarıyoruz.
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Lütfen parolanızı giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (e_email.getText().toString().equals("okan@google.com")){

                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(),"Yanlış girdiniz, Tekrar deneyin", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bagisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email = e_email.getText().toString();
                final String password = e_password.getText().toString();

                //Email girilmemiş ise kullanıcıyı uyarıyoruz.
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Lütfen emailinizi giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Parola girilmemiş ise kullanıcıyı uyarıyoruz.
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Lütfen parolanızı giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (e_email.getText().equals("okan@google.com") && (e_password.getText().equals("1234"))){

                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(),"Yanlış girdiniz, Tekrar deneyin", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
