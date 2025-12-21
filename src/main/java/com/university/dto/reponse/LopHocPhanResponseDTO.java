package com.university.dto.reponse;

import java.util.UUID;
import com.university.enums.TrangThaiLHP;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LopHocPhanResponseDTO {

    private UUID id;

    private String maLopHocPhan;

    private Integer soLuongToiDa;

    private Integer soLuongHienTai;

    private Integer soTinCHi;

    private TrangThaiLHP trangThai;

    private UUID monHocId;

    private String tenMonHoc;

    private UUID giangVienId;

    private String tenGiangVien;

    private UUID kiHocId;

    private String tenKiHoc;

}
