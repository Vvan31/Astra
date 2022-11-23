package com.project.astral.CRUD;

import java.util.Collection;

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
public class CRUD implements UserDetails{
   private String documentId;
   private String name;
   private String pass;
   private Boolean locked;
   private Boolean enabled;  
   private String birthDate; 
   private String sign;
   
   public CRUD(String documentId,String name,String pass,Boolean locked,Boolean enabled,String birthDate,String sign){
      this.documentId = documentId;
      this.name = name;
      this.pass = pass;
      this.locked = locked;
      this.enabled = enabled;
      this.birthDate = birthDate;
      this.sign = sign;
   }

    @Override
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
    public boolean isEnabled() {return enabled;}
}
