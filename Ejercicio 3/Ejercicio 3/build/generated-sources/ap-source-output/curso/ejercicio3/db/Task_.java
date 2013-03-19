package curso.ejercicio3.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-19T10:32:00")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, Integer> id;
    public static volatile SingularAttribute<Task, String> text;
    public static volatile SingularAttribute<Task, Boolean> done;

}