package com.flamierd.booklibraryapi.domain.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "roles")
@Entity
public class UserRole implements GrantedAuthority {
    @Id
    private String authority;
}
