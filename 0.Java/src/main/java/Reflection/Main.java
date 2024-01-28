package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> studentServiceClass = Class.forName("Reflection.StudentService");

        Field[] fields = studentServiceClass.getDeclaredFields();
        System.out.println("Printing all the fields in the class");
        for(Field field: fields) {
            System.out.println(field);
        }

        Field studentNamefield = studentServiceClass.getDeclaredField("studentName");
        System.out.println("fetching individual field name: " + studentNamefield);

        Constructor[] studentServiceConstructor = studentServiceClass.getDeclaredConstructors();
        System.out.println("Printing all the available constructors");
        for(Constructor constructor: studentServiceConstructor) {
            System.out.println(constructor);
        }

        Method[] studentServiceClassMethods = studentServiceClass.getDeclaredMethods();
        System.out.println("Getting all the methods available ");
        for(Method method: studentServiceClassMethods) {
            System.out.println(method);
        }

        // calling the methods
        Constructor<?> constructor = studentServiceClass.getDeclaredConstructor(String.class);
        StudentService service = (StudentService) constructor.newInstance("satya");

        System.out.println(service.getName());

        Method method = studentServiceClass.getDeclaredMethod("setName", String.class);
        method.setAccessible(true);

        method.invoke(service, "ganesh");

        System.out.println(service.getName());
    }
}
