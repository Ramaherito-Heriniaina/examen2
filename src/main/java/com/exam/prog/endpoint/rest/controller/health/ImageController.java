package com.exam.prog.endpoint.rest.controller.health;

import com.exam.prog.entity.Image;
import com.exam.prog.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@AllArgsConstructor
public class ImageController {

    private final ImageRepository repository;


    @GetMapping("/images")
    public List<Image> getAllImages() {
        return repository.findAll();
    }


    @PostMapping("/images")
    public Image uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
        Image image = Image.builder()
                .filename(file.getOriginalFilename())
                .email(email)
                .build();
        return repository.save(image);
    }
}