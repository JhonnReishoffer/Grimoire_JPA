package magicbook.model;

import magicbook.utils.MagicCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="magics")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Magic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private MagicCategory category;

    private Double range;

    private Double damage;

    private Integer manaCost;

    @ManyToOne
    @JoinColumn(name = "grimoire_id")
    private Grimoire grimoire;

}