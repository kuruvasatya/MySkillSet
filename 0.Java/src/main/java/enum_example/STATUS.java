package enum_example;

public enum STATUS {
    RUNNING(1),
    FAILED(2),
    SUCCESS(3);

    int exitcode;
    STATUS(int exitCode) {
        this.exitcode = exitCode;
    }
}
