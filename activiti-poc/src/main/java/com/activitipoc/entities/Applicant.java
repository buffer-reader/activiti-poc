package com.activitipoc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applicant {

    @Id
    private Long id;

    private String applicantName;
    private String emailId;
    private String phoneNumber;

}
