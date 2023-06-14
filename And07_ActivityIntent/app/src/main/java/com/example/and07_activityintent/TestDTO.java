package com.example.and07_activityintent;

import java.io.Serializable;

public class TestDTO implements Serializable {
    private String name;
    private int max;

    public TestDTO(String name, int max) {
        this.name = name;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
