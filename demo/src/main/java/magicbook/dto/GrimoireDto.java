package magicbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GrimoireDto {

    private Long id;
    private String name;
    private String owner;
    private String description;

}
