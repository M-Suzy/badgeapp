package com.practice.badgeapp.entity;

import com.practice.badgeapp.enums.AssignmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignments")
public class AssignmentRequest {
    @Id
    @Column(name = "assignment_id")
    private Long id;
    @Column(nullable = false)
    private AssignmentStatus status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_badge")
    private Badge badge;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
    private User user;
    @Column(nullable = false)
    private LocalDate requestDate;

}
