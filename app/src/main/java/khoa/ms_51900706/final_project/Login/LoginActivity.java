package khoa.ms_51900706.final_project.Login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Objects;

import khoa.ms_51900706.final_project.MainActivity;
import khoa.ms_51900706.final_project.R;
import khoa.ms_51900706.final_project.Session.SessionManagement;
import khoa.ms_51900706.final_project.User.User;

public class LoginActivity extends AppCompatActivity {
    public static final int RC_SIGN_IN = 9001;
    public FirebaseAuth mAuth;
    SignInButton ggLoginBtn;
    Button fbLoginBtn;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://final-project-c4e36-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference myRef;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ggLoginBtn = findViewById(R.id.gg_login_btn);
        setGooglePlusButtonText(ggLoginBtn);

        sessionManagement = new SessionManagement(LoginActivity.this);

        if (!sessionManagement.getSession().equals("")) {
            moveToMainActivity();
        }

        mAuth = FirebaseAuth.getInstance();
        ggLoginBtn.setOnClickListener(view -> {
            Intent i = new Intent(LoginActivity.this, GoogleAuthActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });

        fbLoginBtn = findViewById(R.id.fb_login_btn);
        fbLoginBtn.setOnClickListener(view -> {
            Intent i = new Intent(LoginActivity.this, FacebookAuthActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });
    }

    public void updateUI(FirebaseUser user) {
        if (user != null) {
            User u = new User();
            u.setEmail(user.getEmail());
            u.setName(user.getDisplayName());
            u.setImage(Objects.requireNonNull(user.getPhotoUrl()).toString());
            u.setUid(user.getUid());

            if (Objects.requireNonNull(user.getMetadata()).getCreationTimestamp() == user.getMetadata().getLastSignInTimestamp()) {
                // new user
                myRef = database.getReference("users");
                myRef.child(u.getUid()).setValue(u);
            }

            sessionManagement.saveSession(u);
            moveToMainActivity();
        } else {
            Toast.makeText(LoginActivity.this , "login fail", Toast.LENGTH_SHORT).show();
        }
    }

    private void moveToMainActivity() {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    private void setGooglePlusButtonText(SignInButton signInButton) {
        // Find the TextView that is inside of the SignInButton and set its text
        for (int i = 0; i < signInButton.getChildCount(); i++) {
            View v = signInButton.getChildAt(i);

            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                tv.setText("Đăng nhập bằng Google");
                return;
            }
        }
    }
}