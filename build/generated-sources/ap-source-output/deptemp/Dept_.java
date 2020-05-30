package deptemp;

import deptemp.Emp;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-29T22:45:55")
@StaticMetamodel(Dept.class)
public class Dept_ { 

    public static volatile SingularAttribute<Dept, String> dname;
    public static volatile CollectionAttribute<Dept, Emp> empCollection;
    public static volatile SingularAttribute<Dept, Integer> did;

}