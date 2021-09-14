package com.vmsr.contactlist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Person implements Serializable {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false, length = 30)
    private String first_name;

    @Getter
    @Setter
    @Column(nullable = false, length = 30)
    private String last_name;

    @Getter
    @Setter
    @Column(nullable = false, length = 15)
    private String phone;

    @Getter
    @Setter
    @Column(nullable = false, length = 255)
    private String email;











}
