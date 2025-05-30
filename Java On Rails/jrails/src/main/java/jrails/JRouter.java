package jrails;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;

public class JRouter {

    private Map<String, String> routes = new HashMap<>();

    public void addRoute(String verb, String path, Class clazz, String method) {
        String route = verb.toUpperCase() + ":" + path;
        routes.put(route, clazz.getName() + "#" + method);
    }

    // Returns "clazz#method" corresponding to verb+URN
    // Null if no such route
    public String getRoute(String verb, String path) {
        String route = verb.toUpperCase() + ":" + path;
        return routes.get(route);
    }

    // Call the appropriate controller method and
    // return the result
    public Html route(String verb, String path, Map<String, String> params) {
        String routeName = verb.toUpperCase() + ":" + path;
        String route = routes.get(routeName);

        if (route == null){
            throw new UnsupportedOperationException(route, null);
        }

        try{
            String parts[] = route.split("#");
            String className = parts[0];
            String methodName = parts[1];

            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            Method method = clazz.getMethod(methodName, Map.class);

            return (Html) method.invoke(instance, params);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        throw new UnsupportedOperationException();
    }
}
