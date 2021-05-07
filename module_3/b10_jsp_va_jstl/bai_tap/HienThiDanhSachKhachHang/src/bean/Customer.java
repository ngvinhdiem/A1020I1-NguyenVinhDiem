package bean;

public class Customer {
   private String name,dob,address,image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Customer(String name, String dob, String address, String image)
    {
        this.name=name;
        this.dob=dob;
        this.address=address;
        this.image=image;
    }
}