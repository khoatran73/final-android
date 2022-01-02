package khoa.ms_51900706.final_project;

import android.graphics.Color;
import android.widget.TextView;

public class AppFontColorManager {
    TextView text;
    public AppFontColorManager(TextView text){
        this.text = text;
    }

    public void setFontColor(){
        switch (khoa.ms_51900706.final_project.Constant.fontColor){
            case 1:
                text.setTextColor(Color.GRAY);
                break;
            case 2:
                text.setTextColor(Color.rgb(245,245,220));
                break;
            case 3:
                text.setTextColor(Color.BLACK);
                break;
            case 4:
                text.setTextColor(Color.WHITE);
                break;
            default:
                break;
        }
    }
}
