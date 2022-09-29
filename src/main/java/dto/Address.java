package dto;

import lombok.Data;

@Data
public class Address {

    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geolocation geo;
}
