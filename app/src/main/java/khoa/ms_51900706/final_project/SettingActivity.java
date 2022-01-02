package khoa.ms_51900706.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingActivity extends AppCompatActivity {
    Switch sSetting;
    TextView tvMode;
    ImageView btnColor, btnFontStyle;
    AppCompatActivity appCompatActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(Constant.theme);

        super.onCreate(savedInstanceState);

        appCompatActivity = SettingActivity.this;
        appCompatActivity.getTheme().applyStyle(R.font.corinthia_bold,true);
        setContentView(R.layout.activity_setting);

        sSetting = findViewById(R.id.switchMode);
        tvMode = findViewById(R.id.tvMode);
        btnColor = findViewById(R.id.btnColor);
        btnFontStyle = findViewById(R.id.imgFontStyle);

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            sSetting.setChecked(true);
            tvMode.setText("Dark mode");
        } else
            tvMode.setText("Light mode");

        sSetting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this, ChangeColorThemeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });

        btnFontStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this,ChangeFontActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }
//
//    public void changeTheme() {
//        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
//            setTheme(R.style.DarkThemeCustom);
//
//        } else {
//            setTheme(R.style.LightThemeCustom);
//        }
//    }
//
//    public void reset() {
//        Intent i = new Intent(this,SettingActivity.class);
//        startActivity(i);
//    }

}