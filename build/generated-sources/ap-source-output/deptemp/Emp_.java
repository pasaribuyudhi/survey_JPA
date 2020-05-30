package deptemp;

import deptemp.Dept;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-29T22:45:55")
@StaticMetamodel(Emp.class)
public class Emp_ { 

    public static volatile SingularAttribute<Emp, Integer> eid;
    public static volatile SingularAttribute<Emp, String> ename;
    public static volatile SingularAttribute<Emp, Dept> deptDid;
    public static volatile SingularAttribute<Emp, Double> salary;

}