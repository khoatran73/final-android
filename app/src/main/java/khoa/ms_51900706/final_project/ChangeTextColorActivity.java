package khoa.ms_51900706.final_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeTextColorActivity extends AppCompatActivity {

    Button btnSave;
    TextView tvTest;
    CheckBox checkBoxTextGray, checkBoxTextWhite, checkBoxTextBeige, checkBoxTextBlack;
    khoa.ms_51900706.final_project.Constant constant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(khoa.ms_51900706.final_project.Constant.theme);
        new khoa.ms_51900706.final_project.AppFontManager(this).setFontStyle();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_text_color);

        getID();
        setChecKBoxChecked();
        tvTest.setTextSize(khoa.ms_51900706.final_project.Constant.fontSize);
        checkBoxTextWhite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxTextBeige.setChecked(false);
                    checkBoxTextBlack.setChecked(false);
                    checkBoxTextGray.setChecked(false);
                    constant.fontColor = 4;
                } else {
                    constant.fontColor = 0;
                }
                setChecKBoxChecked();
//                reset();
            }
        });
        checkBoxTextBlack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxTextBeige.setChecked(false);
                    checkBoxTextWhite.setChecked(false);
                    checkBoxTextGray.setChecked(false);
                    khoa.ms_51900706.final_project.Constant.fontColor = 3;
                } else {
                    khoa.ms_51900706.final_project.Constant.fontColor = 0;
                }
                setChecKBoxChecked();
//                reset();
            }
        });
        checkBoxTextBeige.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxTextBlack.setChecked(false);
                    checkBoxTextWhite.setChecked(false);
                    checkBoxTextGray.setChecked(false);
                    constant.fontColor = 2;
                } else {
                    constant.fontColor = 0;
                }
                setChecKBoxChecked();
//                reset();
            }
        });
        checkBoxTextGray.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxTextBeige.setChecked(false);
                    checkBoxTextBlack.setChecked(false);
                    checkBoxTextWhite.setChecked(false);
                    constant.fontColor = 1;
                } else {
                    constant.fontColor = 0;
                }
                setChecKBoxChecked();
//                reset();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChangeTextColorActivity.this, khoa.ms_51900706.final_project.SettingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

    }

    private void getID(){
        checkBoxTextBeige = findViewById(R.id.checkboxTextBeige);
        checkBoxTextBlack = findViewById(R.id.checkboxTextBlack);
        checkBoxTextGray = findViewById(R.id.checkboxTextGray);
        checkBoxTextWhite = findViewById(R.id.checkboxTextWhite);
        tvTest = findViewById(R.id.tvTestFontColor);
        btnSave = findViewById(R.id.btnSaveChangeFontColor);
    }

    private void setChecKBoxChecked() {
        switch (khoa.ms_51900706.final_project.Constant.fontColor){
            case 1:
                tvTest.setTextColor(Color.GRAY);
//                checkBoxTextGray.setChecked(true);
                break;
            case 2:
                tvTest.setTextColor(Color.rgb(245,245,220));
//                checkBoxTextBeige.setChecked(true);
                break;
            case 3:
                tvTest.setTextColor(Color.BLACK);
//                checkBoxTextBlack.setChecked(true);
                break;
            case 4:
                tvTest.setTextColor(Color.WHITE);
//                checkBoxTextWhite.setChecked(true);
                break;
            default:
                break;
        }
    }

    private void reset(){
        Intent i = new Intent(ChangeTextColorActivity.this,ChangeTextColorActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}