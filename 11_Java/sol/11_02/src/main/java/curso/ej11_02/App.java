package curso.ej11_02;

import curso.ej11_02.academy.Academy;
import curso.ej11_02.academy.Classroom;
import curso.ej11_02.academy.Student;
import curso.ej11_02.academy.Subject;
import curso.ej11_02.academy.Teacher;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedList;

public class App {

    private static Academy academy;

    public static void main(String[] args) throws Exception {
        loadAcademy();

        String outdirPath = "/tmp/students";
        File outdir = new File(outdirPath);
        outdir.deleteOnExit();
        if (!outdir.exists()) {
            outdir.mkdirs();
        }

        // Write
        System.out.println("Guardando Alumnos:");
        for (Student student : academy.listStudents()) {
            String outfilePath = student.getId() + "-" + student.getName() + ".data";
            File outFile = new File(outdir, outfilePath);

            FileOutputStream fos = new FileOutputStream(outFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream out = new ObjectOutputStream(bos);

            out.writeObject(student);
            System.out.println(student);

            out.close();
        }

        System.out.println("Alumnos guardados:");

        //Read
        Collection<Student> students = new LinkedList<Student>();
        File[] files = outdir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                //return name.matches(".*\\.data$");
                return name.endsWith(".data");
            }
        });
        for (File file : files) {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream in = new ObjectInputStream(bis);

            Student student = (Student) in.readObject();
            students.add(student);

            in.close();
        }

        System.out.println("Alumnos leídos:");
        for (Student student : students) {
            System.out.println(student);
        }

    }

    public static void loadAcademy() throws ParseException {

        System.out.println("Academy");
        System.out.println();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        academy = new Academy("Java corp", "Calle Falsa 1,2,3");

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
    }
}
