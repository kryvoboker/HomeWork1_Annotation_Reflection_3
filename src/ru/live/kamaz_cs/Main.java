package ru.live.kamaz_cs;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File file = new File("fieldsOfClass.txt");
        Fields f = new Fields();
        System.out.println(f);
        System.out.println(SaveFields.save(Fields.class));

        SaveFields sf = new SaveFields();
        Fields ff = null;
        ff = sf.loadFile(file);
        System.out.println(ff);

    }

}
