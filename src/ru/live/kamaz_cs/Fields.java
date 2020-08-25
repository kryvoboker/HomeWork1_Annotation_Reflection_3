package ru.live.kamaz_cs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Fields implements Serializable {

    private int a = 1;
    private long b = 2;
    private double c = 3;
    private String d = "Hello world";

    public Fields() {
    }

    @Save
    public void save(String text) {
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fieldsOfClass.txt"))) {
                oos.writeObject(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
