package com.mobilecloud.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * A simple object to represent a video and its URL for viewing.
 * It uses Bean Validation for field validation.
 * 
 * @author Riccardo Sirigu
 */
public class Video {
    
    @Size(min = 1, max = 100)
    private String name;
    @Size(min = 10, max = 2000)
    private String url;
    @Min(1)
    private long duration;

    public Video() {
    }
    
    public Video(String name, String url, long duration) {
        this.name = name;
        this.url = url;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }   

    @Override
    public String toString() {
        return "Video{" + "name=" + name + ", url=" + url + ", duration=" + duration + '}';
    }
        
}
