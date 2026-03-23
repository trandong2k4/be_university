package com.university.repository;

import com.university.dto.response.TruongResponseDTO;
import com.university.entity.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TruongRepository extends JpaRepository<Truong, UUID> {

    @Query("""
            SELECT new com.university.dto.response.TruongResponseDTO(
                t.id,
                t.maTruong,
                t.tenTruong,
                t.diaChi,
                t.soDienThoai,
                t.email,
                t.website,
                t.moTa,
                t.logoUrl,
                t.ngayThanhLap,
                t.nguoiDaiDien
            )
            FROM Truong t
            """)
    List<TruongResponseDTO> findAllDTO();

    Optional<Truong> findByMaTruong(String maTruong);

    boolean existsByMaTruong(String maTruong);
}
