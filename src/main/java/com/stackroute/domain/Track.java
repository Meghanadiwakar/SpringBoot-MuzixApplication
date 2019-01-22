package com.stackroute.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {
    @Id
    private int trackId;
    private String trackName;
    private String comment;

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", trackname='" + trackName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Track(int trackId, String trackName, String comment) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.comment = comment;
    }

    public Track() {
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackname() {
        return trackName;
    }

    public void setTrackname(String trackName) {
        this.trackName = trackName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
