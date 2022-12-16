package UserSilme;

import java.util.ArrayList;
import java.util.List;

class SchoolManagementSystem {
    // list of students and teachers in the system
    private List<Student> students;
    private List<Teacher> teachers;

    public SchoolManagementSystem() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public void deleteStudent(Role userRole, int studentId) {
        if (userRole == Role.ADMIN || userRole == Role.TEACHER) {
            // find the student with the given id
            Student studentToDelete = null;
            for (Student student : students) {
                if (student.getId() == studentId) {
                    studentToDelete = student;
                    break;
                }
            }
            // remove the student from the list if it was found
            if (studentToDelete != null) {
                students.remove(studentToDelete);
                System.out.println("Student with id " + studentId + " was successfully deleted.");
            } else {
                System.out.println("Student with id " + studentId + " was not found.");
            }
        } else {
            System.out.println("You do not have permission to delete students.");
        }
    }

    public void deleteTeacher(Role userRole, int teacherId) {
        if (userRole == Role.ADMIN) {
            // find the teacher with the given id
            Teacher teacherToDelete = null;
            for (Teacher teacher : teachers) {
                if (teacher.getId() == teacherId) {
                    teacherToDelete = teacher;
                    break;
                }
            }
            // remove the teacher from the list if it was found
            if (teacherToDelete != null) {
                teachers.remove(teacherToDelete);
                System.out.println("Teacher with id " + teacherId + " was successfully deleted.");
            } else {
                System.out.println("Teacher with id " + teacherId + " was not found.");
            }
        } else {
            System.out.println("You do not have permission to delete teachers.");
        }
    }

    public static void main(String[] args) {
        SchoolManagementSystem sms = new SchoolManagementSystem();

// add some students and teachers
        sms.students.add(new Student("Alice", 1));
        sms.students.add(new Student("Bob", 2));
        sms.teachers.add(new Teacher("Carol", 3));
        sms.teachers.add(new Teacher("Dave", 4));

// try deleting a student as an admin
        sms.deleteStudent(Role.ADMIN, 1);  // should succeed

// try deleting a student as a teacher
        sms.deleteStudent(Role.TEACHER, 2);  // should succeed

// try deleting a student as a student
        sms.deleteStudent(Role.STUDENT, 1);  // should fail

// try deleting a teacher as an admin
        sms.deleteTeacher(Role.ADMIN, 3);  // should succeed

// try deleting a teacher as a teacher
        sms.deleteTeacher(Role.TEACHER, 4);  // should fail

// try deleting a teacher as a student
        sms.deleteTeacher(Role.STUDENT, 3);  // should fail
    }
}
