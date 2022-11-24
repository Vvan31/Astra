package com.project.astral.CRUD;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class User implements UserDetails{
//public class User {
   @SequenceGenerator(
      name="user_seq",
      sequenceName = "user_seq",
      allocationSize = 1
   )
   @Id
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "user_seq"
   )
   private String documentId;
   private String name;
   private String pass;
   private Boolean locked;
   private Boolean enabled;  
   private String birthDay; 
   private String sign;
   
   public User(String documentId,String name,String pass){
      this.documentId = documentId;
      this.name = name;
      this.pass = pass;
      this.locked = false;
      this.enabled = true;
      this.birthDay = null;
      this.sign = null;
   }
   public User(String documentId,String name,String pass,Boolean locked,
               Boolean enabled,String birthDay,String sign){
      this.documentId = documentId;
      this.name = name;
      this.pass = pass;
      this.locked = locked;
      this.enabled = enabled;
      this.birthDay = birthDay;
      this.sign = sign;
   }

  /*  @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {return null;}

   @Override
   public String getPassword() {return pass;}

   @Override
   public String getUsername() {return name;}

   @Override
   public boolean isAccountNonExpired() {return true;}

   @Override
   public boolean isAccountNonLocked() {return !locked;}

   @Override
   public boolean isCredentialsNonExpired() {return true;}

   @Override
   public boolean isEnabled() {return enabled;} */


   public Collection<? extends GrantedAuthority> getAuthorities() {return null;}

   public String getPassword() {return pass;}

   public String getUsername() {return name;}

   public String getSign() {return sign;}

   public String getBirthDay() {return birthDay;}

   public void setUsername(String name){
      this.name = name;
   }
   public void setPass(String pass){
      this.pass = pass;
   }
   public void setBirthday(String bd){
      this.birthDay = bd;
   }
   public void setSign(String sign){
      this.sign = sign; 
   }

   @Override
   public String toString() {
       return "User{"+
               "documentId=" + documentId +
               "name=" + name +
               "pass=" + pass +
               "birthday=" + birthDay +
               "sign=" + sign +
               "}";
   }

/////////////////////////////////////////////////////////////


   public boolean isAccountNonExpired() {return true;}

   public boolean isAccountNonLocked() {return !locked;}

   public boolean isCredentialsNonExpired() {return true;}

   public boolean isEnabled() {return enabled;}


}
