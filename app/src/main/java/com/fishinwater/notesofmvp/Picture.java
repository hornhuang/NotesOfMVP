package com.fishinwater.notesofmvp;

public class Picture {

    public String _id;

    public String createdAt;

    public String desc;

    public String publishedAt;

    public String source;

    public String type;

    public String url;

    public String used;

    public String who;

    public Picture() {
    }

    public Picture(String _id, String createdAt, String desc, String publishedAt, String source, String type, String url, String used, String who) {
        this._id = _id;
        this.createdAt = createdAt;
        this.desc = desc;
        this.publishedAt = publishedAt;
        this.source = source;
        this.type = type;
        this.url = url;
        this.used = used;
        this.who = who;
    }
}
