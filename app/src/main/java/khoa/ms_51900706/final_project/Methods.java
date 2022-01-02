package khoa.ms_51900706.final_project;

import androidx.appcompat.app.AppCompatDelegate;

public class Methods {
    public void setColorTheme(){
        switch (khoa.ms_51900706.final_project.Constant.color) {
            //Đỏ
            case 1:
                if(isDarkMode()){
                    khoa.ms_51900706.final_project.Constant.theme = R.style.RedDarkThemeCustom;
                } else {
                    khoa.ms_51900706.final_project.Constant.theme = R.style.RedThemeCustom;
                }
                break;
            // Tím
            case 2:
                if(isDarkMode())
                    khoa.ms_51900706.final_project.Constant.theme = R.style.PurpleDarkThemeCustom;
                else
                    khoa.ms_51900706.final_project.Constant.theme = R.style.PurpleThemeCustom;
                break;
            // Vàng
            case 3:
                if(isDarkMode())
                    khoa.ms_51900706.final_project.Constant.theme = R.style.YellowDarkThemeCustom;
                else
                    khoa.ms_51900706.final_project.Constant.theme = R.style.YellowThemeCustom;
                break;
            // Xanh lá
            case 4:
                if(isDarkMode())
                    khoa.ms_51900706.final_project.Constant.theme = R.style.GreenDarkThemeCustom;
                else
                    khoa.ms_51900706.final_project.Constant.theme = R.style.GreenThemeCustom;
                break;
            // Xanh biển
            case 5:
                if(isDarkMode())
                    khoa.ms_51900706.final_project.Constant.theme = R.style.BlueDarkThemeCustom;
                else
                    khoa.ms_51900706.final_project.Constant.theme = R.style.BlueThemeCustom;
                break;
            // Mặc định
            default:
                if(isDarkMode())
                    khoa.ms_51900706.final_project.Constant.theme = R.style.DarkThemeCustom;
                else
                    khoa.ms_51900706.final_project.Constant.theme = R.style.LightThemeCustom;
                break;
        }
    }

    public boolean isDarkMode() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            return true;
        }
        return false;
    }

}
