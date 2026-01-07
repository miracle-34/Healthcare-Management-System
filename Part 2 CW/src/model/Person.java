package model;


public class Person {
    private String name;
    private String phone;
    private String address;
    private String dob;

    public Person(String name, String phonenum, String address, String dob)
    {
        this.name = name;
        phone = phonenum;
        this.address = address;
        this.dob = dob;
    }

    public String getName() {return name;}
    public String getPhone() {return phone;};
    public String getAddress() {return address;}
    public String getDob() {return dob;}


    public void updateDetails(String name, String phone, String address, String dob )
    {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dob = dob;

    }

    public String getDetails()
    {
        return "Name: "
                +  name +  "\n" + "Phone: " + "\n"
                + phone + "\n" + "Address: " +"\n"
                + address +"\n" + "Date of Birth: "+ "\n" + dob;
    }
}
