package vn.com.iuh.fit.business;

import vn.com.iuh.fit.models.Student;

import java.util.ArrayList;
import java.util.List;

public class BaseProcess {

    public final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        ArrayList<Student> listStudents = new ArrayList<>();
        listStudents.add(new Student("1", "Nguyen Nhut Anh", "nhutanhngxx@gmail.com"));
        listStudents.add(new Student("2", "Nguyen Thi Nga", "ngangxx@gmail.com"));
        return List.of();
    }

    public Student persist(Student student) {
        return student;
    }

    public Student getById(long id) {
        return students.get((int) id);
    }
}
