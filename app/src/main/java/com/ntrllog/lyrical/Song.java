package com.ntrllog.lyrical;

public class Song {

    private String name;
    private int resource;

    public Song(String n, int r) {
        this.name = n;
        this.resource = r;
    }

    public String getName() {
        return this.name;
    }

    public int getResource() {
        return this.resource;
    }
}
