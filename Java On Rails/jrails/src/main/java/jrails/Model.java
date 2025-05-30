package jrails;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {

    private static Map<Class<?>, Map<Integer, Object>> database = new HashMap<>();
    private int id;
    private static int counter = 1;

    public Model(){
        this.id = 0;
    }

    public void save() {
        Class<?> clazz = this.getClass();
        Map<Integer, Object> table = database.computeIfAbsent(clazz, k -> new HashMap<>());
        if (id == 0){
            id = counter++;
        }

        table.put(id, this);
    }

    public int id() {
        return this.id;
    }

    public static <T> T find(Class<T> c, int id) {
        Map<Integer, Object> table = database.get(c);
        if (table == null){
            return null;
        }
        return c.cast(table.get(id));
    }

    public static <T> List<T> all(Class<T> c) {
        // Returns a List<element type>
        Map<Integer, Object> table = database.get(c);
        if (table == null){
            return new ArrayList<>();
        }
        List<T> all = new ArrayList<>();
        for (Object o : table.values()){
            all.add(c.cast(o));
        }

        return all;
    }

    public void destroy() {
        Class<?> clazz = getClass();
        Map<Integer, Object> table = database.get(clazz);
        if (id == 0){
            throw new IllegalStateException("Cannot destroy an unsaved model.");
        }
        if (table != null){
            table.remove(id);
        }
    }

    public static void reset() {
        database.clear();
        counter = 1;
    }
}
