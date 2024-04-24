package com.example.ex1.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@jakarta.persistence.Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Children {

    @jakarta.persistence.Id
    private int babyId;
    private String babyFirstName;
    private String babyLastName;
    private String fatherName;
    private String motherName;
    private String address;
    
}

