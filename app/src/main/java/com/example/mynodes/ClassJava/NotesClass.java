package com.example.mynodes.ClassJava;

public class NotesClass
{
    private String title;
    private String body;

    public void setBody(String body)
    {
        this.body = body;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return title + " " + body;
    }
}
