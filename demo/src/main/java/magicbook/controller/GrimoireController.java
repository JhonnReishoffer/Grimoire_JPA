package magicbook.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import magicbook.dto.CreateGrimoireDto;
import magicbook.dto.GrimoireDto;
import magicbook.mappper.GrimoireMapper;
import magicbook.model.Grimoire;
import magicbook.repository.GrimoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grimoire")
public class GrimoireController {

    @Autowired
    private GrimoireRepository grimoireRepository;
    @Autowired
    private GrimoireMapper grimoireMapper;

    @GetMapping
    public List<GrimoireDto> GetAllGrimoires(){
        return grimoireRepository.findAll()
                .stream()
                .map(grimoireMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GrimoireDto GetGrimoireById(@PathVariable Integer id){
        Grimoire grimoire = grimoireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grimoire not found!"));
        return grimoireMapper.toDto(grimoire);
    }


    @PostMapping
    public GrimoireDto Post(@RequestBody CreateGrimoireDto createGrimoireDto){
        Grimoire grimoire = grimoireMapper.toEntityCreateGrimoire(createGrimoireDto);
        grimoireRepository.save(grimoire);
        return grimoireMapper.toDto(grimoire);
    }

    @PutMapping("/{id}")
    public GrimoireDto Put(@PathVariable Integer id, @RequestBody GrimoireDto newGrimoireDto){
        Grimoire grimoire = grimoireRepository.findById(id).orElseThrow(() -> new RuntimeException("Grimoire not found!"));
        grimoireMapper.updateGrimoireFromDto(newGrimoireDto, grimoire);
        grimoireRepository.save(grimoire);

        return grimoireMapper.toDto(grimoire);
    }

    @DeleteMapping("/{id}")
    public GrimoireDto Delete(@PathVariable Integer id){
        Grimoire grimoire = grimoireRepository.findById(id).orElseThrow(() -> new RuntimeException("Grimoire not found!"));
        grimoireRepository.delete(grimoire);

        return grimoireMapper.toDto(grimoire);
    }
}

