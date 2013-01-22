package curso.ej09_01;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

public class Subject implements Comparable<Subject> {

    private static IdGenerator idGenerator = new IdGenerator();

    public static int nextId() {
        return idGenerator.nextId();
    }

    private int id;

    private String name;

    private Teacher teacher;

    private Classroom classroom;

    private int totalHours;

    private Date startDate;

    private Date endDate;

    private Set<Student> students = new TreeSet<Student>();

    // ADD

    public void addStudent(Student student) {
        if (students.contains(student)) {
            return;
        }

        students.add(student);
        student.addSubject(this);
    }

    public void removeStudent(Student student) {
        if (!students.contains(student)) {
            return;
        }

        students.remove(student);
        student.removeSubject(this);
    }

    public void setTeacher(Teacher teacher) {
        if (teacher.equals(this.teacher)) {
            return;
        }

        removeTeacher();

        this.teacher = teacher;
        this.teacher.addSubject(this);
    }

    public void removeTeacher() {

        if (this.teacher == null) {
            return;
        }

        Teacher old = this.teacher;
        this.teacher = null;
        old.removeSubject(this);
    }

    public void setClassroom(Classroom classroom) {
        if (classroom.equals(this.classroom)) {
            return;
        }

        removeClassroom();

        this.classroom = classroom;
        this.classroom.addSubject(this);

        System.out.println("Classroom: " + this.classroom);
    }

    public void removeClassroom() {

        if (this.classroom == null) {
            return;
        }

        Classroom old = this.classroom;
        this.classroom = null;
        old.removeSubject(this);
    }

    // Queries

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    public boolean inTime(Date date) {
        GregorianCalendar startGC = new GregorianCalendar();
        startGC.setTime(startDate);
        GregorianCalendar endGC = new GregorianCalendar();
        endGC.setTime(endDate);
        GregorianCalendar timeGC = new GregorianCalendar();
        timeGC.setTime(date);

        if (date.before(startGC.getTime()) || date.after(endGC.getTime())) {
            return false;
        }

        int startTime = startGC.get(HOUR_OF_DAY) * 100 + startGC.get(MINUTE);
        int endTime = endGC.get(HOUR_OF_DAY) * 100 + endGC.get(MINUTE);
        int dateTime = timeGC.get(HOUR_OF_DAY) * 100 + timeGC.get(MINUTE);

        return dateTime <= endTime && dateTime >= startTime;
    }

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 47 * hash + this.totalHours;
        hash = 47 * hash + (this.startDate != null ? this.startDate.hashCode() : 0);
        hash = 47 * hash + (this.endDate != null ? this.endDate.hashCode() : 0);
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
        final Subject other = (Subject) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.totalHours != other.totalHours) {
            return false;
        }
        if (this.startDate != other.startDate && (this.startDate == null || !this.startDate.equals(other.startDate))) {
            return false;
        }
        if (this.endDate != other.endDate && (this.endDate == null || !this.endDate.equals(other.endDate))) {
            return false;
        }
        return true;
    }

    public int compareTo(Subject o) {
        return id - o.getId();
    }

    @Override
    public String toString() {
        return "Asignatura #" + getId() + " nombre:" + getName();
    }
}
