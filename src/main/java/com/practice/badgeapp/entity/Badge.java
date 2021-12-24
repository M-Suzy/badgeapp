package com.practice.badgeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "badges")
public class Badge {
    @Id
    @Column(name = "badge_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer level;
    @Column(nullable = false)
    private LocalDate creationDate = LocalDate.now();
    @Column(nullable = false)
    private LocalDate assignmentDate;
    @OneToMany(mappedBy = "badge", fetch = FetchType.LAZY)
    private List<AssignmentRequest> requests = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_badge",
            joinColumns = {@JoinColumn(name = "fk_user")},
            inverseJoinColumns = {@JoinColumn(name = "fk_badge")}
    )
    private List<User> owners = new ArrayList<>();
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_image")
    private Image icon;

}
