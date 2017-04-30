package com.chemo.hdz.tinytaskdemo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.amulyakhare.textdrawable.TextDrawable;
import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.bus.BusProvider;
import com.chemo.hdz.tinytaskdemo.bus.events.RemoveTaskEvent;
import com.chemo.hdz.tinytaskdemo.entities.Hability;
import com.chemo.hdz.tinytaskdemo.entities.Task;
import com.chemo.hdz.tinytaskdemo.entities.User;
import com.chemo.hdz.tinytaskdemo.util.WordUtilities;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by chemo on 4/28/17.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.WebServiceHolder> {
    private Context mContext;
    private List<Task> itemsList;

    public class WebServiceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.icon_task)
        ImageView icon;

        @BindView(R.id.item_assign_user_task)
        TextView item_assign_user_task;

        @BindView(R.id.item_type_hability_task)
        TextView item_type_hability_task;

        @BindView(R.id.item_description_task)
        TextView item_description_task;

        @BindView(R.id.item_duration_task)
        TextView item_duration_task;

        @BindView(R.id.item_status_task)
        TextView item_status_task;

        public WebServiceHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final int position = getLayoutPosition();
            final Task taskSelected = itemsList.get(position);

            //Only if the current task its finish
            if( taskSelected.currentStatus == 0 ) {
                new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText(mContext.getString(R.string.message_task))
                        .setContentText(mContext.getString(R.string.message_task_2))
                        .setConfirmText(mContext.getString(R.string.message_task_3))
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.setTitleText(mContext.getString(R.string.message_task_4))
                                        .setContentText(mContext.getString(R.string.message_task_5))
                                        .setConfirmText(mContext.getString(R.string.message_task_6))
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);

                                //Remove item
                                new Delete().from(Task.class).where("_id = " + taskSelected.getId()).execute();
                                BusProvider.getInstance().post(new RemoveTaskEvent(position));
                            }
                        }).show();
            }
        }
    }

    public TaskAdapter(Context mContext, List<Task> itemsList) {
        this.mContext = mContext;
        this.itemsList = itemsList;
    }

    @Override
    public WebServiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new WebServiceHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WebServiceHolder holder, int position) {
        Task item = itemsList.get(position);

        User userInfo = new Select().from(User.class).where("id_user = ?", item.idUser).executeSingle();
        Hability habilityInfo = new Select().from(Hability.class).where("id_hability = ?", item.idHability).executeSingle();

        TextDrawable drawable = TextDrawable.builder().buildRound(WordUtilities.getInitialLetters(userInfo.name), Color.RED);
        holder.icon.setImageDrawable(drawable);

        holder.item_assign_user_task.setText(mContext.getString(R.string.assign_user) + " " + userInfo.name);
        holder.item_assign_user_task.setTypeface(EasyFonts.robotoLight(mContext));

        holder.item_type_hability_task.setText(mContext.getString(R.string.type_hability) + " " + habilityInfo.description);
        holder.item_type_hability_task.setTypeface(EasyFonts.robotoLight(mContext));

        holder.item_description_task.setText(mContext.getString(R.string.description) + " " + item.description);
        holder.item_description_task.setTypeface(EasyFonts.robotoLight(mContext));

        holder.item_duration_task.setText(mContext.getString(R.string.time_task) + " " + item.time + " " + mContext.getString(R.string.minutes));
        holder.item_duration_task.setTypeface(EasyFonts.robotoLight(mContext));

        holder.item_status_task.setTypeface(EasyFonts.robotoBlack(mContext));

        //Check if the current task is in process
        if( item.currentStatus == 1 ) {
            holder.item_status_task.setText(mContext.getString(R.string.current_status) + " " + mContext.getString(R.string.status_in_process));
            holder.item_status_task.setTextColor(Color.RED);
        } else {
            holder.item_status_task.setText(mContext.getString(R.string.current_status) + " " + mContext.getString(R.string.statu_finish));
            holder.item_status_task.setTextColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}