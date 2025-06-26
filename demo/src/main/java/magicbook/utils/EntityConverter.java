package magicbook.utils;

import magicbook.model.Magic;
import magicbook.model.Grimoire;
import magicbook.repository.MagicRepository;
import magicbook.repository.GrimoireRepository;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityConverter {

    private final MagicRepository magicRepository;
    private final GrimoireRepository grimoireRepository;

    @Autowired
    public  EntityConverter(MagicRepository magicRepository, GrimoireRepository grimoireRepository){
        this.magicRepository = magicRepository;
        this.grimoireRepository = grimoireRepository;
    }

    @Named("magicFromId")
    public Magic magicFromId(Integer id){
        return magicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado com ID: " + id));
    }

    @Named("grimoireFromId")
    public Grimoire grimoireFromId(Integer id){
        return grimoireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grimoire não encontrado com ID:" + id));
    }
}
