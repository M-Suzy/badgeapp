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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @Column(name = "role_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy="roles", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();
}
