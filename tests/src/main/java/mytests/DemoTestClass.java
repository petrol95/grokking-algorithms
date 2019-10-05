package mytests;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoTestClass {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(TestClass.class);
    }

    public static void start(Class<?> clazz) throws InvocationTargetException, IllegalAccessException {

        Method[] methods = clazz.getMethods();
        Method startMethod = checkMethod(methods, BeforeSuite.class);
        Method endMethod = checkMethod(methods, AfterSuite.class);

        Object ex = null;
        try {
            ex = clazz.getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }

        startMethod.invoke(ex);
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);
                for (int i = 10; i > 0; i--) {
                    if (annotation.priority() == i)
                        method.invoke(ex);
                }
            }
        }
        endMethod.invoke(ex);
    }

    private static Method checkMethod(Method[] methods, Class<? extends Annotation> annotationClass) {
        int col = 0;
        Method targetMethod = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                targetMethod = method;
                col++;
            }
        }
        if (col != 1)
            throw new RuntimeException();
        return targetMethod;
    }
}
