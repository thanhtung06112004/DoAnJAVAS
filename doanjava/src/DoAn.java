import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class VatTu {
    private String ten;
    private int soLuong;
    private double gia;

    public VatTu(String ten, int soLuong, double gia) {
        this.ten = ten;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String layTen() {
        return ten;
    }

    public int laySoLuong() {
        return soLuong;
    }

    public double layGia() {
        return gia;
    }

    public void datSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void datGia(double gia) {
        this.gia = gia;
    }
}

public class DoAn {
    private static ArrayList<VatTu> vatTus = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==========  Hệ Thống Quản Lý Vật Tư  =============");
            System.out.println("||       1. Thêm Vật Tư                        ||");
            System.out.println("||       2. Hiển Thị Danh Sách Vật Tư          ||");
            System.out.println("||       3. Tìm Kiếm Vật Tư                    ||");
            System.out.println("||       4. Xóa Vật Tư                         ||");
            System.out.println("||       5. Sắp Xếp Vật Tư theo Số Lượng       ||");
            System.out.println("||       6. Sắp Xếp Vật Tư theo Giá            ||");
            System.out.println("||       7. Thống Kê Tổng Số Lượng             ||");
            System.out.println("||       8. Thống Kê Số Lượng Theo Tên         ||");
            System.out.println("||       9. Xuất Báo Cáo                       ||");
            System.out.println("||       10. Thoát                             ||");
            System.out.println("==================================================");
            System.out.print(">> Chọn một chức năng: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine();  // Loại bỏ ký tự xuống dòng

            switch (luaChon) {
                case 1:
                    themVatTu();
                    break;
                case 2:
                    hienThiDanhSachVatTu();
                    break;
                case 3:
                    timKiemVatTu();
                    break;
                case 4:
                    xoaVatTu();
                    break;
                case 5:
                    sapXepVatTuTheoSoLuong();
                    break;
                case 6:
                    sapXepVatTuTheoGia();
                    break;
                case 7:
                    thongKeTongSoLuong();
                    break;
                case 8:
                    thongKeSoLuongTheoTen();
                    break;
                case 9:
                    xuatBaoCao();
                    break;
                case 10:
                    System.out.println("Đang thoát...");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    private static void themVatTu() {
        System.out.print("Nhập tên vật tư: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        int soLuong = scanner.nextInt();
        System.out.print("Nhập giá: ");
        double gia = scanner.nextDouble();
        scanner.nextLine();  // Loại bỏ ký tự xuống dòng
        vatTus.add(new VatTu(ten, soLuong, gia));
        System.out.println("Vật tư đã được thêm thành công.");
    }

    private static void hienThiDanhSachVatTu() {
        if (vatTus.isEmpty()) {
            System.out.println("Danh sách vật tư trống.");
            return;
        }
        System.out.println("===== Danh Sách Vật Tư =====");

        // Sắp xếp danh sách vật tư theo số lượng
        Collections.sort(vatTus, Comparator.comparingInt(VatTu::laySoLuong));

        // Hiển thị danh sách vật tư theo số lượng
        System.out.println("Vật Tư   ||   Số Lượng   ||    Giá");
        for (VatTu vatTu : vatTus) {
            System.out.println(vatTu.layTen() + "      || "  + vatTu.laySoLuong() + "      || "  + vatTu.layGia());
        }
    }

    private static void timKiemVatTu() {
        System.out.print("Nhập tên vật tư cần tìm: ");
        String ten = scanner.nextLine();
        boolean timThay = false;
        for (VatTu vatTu : vatTus) {
            if (vatTu.layTen().equalsIgnoreCase(ten)) {
                System.out.println("Vật tư được tìm thấy: " + vatTu.layTen() + ", Số lượng: " + vatTu.laySoLuong() + ", Giá: " + vatTu.layGia());
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy vật tư.");
        }
    }

    private static void xoaVatTu() {
        System.out.print("Nhập tên vật tư cần xóa: ");
        String ten = scanner.nextLine();
        boolean daXoa = false;
        for (int i = 0; i < vatTus.size(); i++) {
            if (vatTus.get(i).layTen().equalsIgnoreCase(ten)) {
                vatTus.remove(i);
                System.out.println("Vật tư đã được xóa thành công.");
                daXoa = true;
                break;
            }
        }
        if (!daXoa) {
            System.out.println("Không tìm thấy vật tư.");
        }
    }

    private static void sapXepVatTuTheoSoLuong() {
        Collections.sort(vatTus, Comparator.comparingInt(VatTu::laySoLuong));
        System.out.println("Vật tư || Số lượng || Giá");
        for (VatTu vatTu : vatTus) {
            System.out.println(vatTu.layTen() + "    || " + vatTu.laySoLuong() + "    || " + vatTu.layGia());
        }
        System.out.println("Vật tư đã được sắp xếp thành công theo số lượng.");
    }

    private static void sapXepVatTuTheoGia() {
        Collections.sort(vatTus, Comparator.comparingDouble(VatTu::layGia));
        System.out.println("Vật Tư   ||   Số Lượng   ||    Giá");
        for (VatTu vatTu : vatTus) {
        	 System.out.println(vatTu.layTen() + "      || "  + vatTu.laySoLuong() + "      || "  + vatTu.layGia());        }
        System.out.println("Vật tư đã được sắp xếp thành công theo giá từ thấp đến cao.");
    }

    private static void thongKeTongSoLuong() {
        int tongSoLuong = 0;
        for (VatTu vatTu : vatTus)
        {
            tongSoLuong += vatTu.laySoLuong();
        }
        System.out.println("Tổng số lượng vật tư : " + tongSoLuong);
    }

    private static void thongKeSoLuongTheoTen() {
        System.out.println("===== Thống Kê Số Lượng Theo Tên =====");
        for (VatTu vatTu : vatTus) {
            System.out.println(vatTu.layTen() + ": " + vatTu.laySoLuong());
        }
    }

    private static void xuatBaoCao() {
        System.out.println("===== Báo Cáo Vật Tư =====");
        System.out.println("Vật Tư   ||   Số Lượng   ||    Giá");
        for (VatTu vatTu : vatTus) {
        	 System.out.println(vatTu.layTen() + "    ||    " + vatTu.laySoLuong() + "     ||    " + vatTu.layGia());
        }
    }
}
