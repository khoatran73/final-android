package khoa.ms_51900706.final_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class ChangeColorThemeActivity extends AppCompatActivity {

    khoa.ms_51900706.final_project.Constant constant;
    khoa.ms_51900706.final_project.Methods methods;

    Button btnC1, btnC2, btnC3, btnC4, btnC5, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(khoa.ms_51900706.final_project.Constant.theme);
        new AppFontManager(this).setFontStyle();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_color_theme);

        methods = new khoa.ms_51900706.final_project.Methods();

        inIt();
        writeThemeColorToFile(String.valueOf(constant.color),ChangeColorThemeActivity.this);

        btnC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.color = 1;
                methods.setColorTheme();
                reset();
            }
        });

        btnC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.color = 2;
                methods.setColorTheme();
                reset();
            }
        });

        btnC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.color = 3;
                methods.setColorTheme();
                reset();
            }
        });

        btnC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.color = 4;
                methods.setColorTheme();
                reset();
            }
        });

        btnC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constant.color = 5;
                methods.setColorTheme();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChangeColorThemeActivity.this, khoa.ms_51900706.final_project.SettingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

    }

    public void inIt(){
        btnC1 = findViewById(R.id.btnColor1);
        btnC2 = findViewById(R.id.btnColor2);
        btnC3 = findViewById(R.id.btnColor3);
        btnC4 = findViewById(R.id.btnColor4);
        btnC5 = findViewById(R.id.btnColor5);
        btnExit = findViewById(R.id.btnExit);
    }

    public void reset() {
        Intent i = new Intent(this,ChangeColorThemeActivity.class);
        startActivity(i);
    }

    public static void writeThemeColorToFile(String data, Context context){
        try {
            OutputStreamWriter outputStream = new OutputStreamWriter(context.openFileOutput("themeColor.txt",Context.MODE_PRIVATE));
            outputStream.write(data);
            outputStream.close();

        }catch (IOException e){
            Log.e("Exception","File write failed "+e.toString());
        }
    }
}