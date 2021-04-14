package com.example.christmasshop;

import androidx.annotation.NonNull;

public class Garlends {
    String title;
    String info;
    int imageResourseId;

    public Garlends(String title, String info, int imageResourseId) {
        this.title = title;
        this.info = info;
        this.imageResourseId = imageResourseId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResourseId() {
        return imageResourseId;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
