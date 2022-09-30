package com.example.shoshaplaystation.adapters;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoshaplaystation.R;
import com.example.shoshaplaystation.activities.MainActivity;
import com.example.shoshaplaystation.interfaces.rcv_alarms_click_listener;
import com.example.shoshaplaystation.models.alarmsModel;
import com.example.shoshaplaystation.services.alarm_timer_job_service;
import com.example.shoshaplaystation.services.alarm_timer_service;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

public class rcv_alarms_adapter extends RecyclerView.Adapter<rcv_alarms_adapter.alarm> {
    ArrayList<alarmsModel> alarmList=new ArrayList<>();
    Context context;
    rcv_alarms_click_listener listener;

    public rcv_alarms_adapter(ArrayList<alarmsModel> alarmList, Context context, rcv_alarms_click_listener listener) {
        this.alarmList = alarmList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public alarm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_alarms_item_layout,null,false);
        return new alarm(view);
    }

    @Override
    public void onBindViewHolder(@NonNull alarm holder, int position) {
        alarmsModel newModel=alarmList.get(position);
        holder.txtTimeer.setText(newModel.getDuration());
        holder.reservationName.setText(newModel.getReservationName());
        ComponentName componentName=new ComponentName(context.getApplicationContext(), new alarm_timer_job_service().getClass());
        JobInfo info;
        if (Build.VERSION.SDK_INT<=Build.VERSION_CODES.N){
                info=new JobInfo.Builder(1,componentName)
                        .setPeriodic(1000)
                        .build();
        }else {
            info=new JobInfo.Builder(1,componentName)
                    .setMinimumLatency(1000)
                    .build();
        }
        JobScheduler jobScheduler= (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(info);
    }

    @Override
    public int getItemCount() {
        return alarmList.size();
    }

    public class alarm extends RecyclerView.ViewHolder{
        TextView txtTimeer,reservationName;
        FoldingCell foldingCell;
        public alarm(@NonNull View itemView) {
            super(itemView);
            txtTimeer=itemView.findViewById(R.id.rcv_alarms_timer);
            reservationName=itemView.findViewById(R.id.rcv_alarms_reservation_name);
            foldingCell=itemView.findViewById(R.id.rcv_alarms_folding_cell);
            foldingCell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    foldingCell.toggle(false);
                }
            });

            }

        }



}
