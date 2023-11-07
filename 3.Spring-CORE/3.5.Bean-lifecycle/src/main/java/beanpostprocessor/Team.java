package beanpostprocessor;

public class Team {
    Developer developer;
    Admin admin;

    public Team() {

    }

    public Team(Developer developer, Admin admin) {
        this.developer = developer;
        this.admin = admin;
    }
}
