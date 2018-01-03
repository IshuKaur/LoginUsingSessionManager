package com.example.ishpreetkaur.loginappsession;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AfterLoginActivity extends AppCompatActivity {

    EditText username_text,pass_text;
    Button Login_Button;
    SharedPreferenceSession sharedPreferenceSession;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        sharedPreferenceSession=new SharedPreferenceSession(getApplicationContext());
        username_text=findViewById(R.id.textview1);
        pass_text=findViewById(R.id.textview2);
        Login_Button=findViewById(R.id.logout_button);

        Login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginCheck();
            }
        });

        Toast.makeText(getApplicationContext(), "User Login Status: " + sharedPreferenceSession.isLoggedIn(), Toast.LENGTH_LONG).show();
    }

    public void LoginCheck()
    {
       String user_name=username_text.getText().toString();
       String pass=pass_text.getText().toString();

       if(user_name.equals("text")&& pass.equals("text"))
       {
           sharedPreferenceSession.createLoginSession("IshpreetKaur","ishukaur14@gmail.com");
           Intent intent=new Intent(this,MainActivity.class);
           startActivity(intent);
       }
       else
           Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }
}
