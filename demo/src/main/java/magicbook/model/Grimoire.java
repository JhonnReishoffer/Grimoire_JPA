package magicbook.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name="grimoire")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Grimoire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String owner;

    private String description;

    @OneToMany(mappedBy = "magics", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Magic> listOfMagics;


}
