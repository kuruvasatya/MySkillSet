import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ObjectInvocationHandler implements InvocationHandler {
    Object target;

    ObjectInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(">> " + method.getName() + " started...");

        Object result =method.invoke(target, args);

        System.out.println("<< " + method.getName() + " completed.");

        return result;
    }
}
