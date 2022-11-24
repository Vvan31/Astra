package com.project.astral.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String userName;

    @NotBlank
    private String pass; 

    private String birthDay;
    private String sign;

    public AppUser(String userName, String pass){
        this.userName = userName;
        this.pass = pass;
        this.birthDay = null;
        this.sign = null;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getUserName() + "'" +
            ", pass='" + getPass() + "'" +
            ", sign='" + getSign() + "'" +
            "}";
    }

}
