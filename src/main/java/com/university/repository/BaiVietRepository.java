package com.university.repository;

import com.university.entity.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BaiVietRepository extends JpaRepository<BaiViet, UUID> {

    @Query("SELECT b FROM BaiViet b WHERE LOWER(b.tieuDe) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<BaiViet> searchByTieuDe(@Param("keyword") String keyword);
}
