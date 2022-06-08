package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.entity.ImagineCazare;

import ubb.licenta.service.ImagineCazareService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/imagineCazare")
public class ImagineCazareController {
    private final ImagineCazareService imagineCazareService;

    @PostMapping()
    public Integer insert(@RequestBody ImagineCazare imagineCazare) {
        Integer id = imagineCazareService.insert(imagineCazare);

        return id;
    }


    @GetMapping(value = "/id={id}")
    public ImagineCazare findById(@PathVariable("id") Integer id) {
        ImagineCazare imagineCazare = imagineCazareService.findById(id);

        return imagineCazare;
    }

    @GetMapping()
    public List<ImagineCazare> findAll() {
        return imagineCazareService.findAll();
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteImagineCazare(@PathVariable("id") Integer id) {
        imagineCazareService.delete(id);
    }

    @PutMapping()
    public ImagineCazare updateImagineCazare(@RequestBody ImagineCazare imagineCazare) {
        return imagineCazareService.update(imagineCazare);
    }
}
