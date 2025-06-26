package magicbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import magicbook.utils.MagicCategory;

@Data
@AllArgsConstructor
public class MagicDto {

    private Long id;
    private String name;
    private String description;
    private MagicCategory category;
    private Double range;
    private Double damage;
    private Integer manaCost;

}
