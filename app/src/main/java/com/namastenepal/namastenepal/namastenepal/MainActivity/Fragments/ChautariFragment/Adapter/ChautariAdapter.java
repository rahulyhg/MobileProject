package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.ChautariDto;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.ChautariDtoResponse;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.MediaChecker.Media;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajAdapter;
import com.namastenepal.namastenepal.namastenepal.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChautariAdapter extends RecyclerView.Adapter<ChautariAdapter.ViewHolder> {
    List<ChautariDto> chautariDtoList;
    private Context DcoContext;

    public ChautariAdapter(List<ChautariDto> chautariDtoList, Context dcoContext) {
        this.chautariDtoList = chautariDtoList;
        DcoContext = dcoContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chautari_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.vProfile_Name.setText(chautariDtoList.get(position).getUser().getFirst_name());
        holder.vStatus.setText(chautariDtoList.get(position).getTitle());
        holder.vProfile_Date.setText(chautariDtoList.get(position).getTimestamp());
        holder.vProfile_Samaj_Name.setText(chautariDtoList.get(position).getName().getName());
        Media media = new Media();
        String mediaString;
        if (chautariDtoList.get(position).getMedia() != null) {
            mediaString = chautariDtoList.get(position).getMedia().toString();

            if (media.checkMedia(mediaString) == 1) {
                holder.vProfile_share_Video.setVideoPath(chautariDtoList.get(position).getMedia());
                Toast.makeText(DcoContext, "" + chautariDtoList.get(position).getMedia(), Toast.LENGTH_LONG).show();
//        holder.vProfile_share_Video.setVideoPath("https://www.namastenepal.com/media/TensorFlow_Tutorial_-_Deep_Learning.mp4");
            } else if (media.checkMedia(mediaString) == 0) {
                Glide.with(DcoContext).
                        load(chautariDtoList.get(position).getMedia())
                        .into(holder.vProfile_Shared_Image);
            }
        }
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
        private VideoView vProfile_share_Video;
        private TextView vProfile_Samaj_Name;
        private MediaController DcoMediaController;

        public ViewHolder(View itemView) {
            super(itemView);
            //       vProfile_Image = itemView.findViewById(R.id.profile_chautari_image);
            vProfile_Name = itemView.findViewById(R.id.profile_timeline_name);
            vProfile_Date = itemView.findViewById(R.id.profile_timeline_Date);
            vType = itemView.findViewById(R.id.type_textView);
            vProfile_share_Video = itemView.findViewById(R.id.profile_share_video);
            vStatus = itemView.findViewById(R.id.status);
            vProfile_Samaj_Name = itemView.findViewById(R.id.profile_timline_samaj_name);
            vProfile_Shared_Image = itemView.findViewById(R.id.profile_share_image_chautari);
            vProfile_share_Video.start();
            DcoMediaController=new MediaController(DcoContext);
            DcoMediaController.setMediaPlayer(vProfile_share_Video);
        }
    }
}
