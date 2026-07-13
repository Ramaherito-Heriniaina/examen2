package com.exam.prog.service;

import com.exam.prog.entity.Image;
import com.exam.prog.repository.ImageRepository;
import com.exam.prog.mail.Mailer;
// import com.exam.prog.file.BucketComponent;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.UUID;

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