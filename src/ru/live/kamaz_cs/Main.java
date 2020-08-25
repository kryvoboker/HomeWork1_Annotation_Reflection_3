package ru.live.kamaz_cs;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
        SaveFields sf = new SaveFields();
        sf.save(Fields.class);
    }

}
