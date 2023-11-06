package com.main.lab2_2.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ElementForTable {
    protected String x;
    protected String y;
    protected String r;
    protected boolean condition;
    protected long timeOfWork;
    protected Date time;
    public ElementForTable() {
        x = "0";
        y = "0";
        r = "0";
        condition = false;
        timeOfWork = System.nanoTime();
        time = new Date();
    }
    public ElementForTable(String x, String y, String r) {
        this.x = x;
        this.y = y;
        this.r = r;
        condition = false;
        timeOfWork = System.nanoTime();
        time = new Date();
    }
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return "<tr>\n" +
                "            <td width=\"150\">" + Double.parseDouble(x) + "</td>\n" +
                "            <td width=\"150\">" + y + "</td>\n" +
                "            <td width=\"150\">" + r + "</td>\n" +
                "            <td width=\"150\">" + condition + "</td>\n" +
                "            <td width=\"150\">" + timeOfWork + "</td>\n" +
                "            <td width=\"150\">" + format.format(time) + "</td>\n" +
                "        </tr>";
    }
    public Dot toDot() {
        double x = Double.parseDouble(this.x);
        double y = Double.parseDouble(this.y);
        double r = Double.parseDouble(this.r);
        String condition = "false";
        if (this.condition) {
            condition = "true";
        }
        Dot dot = new Dot(x, y, r, condition);
        return dot;
    }
    public void setTimeOfWork(long endTime) {
        timeOfWork = endTime - timeOfWork;
    }
}
