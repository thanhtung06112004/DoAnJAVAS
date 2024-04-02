package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class DoAn {
    private String ten;
    private double gia;
    private int soLuong;

    private static ArrayList<DoAn> danhSachVatTu = new ArrayList<>();
    private static ArrayList<ThongTinKhachHang> danhSachKhachHang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        while (true) {
            hienThiMenu();
            System.out.println("                                   ");

            System.out.print(" Chọn chức năng bạn muốn thực hiện: ");

            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    themVatTu();
                    break;
                case 2:
                    timKiemVatTu();
                    break;
                case 3:
                    xoaVatTu();
                    break;
                case 4:
                    suaThongTinVatTu();
                    break;
                case 5:
                    hienThiDanhSachVatTu();
                    break;
                case 6:
                    sapXepVatTuTheoGia();
                    break;
                case 7:
                    thongKeVatTu();
                    break;
                case 8:
                    baoCaoVatTu();
                    break;
                case 9:
                    timKiemVatTuTheoGia();
                    break;
                case 10:
                    locVatTuTheoTen();
                    break;
                case 11:
                    nhapThongTinKhachHang();
                    break;
                case 12:
                    hienThiDanhSachKhachHang();
                    break;
                case 13:
                    System.out.println("Thoát chương trình. Cảm ơn bạn đã sử dụng!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
            }
        }
    }

    private static void hienThiMenu() {
        System.out.println("||========     QUẢN LÍ SHOP VẬT TƯ    ========||");
        System.out.println("||                                            ||");
        System.out.println("|| 1.    Nhập thông tin vật tư                ||");
        System.out.println("|| 2.    Tìm kiếm thông tin vật tư            ||");
        System.out.println("|| 3.    Xóa vật tư                           ||");
        System.out.println("|| 4.    Sửa thông tin vật tư                 ||");
        System.out.println("|| 5.    Hiển thị danh sách các vật tư        ||");
        System.out.println("|| 6.    Sắp xếp vật tư theo giá              ||");
        System.out.println("|| 7.    Thống kê số lượng và giá trị vật tư  ||");
        System.out.println("|| 8.    Báo cáo tổng quan về vật tư          ||");
        System.out.println("|| 9.    Tìm kiếm vật tư theo giá             ||");
        System.out.println("|| 10.   Lọc vật tư theo tên                  ||");
        System.out.println("|| 11.   Nhập thông tin khách hàng             ||");
        System.out.println("|| 12.   Hiển thị danh sách khách hàng        ||");
        System.out.println("|| 13.   Thoát chương trình                   ||");
        System.out.println("||                                            ||");
        System.out.println("||============================================||");
    }

    private static void themVatTu() {
        System.out.println("===== Nhập thông tin vật tư =====");
        System.out.print("Nhập tên vật tư: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập giá vật tư: ");
        double gia = scanner.nextDouble();
        System.out.print("Nhập số lượng vật tư: ");
        int soLuong = scanner.nextInt();

        DoAn vatTu = new DoAn();
        vatTu.setTen(ten);
        vatTu.setGia(gia);
        vatTu.setSoLuong(soLuong);

        danhSachVatTu.add(vatTu);
        System.out.println("Thêm vật tư thành công!");
    }

    private static void timKiemVatTu() {
        System.out.println("===== Tìm kiếm thông tin vật tư =====");
        System.out.println("+-----------------------+---------+----------+");
        System.out.println("| Tên vật tư            |   Giá   | Số lượng |");
        System.out.println("+-----------------------+---------+----------+");

        System.out.print("Nhập tên vật tư cần tìm: ");
        String ten = scanner.nextLine();

        boolean timThay = false;

        for (DoAn vatTu : danhSachVatTu) {
            if (vatTu.getTen().equalsIgnoreCase(ten)) {
                System.out.println(vatTu);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy vật tư!");
        }
    }

    private static void xoaVatTu() {
        System.out.println("===== Xóa vật tư ra khỏi danh sách =====");
        System.out.print("Nhập tên vật tư cần xóa: ");
        String ten = scanner.nextLine();

        Iterator<DoAn> iterator = danhSachVatTu.iterator();
        boolean timThay = false;

        while (iterator.hasNext()) {
            DoAn vatTu = iterator.next();
            if (vatTu.getTen().equalsIgnoreCase(ten)) {
                iterator.remove();
                timThay = true;
            }
        }

        if (timThay) {
            System.out.println("Xóa vật tư thành công!");
        } else {
            System.out.println("Không tìm thấy vật tư!");
        }
    }

    private static void suaThongTinVatTu() {
        System.out.println("===== Sửa thông tin vật tư =====");
        System.out.print("Nhập tên vật tư cần sửa: ");
        String ten = scanner.nextLine();

        boolean timThay = false;

        for (DoAn vatTu : danhSachVatTu) {
            if (vatTu.getTen().equalsIgnoreCase(ten)) {
                System.out.print("Nhập mới tên vật tư: ");
                String newTen = scanner.nextLine();
                System.out.print("Nhập mới giá vật tư: ");
                double newGia = scanner.nextDouble();
                System.out.print("Nhập mới số lượng vật tư: ");
                int newSoLuong = scanner.nextInt();

                vatTu.setTen(newTen);
                vatTu.setGia(newGia);
                vatTu.setSoLuong(newSoLuong);

                timThay = true;
                break;
            }
        }

        if (timThay) {
            System.out.println("Sửa thông tin vật tư thành công!");
        } else {
            System.out.println("Không tìm thấy vật tư!");
        }
    }

    private static void sapXepVatTuTheoGia() {
        Collections.sort(danhSachVatTu, Comparator.comparingDouble(DoAn::getGia));

        System.out.println("Danh sách vật tư sau khi sắp xếp theo giá tăng dần: ");
        hienThiDanhSachVatTu();
    }

    private static void hienThiDanhSachVatTu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("| Tên vật tư             |   Giá    | Số lượng |");
        System.out.println("+------------------------+----------+-----------+");

        for (DoAn vatTu : danhSachVatTu) {
            System.out.println(vatTu);
        }

        System.out.println("+-----------------------+---------+----------+");
    }

    private static void thongKeVatTu() {
        int tongSoLuong = 0;
        double tongGiaTri = 0;

        for (DoAn vatTu : danhSachVatTu) {
            tongSoLuong += vatTu.getSoLuong();
            tongGiaTri += vatTu.getGia() * vatTu.getSoLuong();
        }

        System.out.println("===== Thống kê số lượng và giá trị vật tư =====");
        System.out.println("Tổng số lượng vật tư: " + tongSoLuong);
        System.out.println("Tổng giá trị các vật tư: " + tongGiaTri);
    }

    private static void baoCaoVatTu() {
        System.out.println("===== Báo cáo tổng quan về vật tư =====");
        System.out.println("Số lượng vật tư có sẵn: " + danhSachVatTu.size());

        double tongGiaTri = 0;
        for (DoAn vatTu : danhSachVatTu) {
            tongGiaTri += vatTu.getGia() * vatTu.getSoLuong();
        }
        System.out.println("Tổng giá trị các vật tư: " + tongGiaTri);
    }

    private static void timKiemVatTuTheoGia() {
        System.out.println("===== Tìm kiếm vật tư theo giá =====");
        System.out.print("Nhập giá vật tư cần tìm: ");
        double gia = scanner.nextDouble();

        boolean timThay = false;

        for (DoAn vatTu : danhSachVatTu) {
            if (vatTu.getGia() == gia) {
                System.out.println(vatTu);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy vật tư!");
        }
    }

    private static void locVatTuTheoTen() {
        System.out.println("===== Lọc vật tư theo tên =====");
        System.out.print("Nhập tên vật tư cần lọc: ");
        String ten = scanner.nextLine();

        System.out.println("Các vật tư có tên chứa '" + ten + "':");

        for (DoAn vatTu : danhSachVatTu) {
            if (vatTu.getTen().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println(vatTu);
            }
        }
    }

    private static void nhapThongTinKhachHang() {
        System.out.println("===== Nhập thông tin khách hàng =====");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên khách hàng: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhập số điện thoại khách hàng: ");
        String soDienThoai = scanner.nextLine();

        // Nhập thông tin về sản phẩm mà khách hàng đã mua
        ArrayList<DoAn> sanPhamDaMua = new ArrayList<>();
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.print("Nhập tên sản phẩm đã mua: ");
            String tenSanPham = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm đã mua: ");
            double giaSanPham = scanner.nextDouble();
            System.out.print("Nhập số lượng sản phẩm đã mua: ");
            int soLuongSanPham = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự '\n'

            DoAn spMua = new DoAn();
            spMua.setTen(tenSanPham);
            spMua.setGia(giaSanPham);
            spMua.setSoLuong(soLuongSanPham);

            sanPhamDaMua.add(spMua);

            System.out.print("Bạn có muốn nhập thông tin về sản phẩm khác? (Y/N): ");
            String luaChon = scanner.nextLine();
            tiepTuc = luaChon.equalsIgnoreCase("Y");
        }

        ThongTinKhachHang khachHang = new ThongTinKhachHang(ten, diaChi, soDienThoai, sanPhamDaMua);
        danhSachKhachHang.add(khachHang);
        System.out.println("Thêm thông tin khách hàng thành công!");
    }

    private static void hienThiDanhSachKhachHang() {
        System.out.println("===== Danh sách khách hàng =====");
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("Danh sách khách hàng trống!");
        } else {
            System.out.println("+-------------------------+----------------------+------------------------+-------------------------------------+");
            System.out.println("|   Tên khách hàng       |     Địa chỉ          |  Số điện thoại         |        Sản phẩm đã mua            |");
            System.out.println("+-------------------------+----------------------+------------------------+-------------------------------------+");
            for (ThongTinKhachHang khachHang : danhSachKhachHang) {
                System.out.printf("| %-23s | %-20s | %-22s | %s\n",
                        khachHang.getTen(),
                        khachHang.getDiaChi(),
                        khachHang.getSoDienThoai(),
                        khachHang.sanPhamDaMuaToString());
            }
            System.out.println("+-------------------------+----------------------+------------------------+-------------------------------------+");
        }
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        String formatString = "| %-21s | %7.2f | %8d |\n";
        return String.format(formatString, ten, gia, soLuong);
    }

    public static void main(String[] args) {
        DoAn.menu();
    }
}

class ThongTinKhachHang {
    private String ten;
    private String diaChi;
    private String soDienThoai;
    private ArrayList<DoAn> sanPhamDaMua;

    public ThongTinKhachHang(String ten, String diaChi, String soDienThoai, ArrayList<DoAn> sanPhamDaMua) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.sanPhamDaMua = sanPhamDaMua;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String sanPhamDaMuaToString() {
        StringBuilder sb = new StringBuilder();
        for (DoAn sp : sanPhamDaMua) {
            sb.append(sp.getTen()).append(": ").append(sp.getGia()).append(" VND, ");
        }
        return sb.toString();
    }
}
