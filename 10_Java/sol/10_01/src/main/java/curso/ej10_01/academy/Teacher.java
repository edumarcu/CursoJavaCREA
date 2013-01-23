package curso.ej10_01.academy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Teacher extends People {

    private static IdGenerator idGenerator = new IdGenerator();

    public static int nextId() {
        return idGenerator.nextId();
    }

    private Set<Subject> subjects = new HashSet<Subject>();

    // ADD

    public void addSubject(Subject subject) {
        if (subjects.contains(subject)) {
            return;
        }

        subjects.add(subject);
        subject.setTeacher(this);
    }

    public void removeSubject(Subject subject) {
        if (!subjects.contains(subject)) {
            return;
        }

        subjects.remove(subject);
        subject.removeTeacher();
    }

    // Queries

    public Set<Subject> getSubjects() {
        return Collections.unmodifiableSet(subjects);
    }

    public Set<Student> getStudents() {
        Set<Student> students = new TreeSet<Student>();
        for (Subject subject : subjects) {
            students.addAll(subject.getStudents());
        }
        return students;
    }

    @Override
    public int hashCode() {
        int hash = 7 * super.hashCode();
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
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Profesor #" + getId() + " nombre:" + getName();
    }
}
