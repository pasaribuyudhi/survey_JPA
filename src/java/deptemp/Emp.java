/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deptemp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "emp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emp.findAll", query = "SELECT e FROM Emp e")
    , @NamedQuery(name = "Emp.findByEid", query = "SELECT e FROM Emp e WHERE e.eid = :eid")
    , @NamedQuery(name = "Emp.findByEname", query = "SELECT e FROM Emp e WHERE e.ename = :ename")
    , @NamedQuery(name = "Emp.findBySalary", query = "SELECT e FROM Emp e WHERE e.salary = :salary")})
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EID")
    private Integer eid;
    @Size(max = 20)
    @Column(name = "ENAME")
    private String ename;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private Double salary;
    @JoinColumn(name = "DEPT_DID", referencedColumnName = "DID")
    @ManyToOne
    private Dept deptDid;

    public Emp() {
    }

    public Emp(Integer eid) {
        this.eid = eid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Dept getDeptDid() {
        return deptDid;
    }

    public void setDeptDid(Dept deptDid) {
        this.deptDid = deptDid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eid != null ? eid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emp)) {
            return false;
        }
        Emp other = (Emp) object;
        if ((this.eid == null && other.eid != null) || (this.eid != null && !this.eid.equals(other.eid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "deptemp.Emp[ eid=" + eid + " ]";
    }
    
}
