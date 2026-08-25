package com.exam.prog.repository;

import com.exam.prog.entity.Image;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {

  List<Image> findAll();
}
