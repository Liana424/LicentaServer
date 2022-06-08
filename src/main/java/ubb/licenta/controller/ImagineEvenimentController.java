package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.entity.ImagineEveniment;

import ubb.licenta.service.ImagineEvenimentService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/imagineEveniment")
public class ImagineEvenimentController {
    private final ImagineEvenimentService imagineEvenimentService;

    @PostMapping()
    public Integer insert(@RequestBody ImagineEveniment imagineEveniment) {
        Integer id = imagineEvenimentService.insert(imagineEveniment);

        return id;
    }


    @GetMapping(value = "/id={id}")
    public ImagineEveniment findById(@PathVariable("id") Integer id) {
        ImagineEveniment imagineEveniment = imagineEvenimentService.findById(id);

        return imagineEveniment;
    }

    @GetMapping()
    public List<ImagineEveniment> findAll() {
        return imagineEvenimentService.findAll();
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteImagineEveniment(@PathVariable("id") Integer id) {
        imagineEvenimentService.delete(id);
    }

    @PutMapping()
    public ImagineEveniment updateImagineEveniment(@RequestBody ImagineEveniment imagineEveniment) {
        return imagineEvenimentService.update(imagineEveniment);
    }

}
