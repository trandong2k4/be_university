-- Bật extension cho UUID
CREATE EXTENSION
IF NOT EXISTS pgcrypto;

-- =====================================================
-- USERS / ROLES / PERMISSIONS
-- =====================================================
CREATE TABLE users
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    username varchar(30) UNIQUE NOT NULL,
    password bytea NOT NULL,
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
    user_id uuid NOT NULL,
    role_id uuid NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

CREATE TABLE roles_permissions
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    role_id uuid NOT NULL,
    permission_id uuid NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE,
    FOREIGN KEY (permission_id) REFERENCES permissions(id) ON DELETE CASCADE
);

-- =====================================================
-- TRƯỜNG / KHOA / NGÀNH
-- =====================================================
CREATE TABLE truongs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_truong varchar(5) UNIQUE NOT NULL,
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
    ma_khoa varchar(5) UNIQUE NOT NULL,
    ten_khoa varchar(100),
    truong_id uuid NOT NULL,
    FOREIGN KEY (truong_id) REFERENCES truongs(id) ON DELETE CASCADE
);

CREATE TABLE nganhhocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_nganh varchar(5) UNIQUE NOT NULL,
    ten_nganh varchar(100),
    khoa_id uuid NOT NULL,
    FOREIGN KEY (khoa_id) REFERENCES khoas(id) ON DELETE CASCADE
);

-- =====================================================
-- SINH VIÊN
-- =====================================================
CREATE TABLE sinhviens (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_sinh_vien varchar(10) UNIQUE NOT NULL,
    ho_ten varchar(50),
    email varchar(50) UNIQUE,
    so_dien_thoai varchar(10) UNIQUE,
    ngay_nhap_hoc date,
    ngay_tot_nghiep date,
    nganh_id uuid NOT NULL,
    user_id uuid UNIQUE,
    FOREIGN KEY (nganh_id) REFERENCES nganhhocs(id) ON DELETE RESTRICT,
    FOREIGN KEY
(user_id) REFERENCES users
(id) ON
DELETE
SET NULL
);

CREATE TABLE chitietsinhviens
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    dia_chi varchar(100),
    ngay_sinh date,
    gioi_tinh varchar(10),
    quoc_tich varchar(50) DEFAULT 'Viet Nam',
    cccd varchar(12) UNIQUE,
    sdt_nguoi_than varchar(10),
    sinhvien_id uuid NOT NULL,
    FOREIGN KEY (sinhvien_id) REFERENCES sinhviens(id) ON DELETE CASCADE
);

-- =====================================================
-- NHÂN SỰ
-- =====================================================
CREATE TABLE vitris
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_vi_tri varchar(5) UNIQUE NOT NULL,
    ten_vi_tri varchar(50) NOT NULL,
    mo_ta varchar(255),
    muc_luong_co_ban numeric(12,2)
);

CREATE TABLE nhanviens
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ho_ten varchar(50),
    email varchar(50) UNIQUE,
    so_dien_thoai varchar(10) UNIQUE,
    ngay_vao_lam date,
    ngay_nghi_viec date,
    vitri_id uuid,
    user_id uuid UNIQUE,
    FOREIGN KEY (vitri_id) REFERENCES vitris(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- =====================================================
-- MÔN HỌC & TÍN CHỈ
-- =====================================================
CREATE TABLE monhocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_mon_hoc varchar(5) UNIQUE NOT NULL,
    ten_mon_hoc varchar(50),
    mo_ta varchar(255),
    tong_so_tin_chi int
);

CREATE TABLE loaitinchi
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_loai_tin_chi varchar(5) UNIQUE NOT NULL,
    ten_loai_tin_chi varchar(50) NOT NULL
);

CREATE TABLE tinchi
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    so_tin_chi int NOT NULL,
    gia_tri_tin_chi numeric(10,2) NOT NULL,
    ten_tin_chi varchar(50) NOT NULL,
    loaitinchi_id uuid,
    monhoc_id uuid,
    FOREIGN KEY (loaitinchi_id) REFERENCES loaitinchi(id),
    FOREIGN KEY (monhoc_id) REFERENCES monhocs(id)
);

CREATE TABLE monhoc_tienquyet
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    monhoc_id uuid NOT NULL,
    monhoc_tienquyet_id uuid NOT NULL,
    FOREIGN KEY (monhoc_id) REFERENCES monhocs(id) ON DELETE CASCADE,
    FOREIGN KEY (monhoc_tienquyet_id) REFERENCES monhocs(id) ON DELETE CASCADE
);

-- =====================================================
-- KỲ HỌC / PHÒNG HỌC / LỊCH HỌC
-- =====================================================
CREATE TABLE kihocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_ki_hoc varchar(5) UNIQUE NOT NULL,
    ten_ki_hoc varchar(50),
    ngay_bat_dau date,
    ngay_ket_thuc date
);

CREATE TABLE phonghocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_phong_hoc varchar(5) UNIQUE NOT NULL,
    ten_phong varchar(50),
    toa_nha varchar(50),
    tang int,
    suc_chua int
);

CREATE TABLE lichhocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ngay_bat_dau date,
    ngay_ket_thuc date,
    phonghoc_id uuid,
    kihoc_id uuid,
    monhoc_id uuid,
    FOREIGN KEY (phonghoc_id) REFERENCES phonghocs(id),
    FOREIGN KEY (kihoc_id) REFERENCES kihocs(id),
    FOREIGN KEY (monhoc_id) REFERENCES monhocs(id)
);

CREATE TABLE dangky_lichhoc
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    lichhoc_id uuid NOT NULL,
    sinhvien_id uuid NOT NULL,
    FOREIGN KEY (lichhoc_id) REFERENCES lichhocs(id) ON DELETE CASCADE,
    FOREIGN KEY (sinhvien_id) REFERENCES sinhviens(id) ON DELETE CASCADE
);

-- =====================================================
-- GIỜ HỌC / BUỔI HỌC
-- =====================================================
CREATE TABLE giohocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_gio_hoc varchar(5) UNIQUE NOT NULL,
    ten_gio_hoc varchar(50),
    thoi_gian_bat_dau time,
    thoi_gian_ket_thuc time
);

CREATE TABLE buoihocs
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    thu_trong_tuan varchar(50),
    giohoc_id uuid,
    lichhoc_id uuid,
    FOREIGN KEY (giohoc_id) REFERENCES giohocs(id),
    FOREIGN KEY (lichhoc_id) REFERENCES lichhocs(id)
);

-- =====================================================
-- HỌC PHÍ / HỌC LẠI
-- =====================================================
CREATE TABLE hocphis
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    sinhvien_id uuid NOT NULL,
    kihoc_id uuid NOT NULL,
    so_tien numeric(12,2) NOT NULL,
    gia_tri_tin_chi numeric(10,2),
    ngay_tao date,
    han_thanh_toan date,
    ngay_thanh_toan date,
    trang_thai varchar(20),
    ghi_chu varchar(255),
    FOREIGN KEY (sinhvien_id) REFERENCES sinhviens(id),
    FOREIGN KEY (kihoc_id) REFERENCES kihocs(id)
);

CREATE TABLE hoclais
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    sinhvien_id uuid NOT NULL,
    monhoc_id uuid NOT NULL,
    kihoc_id uuid NOT NULL,
    lan_hoc int,
    diem_cu numeric(3,1),
    ly_do varchar(255),
    trang_thai varchar(20),
    lichhoc_id uuid,
    FOREIGN KEY (sinhvien_id) REFERENCES sinhviens(id),
    FOREIGN KEY (monhoc_id) REFERENCES monhocs(id),
    FOREIGN KEY (kihoc_id) REFERENCES kihocs(id),
    FOREIGN KEY (lichhoc_id) REFERENCES lichhocs(id)
);

-- =====================================================
-- BÀI VIẾT
-- =====================================================
CREATE TABLE baiviets
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    tieu_de varchar(255) NOT NULL,
    noi_dung text NOT NULL,
    loai_bai_viet varchar(50),
    ngay_dang date DEFAULT CURRENT_DATE,
    tac_gia varchar(100),
    trang_thai varchar(20) DEFAULT 'CONG_KHAI',
    hinh_anh_url varchar(255),
    file_dinh_kem_url varchar(255),
    user_id uuid,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);
