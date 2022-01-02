package khoa.ms_51900706.final_project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        khoa.ms_51900706.final_project.NotificationHelper notificationHelper = new khoa.ms_51900706.final_project.NotificationHelper(context);
        notificationHelper.createNotification();

    }
}
