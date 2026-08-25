package com.exam.prog.endpoint.rest.controller;

import com.exam.prog.entity.Image;
import com.exam.prog.repository.ImageRepository;
import com.exam.prog.service.ImageService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class ImageController {

  private final ImageRepository repository;
  private final ImageService imageService;

  @GetMapping("/images")
  public List<Image> getAllImages() {
    return repository.findAll();
  }

  @PostMapping("/images")
  public Image uploadImage(
      @RequestParam("file") MultipartFile file, @RequestParam("email") String email)
      throws Exception {
    Image image = Image.builder().filename(file.getOriginalFilename()).email(email).build();
    Image saved = repository.save(image);
    imageService.processImage(saved.getId(), file, email);

    return saved;
  }
}
