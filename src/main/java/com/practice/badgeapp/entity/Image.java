package com.practice.badgeapp.entity;

import com.practice.badgeapp.enums.ImageCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
public class Image {
    @Id
    @Column(name = "image_id")
    private Long id;
    @Column(nullable = false)
    private String fileName;
    @Column(nullable = false)
    private Long fileSize;
    @Column(nullable = false)
    private ImageCategory imageType;
    @Column(nullable = false)
    private byte[] fileContent;
    @OneToOne(mappedBy = "avatar", fetch = FetchType.LAZY)
    private User user;
    @OneToOne(mappedBy = "icon", fetch = FetchType.LAZY)
    private Badge badge;

}
