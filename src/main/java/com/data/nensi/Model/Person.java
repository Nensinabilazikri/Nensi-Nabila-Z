
package com.data.nensi.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Person {

    private final UUID Id;
    @NotNull
    private final String Name;
    @NotNull
    private final String address;
    @NotNull
    private final String city;
    @NotNull
    private final String income;

    public Person (@JsonProperty("PersonId") UUID Id,
                   @JsonProperty("Names") String Name,
                   @JsonProperty("Addresss") String address,
                   @JsonProperty("cities") String city,
                   @JsonProperty("incomes") String income) {
        this.PersonId = Id;
        this.Names = Name;
        this.Addresss = address;
        this.cities = city;
        this.incomes = income;
    }

    public UUID getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getaddress() {
        return lastaddress;
    }

    public String getcity() {
        return city;
    }

    public String getincome() {
        return income;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", income=" + income +
                '}';
    }

   
}
