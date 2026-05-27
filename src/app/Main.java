package app;

import reflection.ReflectionUtils;
import testclasses.TestClass;

import java.lang.reflect.Constructor;
import java.util.Scanner;
import arrays.ArrayUtils;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        Class<?> cls = TestClass.class;

        /*ReflectionUtils.printClassInfo(cls);

        Constructor<?>[] constructors =
                cls.getDeclaredConstructors();

        System.out.println("\nChoose constructor:");

        for (int i = 0; i < constructors.length; i++) {
            System.out.println(i + ": " + constructors[i]);
        }

        int choice = scanner.nextInt();

        Object obj;

        if (constructors[choice].getParameterCount() == 0) {

            obj = constructors[choice].newInstance();

        } else {

            System.out.print("Input x: ");
            int x = scanner.nextInt();

            System.out.print("Input y: ");
            double y = scanner.nextDouble();

            obj = constructors[choice].newInstance(x, y);
        }

        System.out.println("\nOBJECT CREATED:");
        System.out.println(obj);

        ReflectionUtils.printObjectState(obj);

        System.out.println("\nREAL TYPE:");
        System.out.println(obj.getClass().getName());

        java.lang.reflect.Method[] methods =
                ReflectionUtils.getPublicNoArgMethods(cls);

        System.out.print("\nChoose method: ");

        int methodChoice = scanner.nextInt();

        java.lang.reflect.Method selectedMethod =
                methods[methodChoice];

        Object result = selectedMethod.invoke(obj);

        System.out.println("\nMETHOD RESULT:");
        System.out.println(result);

        System.out.println("\nTASK 3:");

        Object result2 = ReflectionUtils.callMethod(
                obj,
                "distance"
        );

        System.out.println("Result: " + result2);
        System.out.println("\nTASK 4:");

        int[] arr = (int[]) ArrayUtils.createArray(
                int.class,
                5
        );

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println(
                "Original array: "
                        + ArrayUtils.arrayToString(arr)
        );

        arr = (int[]) ArrayUtils.resizeArray(arr, 8);

        System.out.println(
                "Resized array: "
                        + ArrayUtils.arrayToString(arr)
        );*/
        System.out.println("\nTASK 5:");

        proxy.Calculator calculator =
                new proxy.CalculatorImpl();

        proxy.Calculator proxyCalculator =
                (proxy.Calculator)
                        java.lang.reflect.Proxy.newProxyInstance(
                                proxy.Calculator.class.getClassLoader(),
                                new Class[]{
                                        proxy.Calculator.class
                                },
                                new proxy.ProxyHandler(calculator)
                        );

        double sum =
                proxyCalculator.add(5, 3);

        double product =
                proxyCalculator.multiply(4, 2);

        System.out.println("\nFINAL RESULTS:");

        System.out.println("Sum = " + sum);

        System.out.println("Product = " + product);

    }

}