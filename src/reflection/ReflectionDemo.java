package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.awt.Dimension");
            System.out.println("Constructors:");
            Constructor[] constructors = clazz.getConstructors();
            Arrays.stream(constructors).forEach(c -> System.out.println(" " + c));
            System.out.println("Fields:");
            Field[] fields = clazz.getFields();
            Arrays.stream(fields).forEach(f -> System.out.println(" " + f));
            System.out.println("Methods:");
            Method[] methods = clazz.getMethods();
            Arrays.stream(methods).forEach(m -> System.out.println(" " + m));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ReflectionDemo2{
    public static void main(String[] args) {
        A a = new A();
        Class<?> clazz = a.getClass();
        System.out.println("public methods:");
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods).filter(method -> Modifier.isPublic(method.getModifiers())).
                forEach(method -> System.out.println(method.getName()));

    }
    static class A{
        public void a1(){}
        public void a2(){}
        protected void a3(){}
        private void a4(){}
    }
}