package usingannotation;
import javax.annotation.*;

public class ApplicationDao {

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

    @PostConstruct
    public void init () {
        System.out.println("init method ... ");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy method ...");
    }
}
