package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void printClassInfo(Class<?> cls) {

        System.out.println("Class: " + cls.getName());

        System.out.println("\nFIELDS:");

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("\nMETHODS:");

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("\nCONSTRUCTORS:");

        Constructor<?>[] constructors = cls.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
    public static void printObjectState(Object obj) throws IllegalAccessException {

        Class<?> cls = obj.getClass();

        Field[] fields = cls.getDeclaredFields();

        System.out.println("\nOBJECT STATE:");

        for (Field field : fields) {

            field.setAccessible(true);

            System.out.println(
                    field.getName() + " = " + field.get(obj)
            );
        }
    }
    public static Method[] getPublicNoArgMethods(Class<?> cls) {

        Method[] methods = cls.getDeclaredMethods();

        System.out.println("\nPUBLIC METHODS WITHOUT PARAMETERS:");

        int count = 0;

        for (Method method : methods) {

            if (java.lang.reflect.Modifier.isPublic(method.getModifiers())
                    && method.getParameterCount() == 0) {

                System.out.println(count + ": " + method.getName());

                count++;
            }
        }

        return methods;
    }
    public static Object callMethod(
            Object obj,
            String methodName,
            Object... params)

            throws Exception {

        Class<?> cls = obj.getClass();

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {

            if (method.getName().equals(methodName)
                    && method.getParameterCount() == params.length) {

                return method.invoke(obj, params);
            }
        }

        throw new exceptions.FunctionNotFoundException(
                "Method not found: " + methodName
        );
    }
}