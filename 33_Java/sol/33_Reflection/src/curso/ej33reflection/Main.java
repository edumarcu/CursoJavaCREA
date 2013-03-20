package curso.ej33reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {
        Class clazz = Main.class;
        System.out.println("Nombre: " + clazz.getName());
        System.out.println("Nombre Canónico: " + clazz.getCanonicalName());
        System.out.println("Nombre Simple: " + clazz.getSimpleName());

        Class taskc = Task.class;
        System.out.println();
        System.out.println("Task:");
        System.out.println("Methods:");
        for (Method method : taskc.getMethods()) {
            System.out.println("* " + method.getName());
        }

        System.out.println();
        System.out.println("Field:");
        for (Field field : taskc.getDeclaredFields()) {
            boolean isStatic = Modifier.isStatic(field.getModifiers());
            System.out.println("* " + field.getName() + " static: " + isStatic);
        }

        System.out.println();
        System.out.println("Creating a task:");
        taskc = Class.forName("curso.ej33reflection.Task");
        Task t = (Task) taskc.newInstance();
        //
        Constructor c = taskc.getConstructor(String.class);
        t = (Task) c.newInstance("Crear una tarea para recordarme que tengo que crear una tarea.");
        System.out.println("Task t = " + t);

        //
        System.out.println();
        System.out.println("Accessing a private field:");
        Field f = taskc.getDeclaredField("name");
        f.setAccessible(true);
        f.set(t, "Acceder a un campo");
        System.out.println("Task t = " + t);
    }
}
