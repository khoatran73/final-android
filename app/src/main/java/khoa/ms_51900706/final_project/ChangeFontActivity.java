package khoa.ms_51900706.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;


public class ChangeFontActivity extends AppCompatActivity {

    CheckBox checkBoxCorinThiaBoldFont,
            checkBoxDancingFont,
            checkBoxDancingBold,
            checkBoxDancingMedium,
            checkBoxDancingRegular,
            checkBoxDancingSemiBold,
            checkBoxDosisBold,
            checkBoxDosisExtraBold,
            checkBoxDosisExtraLight,
            checkBoxDosisLight,
            checkBoxDosisMedium,
            checkBoxDosisRegular,
            checkBoxDosisSemiBold,
            checkBoxFuzzyBoldFont,
            checkBoxFuzzyRegular,
            checkBoxShadowIntoLight,
            checkBoxShalimar,
            checkBoxIndieFlower;
    Constant constant;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(Constant.theme);
        new AppFontManager(this).setFontStyle();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_font);

        getID();
        setCheckBoxChecked();

        checkBoxCorinThiaBoldFont.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 1;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDancingFont.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 2;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDancingBold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 3;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDancingMedium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 4;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDancingRegular.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 5;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDancingSemiBold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 6;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDosisBold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 7;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDosisExtraBold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 8;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDosisExtraLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 9;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDosisLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 10;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDosisMedium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 11;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDosisRegular.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 12;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxDosisSemiBold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 13;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxFuzzyBoldFont.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 14;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxFuzzyRegular.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 15;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxIndieFlower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 16;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxShadowIntoLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 17;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        checkBoxShalimar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    constant.fontStyle = 19;
                } else{
                    constant.fontStyle = 7;
                }
                reset();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChangeFontActivity.this,SettingActivity.class);
                startActivity(i);
            }
        });
    }

    public void getID(){
        checkBoxCorinThiaBoldFont = findViewById(R.id.checkboxCorinthiaBoldFont);
        checkBoxDancingFont  = findViewById(R.id.checkboxDancingFont);
        checkBoxDancingBold = findViewById(R.id.checkboxDancingBoldFont);
        checkBoxDancingMedium = findViewById(R.id.checkboxDancingMediumFont);
        checkBoxDancingRegular = findViewById(R.id.checkboxDancingRegular);
        checkBoxDancingSemiBold = findViewById(R.id.checkboxDancingSemiBoldFont);
        checkBoxDosisBold = findViewById(R.id.checkboxDosisBoldFont);
        checkBoxDosisExtraBold = findViewById(R.id.checkboxDosisExtraBoldFont);
        checkBoxDosisExtraLight = findViewById(R.id.checkboxDosisExtraLightFont);
        checkBoxDosisLight = findViewById(R.id.checkboxDosisLightFont);
        checkBoxDosisMedium = findViewById(R.id.checkboxDosisMediumFont);
        checkBoxDosisRegular = findViewById(R.id.checkboxDosisRegularFont);
        checkBoxDosisSemiBold = findViewById(R.id.checkboxDosisSemiBoldFont);
        checkBoxFuzzyBoldFont = findViewById(R.id.checkboxFuzzyBoldFont);
        checkBoxFuzzyRegular = findViewById(R.id.checkboxFuzzyRegularFont);
        checkBoxIndieFlower = findViewById(R.id.checkboxIndieFlowerFont);
        checkBoxShadowIntoLight = findViewById(R.id.checkboxShadowIntoLightFont);
        checkBoxShalimar = findViewById(R.id.checkboxShalimarFont);
        btnSave = findViewById(R.id.btnSaveChangeFont);
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
            case 3:
                checkBoxDancingBold.setChecked(true);
                break;
            case 4:
                checkBoxDancingMedium.setChecked(true);
                break;
            case 5:
                checkBoxDancingRegular.setChecked(true);
                break;
            case 6:
                checkBoxDancingSemiBold.setChecked(true);
                break;
            case 7:
                checkBoxDosisBold.setChecked(true);
                break;
            case 8:
                checkBoxDosisExtraBold.setChecked(true);
                break;
            case 9:
                checkBoxDosisExtraLight.setChecked(true);
                break;
            case 10:
                checkBoxDosisLight.setChecked(true);
                break;
            case 11:
                checkBoxDosisMedium.setChecked(true);
                break;
            case 12:
                checkBoxDosisRegular.setChecked(true);
                break;
            case 13:
                checkBoxDosisSemiBold.setChecked(true);
                break;
            case 14:
                checkBoxFuzzyBoldFont.setChecked(true);
                break;
            case 15:
                checkBoxFuzzyRegular.setChecked(true);
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