package me.gogosing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by JinBum Jeong on 2020/03/02.
 */
public class Salt {

    @JsonProperty(value = "contents")
    private String contents;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
