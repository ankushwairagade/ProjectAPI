package com.kapture.projectAPI.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Data {

    @Id
    @SequenceGenerator(
            name = "data_sequence",
            sequenceName = "data_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "data_sequence"
    )
    private long dataId;

    private double field1;
    private double field2;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name ="user_id",
            referencedColumnName = "userId"
    )
    @JsonBackReference
    private User user;

}
