package com.main.lab2_2.model;

public class Dot {
    public double x;
    public double y;
    public double r;
    public String condition;
    
    public Dot() {
        this.x = 0.0;
        this.y = 0.0;
        this.r = 0.0;
        this.condition = "out";
    }
    public Dot(double x, double y, double r, String condition) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.condition = condition;
    }
}
