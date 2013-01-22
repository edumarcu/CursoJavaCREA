package curso.ej09_01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class App
{
    public static void main( String[] args ) throws ParseException
    {
        System.out.println( "Academy" );
        System.out.println();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        Academy academy = new Academy("Java corp", "Calle Falsa 1,2,3");

        Classroom a1 = new Classroom();
        a1.setName("101");
        a1.setCapacity(20);
        a1.setHaveProjector(false);
        academy.addClassroom(a1);

        Classroom a2 = new Classroom();
        a2.setName("201");
        a2.setCapacity(50);
        a2.setHaveProjector(true);
        academy.addClassroom(a2);

        Classroom a3 = new Classroom();
        a3.setName("202");
        a3.setCapacity(10);
        a3.setHaveProjector(false);
        academy.addClassroom(a3);

        Teacher t1 = new Teacher();
        t1.setId(Teacher.nextId());
        t1.setName("Víctor Jiménez Cerrada");
        t1.setAddress("Calle falsa 5");
        academy.addTeacher(t1);

        Subject s1 = new Subject();
        s1.setId(Subject.nextId());
        s1.setName("Introducción a la programación");
        s1.setStartDate(sdf.parse("2012-12-27 09:00"));
        s1.setEndDate(sdf.parse("2013-01-26 14:00"));
        s1.setTotalHours(40);
        academy.addSubject(s1);

        Subject s2 = new Subject();
        s2.setId(Subject.nextId());
        s2.setName("Programación Java avanzada");
        s2.setStartDate(sdf.parse("2013-01-27 09:00"));
        s2.setEndDate(sdf.parse("2013-02-28 14:00"));
        s2.setTotalHours(40);
        academy.addSubject(s2);

        Student st1 = new Student();
        st1.setId(Student.nextId());
        st1.setName("Pedro");
        st1.setAddress("Calle no existente 5");
        academy.addStudent(st1);

        Student st2 = new Student();
        st2.setId(Student.nextId());
        st2.setName("Pablo");
        st2.setAddress("Calle no existente 10");
        academy.addStudent(st2);

        Student st3 = new Student();
        st3.setId(Student.nextId());
        st3.setName("Paula");
        st3.setAddress("Calle no existente 10");
        academy.addStudent(st3);

        academy.setClassroomForSubject(a1.getName(), s1.getId());
        academy.setClassroomForSubject(a1.getName(), s2.getId());

        academy.setTeacherForSubject(t1.getId(), s1.getId());
        academy.setTeacherForSubject(t1.getId(), s2.getId());

        academy.registerStudentOnSubject(st1.getId(), s1.getId());
        academy.registerStudentOnSubject(st1.getId(), s2.getId());
        academy.registerStudentOnSubject(st2.getId(), s1.getId());
        academy.registerStudentOnSubject(st2.getId(), s2.getId());
        academy.registerStudentOnSubject(st3.getId(), s1.getId());
        academy.registerStudentOnSubject(st3.getId(), s2.getId());

        System.out.println();
        System.out.println("Aulas: ");
        printCollection(academy.listClassrooms());

        System.out.println();
        System.out.println("Profesores: ");
        printCollection(academy.listTeachers());

        System.out.println();
        System.out.println("Asignaturas: ");
        printCollection(academy.listSubjects());

        System.out.println();
        System.out.println("Alumnos: ");
        printCollection(academy.listStudents());

        System.out.println();
        System.out.println("Alumnos atendidos por: " + t1);
        printCollection(t1.getStudents());

        System.out.println();
        System.out.println("Alumnos que atienden a : " + s1);
        printCollection(s1.getStudents());

        System.out.println();
        System.out.println("Asignaturas impartidas por : " + t1);
        printCollection(t1.getSubjects());

        System.out.println();
        System.out.println("Asignaturas impartidas en : " + a1);
        printCollection(a1.getSubjects());

        System.out.println();
        System.out.println("Aulas libres ahora: " + sdf.format(new Date()));
        printCollection(academy.availableClassroomsAt(new Date()));
    }

    public static void printCollection(Collection<?> collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}
