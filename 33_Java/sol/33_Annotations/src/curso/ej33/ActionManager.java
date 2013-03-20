package curso.ej33;

import java.lang.reflect.Method;
import java.util.HashMap;

public class ActionManager {

    private HashMap<String, Class> classes = new HashMap<String, Class>();
    private HashMap<String, Method> methods = new HashMap<String, Method>();

    public Class classForAction(String action) {
        return classes.get(action);
    }

    public Method methodForAction(String action) {
        return methods.get(action);
    }

    public void executeAction(String action) {
        Class clazz = classForAction(action);
        Method method = methodForAction(action);

        try {
            Object o = clazz.newInstance();
            method.invoke(o);
        } catch (Exception e) {
            System.out.println("ERROR ERROR ERROR!! <corriendo en círculos con los brazos en alto>");
        }
    }

    public void scanClass(String className) throws Exception {
        Class clazz = Class.forName(className);

        for (Method method : clazz.getMethods()) {
            Action action = method.getAnnotation(Action.class);
            if (action != null) {
                String actionName = action.value();
                classes.put(actionName, clazz);
                methods.put(actionName, method);
            }
        }
    }

}
