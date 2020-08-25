package ru.live.kamaz_cs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SaveFields {

    public void save(Class<?>... ls) {
        Fields f = new Fields();
        final Class<?> cls = Fields.class;
        try {
            StringBuilder sb = new StringBuilder();
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                Class<?> fieldType = field.getType();
                System.out.print(field.getName() + " ");
                sb.append(fieldType + " ");
            }
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                if (cls.isAnnotationPresent(Save.class)); //если ставлю фигурные скобки то серреализация не происходит
                    method.invoke(f, sb.toString());
                
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Good");
    }

}
