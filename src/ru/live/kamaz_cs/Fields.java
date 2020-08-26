package ru.live.kamaz_cs;

import java.io.*;

@Save
public class Fields implements Serializable {
    private int a = 1;
    private long b = 2;
    private double c = 3;
    private String d = "Hello world";

    public Fields(int a, long b, double c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Fields() {
    }

    public int getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(long b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d='" + d + '\'' +
                '}';
    }
}



