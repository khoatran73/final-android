package khoa.ms_51900706.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;

public class FontSizeActivity extends AppCompatActivity {
    Slider sliderFontSize;
    TextView tvTestFontSize;
    khoa.ms_51900706.final_project.Constant constant;
    Button btnSave;
    khoa.ms_51900706.final_project.AppFontColorManager appFontColorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set Theme and FontStyle
        setTheme(khoa.ms_51900706.final_project.Constant.theme);
        new khoa.ms_51900706.final_project.AppFontManager(this).setFontStyle();
//        new AppFontSizeManager(this).setFontSize(tvTestFontSize);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_size);

        getID();

        //set text color
        appFontColorManager = new khoa.ms_51900706.final_project.AppFontColorManager(tvTestFontSize);
        appFontColorManager.setFontColor();

        // set text size
        sliderFontSize.setValue(khoa.ms_51900706.final_project.Constant.fontSize);
        tvTestFontSize.setTextSize(khoa.ms_51900706.final_project.Constant.fontSize);

        sliderFontSize.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                tvTestFontSize.setTextSize(value);
                constant.fontSize = value;
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FontSizeActivity.this, khoa.ms_51900706.final_project.SettingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }

    private void getID(){
        sliderFontSize = findViewById(R.id.sliderFontSize);
        tvTestFontSize = findViewById(R.id.tvTestFontSize);
        btnSave = findViewById(R.id.btnSaveFontSize);
    }
}