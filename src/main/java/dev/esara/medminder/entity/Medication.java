package dev.esara.medminder.entity;
import dev.esara.medminder.model.enums.Usage;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "medications")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int stock = 0;
    private int dosage;

    @Enumerated(EnumType.STRING)
    private Usage usage;

    @Column(name="user_id", nullable=false)
    private long userId;

    @ManyToOne
    @JoinColumn(name="user_id", insertable=false, updatable=false)
    private User user;
}
