package implementingclass;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ApplicationDao implements InitializingBean, DisposableBean {

    Dependency dependency;

    public Dependency getDependency() {
        return dependency;
    }

    public void setDependency(Dependency dependency) {
        System.out.println("i am injecting the dependency..");
        this.dependency = dependency;
    }

    ApplicationDao() {
        System.out.println("I am constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroying the object...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init method called");
    }
}
