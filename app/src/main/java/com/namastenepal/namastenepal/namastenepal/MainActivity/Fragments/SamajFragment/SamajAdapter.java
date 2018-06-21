package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.namastenepal.namastenepal.namastenepal.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class SamajAdapter extends RecyclerView.Adapter<SamajAdapter.viewHolder> {
    private List<SamajDto> SamajDtoArrayList;
    private Context DcoContext;


    public SamajAdapter(List<SamajDto> samajDtoArrayList, Context dcoContext) {
        SamajDtoArrayList = samajDtoArrayList;
        DcoContext = dcoContext;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.samaj_card, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        holder.vSamaj_Name.setText(SamajDtoArrayList.get(position).getSlug());
        holder.vSamaj_subscriber_number.setText(SamajDtoArrayList.get(position).getSubscriber());
        holder.vSamaj_Description.setText(SamajDtoArrayList.get(position).getDescription());
        Glide.with(DcoContext).load(SamajDtoArrayList.get(position).getBackground()).into(holder.vCircleImageView);
    }

    @Override
    public int getItemCount() {
        return SamajDtoArrayList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private TextView vSamaj_Name;
        private TextView vSamaj_subscriber_number;
        private TextView vSamaj_Description;
        private CircleImageView vCircleImageView;


        public viewHolder(View itemView) {
            super(itemView);
            vCircleImageView = itemView.findViewById(R.id.samaj_icon);
            vSamaj_Name = itemView.findViewById(R.id.samaj_name);
            vSamaj_subscriber_number = itemView.findViewById(R.id.number_subscriber_samaj);
            vSamaj_Description = itemView.findViewById(R.id.description_samaj_type);
        }
    }
}
