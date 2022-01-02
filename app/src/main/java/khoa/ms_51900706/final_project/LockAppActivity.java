package khoa.ms_51900706.final_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LockAppActivity extends AppCompatActivity {
    khoa.ms_51900706.final_project.Constant constant;
    Button btnSave;
    EditText etPass;
    Integer pass;
    khoa.ms_51900706.final_project.DatabaseHandler db;
    khoa.ms_51900706.final_project.Lock lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_app);

        getID();
        db = new khoa.ms_51900706.final_project.DatabaseHandler(this);
        lock = db.getLock(1);
//        lock.setFlag("false");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lock.setPassword((etPass.getText().toString()));
                db.updateLock(lock);
                Toast.makeText(LockAppActivity.this,lock.getPassword(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getID(){
        btnSave = findViewById(R.id.bntSavePassword);
        etPass = findViewById(R.id.etPassword);
    }
}