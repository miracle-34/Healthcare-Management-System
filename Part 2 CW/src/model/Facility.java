package model;

public class Facility
{
    private String facilityId;
    private String name;
    private String type;
    private String services;
    private String contact;
    private int capacity;

    public Facility(String facilityId, String name, String type, String services, String contact, int capacity)
    {
        this.facilityId = facilityId;
        this.name = name;
        this.type = type;
        this.services = services;
        this.contact = contact;
        this.capacity = capacity;

    }

    public String getFacilityId() {return facilityId;}
    public String getName() {return name;}
    public String getType() {return type;}
    public String getServices() {return services;}
    public String getContact() {return contact;}
    public int getCapacity() {return capacity;}
}
