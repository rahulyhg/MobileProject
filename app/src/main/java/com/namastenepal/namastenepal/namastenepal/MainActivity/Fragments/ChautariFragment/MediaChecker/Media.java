package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.MediaChecker;

import android.widget.Toast;

import java.io.File;

public class Media {
    public int mediaType;

    public int checkMedia(String media) {
        File file = new File(media);
        switch (getFileExtension(file)) {
            case "jpg":
                mediaType = 0;
                break;
            case "jpeg":
                mediaType = 0;
                break;
            case "gif":
                mediaType = 0;
                break;
            case "PNG":
                mediaType = 0;
                break;
            case "mp4":
                mediaType = 1;
                break;
            case "mov":
                mediaType = 1;
                break;
            case "mpeg":
                mediaType = 1;
                break;
        }
        return mediaType;
    }

    public String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
}
