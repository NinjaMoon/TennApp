package com.example.tennApp;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data  // autogenerate getter setter
@NoArgsConstructor  // autogenerate constructor
public class Courts {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address_line1;

    private String address_line2;

    private String city;

    private String state;

    private String postal_code;

    private float latitude;

    private float longitude;

    private Integer has_light;

    private Integer has_parking;

    private Integer total_num_of_courts;

    private Integer latest_num_of_courts_available;

}
