package khoa.ms_51900706.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationActivity extends AppCompatActivity {
    NumberPicker pickerHour, pickerMinute, pickerSencond;
    Button btnReset, btnSave;
    AppFontManager app;
    khoa.ms_51900706.final_project.Constant constant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //set theme
        setTheme(khoa.ms_51900706.final_project.Constant.theme);

        // set font
        app = new AppFontManager(this);
        app.setFontStyle();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //find ID
        findID();

        //setting number picker
        pickerHour.setMinValue(0);
        pickerHour.setMaxValue(23);
        pickerMinute.setMaxValue(60);
        pickerMinute.setMinValue(0);
        pickerSencond.setMinValue(0);
        pickerSencond.setMaxValue(60);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickerHour.setValue(0);
                pickerMinute.setValue(0);
                pickerSencond.setValue(0);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.second = pickerSencond.getValue();
                constant.minute = pickerMinute.getValue();
                constant.hour = pickerHour.getValue();
                Intent i = new Intent(NotificationActivity.this, khoa.ms_51900706.final_project.SettingActivity.class);
                startActivity(i);
            }
        });
    }

    public void findID(){
        pickerHour = findViewById(R.id.number_picker_hours);
        pickerMinute = findViewById(R.id.number_picker_minutes);
        pickerSencond = findViewById(R.id.number_picker_senconds);
        btnReset = findViewById(R.id.btnReset);
        btnSave = findViewById(R.id.btnSaveTimeNoti);
    }
}