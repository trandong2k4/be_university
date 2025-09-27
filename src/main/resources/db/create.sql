
-- USERS / ROLES / PERMISSIONS

CREATE TABLE users
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    username char(30) UNIQUE NOT NULL,
    -- Tên đăng nhập cố định 30 ký tự
    password bytea NOT NULL,
    -- Mật khẩu mã hóa
    first_name varchar(30),
    last_name varchar(30),
    date_of_birth date
);

CREATE TABLE roles
(
    name char(30) PRIMARY KEY DEFAULT gen_random_uuid(),
    -- Tên role ngắn, ví dụ: ADMIN, STUDENT
    description varchar(255)
);

CREATE TABLE permissions
(
    name char(30) PRIMARY KEY DEFAULT gen_random_uuid(),
    -- Tên permission ngắn, ví dụ: VIEW_USER
    description varchar(255)
);

CREATE TABLE users_roles
(
    user_id uuid NOT NULL DEFAULT gen_random_uuid(),
    role_name char(30) NOT NULL,
    PRIMARY KEY (user_id, role_name),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_name) REFERENCES roles(name) ON DELETE CASCADE
);

CREATE TABLE roles_permissions
(
    role_name char(30) NOT NULL DEFAULT gen_random_uuid(),
    permission_name char(30) NOT NULL,
    PRIMARY KEY (role_name, permission_name),
    FOREIGN KEY (role_name) REFERENCES roles(name) ON DELETE CASCADE,
    FOREIGN KEY (permission_name) REFERENCES permissions(name) ON DELETE CASCADE
);

-- ============================================
-- SINH VIÊN
-- ============================================
CREATE TABLE sinhviens
(
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_sinh_vien char(10) NOT NULL UNIQUE,
    ho_ten varchar(50),
    email varchar(50) UNIQUE,
    so_dien_thoai varchar(10) UNIQUE,
    ngay_nhap_hoc date,
    ngay_tot_nghiep date
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
    ma_sinh_vien char(10) NOT NULL,
    FOREIGN KEY (ma_sinh_vien) REFERENCES sinhviens(ma_sinh_vien)
);

-- ============================================
-- MÔN HỌC & TÍN CHỈ
-- ============================================
CREATE TABLE monhocs
(
    ma_mon_hoc char(5) NOT NULL PRIMARY KEY,
    -- Ví dụ: CS101, MTH01
    ten_mon_hoc varchar(50),
    mo_ta varchar(255),
    tong_so_tin_chi int,
    ma_mon_hoc_tien_quyet char(5) NULL,
    -- Môn tiên quyết
    FOREIGN KEY (ma_mon_hoc_tien_quyet) REFERENCES monhocs(ma_mon_hoc)
);

CREATE TABLE loaitinchi
(
    ma_loai_tin_chi char(5) PRIMARY KEY,
    -- Ví dụ: LT, TH
    ten_loai_tin_chi varchar(50) NOT NULL
);

CREATE TABLE tinchi
(
    ma_tin_chi uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    so_tin_chi int NOT NULL,
    gia_tri_tin_chi numeric(10,2) NOT NULL,
    ma_loai_tin_chi char(5),
    ma_mon_hoc char(5),
    ten_tin_chi varchar(50) NOT NULL,
    FOREIGN KEY (ma_loai_tin_chi) REFERENCES loaitinchi(ma_loai_tin_chi),
    FOREIGN KEY (ma_mon_hoc) REFERENCES monhocs(ma_mon_hoc)
);

-- ============================================
-- KỲ HỌC / PHÒNG HỌC / LỊCH HỌC
-- ============================================
CREATE TABLE kihocs
(
    ma_ki_hoc char(5) PRIMARY KEY,
    -- Ví dụ: HK01, HK02
    ten_ki_hoc varchar(50),
    ngay_bat_dau date,
    ngay_ket_thuc date
);

CREATE TABLE phonghocs
(
    ma_phong_hoc char(5) PRIMARY KEY,
    -- Ví dụ: A101, B202
    ten_phong varchar(50),
    toa_nha varchar(50),
    tang int,
    suc_chua int
);

CREATE TABLE lichhocs
(
    ma_lich_hoc uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ngay_bat_dau date,
    ngay_ket_thuc date,
    ma_phong_hoc char(5),
    ma_ki_hoc char(5),
    ma_mon_hoc char(5),
    FOREIGN KEY (ma_phong_hoc) REFERENCES phonghocs(ma_phong_hoc),
    FOREIGN KEY (ma_ki_hoc) REFERENCES kihocs(ma_ki_hoc),
    FOREIGN KEY (ma_mon_hoc) REFERENCES monhocs(ma_mon_hoc)
);

CREATE TABLE dangky_lichhoc
(
    ma_lich_hoc uuid,
    ma_sinh_vien char(10),
    PRIMARY KEY (ma_lich_hoc, ma_sinh_vien),
    FOREIGN KEY (ma_lich_hoc) REFERENCES lichhocs(ma_lich_hoc),
    FOREIGN KEY (ma_sinh_vien) REFERENCES sinhviens(ma_sinh_vien)
);

-- ============================================
-- GIỜ HỌC / BUỔI HỌC
-- ============================================
CREATE TABLE giohocs
(
    ma_gio_hoc char(5) PRIMARY KEY,
    -- Ví dụ: G01, G02
    ten_gio_hoc varchar(50),
    thoi_gian_bat_dau time,
    thoi_gian_ket_thuc time
);

CREATE TABLE buoihocs
(
    ma_buoi_hoc uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    thu_trong_tuan varchar(50),
    ma_gio_hoc char(5),
    ma_lich_hoc uuid,
    FOREIGN KEY (ma_gio_hoc) REFERENCES giohocs(ma_gio_hoc),
    FOREIGN KEY (ma_lich_hoc) REFERENCES lichhocs(ma_lich_hoc)
);

-- ============================================
-- NHÂN SỰ
-- ============================================
CREATE TABLE vitris
(
    ma_vi_tri char(5) PRIMARY KEY,
    -- Ví dụ: GV, NV, QL
    ten_vi_tri varchar(50) NOT NULL,
    mo_ta varchar(255),
    muc_luong_co_ban numeric(12,2)
);

CREATE TABLE nhanviens
(
    ma_nhan_vien uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ho_ten varchar(50),
    email varchar(50) UNIQUE,
    so_dien_thoai varchar(10) UNIQUE,
    ngay_vao_lam date,
    ngay_nghi_viec date,
    ma_vi_tri char(5),
    user_id uuid UNIQUE,
    FOREIGN KEY (ma_vi_tri) REFERENCES vitris(ma_vi_tri),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- ============================================
-- HỌC PHÍ / HỌC LẠI
-- ============================================
Drop table hocphis
CREATE TABLE hocphis
(
    ma_hoc_phi uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_sinh_vien char(10) NOT NULL,
    ma_ki_hoc char(5) NOT NULL,
    so_tien numeric(12,2) NOT NULL,
    gia_tri_tin_chi numeric(10,2),
    ngay_tao date,
    han_thanh_toan date,
    ngay_thanh_toan date,
    trang_thai varchar(20),
    ghi_chu varchar(255),
    FOREIGN KEY (ma_sinh_vien) REFERENCES sinhviens(ma_sinh_vien),
    FOREIGN KEY (ma_ki_hoc) REFERENCES kihocs(ma_ki_hoc)
);

CREATE TABLE hoclais
(
    ma_hoc_lai uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    ma_sinh_vien char(10) NOT NULL,
    ma_mon_hoc char(5) NOT NULL,
    ma_ki_hoc char(5) NOT NULL,
    lan_hoc int,
    diem_cu numeric(3,1),
    ly_do varchar(255),
    trang_thai varchar(20),
    ma_lich_hoc uuid,
    FOREIGN KEY (ma_sinh_vien) REFERENCES sinhviens(ma_sinh_vien),
    FOREIGN KEY (ma_mon_hoc) REFERENCES monhocs(ma_mon_hoc),
    FOREIGN KEY (ma_ki_hoc) REFERENCES kihocs(ma_ki_hoc),
    FOREIGN KEY (ma_lich_hoc) REFERENCES lichhocs(ma_lich_hoc)
);
