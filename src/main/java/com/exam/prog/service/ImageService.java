package com.exam.prog.service;

import com.exam.prog.mail.Mailer;
// import com.exam.prog.file.BucketComponent;
import com.exam.prog.repository.ImageRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class ImageService {
  private final ImageRepository repository;
  private final Mailer mailer;

  // private final BucketComponent bucketComponent;

  @Async
  public void processImage(UUID imageId, MultipartFile file, String email) throws Exception {

    System.out.println("Image traitée : " + imageId);

    mailer.send(email, "Votre image", "Image traitée avec succès");
  }
}
