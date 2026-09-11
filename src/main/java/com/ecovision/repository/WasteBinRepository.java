package com.ecovision.repository;

import com.ecovision.model.WasteBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WasteBinRepository extends JpaRepository<WasteBin, Long> {
    List<WasteBin> findByStatus(String status);
}