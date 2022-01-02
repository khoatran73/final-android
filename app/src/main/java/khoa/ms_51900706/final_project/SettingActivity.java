package khoa.ms_51900706.final_project;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import java.util.Calendar;
import java.util.Date;


public class SettingActivity extends AppCompatActivity {
    Methods methods;
    Boolean isLock;
    Switch sSetting, sNoti, sLock;
    TextView tvMode;
    Constant constant;
    Button btnMain;
    CardView cardMode, cardColorPrimary, cardFont, cardFontSize, cardFontColor, cardNoti, cardLockApp;
    DatabaseHandler data;
    Lock lock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //set theme
        setTheme(Constant.theme);

        // set font
        new AppFontManager(this).setFontStyle();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //find ID
        getID();

        //get data
        data = new DatabaseHandler(this);
        lock = data.getLock(1);

        //set checked for switch sLock
        sLock.setChecked(Boolean.valueOf(lock.getLock()));
        Toast.makeText(SettingActivity.this, lock.getLock(),Toast.LENGTH_LONG).show();

        // set notify checked
        sNoti.setChecked(Constant.notify);

        // set mode checked
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            sSetting.setChecked(true);
        } else
            sSetting.setChecked(false);

        //sLock.setChecked(isLock);

        methods = new Methods();
        sSetting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    methods.setColorTheme();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    methods.setColorTheme();
                }
            }
        });

        cardColorPrimary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this, ChangeColorThemeActivity.class);
                startActivity(i);
            }
        });

        cardFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this, khoa.ms_51900706.final_project.ChangeFontActivity.class);
                startActivity(i);
            }
        });

        cardFontSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this,FontSizeActivity.class);
                startActivity(i);
            }
        });

        cardFontColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this, ChangeTextColorActivity.class);
                startActivity(i);
            }
        });

        sNoti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Constant.notify = true;
                    myAlarm();
                } else{
                    Constant.notify = false;
                }
            }
        });

        cardNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this, NotificationActivity.class);
                startActivity(i);
            }
        });

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this, khoa.ms_51900706.final_project.MainActivity.class);
                startActivity(i);
            }
        });

        cardLockApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this, LockAppActivity.class);
                startActivity(i);
            }
        });

        sLock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                lock.setLock(String.valueOf(b));
                data.updateLock(lock);
                Toast.makeText(SettingActivity.this,lock.getLock(),Toast.LENGTH_LONG).show();
            }
        });


    }

    private void getID(){
        sSetting = findViewById(R.id.switchMode);
        tvMode = findViewById(R.id.tvMode);
        cardMode = findViewById(R.id.cardMode);
        cardColorPrimary = findViewById(R.id.cardColorPrimary);
        cardFont = findViewById(R.id.cardFont);
        cardFontSize = findViewById(R.id.cardFontSize);
        cardFontColor = findViewById(R.id.cardFontColor);
        cardNoti = findViewById(R.id.cardNotification);
        sNoti = findViewById(R.id.switchNoti);
        btnMain = findViewById(R.id.btnGoMain);
        cardLockApp = findViewById(R.id.cardLockApp);
        sLock = findViewById(R.id.switchLock);
    }

    private void reset() {
        Intent i = new Intent(this,SettingActivity.class);
        startActivity(i);
    }
    public void myAlarm(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Constant.hour);
        calendar.set(Calendar.MINUTE, Constant.minute);
        calendar.set(Calendar.SECOND, Constant.second);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        }
    }
//    public void readIsLock(){
//        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("isLock");
//        // Read from the database
//        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                isLock = Boolean.valueOf(task.getResult().getValue().toString());
//            }
//        });
//    }
//
//    public void pushBool(Boolean data){
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("isLock");
//        myRef.setValue(data);
//    }


}