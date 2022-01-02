package khoa.ms_51900706.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeFontActivity extends AppCompatActivity {

    CheckBox checkBoxCorinThiaBoldFont, checkBoxDancingFont, checkBoxDosisBold, checkBoxFuzzyBoldFont, checkBoxShadowIntoLight, checkBoxShalimar, checkBoxIndieFlower;
    Constant constant;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(Constant.theme);
        new AppFontManager(this).setFontStyle();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_font);

        getID();
        setCheckBoxChecked();

        checkBoxCorinThiaBoldFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.fontStyle = 1;
                reset();
            }
        });

        checkBoxDancingFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.fontStyle = 2;
                reset();
            }
        });

        checkBoxDosisBold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.fontStyle = 7;
                reset();
            }
        });

        checkBoxFuzzyBoldFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.fontStyle = 14;
                reset();
            }
        });

        checkBoxIndieFlower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.fontStyle = 16;
                reset();
            }
        });


        checkBoxShadowIntoLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.fontStyle = 17;
                reset();
            }
        });

        checkBoxShalimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.fontStyle = 18;
                reset();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChangeFontActivity.this, khoa.ms_51900706.final_project.SettingActivity.class);
                startActivity(i);
            }
        });
    }

    public void getID(){
        checkBoxCorinThiaBoldFont = findViewById(R.id.checkboxCorinthiaBoldFont);
        checkBoxDancingFont  = findViewById(R.id.checkboxDancingFont);
        checkBoxDosisBold = findViewById(R.id.checkboxDosisBoldFont);
        checkBoxFuzzyBoldFont = findViewById(R.id.checkboxFuzzyBoldFont);
        checkBoxIndieFlower = findViewById(R.id.checkboxIndieFlowerFont);
        checkBoxShadowIntoLight = findViewById(R.id.checkboxShadowIntoLightFont);
        checkBoxShalimar = findViewById(R.id.checkboxShalimarFont);
        btnExit = findViewById(R.id.btnExit);
    }

    private void reset() {
        Intent i = new Intent(this,ChangeFontActivity.class);
        startActivity(i);
    }

    private void setCheckBoxChecked(){
        switch (Constant.fontStyle){
            case 1:
                checkBoxCorinThiaBoldFont.setChecked(true);
                break;
            case 2:
                checkBoxDancingFont.setChecked(true);
                break;
            case 7:
                checkBoxDosisBold.setChecked(true);
                break;
            case 14:
                checkBoxFuzzyBoldFont.setChecked(true);
                break;
            case 16:
                checkBoxIndieFlower.setChecked(true);
                break;
            case 17:
                checkBoxShadowIntoLight.setChecked(true);
                break;
            case 18:
                checkBoxShalimar.setChecked(true);
                break;
        }
    }
}