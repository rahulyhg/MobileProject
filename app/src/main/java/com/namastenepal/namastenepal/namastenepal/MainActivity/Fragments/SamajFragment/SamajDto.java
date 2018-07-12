package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment;

public class SamajDto {
    private String name;
    private String slug;
    private String background;
    private String description;
    private String subscriber;
    private String timestamp;
    private String updated;
//    private boolean is_private;

    public SamajDto(String name, String slug, String background, String description, String subscriber, String timestamp, String updated) {
        this.name = name;
        this.slug = slug;
        this.background = background;
        this.description = description;
        this.subscriber = subscriber;
        this.timestamp = timestamp;
        this.updated = updated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBackground() {
        return "https://www.namastenepal.com/" + background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

}
