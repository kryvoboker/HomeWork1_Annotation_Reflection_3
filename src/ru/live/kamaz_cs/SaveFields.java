package ru.live.kamaz_cs;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

public class SaveFields implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String save(Class<?>... ls) {
        Fields f = new Fields();
        final Class<?> cls = Fields.class;
        try {
            StringBuilder sb = new StringBuilder();
            if (cls.isAnnotationPresent(Save.class)) {
                Field[] fields = cls.getDeclaredFields();
                for (Field field : fields) {
                    sb.append(field).append(System.lineSeparator());
                }
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fieldsOfClass.txt"))) {
                    oos.writeObject(sb.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }

}
