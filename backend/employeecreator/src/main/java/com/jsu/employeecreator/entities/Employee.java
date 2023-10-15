package com.jsu.employeecreator.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

import com.jsu.employeecreator.enums.EBasis;
import com.jsu.employeecreator.enums.EContractType;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
public class Employee {
    // * Primary Key
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    /* -------------------------- Personal Information -------------------------- */

    // * First Name
    @Column(name = "first_name")
    @NotEmpty
    @Getter
    @Setter
    private String firstName;

    // * Middle Name
    @Column(name = "middle_name")
    @Getter
    @Setter
    private String middleName;

    // * Last Name

    @Column(name = "last_name")
    @NotEmpty
    @Getter
    @Setter
    private String lastName;

    /* --------------------------- Contact Information -------------------------- */

    // * Email Address

    @Column(name = "email_address")
    @NotEmpty
    @Getter
    @Setter
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String emailAddress;

    // * Phone Number
    // * This should follow the Australian phone number format (+61 ### ### ###)
    @Column(name = "phone_number")
    @NotNull
    @Getter
    @Setter
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{3}$")
    private String phoneNumber;

    // * Residential Address
    // ? Should this just be a string or should it be its own entity?
    @Column(name = "residential_address")
    @Getter
    @Setter
    private String residentialAddress;

    /* ----------------------------- Employee Status ---------------------------- */

    // * Contract Type

    @Column(name = "contract_type")
    @NotNull
    @Getter
    @Setter
    private EContractType contractType;

    // * Start Date

    @Column(name = "start_date")
    @NotNull
    @Getter
    @Setter
    private Date startDate;

    // * End Date

    @Column(name = "end_date")
    @Getter
    @Setter
    private Date endDate;

    // * Is Ongoing
    @Column(name = "is_ongoing")
    @NotNull
    @Getter
    @Setter
    private boolean isOngoing;

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
    private byte hoursPerWeek;

    /* -------------------------------------------------------------------------- */
    /* Constructors */
    /* -------------------------------------------------------------------------- */

    public Employee(String firstName,
            String lastName,
            String emailAddress,
            String phoneNumber,
            String residentialAddress,
            EContractType contractType,
            Date startDate,
            Date endDate,
            boolean isOngoing,
            EBasis basis,
            byte hoursPerWeek) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(emailAddress);
        setPhoneNumber(phoneNumber);
        setResidentialAddress(residentialAddress);
        setContractType(contractType);
        setStartDate(startDate);
        setEndDate(endDate);
        setOngoing(isOngoing);
        setBasis(basis);
        setHoursPerWeek(hoursPerWeek);
    }

}