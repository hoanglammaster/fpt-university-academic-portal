package com.fpt.academic_portal.application_user;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Document(collection = "user_information")
@Data
public class ApplicationUser {
    @Id
    @Field("_id")
    private UUID id;
    private String username;
    private String password;
    private Set<Integer> role;
    @Field("is_non_expired")
    private Boolean isAccountNonExpired;
    @Field("is_non_locked")
    private Boolean isAccountNonLocked;
    @Field("is_credential_non_expired")
    private Boolean isCredentialsNonExpired;
    @Field("is_enable")
    private Boolean isEnabled;
    Collection<? extends GrantedAuthority> authorities;
    public ApplicationUser(UUID id,
                           String username,
                           String password,
                           Boolean isAccountNonExpired,
                           Boolean isAccountNonLocked,
                           Boolean isCredentialsNonExpired,
                           Boolean isEnabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthoritySet(){
        return (Set<SimpleGrantedAuthority>) authorities;
    }
    public void setAuthorities(Set<SimpleGrantedAuthority> authorities){
        this.authorities = authorities;
    }
}
