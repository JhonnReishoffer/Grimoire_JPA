package magicbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateGrimoireDto {

    private Long id;
    private String name;
    private String owner;
    private String description;
}
