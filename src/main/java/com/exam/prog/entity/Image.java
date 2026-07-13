package com.exam.prog.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "\"image\"")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "email")
    private String email;

    @CreationTimestamp 
    @Column(name = "created_at")
    private Instant createdAt;
}