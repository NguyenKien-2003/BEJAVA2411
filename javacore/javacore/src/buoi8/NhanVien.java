package buoi8;

public abstract class NhanVien {
    private String maSo;
    private String hoTen;
    private String soDienThoai;
    private String soNgayLamViec;
    private int luong1Ngay;
    private double cachTinhLuong;

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(String soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public int getLuong1Ngay() {
        return luong1Ngay;
    }

    public void setLuong1Ngay(int luong1Ngay) {
        this.luong1Ngay = luong1Ngay;
    }

    public double getCachTinhLuong() {
        return cachTinhLuong;
    }

    public void setCachTinhLuong(double cachTinhLuong) {
        this.cachTinhLuong = cachTinhLuong;
    }
}
