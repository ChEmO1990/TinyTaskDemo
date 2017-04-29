package com.chemo.hdz.tinytaskdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.entities.Hability;
import com.chemo.hdz.tinytaskdemo.entities.Task;
import com.chemo.hdz.tinytaskdemo.entities.User;
import com.chemo.hdz.tinytaskdemo.util.Constants;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chemo on 4/28/17.
 */
public class AssignTaskAdapter extends RecyclerView.Adapter<AssignTaskAdapter.WebServiceHolder> {
    private Context mContext;
    private List<Task> itemsList;

    public class WebServiceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.item_description_task)
        TextView item_description_task;

        @BindView(R.id.item_duration_task)
        TextView item_duration_task;

        @BindView(R.id.item_status_task)
        TextView item_status_task;

        public WebServiceHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
        }
    }

    public AssignTaskAdapter(Context mContext, List<Task> itemsList) {
        this.mContext = mContext;
        this.itemsList = itemsList;
    }

    @Override
    public WebServiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_assign_task, parent, false);
        return new WebServiceHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WebServiceHolder holder, int position) {
        Task item = itemsList.get(position);

        holder.item_description_task.setText(mContext.getString(R.string.description) + " " + item.description);
        holder.item_description_task.setTypeface(EasyFonts.robotoLight(mContext));

        holder.item_duration_task.setText(mContext.getString(R.string.time_task) + " " + item.time);
        holder.item_duration_task.setTypeface(EasyFonts.robotoLight(mContext));

        holder.item_status_task.setTypeface(EasyFonts.robotoLight(mContext));

        //Check if the current task is in process
        if( item.status.equals(Constants.STATUS_IN_PROCESS ) ) {
            holder.item_status_task.setText(mContext.getString(R.string.current_status) + " " + mContext.getString(R.string.status_in_process));
        } else {
            holder.item_status_task.setText(mContext.getString(R.string.current_status) + " " + mContext.getString(R.string.statu_finish));
        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}