package Reflection;

public class StudentService {
    private String studentName;

    StudentService(String name) {
          this.studentName = name;
    }

    public String getName() {
        return this.studentName;
    }

    private void setName(String name) {
        this.studentName = name;
    }
}
