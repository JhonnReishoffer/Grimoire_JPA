package magicbook.mappper;

import magicbook.dto.CreateGrimoireDto;
import magicbook.dto.GrimoireDto;
import magicbook.model.Grimoire;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface GrimoireMapper {

    GrimoireDto toDto(Grimoire grimoire);
    Grimoire toEntity(GrimoireDto grimoireDto);
    CreateGrimoireDto toDtoCreateGrimoire(Grimoire grimoire);
    Grimoire toEntityCreateGrimoire(CreateGrimoireDto createGrimoireDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGrimoireFromDto(GrimoireDto grimoireDto, @MappingTarget Grimoire grimoire);
}

