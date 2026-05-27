package arrays;

import java.lang.reflect.Array;

public class ArrayUtils {

    public static Object createArray(
            Class<?> type,
            int size) {

        return Array.newInstance(type, size);
    }

    public static Object resizeArray(
            Object oldArray,
            int newSize) {

        int oldSize = Array.getLength(oldArray);

        Class<?> type =
                oldArray.getClass().getComponentType();

        Object newArray =
                Array.newInstance(type, newSize);

        System.arraycopy(
                oldArray,
                0,
                newArray,
                0,
                Math.min(oldSize, newSize)
        );

        return newArray;
    }

    public static String arrayToString(Object array) {

        int size = Array.getLength(array);

        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {

            sb.append(Array.get(array, i));

            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}