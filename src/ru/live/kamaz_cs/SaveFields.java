package ru.live.kamaz_cs;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;

public class SaveFields {

    public static String Serializable(Object o) throws IllegalAccessException {
        Class<?> cls = o.getClass();
        StringBuilder sb = new StringBuilder();

        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(Save.class))
                continue;
            if (Modifier.isPrivate(field.getModifiers()))
                field.setAccessible(true);

            sb.append(field.getName() + "=");

            if (field.getType() == int.class) {
                sb.append(field.getInt(o));
            } else if (field.getType() == String.class) {
                sb.append((String) field.get(o));
            } else if (field.getType() == long.class) {
                sb.append(field.getLong(o));
            }
            sb.append(";");
        }
        return sb.toString();
    }

    public static <T> T Deserializable(String s, Class<T> cls) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        T res = (T) cls.newInstance();
        String[] pairs = s.split(";");

        for (String p : pairs) {
            String[] nv = p.split("=");
            if (nv.length != 2)
                throw new InvalidParameterException(s);

            String name = nv[0];
            String value = nv[1];
            Field f = cls.getDeclaredField(name);
            if (Modifier.isPrivate(f.getModifiers()))
                f.setAccessible(true);

            if (f.isAnnotationPresent(Save.class)) {
                if (f.getType() == int.class) {
                    f.setInt(res, Integer.parseInt(value));
                } else if (f.getType() == String.class) {
                    f.set(res, value);
                } else if (f.getType() == long.class) {
                    f.setLong(res, Long.parseLong(value));
                }
            }
        }
        return res;
    }

}
