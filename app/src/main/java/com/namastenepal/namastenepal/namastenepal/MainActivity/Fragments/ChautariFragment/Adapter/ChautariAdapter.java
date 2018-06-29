package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.ChautariDto;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajAdapter;
import com.namastenepal.namastenepal.namastenepal.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChautariAdapter extends RecyclerView.Adapter<ChautariAdapter.ViewHolder> {
    List<ChautariDto> chautariDtoList = new ArrayList<>();
    private Context DcoContext;

    public ChautariAdapter(List<ChautariDto> chautariDtoList, Context dcoContext) {
        this.chautariDtoList = chautariDtoList;
        DcoContext = dcoContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chautari_card, parent, false);
        return new ChautariAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.vProfile_Name.setText(chautariDtoList.get(position).getUsername());
        holder.vStatus.setText(chautariDtoList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return chautariDtoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView vProfile_Image;
        private TextView vProfile_Name;
        private ImageView vProfile_Shared_Image;
        private TextView vStatus;
        private TextView vType;
        private TextView vProfile_Date;

        public ViewHolder(View itemView) {
            super(itemView);
            vProfile_Image = itemView.findViewById(R.id.profile_chautari_image);
            vProfile_Name = itemView.findViewById(R.id.profile_chautari_image);
            vStatus = itemView.findViewById(R.id.status);
        }
    }
}
