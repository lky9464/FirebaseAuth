package kr.ivis.firebaseauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class EmailVerifyPage extends AppCompatActivity implements View.OnClickListener {

    Button btn_send;
    Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verify_page);

        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);
        btn_confirm = findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send: {
                FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification();
                Toast.makeText(this, "인증 메일 보냄", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.btn_confirm: {
                Toast.makeText(this, "인증됨", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HalloAuth.class));
            }
            break;
        }
    }
}