package com.company;

public class AudioTrack implements Comparable<AudioTrack> {

    private int duration;
    private String title;
    private String author;


    public AudioTrack(int duration, String title, String author) {
        this.duration = duration;
        this.title = title;
        this.author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(AudioTrack o) {
        return duration - o.duration;
    }

    @Override
    public String toString() {
        return "AudioTrack{" +
                "duration=" + duration +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

//сравнение сначала по продолжительности, а если совпадает, то по имени
//        int d = duration - o.duration;
//        if (d != 0) {
//            return d;
//        } else {
//            return title.compareTo(o.title);
//        }

//        if (duration > o.duration) {
//            return 1;
//        }
//        if (duration < o.duration) {
//            return -1;
//        }
//        if (duration == o.duration) {
//            return 0;
//        }
