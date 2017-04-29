package com.chemo.hdz.tinytaskdemo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.rest.responses.ItemResponse;
import com.chemo.hdz.tinytaskdemo.util.WordUtilities;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chemo on 4/28/17.
 */
public class WebServiceAdapter extends RecyclerView.Adapter<WebServiceAdapter.WebServiceHolder> {
    private Context mContext;
    private List<ItemResponse> itemsList;

    public class WebServiceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.item_icon)
        ImageView icon;

        @BindView(R.id.item_name)
        TextView item_name;

        @BindView(R.id.item_business_webservice)
        TextView item_business;

        @BindView(R.id.item_phone_webservice)
        TextView item_phone;

        @BindView(R.id.item_website_webservice)
        TextView item_website;

        @BindView(R.id.item_zipcode_webservice)
        TextView item_zipcode;

        public WebServiceHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
        }
    }

    public WebServiceAdapter(Context mContext, List<ItemResponse> itemsList) {
        this.mContext = mContext;
        this.itemsList = itemsList;
    }

    @Override
    public WebServiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_webservice, parent, false);
        return new WebServiceHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WebServiceHolder holder, int position) {
        ItemResponse item = itemsList.get(position);

        TextDrawable drawable = TextDrawable.builder().buildRound(WordUtilities.getInitialLetters(item.getFarm_name()), Color.RED);
        holder.icon.setImageDrawable(drawable);

        holder.item_name.setText(mContext.getString(R.string.item_item) + " " + item.getItem());
        holder.item_name.setTypeface(EasyFonts.robotoLight(mContext));

        holder.item_business.setText(mContext.getString(R.string.item_business) + " " + item.getBusiness());
        holder.item_business.setTypeface(EasyFonts.robotoLight(mContext));

        holder.item_phone.setText(mContext.getString(R.string.item_phone) + " " + item.getPhone1());
        holder.item_phone.setTypeface(EasyFonts.robotoLight(mContext));

        //Check if exit any website
        if( item.getWebsite() == null ) {
            holder.item_website.setText(mContext.getString(R.string.item_website) + " " + mContext.getString(R.string.no_phone));
            holder.item_website.setTypeface(EasyFonts.robotoLight(mContext));
        } else {
            holder.item_website.setText(mContext.getString(R.string.item_website) + " " + item.getWebsite());
            holder.item_website.setTypeface(EasyFonts.robotoLight(mContext));
        }

        holder.item_zipcode.setText(mContext.getString(R.string.item_zipcode) + " " + item.getZipcode());
        holder.item_zipcode.setTypeface(EasyFonts.robotoLight(mContext));
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}