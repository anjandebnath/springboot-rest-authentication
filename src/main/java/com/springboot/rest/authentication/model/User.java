package com.springboot.rest.authentication.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })

@AllArgsConstructor
@NoArgsConstructor (access= AccessLevel.PRIVATE, force=true)
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(max = 20)
        private String username;

        @NotBlank
        @Size(max = 50)
        @Email
        private String email;

        @NotBlank
        @Size(max = 120)
        private String password;

        /*  We use @ManyToMany annotation to create a many-to-many relationship
       between two entities. In a bi-directional association,
       the @ManyToMany annotation is used on both the entities but
       only one entity can be the owner of the relationship.*/


       /*  The entity that specifies the @JoinTable is the owning side of the
       relationship and the entity that specifies the mappedBy attribute
       is the inverse side.*/

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(  name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Collection<Role> roles;

        public User(String username, String email, String password) {
                this.username = username;
                this.email = email;
                this.password = password;
        }

}
