package khoa.ms_51900706.final_project;

import androidx.appcompat.app.AppCompatActivity;

public class AppFontManager {
    private AppCompatActivity appCompatActivity;

    public AppFontManager(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }
    public void setFontStyle (){
        switch (khoa.ms_51900706.final_project.Constant.fontStyle){
            case 1:
                appCompatActivity.getTheme().applyStyle(R.style.CorinthiaBold,true);
                break;
            case 2:
                appCompatActivity.getTheme().applyStyle(R.style.Dancing,true);
                break;
            case 3:
                appCompatActivity.getTheme().applyStyle(R.style.DancingBold,true);
                break;
            case 4:
                appCompatActivity.getTheme().applyStyle(R.style.DancingMedium,true);
                break;
            case 5:
                appCompatActivity.getTheme().applyStyle(R.style.Dancing_regular,true);
                break;
            case 6:
                appCompatActivity.getTheme().applyStyle(R.style.Dancing_semi_bold,true);
                break;
            case 7:
                appCompatActivity.getTheme().applyStyle(R.style.Dosis_Bold,true);
                break;
            case 8:
                appCompatActivity.getTheme().applyStyle(R.style.Dosis_extraBold,true);
                break;
            case 9:
                appCompatActivity.getTheme().applyStyle(R.style.Dosis_extraLight,true);
                break;
            case 10:
                appCompatActivity.getTheme().applyStyle(R.style.Dosis_Light,true);
                break;
            case 11:
                appCompatActivity.getTheme().applyStyle(R.style.Dosis_Medium,true);
                break;
            case 12:
                appCompatActivity.getTheme().applyStyle(R.style.Dosis_regular,true);
                break;
            case 13:
                appCompatActivity.getTheme().applyStyle(R.style.Dosis_semiBold,true);
                break;
            case 14:
                appCompatActivity.getTheme().applyStyle(R.style.Fuzzy_Bubbles_Bold,true);
                break;
            case 15:
                appCompatActivity.getTheme().applyStyle(R.style.Fuzzy_Bubbles_Regular,true);
                break;
            case 16:
                appCompatActivity.getTheme().applyStyle(R.style.Indie_Flower_Regular,true);
                break;
            case 17:
                appCompatActivity.getTheme().applyStyle(R.style.Shadow_into_light_regular,true);
                break;
            case 18:
                appCompatActivity.getTheme().applyStyle(R.style.Shalimar_Regular,true);
            default:
                appCompatActivity.getTheme().applyStyle(R.style.Dosis_regular,true);
                break;
        }
    }
}
