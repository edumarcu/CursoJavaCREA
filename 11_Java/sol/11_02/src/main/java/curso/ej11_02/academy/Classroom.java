package curso.ej11_02.academy;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Classroom implements Comparable<Classroom>{

    private String name;

    private int capacity;

    private boolean haveProjector;

    private Set<Subject> subjects = new HashSet<Subject>();

    // ADD

    public void addSubject(Subject subject) {
        if (subjects.contains(subject)) {
            return;
        }

        subjects.add(subject);
        subject.setClassroom(this);
    }

    public void removeSubject(Subject subject) {
        if (!subjects.contains(subject)) {
            return;
        }

        subjects.remove(subject);
        subject.removeClassroom();
    }

    // Queries

    public Set<Subject> getSubjects() {
        return Collections.unmodifiableSet(subjects);
    }

    public boolean availableInTime(Date date) {
        for (Subject subject : subjects) {
            if (subject.inTime(date)) {
                return false;
            }
        }
        return true;
    }

    // Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHaveProjector() {
        return haveProjector;
    }

    public void setHaveProjector(boolean haveProjector) {
        this.haveProjector = haveProjector;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.name != null ? this.name.hashCode() : 0);
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
        final Classroom other = (Classroom) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    public int compareTo(Classroom o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Aula #" + name + " capacidad: " + capacity + " proyector:" + haveProjector;
    }
}
