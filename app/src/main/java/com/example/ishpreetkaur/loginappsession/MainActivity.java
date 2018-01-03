package com.example.ishpreetkaur.loginappsession;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView username,password;
    Button login_button;
    SharedPreferenceSession sharedPreferenceSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.editext1);
        password=findViewById(R.id.editext2);
        sharedPreferenceSession=new SharedPreferenceSession(getApplicationContext());
        login_button=findViewById(R.id.button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        Toast.makeText(this, "User Login status"+sharedPreferenceSession.isLoggedIn(), Toast.LENGTH_SHORT).show();
        sharedPreferenceSession.checkLogin();
        HashMap<String,String> user=sharedPreferenceSession.getUserDetails();
        String name=user.get(SharedPreferenceSession.KEY_NAME);
        String email=user.get(SharedPreferenceSession.KEY_EMAIL);

        username.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        password.setText(Html.fromHtml("Email: <b>" + email + "</b>"));
    }

    public void login()
    {
        sharedPreferenceSession.logoutUSer();

    }
}
