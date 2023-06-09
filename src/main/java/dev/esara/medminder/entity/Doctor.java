package dev.esara.medminder.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private String phoneNumber;

    @Column(name="user_id", nullable=false)
    private long userId;

    @ManyToOne
    @JoinColumn(name="user_id", insertable=false, updatable=false)
    private User user;
}