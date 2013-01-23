package curso.ej11_02.academy;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Academy {

    private String name;

    private String address;

    private Map<Integer, Student> students = new TreeMap<Integer, Student>();

    private Map<Integer, Teacher> teachers = new TreeMap<Integer, Teacher>();

    private Map<Integer, Subject> subjects = new TreeMap<Integer, Subject>();

    private Map<String, Classroom> classrooms = new HashMap<String, Classroom>();

    public Academy(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // ADD

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getId(), teacher);
    }

    public void addClassroom(Classroom classroom) {
        classrooms.put(classroom.getName(), classroom);
    }

    public void addSubject(Subject subject) {
        subjects.put(subject.getId(), subject);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void setTeacherForSubject(int teacherid, int subjectid) {
        Teacher teacher = teachers.get(teacherid);
        Subject subject = subjects.get(subjectid);

        subject.setTeacher(teacher);
    }

    public void setClassroomForSubject(String classroomName, int subjectid) {
        Classroom classroom = classrooms.get(classroomName);
        Subject subject = subjects.get(subjectid);

        subject.setClassroom(classroom);
    }

    public void registerStudentOnSubject(int studentid, int subjectid) {
        Student student = students.get(studentid);
        Subject subject = subjects.get(subjectid);

        subject.addStudent(student);
    }

    // Queries

    public Collection<Student> listStudents() {
        return Collections.unmodifiableCollection(students.values());
    }

    public Collection<Teacher> listTeachers() {
        return Collections.unmodifiableCollection(teachers.values());
    }

    public Collection<Subject> listSubjects() {
        return Collections.unmodifiableCollection(subjects.values());
    }

    public Collection<Classroom> listClassrooms() {
        return Collections.unmodifiableCollection(classrooms.values());
    }

    public Student studentById(int id) {
        return students.get(id);
    }

    public Teacher teacherById(int id) {
        return teachers.get(id);
    }

    public Subject subjectById(int id) {
        return subjects.get(id);
    }

    public Classroom classroomByName(String name) {
        return classrooms.get(name);
    }

    public Set<Classroom> availableClassroomsAt(Date date) {
        Set<Classroom> available = new TreeSet<Classroom>();
        for (Classroom classroom : classrooms.values()) {
            if (classroom.availableInTime(date)) {
                available.add(classroom);
            }
        }
        return available;
    }

    // Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 71 * hash + (this.address != null ? this.address.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Academy other = (Academy) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.address == null) ? (other.address != null) : !this.address.equals(other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Academia nombre:" + name + " dirección:" + address;
    }

}
