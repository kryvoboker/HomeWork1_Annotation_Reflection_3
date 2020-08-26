package ru.live.kamaz_cs;

import java.io.*;

public class SaveFields implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String save(Class<?>... ls) {
        final Class<?> cls = Fields.class;
        Fields f = new Fields();
        StringBuffer sb = new StringBuffer();
        try {
            sb.append(f.getA() + " " + f.getB() + " " + f.getC() + " " + f.getD());
            sb.append(System.lineSeparator());
            if (cls.isAnnotationPresent(Save.class)) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fieldsOfClass.txt"))) {
                    oos.writeObject(sb);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }

    public Fields loadFile(File file) {
        Fields f = new Fields();
        StringBuffer sb = new StringBuffer();
        try (ObjectInputStream ois = new ObjectInputStream((new FileInputStream(file)))) {
            sb = (StringBuffer) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        String[] st = sb.toString().split(" ");
        for (int i = 0; i < st.length; i += 1) {
            int a = Integer.parseInt(st[0]);
            long b = Long.parseLong(st[1]);
            double c = Double.parseDouble(st[2]);
            String d = st[3] + " " + st[4];
            f.setA(a);
            f.setB(b);
            f.setC(c);
            f.setD(d);
        }
        return f;
    }

}
