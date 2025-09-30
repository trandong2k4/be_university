-- =====================================================
-- TRƯỜNG / KHOA / NGÀNH
-- =====================================================
INSERT INTO truongs
    (ma_truong, ten_truong)
VALUES
    ('T01', 'Đại học ABC'),
    ('T02', 'Đại học XYZ'),
    ('T03', 'Đại học DEF'),
    ('T04', 'Đại học GHI'),
    ('T05', 'Đại học JKL'),
    ('T06', 'Đại học MNO'),
    ('T07', 'Đại học PQR'),
    ('T08', 'Đại học STU'),
    ('T09', 'Đại học VWX'),
    ('T10', 'Đại học YZA');

INSERT INTO khoas
    (ma_khoa, ten_khoa, truong_id)
SELECT 'K0'||i, 'Khoa '||i, id
FROM truongs
ORDER BY id LIMIT 10
FROM generate_series
(1,10) AS s
(i);

INSERT INTO nganhhocs
    (ma_nganh, ten_nganh, khoa_id)
SELECT 'N0'||i, 'Ngành '||i, id
FROM khoas
ORDER BY id LIMIT 10
FROM generate_series
(1,10) AS s
(i);

-- =====================================================
-- USERS / ROLES / PERMISSIONS
-- =====================================================
INSERT INTO users
    (username, password, first_name, last_name, date_of_birth)
VALUES
    ('user1', 'pass1'
::bytea,'Nguyen','An','2000-01-01'),
('user2','pass2'::bytea,'Tran','Binh','2001-02-02'),
('user3','pass3'::bytea,'Le','Cuong','2002-03-03'),
('user4','pass4'::bytea,'Pham','Dung','2003-04-04'),
('user5','pass5'::bytea,'Hoang','Em','2004-05-05'),
('user6','pass6'::bytea,'Vo','Giang','2000-06-06'),
('user7','pass7'::bytea,'Bui','Hanh','2001-07-07'),
('user8','pass8'::bytea,'Dang','Khai','2002-08-08'),
('user9','pass9'::bytea,'Do','Long','2003-09-09'),
('user10','pass10'::bytea,'Nguyen','Mai','2004-10-10');

INSERT INTO roles
    (ma_role, description)
VALUES
    ('ADMIN', 'Quản trị hệ thống'),
    ('GV', 'Giảng viên'),
    ('SV', 'Sinh viên'),
    ('QLSV', 'Quản lý sinh viên'),
    ('KT', 'Kế toán'),
    ('TK', 'Thư ký'),
    ('TV', 'Tư vấn'),
    ('TKH', 'Thống kê học tập'),
    ('HT', 'Học thuật'),
    ('BM', 'Bộ môn');

INSERT INTO permissions
    (ma_permission, description)
VALUES
    ('READ_USER', 'Xem thông tin user'),
    ('WRITE_USER', 'Chỉnh sửa user'),
    ('DELETE_USER', 'Xóa user'),
    ('READ_SV', 'Xem sinh viên'),
    ('WRITE_SV', 'Chỉnh sửa sinh viên'),
    ('READ_MON', 'Xem môn học'),
    ('WRITE_MON', 'Chỉnh sửa môn học'),
    ('READ_HP', 'Xem học phí'),
    ('WRITE_HP', 'Chỉnh sửa học phí'),
    ('ADMIN_ALL', 'Toàn quyền');

-- =====================================================
-- USERS_ROLES
-- =====================================================
INSERT INTO users_roles
    (user_id, role_id)
SELECT u.id, r.id
FROM users u CROSS JOIN roles r
WHERE u.username IN ('user1','user2','user3','user4','user5')
    AND r.ma_role='SV'
LIMIT 5;

-- =====================================================
-- SINH VIÊN
-- =====================================================
INSERT INTO sinhviens
    (ma_sinh_vien, ho_ten, email, so_dien_thoai, ngay_nhap_hoc, nganh_id)
SELECT 'SV00'||i, 'Sinh viên '||i, 'sv'||i||'@example.com', '090000000'||i, '2021-09-01', id
FROM nganhhocs
LIMIT
10;

INSERT INTO chitietsinhviens
    (dia_chi, ngay_sinh, gioi_tinh, cccd, sdt_nguoi_than, sinhvien_id)
SELECT 'Địa chỉ '||i, '2000-01-0'||i, CASE WHEN i%2=0 THEN 'Nam' ELSE 'Nữ' END,
    '1234567890'||i, '09000000'||i, id
FROM sinhviens
LIMIT
10;

-- =====================================================
-- NHÂN SỰ
-- =====================================================
INSERT INTO vitris
    (ma_vi_tri, ten_vi_tri, muc_luong_co_ban)
VALUES
    ('GV', 'Giảng viên', 15000000),
    ('NV', 'Nhân viên', 8000000),
    ('QL', 'Quản lý', 20000000),
    ('KT', 'Kế toán', 12000000),
    ('TK', 'Thư ký', 10000000),
    ('TV', 'Tư vấn', 9000000),
    ('BM', 'Bộ môn', 15000000),
    ('HT', 'Hiệu trưởng', 25000000),
    ('PC', 'Phó chủ nhiệm', 20000000),
    ('TL', 'Thủ thư', 8000000);

INSERT INTO nhanviens
    (ho_ten, email, so_dien_thoai, ngay_vao_lam, vitri_id)
SELECT 'Nhân viên '||i, 'nv'||i||'@example.com', '09100000'||i, '2020-01-0'||i, id
FROM vitris
LIMIT
10;

-- =====================================================
-- MÔN HỌC & LOẠI TÍN CHỈ & TÍN CHỈ
-- =====================================================
INSERT INTO monhocs
    (ma_mon_hoc, ten_mon_hoc, tong_so_tin_chi)
VALUES
    ('MH001', 'Toán A1', 3),
    ('MH002', 'Lý 1', 3),
    ('MH003', 'Hóa đại cương', 3),
    ('MH004', 'Tin học đại cương', 4),
    ('MH005', 'Triết học Mác Lênin', 2),
    ('MH006', 'Kinh tế vi mô', 3),
    ('MH007', 'Xác suất thống kê', 3),
    ('MH008', 'Cơ học', 3),
    ('MH009', 'Mạng máy tính', 4),
    ('MH010', 'Lập trình Java', 4);

INSERT INTO loaitinchi
    (ma_loai_tin_chi, ten_loai_tin_chi)
VALUES
    ('LT01', 'Lý thuyết'),
    ('TH01', 'Thực hành'),
    ('BT01', 'Bài tập'),
    ('DA01', 'Đồ án'),
    ('TT01', 'Thực tập'),
    ('LT02', 'Lý thuyết nâng cao'),
    ('TH02', 'Thực hành nâng cao'),
    ('BT02', 'Bài tập nâng cao'),
    ('DA02', 'Đồ án lớn'),
    ('NC01', 'Nghiên cứu');

INSERT INTO tinchi
    (so_tin_chi, gia_tri_tin_chi, ten_tin_chi, monhoc_id, loaitinchi_id)
SELECT 3, 3.0, 'TC '||i, m.id, l.id
FROM monhocs m CROSS JOIN loaitinchi l
LIMIT 10;

-- =====================================================
-- KỲ HỌC / PHÒNG HỌC / LỊCH HỌC / GIỜ HỌC / BUỔI HỌC
-- =====================================================
INSERT INTO kihocs
    (ma_ki_hoc, ten_ki_hoc, ngay_bat_dau, ngay_ket_thuc)
SELECT 'K0'||i, 'Kỳ học '||i, '2021-09-0'||i, '2022-01-0'||i
FROM generate_series(1,10) AS s(i);

INSERT INTO phonghocs
    (ma_phong_hoc, ten_phong, toa_nha, tang, suc_chua)
SELECT 'P0'||i, 'Phòng '||i, 'A', i%5+1, 30+i*5
FROM generate_series(1,10) AS s(i);

INSERT INTO giohocs
    (ma_gio_hoc, ten_gio_hoc, thoi_gian_bat_dau, thoi_gian_ket_thuc)
SELECT 'G0'||i, 'Giờ '||i, '08:00:00'
::time, '10:00:00'::time
FROM generate_series
(1,10) AS s
(i);

INSERT INTO lichhocs
    (ngay_bat_dau, ngay_ket_thuc, monhoc_id, phonghoc_id, kihoc_id)
SELECT '202
