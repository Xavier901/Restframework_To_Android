package com.example.rest_test2;

import java.util.Date;

public class Post_data {
    private int id;
    private int author;
    private String title;
    private String body;
    private Date created_at;

    public int getId() {
        return id;
    }

    public int getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Date getCreated_at() {
        return created_at;
    }
}
