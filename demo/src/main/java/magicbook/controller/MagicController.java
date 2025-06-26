package magicbook.controller;

import magicbook.dto.CreateMagicDto;
import magicbook.dto.MagicDto;
import magicbook.mappper.MagicMapper;
import magicbook.model.Magic;
import magicbook.repository.MagicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/magics")
public class MagicController {
    @Autowired
    private MagicRepository magicRepository;
    @Autowired
    private MagicMapper magicMapper;

    @GetMapping
    public List<MagicDto> GetAllMagics(){
        return magicRepository.findAll()
                .stream()
                .map(magicMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MagicDto GetMagicById(@PathVariable Integer id){
        Magic magic = magicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Magic not found!"));
        return magicMapper.toDto(magic);
    }

    @PostMapping
    public MagicDto Post(@RequestBody CreateMagicDto criarMagicDto){
        Magic magic = magicMapper.toEntityCreateMagic(criarMagicDto);
        magicRepository.save(magic);
        return magicMapper.toDto(magic);
    }

    @PutMapping("/{id}")
    public MagicDto Put(@PathVariable Integer id, @RequestBody MagicDto novoMagicDto){
        Magic magic = magicRepository.findById(id).orElseThrow(() -> new RuntimeException("Magic not found!"));
        magicMapper.updateMagicFromDto(novoMagicDto, magic);
        magicRepository.save(magic);

        return magicMapper.toDto(magic);
    }

    @DeleteMapping("/{id}")
    public MagicDto Delete(@PathVariable Integer id){
        Magic magic = magicRepository.findById(id).orElseThrow(() -> new RuntimeException("Magic not found!"));
        magicRepository.delete(magic);

        return magicMapper.toDto(magic);
    }
}
