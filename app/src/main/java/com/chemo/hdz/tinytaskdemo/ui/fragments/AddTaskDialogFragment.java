package com.chemo.hdz.tinytaskdemo.ui.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.bus.BusProvider;
import com.chemo.hdz.tinytaskdemo.bus.events.AddTaskEvent;
import com.chemo.hdz.tinytaskdemo.entities.Hability;
import com.chemo.hdz.tinytaskdemo.logic.TaskManager;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chemo1990 on 28/04/17.
 */

public class AddTaskDialogFragment extends BaseSubscriberFragment {
    @BindView(R.id.add_task_title)
    TextView title;

    @BindView(R.id.add_task_description)
    EditText description;

    @BindView(R.id.add_task_duration)
    EditText duration;

    @BindView(R.id.spinnerHabilities)
    Spinner spinnerHabilities;

    private List<Hability> itemsHabilities;
    private ArrayAdapter<Hability> adapterHabilities;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.dialog_add_task, null, false);
        ButterKnife.bind(this, rootView);

        title.setTypeface(EasyFonts.droidSerifBold(getActivity()));

        itemsHabilities = getHabilities();

        adapterHabilities = new ArrayAdapter<Hability>(getActivity(), R.layout.spinner_item, itemsHabilities);
        spinnerHabilities.setAdapter(adapterHabilities);
        adapterHabilities.notifyDataSetChanged();

        spinnerHabilities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(rootView)
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if( TextUtils.isEmpty( description.getText().toString()) || TextUtils.isEmpty( duration.getText().toString())) {
                            Toast.makeText(getActivity(), getString(R.string.empty_data), Toast.LENGTH_LONG).show();
                        } else {
                            int time = Integer.parseInt( duration.getText().toString().trim());
                            int id = itemsHabilities.get(spinnerHabilities.getSelectedItemPosition()).idHability;
                            String desc = description.getText().toString();

                            if( time > 1440 ) {
                                Toast.makeText(getActivity(), getString(R.string.error_max_time), Toast.LENGTH_LONG).show();
                            } else if( time <= 0 ) {
                                Toast.makeText(getActivity(), getString(R.string.error_no_time), Toast.LENGTH_LONG).show();
                            } else if( id == 1 ) {
                                Toast.makeText(getActivity(), getString(R.string.error_admin), Toast.LENGTH_LONG).show();
                            } else {
                                new TaskManager(id, desc, time).assignTask();
                            }
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDialog().cancel();
                    }
                }).create();
    }

    private List<Hability> getHabilities() {
        return new Select()
                .from(Hability.class)
                .orderBy("Description ASC")
                .execute();
    }
}