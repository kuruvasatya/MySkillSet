package enum_example;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Week week = Week.MONDAY;
        System.out.println(week);

        switch (week) {
            case SUNDAY:
            case SATURDAY:
                System.out.println("Its holiday"); break;
            default: System.out.println("Its working day");
        }

        Arrays.stream(Week.values()).forEach(System.out::println);

        STATUS status = STATUS.RUNNING;
        System.out.println(status.exitcode);
    }
}
