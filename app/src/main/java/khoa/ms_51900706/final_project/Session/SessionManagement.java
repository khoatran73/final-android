package khoa.ms_51900706.final_project.Session;

import android.content.Context;
import android.content.SharedPreferences;

import khoa.ms_51900706.final_project.User.User;

public class SessionManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "user_uid";

    public SessionManagement(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public void saveSession(User user) {
        editor.putString(SESSION_KEY, user.getUid()).commit();
    }

    public String getSession() {
        return sharedPreferences.getString(SESSION_KEY, "");
    }

    public void removeSession() {
        editor.putString(SESSION_KEY, "").commit();
    }

}
