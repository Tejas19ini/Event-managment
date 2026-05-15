package com.Project.Event_Managment;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "colleges")
@Data
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collegeId;

    @Column(name = "college_name")
    private String name;

    private String city;
}