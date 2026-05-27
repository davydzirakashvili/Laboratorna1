package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(
            Object proxy,
            Method method,
            Object[] args) throws Throwable {

        long start = System.nanoTime();

        System.out.println("\nMETHOD: "
                + method.getName());

        System.out.println("PARAMETERS:");

        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg);
            }
        }

        Object result =
                method.invoke(target, args);

        long end = System.nanoTime();

        System.out.println("RESULT: " + result);

        System.out.println(
                "TIME: "
                        + (end - start)
                        + " ns"
        );

        return result;
    }
}