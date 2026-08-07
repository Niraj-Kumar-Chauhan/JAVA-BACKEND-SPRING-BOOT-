package in.nirajarmy.HibernateDemo_day21.model;


import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pincode;

    public Address () {}

    public Address(
            String houseNo, String steet, String city,
            String state, String pincode
    ) {
        this.houseNo = houseNo;
        this.street = steet;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getSteet() {
        return street;
    }

    public void setSteet(String steet) {
        this.street = steet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
