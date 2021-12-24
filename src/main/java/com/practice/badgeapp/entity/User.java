package com.practice.badgeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = { @JoinColumn(name = "fk_user") },
            inverseJoinColumns = { @JoinColumn(name = "fk_role") })
    private List<Roles> roles = new ArrayList<>();
    @ManyToMany(mappedBy = "owners")
    private List<Badge> badges = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<AssignmentRequest> assignmentRequests = new ArrayList<>();
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_image")
    private Image avatar;
}
