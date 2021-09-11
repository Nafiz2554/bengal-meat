 
package NewFx;

 
public class Supplier {
    int id,mobile_no,tradeLisence_no;
    String name;

    public Supplier(int id, int mobile_no, int tradeLisence_no, String name) {
        this.id = id;
        this.mobile_no = mobile_no;
        this.tradeLisence_no = tradeLisence_no;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(int mobile_no) {
        this.mobile_no = mobile_no;
    }

    public int getTradeLisence_no() {
        return tradeLisence_no;
    }

    public void setTradeLisence_no(int tradeLisence_no) {
        this.tradeLisence_no = tradeLisence_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    
}
