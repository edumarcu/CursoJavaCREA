package curso.ej11_02.academy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Student extends People {

    transient
    private static IdGenerator idGenerator = new IdGenerator();

    public static int nextId() {
        return idGenerator.nextId();
    }

    transient
    private Set<Subject> subjects = new HashSet<Subject>();

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

    // ADD

    public void addSubject(Subject subject) {
        if (subjects.contains(subject)) {
            return;
        }

        subjects.add(subject);
        subject.addStudent(this);
    }

    public void removeSubject(Subject subject) {
        if (!subjects.contains(subject)) {
            return;
        }

        subjects.remove(subject);
        subject.removeStudent(this);
    }

    // Queries

    public Set<Subject> getSubjects() {
        return Collections.unmodifiableSet(subjects);
    }

    @Override
    public String toString() {
        return "Alumno #" + getId() + " nombre:" + getName();
    }
}
