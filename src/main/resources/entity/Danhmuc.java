package entity;
// Generated Jul 12, 2014 12:42:33 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Danhmuc  implements java.io.Serializable {


     private Integer madanhmuc;
     private String tendanhmuc;
     private Set sanphams = new HashSet(0);

    public Danhmuc() {
    }

	
    public Danhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }
    public Danhmuc(String tendanhmuc, Set sanphams) {
       this.tendanhmuc = tendanhmuc;
       this.sanphams = sanphams;
    }
   
    public Integer getMadanhmuc() {
        return this.madanhmuc;
    }
    
    public void setMadanhmuc(Integer madanhmuc) {
        this.madanhmuc = madanhmuc;
    }
    public String getTendanhmuc() {
        return this.tendanhmuc;
    }
    
    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }
    @XmlTransient
    public Set getSanphams() {
        return this.sanphams;
    }
    
    public void setSanphams(Set sanphams) {
        this.sanphams = sanphams;
    }

    @Override
    public String toString() {
        return "Danhmuc{" + "madanhmuc=" + madanhmuc + ", tendanhmuc=" + tendanhmuc + ", sanphams=" + sanphams + '}';
    }




}


