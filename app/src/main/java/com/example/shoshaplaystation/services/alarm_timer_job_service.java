package com.example.shoshaplaystation.services;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.shoshaplaystation.R;
import com.example.shoshaplaystation.activities.MainActivity;
import com.example.shoshaplaystation.models.alarmsModel;
import com.example.shoshaplaystation.models.storeItemModel;

import java.util.ArrayList;

public class alarm_timer_job_service extends JobService {
    ArrayList<storeItemModel> list=new ArrayList<>();
    alarmsModel model=new alarmsModel("علي طاحون ","5000",list);
    TextView view;
    public static final String channelID = "newTimerID01";

    public alarm_timer_job_service() {
    }




    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        getAlarmTimerInNotifiaction(model);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }


    //////////////////////////////////////////////Notification
    //show timer in notification
    public Notification getAlarmTimerInNotifiaction(alarmsModel newTimer){
        Intent intent =new Intent(getApplicationContext().getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(getApplicationContext(), 0,
                intent,PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder newNotificationBuilder= new NotificationCompat.Builder(getApplicationContext(),channelID);
        newNotificationBuilder.setSmallIcon(R.drawable.logo)
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setContent(getCustomDesign(newTimer))
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager= (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel= null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(channelID,"Alarms",
                    NotificationManager.IMPORTANCE_DEFAULT);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(1,newNotificationBuilder.build());
        return  newNotificationBuilder.build();
    }

    //create custom view
    private RemoteViews getCustomDesign(alarmsModel newModel){
        @SuppressLint("RemoteViewLayout") RemoteViews rv=new RemoteViews(getApplicationContext().getPackageName(),R.layout.notification_layout);
        rv.setTextViewText(R.id.not_alarms_reservation_name,newModel.getReservationName());
        rv.setTextViewText(R.id.not_alarms_timer,newModel.getDuration());
        return rv;
    }
    ////////////////////////////////////////////////
    //timer method
    public void reverseTimer(int Seconds, TextView tv) {
        new CountDownTimer(Seconds * 1000 + 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);

                int hours = seconds / (60 * 60);
                int tempMint = (seconds - (hours * 60 * 60));
                int minutes = tempMint / 60;
                seconds = tempMint - (minutes * 60);

                tv.setText("TIME : " + String.format("%02d", hours)
                        + ":" + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                tv.setText("Completed");
            }
        }.start();

    }
}
