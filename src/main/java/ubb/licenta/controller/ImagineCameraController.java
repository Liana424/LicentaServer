package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.entity.ImagineCamera;

import ubb.licenta.service.ImagineCameraService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/imagineCamera")
public class ImagineCameraController {
    private final ImagineCameraService imagineCameraService;

    @PostMapping()
    public Integer insert(@RequestBody ImagineCamera imagineCamera) {
        Integer id = imagineCameraService.insert(imagineCamera);

        return id;
    }


    @GetMapping(value = "/id={id}")
    public ImagineCamera findById(@PathVariable("id") Integer id) {
        ImagineCamera imagineCamera = imagineCameraService.findById(id);

        return imagineCamera;
    }

    @GetMapping()
    public List<ImagineCamera> findAll() {
        return imagineCameraService.findAll();
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteImagineCamera(@PathVariable("id") Integer id) {
        imagineCameraService.delete(id);
    }

    @PutMapping()
    public ImagineCamera updateImagineCamera(@RequestBody ImagineCamera imagineCamera) {
        return imagineCameraService.update(imagineCamera);
    }
}
