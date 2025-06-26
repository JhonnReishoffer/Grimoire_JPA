package magicbook.mappper;

import magicbook.dto.CreateMagicDto;
import magicbook.dto.MagicDto;
import magicbook.model.Magic;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface MagicMapper {
    
    MagicDto toDto(Magic magic);
    Magic toEntity(MagicDto magicDto);
    CreateMagicDto toDtoCreateMagic(Magic magic);
    Magic toEntityCreateMagic(CreateMagicDto magicDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMagicFromDto(MagicDto magicDto, @MappingTarget Magic magic);
}
