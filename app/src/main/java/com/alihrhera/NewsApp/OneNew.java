package com.alihrhera.NewsApp;

public class OneNew {
    private String title,content,photoPath;
    private long time;
    private int type;

    public OneNew() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public long getTime() {
        return time;
    }

    public int getType() {
        return type;
    }


    public OneNew(String title, String content, int  type, String photoPath, long time) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.photoPath = photoPath;
        this.time = time;
    }

}
