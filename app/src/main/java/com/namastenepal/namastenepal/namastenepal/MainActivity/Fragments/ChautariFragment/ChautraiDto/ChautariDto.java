package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto;

import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.MediaChecker.Media;

import java.io.File;
import java.util.ArrayList;

public class ChautariDto {

    private int id;
    private user user;
    private String title;
    private String slug;
    private String body;
    private String media;
    private boolean is_hidden;
    private String timestamp;
    //   private String likes;
    private boolean pinned;
    private name name;
    private int likes[];

    public int[] getLikes() {
        return likes;
    }

    public void setLikes(int[] likes) {
        this.likes = likes;
    }

    public ChautariDto(int id, ChautariDto.user user, String title, String slug, String body, String media, boolean is_hidden, String timestamp, boolean pinned, com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.name name, int[] likes) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.slug = slug;
        this.body = body;
        this.media = media;
        this.is_hidden = is_hidden;
        this.timestamp = timestamp;
        this.pinned = pinned;
        this.name = name;
        this.likes = likes;
    }

// private String health;


    public com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.name getName() {
        return name;
    }

    public void setName(com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.name name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChautariDto.user getUser() {
        return user;
    }

    public void setUser(ChautariDto.user user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return "https://www.namastenepal.com/" + slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMedia() {
        return "https://www.namastenepal.com" + media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public boolean isIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public String getTimestamp() {
        String PostTimestamp = timestamp.split("T")[0];
        return PostTimestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }


    public class user {
        private int id;
        private String username;
        private String email;
        private String first_name;
        private String last_name;

        public user(int id, String username, String email, String first_name, String last_name) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.first_name = first_name;
            this.last_name = last_name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }
    }

}
