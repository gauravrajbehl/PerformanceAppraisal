package org.app.perf.domain;

import lombok.Data;

import java.util.Calendar;

/**
 * Created by gauravbehl on 9/5/17.
 */

@Data
public class EmployeeProfile {

    private long id;

    private long employeeId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String gender;

    private Calendar dateOfBirth;

    private String contactNumber;

    private String emailAddress;

    private Calendar dateOfJoining;

    private Designation designation;

    private EmployeeType employeeType;

}
