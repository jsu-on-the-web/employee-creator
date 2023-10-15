package com.jsu.employeecreator.entities;



import java.sql.Date;

import com.jsu.employeecreator.enums.EBasis;
import com.jsu.employeecreator.enums.EContractType;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


public class CreateEmployeeDTO {

    // * Primary Key
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    /* -------------------------- Personal Information -------------------------- */

    // * First Name
    @Column(name = "first_name")
    @NotNull
    @Getter
    @Setter
    private String first_name;

    // * Middle Name
    @Column(name = "middle_name")
    @Getter
    @Setter
    private String middle_name;

    // * Last Name
    @Column(name = "last_name")
    @NotNull
    @Getter
    @Setter
    private String last_name;

    /* --------------------------- Contact Information -------------------------- */

    // * Email Address
    @Column(name = "email_address")
    @NotNull
    @Getter
    @Setter
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email_address;

    // * Phone Number
    @Column(name = "phone_number")
    @NotNull
    @Getter
    @Setter
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{3}$")
    private String phone_number;

    // * Residential Address
    // TODO: Add validation or make use of an address search API
    // ? Should this just be a string or should it be its own entity?
    @Column(name = "residential_address")
    @Getter
    @Setter
    private String residential_address;


    /* ----------------------------- Employee Status ---------------------------- */

    // * Contract Type 
    @Column(name = "contract_type")
    @NotNull
    @Getter
    @Setter
    private EContractType contract_type;

    // * Start Date
    @Column(name = "start_date")
    @NotNull
    @Getter
    @Setter
    private Date start_date;

    // * End Date
    @Column(name = "end_date")
    @Getter
    @Setter
    private Date end_date;

    // * Is Ongoing
    @Column(name = "is_ongoing")
    @NotNull
    @Getter
    @Setter
    private boolean is_ongoing;

    // * Basis
    @Column(name = "basis")
    @NotNull
    @Getter
    @Setter
    private EBasis basis;

    // * Hours per week
    @Column(name = "hours_per_week")
    @NotNull
    @Getter
    @Setter
    private byte hours_per_week;
}