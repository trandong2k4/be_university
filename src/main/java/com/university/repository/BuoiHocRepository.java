package com.university.repository;

import com.university.entity.BuoiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface BuoiHocRepository extends JpaRepository<BuoiHoc, UUID> {

    @Query("SELECT b FROM BuoiHoc b WHERE LOWER(b.lichHoc.monHoc.tenMonHoc) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<BuoiHoc> searchByTenMonHoc(@Param("keyword") String keyword);

    List<BuoiHoc> findByNgayHoc(LocalDate ngayHoc);
}
