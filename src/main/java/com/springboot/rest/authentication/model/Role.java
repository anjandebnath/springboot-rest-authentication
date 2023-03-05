package com.springboot.rest.authentication.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor (access= AccessLevel.PRIVATE, force=true)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public Role(ERole role){
       this.name = role;
    }
}
