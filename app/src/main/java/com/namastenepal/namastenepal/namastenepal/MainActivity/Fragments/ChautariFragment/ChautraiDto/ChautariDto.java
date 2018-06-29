package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto;

public class ChautariDto {
    /*
     {
        "id": 74,
        "user": {
            "id": 4,
            "username": "ashok1",
            "email": "kingele16@gmail.com",
            "first_name": "ashok",
            "last_name": "gurung"
        },
        "title": "MERO DURLUNG GAUN.NEPALI HIT SONG 2015 .GURUNG HIT SONG FULL HD",
        "slug": "mero-durlung-gaunnepali-hit-song-2015-gurung-hit-song-full-hd-20180623-081803",
        "body": "",
        "media": "/media/MERO_DURLUNG_GAUN.NEPALI_HIT_SONG_2015_.GURUNG_HIT_SONG_FULL_HD_-_YouTube360p.mp4",
        "likes": [],
        "pinned": false,
        "health": [],
        "is_hidden": false,
        "timestamp": "2018-06-23T02:33:03.059952Z"
    }
    * */
    private int id;
    private String title;
    private String username;

    public ChautariDto(int id, String title, String username) {
        this.id = id;
        this.title = title;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
