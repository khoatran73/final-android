package khoa.ms_51900706.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LockScreenActivity extends AppCompatActivity {

    TextInputEditText inputPass;
    Button btnNhap;
    khoa.ms_51900706.final_project.DatabaseHandler db;
    khoa.ms_51900706.final_project.Lock lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen);

        db = new khoa.ms_51900706.final_project.DatabaseHandler(this);

//         create default lock
//        if(db.getLock(1)==null){
//            lock = new Lock(1,"123456","false","false");
//            db.addLock(lock);
//        }
//
        lock = db.getLock(1);

       if(!Boolean.parseBoolean(lock.getLock())){
            Intent i = new Intent(LockScreenActivity.this, khoa.ms_51900706.final_project.MainActivity.class);
               i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
               i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
        getID();
//        String color = readMainColor(this);
//        if (color != "") {
//            Constant.color = Integer.valueOf(color);
//        }



        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(LockScreenActivity.this,"input: "+inputPass.getText()+"\n"+lock.getPassword(),Toast.LENGTH_LONG).show();

                if (!lock.getPassword().equals(inputPass.getText().toString())) {
                    Toast.makeText(LockScreenActivity.this,"Mật khẩu sai", Toast.LENGTH_LONG).show();
                } else {
                    lock.setFlag("true");
                    db.updateLock(lock);
                    Intent i = new Intent(LockScreenActivity.this, khoa.ms_51900706.final_project.MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                }
            }
        });
    }

    private void getID(){
        inputPass = findViewById(R.id.etInputPass);
        btnNhap = findViewById(R.id.btnNhapPass);
    }

//    public static  String readThemeColor(Context context){
//        String ret="";
//        try {
//            InputStream input = context.openFileInput("mainColor.txt");
//            if(input != null){
//                InputStreamReader inputStreamReader = new InputStreamReader(input);
//                BufferedReader buffered = new BufferedReader(inputStreamReader);
//                String reciverString ="";
//                StringBuilder stringBuilder = new StringBuilder();
//
//                while ((reciverString = buffered.readLine()) != null){
//                    stringBuilder.append(reciverString);
//                }
//
//                input.close();
//                ret = stringBuilder.toString();
//            }
//        }
//        catch (FileNotFoundException e){
//            Log.e("lock activity","File not found: "+e.toString());
//            return "";
//        } catch (IOException e){
//            Log.e("lock activity","Can not read file"+e.toString());
//            return  "";
//        }
//        return ret;
//    }

}