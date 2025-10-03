-- Bật extension cho UUID
CREATE EXTENSION
IF NOT EXISTS pgcrypto;

-- =====================================================
-- ENUM TYPES
-- =====================================================
CREATE TYPE gioi_tinh_enum AS ENUM
('Nam', 'Nữ', 'Khác');
CREATE TYPE thu_enum AS ENUM
('Thứ 2','Thứ 3','Thứ 4','Thứ 5','Thứ 6','Thứ 7','Chủ Nhật');
CREATE TYPE hocphi_enum AS ENUM
('CHUA_THANH_TOAN','DA_THANH_TOAN','QUA_HAN');
CREATE TYPE hoclai_enum AS ENUM
('CHO_XET_DUYET','DA_DUYET','DA_HUY');
CREATE TYPE baiviet_enum AS ENUM
('CONG_KHAI','RIENG_TU','NHAP');

-- =====================================================
-- USERS / ROLES / PERMISSIONS
-- =====================================================
CREATE TABLE users
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    username varchar(30) UNIQUE NOT NULL,
    password varchar(72) NOT NULL,
    first_name varchar(30),
    last_name varchar(30),
    date_of_birth date
);

CREATE TABLE roles
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_role varchar(30) UNIQUE NOT NULL,
    description varchar(255)
);

CREATE TABLE permissions
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_permission varchar(30) UNIQUE NOT NULL,
    description varchar(255)
);

CREATE TABLE users_roles
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id uuid NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    role_id uuid NOT NULL REFERENCES roles(id) ON DELETE CASCADE,
    CONSTRAINT uq_users_roles UNIQUE (user_id, role_id)
);

CREATE TABLE roles_permissions
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    role_id uuid NOT NULL REFERENCES roles(id) ON DELETE CASCADE,
    permission_id uuid NOT NULL REFERENCES permissions(id) ON DELETE CASCADE,
    CONSTRAINT uq_roles_permissions UNIQUE (role_id, permission_id)
);

-- =====================================================
-- TRƯỜNG / KHOA / NGÀNH
-- =====================================================
CREATE TABLE truongs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_truong varchar(10) UNIQUE NOT NULL,
    ten_truong varchar(100),
    dia_chi varchar(255),
    so_dien_thoai varchar(20),
    email varchar(100),
    website varchar(100),
    mo_ta text,
    logo_url varchar(255),
    ngay_thanh_lap date,
    nguoi_dai_dien varchar(100)
);

CREATE TABLE khoas
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_khoa varchar(10) UNIQUE NOT NULL,
    ten_khoa varchar(100),
    truong_id uuid NOT NULL REFERENCES truongs(id) ON DELETE CASCADE
);

CREATE TABLE nganhs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_nganh varchar(10) UNIQUE NOT NULL,
    ten_nganh varchar(100),
    khoa_id uuid NOT NULL REFERENCES khoas(id) ON DELETE CASCADE
);

-- =====================================================
-- SINH VIÊN
-- =====================================================
CREATE TABLE sinhviens
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_sinh_vien varchar(10) UNIQUE NOT NULL,
    ho_ten varchar(50),
    email varchar(50) UNIQUE,
    so_dien_thoai varchar(10) UNIQUE,
    ngay_nhap_hoc date,
    ngay_tot_nghiep date,
    nganh_id uuid NOT NULL REFERENCES nganhs(id) ON DELETE CASCADE,
    user_id uuid UNIQUE NOT NULL REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE chitietsinhviens
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    dia_chi varchar(100),
    ngay_sinh date,
    gioi_tinh gioi_tinh_enum,
    quoc_tich varchar(50) DEFAULT 'Viet Nam',
    cccd varchar(12) UNIQUE,
    sdt_nguoi_than varchar(10),
    sinhvien_id uuid NOT NULL REFERENCES sinhviens(id) ON DELETE CASCADE
);

-- =====================================================
-- NHÂN SỰ
-- =====================================================
CREATE TABLE vitris
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_vi_tri varchar(10) UNIQUE NOT NULL,
    ten_vi_tri varchar(50) NOT NULL,
    mo_ta varchar(255),
    muc_luong_co_ban numeric(12,2) CHECK (muc_luong_co_ban >= 0)
);

CREATE TABLE nhanviens
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ho_ten varchar(50),
    email varchar(50) UNIQUE,
    so_dien_thoai varchar(10) UNIQUE,
    ngay_vao_lam date,
    ngay_nghi_viec date,
    vitri_id uuid NOT NULL REFERENCES vitris(id),
    user_id uuid UNIQUE NOT NULL REFERENCES users(id) ON DELETE CASCADE
);

-- =====================================================
-- MÔN HỌC & TÍN CHỈ
-- =====================================================
CREATE TABLE monhocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_mon_hoc varchar(10) UNIQUE NOT NULL,
    ten_mon_hoc varchar(50),
    mo_ta varchar(255),
    tong_so_tin_chi int CHECK (tong_so_tin_chi >= 0)
);

CREATE TABLE loaitinchi
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_loai_tin_chi varchar(10) UNIQUE NOT NULL,
    ten_loai_tin_chi varchar(50) NOT NULL
);

CREATE TABLE tinchi
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    so_tin_chi int NOT NULL CHECK (so_tin_chi > 0),
    gia_tri_tin_chi numeric(10,2) NOT NULL CHECK (gia_tri_tin_chi >= 0),
    ten_tin_chi varchar(50) NOT NULL,
    loaitinchi_id uuid REFERENCES loaitinchi(id),
    monhoc_id uuid REFERENCES monhocs(id)
);

CREATE TABLE monhoc_tienquyet
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    monhoc_id uuid NOT NULL REFERENCES monhocs(id) ON DELETE CASCADE,
    monhoc_tienquyet_id uuid NOT NULL REFERENCES monhocs(id) ON DELETE CASCADE,
    CONSTRAINT uq_monhoc_tienquyet UNIQUE (monhoc_id, monhoc_tienquyet_id),
    CONSTRAINT chk_monhoc_tienquyet_self CHECK (monhoc_id <> monhoc_tienquyet_id)
);

-- =====================================================
-- KỲ HỌC / PHÒNG HỌC / LỊCH HỌC
-- =====================================================
CREATE TABLE kihocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_ki_hoc varchar(10) UNIQUE NOT NULL,
    ten_ki_hoc varchar(50),
    ngay_bat_dau date,
    ngay_ket_thuc date,
    CONSTRAINT chk_kihoc_date CHECK (ngay_ket_thuc IS NULL OR ngay_bat_dau IS NULL OR ngay_ket_thuc >= ngay_bat_dau)
);

CREATE TABLE phonghocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_phong_hoc varchar(10) UNIQUE NOT NULL,
    ten_phong varchar(50),
    toa_nha varchar(50),
    tang int,
    suc_chua int CHECK (suc_chua >= 0)
);

CREATE TABLE lichhocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ngay_bat_dau date,
    ngay_ket_thuc date,
    phonghoc_id uuid NOT NULL REFERENCES phonghocs(id),
    kihoc_id uuid NOT NULL REFERENCES kihocs(id),
    monhoc_id uuid NOT NULL REFERENCES monhocs(id),
    CONSTRAINT chk_lichhoc_date CHECK (ngay_ket_thuc IS NULL OR ngay_bat_dau IS NULL OR ngay_ket_thuc >= ngay_bat_dau)
);

CREATE TABLE dangky_lichhoc
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    lichhoc_id uuid NOT NULL REFERENCES lichhocs(id) ON DELETE CASCADE,
    sinhvien_id uuid NOT NULL REFERENCES sinhviens(id) ON DELETE CASCADE,
    CONSTRAINT uq_dangky_lichhoc UNIQUE (lichhoc_id, sinhvien_id)
);

-- =====================================================
-- GIỜ HỌC / BUỔI HỌC
-- =====================================================
CREATE TABLE giohocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_gio_hoc varchar(10) UNIQUE NOT NULL,
    ten_gio_hoc varchar(50),
    thoi_gian_bat_dau time,
    thoi_gian_ket_thuc time,
    CONSTRAINT chk_giohoc_time CHECK (thoi_gian_bat_dau IS NULL OR thoi_gian_ket_thuc IS NULL OR thoi_gian_ket_thuc > thoi_gian_bat_dau)
);

CREATE TABLE buoihocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ngay_hoc date,
    thu_trong_tuan thu_enum,
    giohoc_id uuid REFERENCES giohocs(id),
    lichhoc_id uuid REFERENCES lichhocs(id)
);

-- =====================================================
-- HỌC PHÍ / HỌC LẠI
-- =====================================================
CREATE TABLE hocphis
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    sinhvien_id uuid NOT NULL REFERENCES sinhviens(id),
    kihoc_id uuid NOT NULL REFERENCES kihocs(id),
    so_tien numeric(12,2) NOT NULL CHECK (so_tien >= 0),
    gia_tri_tin_chi numeric(10,2) CHECK (gia_tri_tin_chi >= 0),
    ngay_tao date,
    han_thanh_toan date,
    ngay_thanh_toan date,
    trang_thai hocphi_enum,
    ghi_chu varchar(255),
    CONSTRAINT uq_hocphis UNIQUE (sinhvien_id, kihoc_id),
    CONSTRAINT chk_hocphi_date CHECK (han_thanh_toan IS NULL OR ngay_tao IS NULL OR han_thanh_toan >= ngay_tao)
);

CREATE TABLE hoclais
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    sinhvien_id uuid NOT NULL REFERENCES sinhviens(id),
    monhoc_id uuid NOT NULL REFERENCES monhocs(id),
    kihoc_id uuid NOT NULL REFERENCES kihocs(id),
    lan_hoc int,
    diem_cu numeric(3,1),
    ly_do varchar(255),
    trang_thai hoclai_enum,
    lichhoc_id uuid REFERENCES lichhocs(id),
    CONSTRAINT uq_hoclais UNIQUE (sinhvien_id, monhoc_id, kihoc_id)
);

-- =====================================================
-- BÀI VIẾT / KẾT QUẢ HỌC TẬP
-- =====================================================
CREATE TABLE baiviets
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    tieu_de varchar(255) NOT NULL,
    noi_dung text NOT NULL,
    loai_bai_viet varchar(50),
    ngay_dang date DEFAULT CURRENT_DATE,
    tac_gia varchar(100),
    trang_thai baiviet_enum DEFAULT 'CONG_KHAI',
    hinh_anh_url varchar(255),
    file_dinh_kem_url varchar(255),
    user_id uuid REFERENCES users(id) ON DELETE SET NULL
);

CREATE TABLE ketquahoctaps
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    sinhvien_id uuid NOT NULL REFERENCES sinhviens(id) ON DELETE CASCADE,
    monhoc_id uuid NOT NULL REFERENCES monhocs(id) ON DELETE CASCADE,
    kihoc_id uuid NOT NULL REFERENCES kihocs(id) ON DELETE CASCADE,
    diem numeric(3,1) CHECK (diem >= 0 AND diem <= 10),
    danh_gia varchar(50),
    ghi_chu text,
    ngay_cap_nhat date DEFAULT CURRENT_DATE,
    CONSTRAINT uq_ketquahoctaps UNIQUE (sinhvien_id, monhoc_id, kihoc_id)
);

-- =====================================================
-- INDEXES
-- =====================================================
CREATE INDEX idx_khoas_truong ON khoas(truong_id);
CREATE INDEX idx_nganhs_khoa ON nganhs(khoa_id);
CREATE INDEX idx_sinhviens_nganh ON sinhviens(nganh_id);
CREATE INDEX idx_lichhocs_monhoc ON lichhocs(monhoc_id);
CREATE INDEX idx_lichhocs_kihoc ON lichhocs(kihoc_id);
CREATE INDEX idx_lichhocs_phonghoc ON lichhocs(phonghoc_id);
CREATE INDEX idx_buoihocs_lichhoc ON buoihocs(lichhoc_id);

CREATE INDEX idx_sinhviens_email ON sinhviens(email);
CREATE INDEX idx_sinhviens_sdt ON sinhviens(so_dien_thoai);
CREATE INDEX idx_sinhviens_ma ON sinhviens(ma_sinh_vien);
CREATE INDEX idx_sinhviens_user_id ON sinhviens(user_id);

CREATE INDEX idx_nhanviens_email ON nhanviens(email);
CREATE INDEX idx_nhanviens_sdt ON nhanviens(so_dien_thoai);

CREATE INDEX idx_monhocs_ma ON monhocs(ma_mon_hoc);

CREATE INDEX idx_users_username ON users(username);
