package com.example.anew;
import java.util.List;

public class News {
    public Result result;
    public static class Result { public List<Article> data; }
    public static class Article { public String title, author_name; }
}