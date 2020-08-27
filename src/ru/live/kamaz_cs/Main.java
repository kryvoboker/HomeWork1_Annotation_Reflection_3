package ru.live.kamaz_cs;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        Fields f = new Fields();
        f.setA(7);
        f.setB("Hello world");
        f.setC(25);

        String res = SaveFields.Serializable(f);
        System.out.println("Serializable: " + res);

        f = SaveFields.Deserializable(res, Fields.class);
        System.out.println("Deserializable: " + f.getA() + ", " + f.getB() + ", " + f.getC());

    }

}
