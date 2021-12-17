package KhoHang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Main.ThongTin;
import Quay.QuayGiaDung;
import Quay.QuayKhac;
import Quay.QuayThucPham;
import Quay.QuayTuoiSong;

public abstract class KhoHang extends ThongTin {
    public static List<QuayKhac>quaykhacList = new ArrayList<>();
    public static List<QuayGiaDung>giadungList = new ArrayList<>();
    public static List<QuayThucPham>thucphamList = new ArrayList<>();
    public static List<QuayTuoiSong>tuoisongList = new ArrayList<>();

    public String NgayNhapHang;
    public String XuatXu;
    public int SoLuong;
    public float GiaCa; //giá muốn bán
    public KhoHang(String Ten, String MaSo, String NgayNhapHang, String XuatXu, int SoLuong, float GiaCa){
        super(Ten, MaSo);
        this.NgayNhapHang = NgayNhapHang;
        this.XuatXu = XuatXu;
        this.SoLuong = SoLuong;
        this.GiaCa = GiaCa;
    }
    public String getNgayNhapHang(){
        return NgayNhapHang;
    }
    public void setNgayNhapHang(String NgayNhapHang){
        this.NgayNhapHang = NgayNhapHang;
    }
    public String getXuatXu(){
        return XuatXu;
    }
    public void setXuatXu(String XuatXu){
        this.XuatXu = XuatXu;
    }
    public int getSoLuong(){
        return SoLuong;
    }
    public void setSoLuong(int SoLuong){
        this.SoLuong = SoLuong;
    }
    public float getGiaCa(){
        return GiaCa;
    }
    public void setGiaCa(float GiaCa){
        this.GiaCa = GiaCa;
    }

    // Quay gia dung
    public static void themGiaDung(QuayGiaDung giaDung){
        giadungList.add(giaDung);
    }
    public static void xuatGiaDung(){
        for (QuayGiaDung giaDung: giadungList) {
            System.out.println(giaDung);
        }
    }

    // Quay thuc pham
    public static void themThucPham(QuayThucPham thucPham) {
        thucphamList.add(thucPham);
    }
    public static void xuatThucPham() {
        for (QuayThucPham thucPham: thucphamList) {
            System.out.println(thucPham);
        }
    }

    //Quay tuoi song
    public static void themTuoiSong(QuayTuoiSong tuoiSong) {
        tuoisongList.add(tuoiSong);
    }
    public static void xuatTuoiSong() {
        for (QuayTuoiSong tuoiSong: tuoisongList) {
            System.out.println(tuoiSong);
        }
    }

    //Quay khac
    public static void themKhac(QuayKhac khac) {
        quaykhacList.add(khac);
    }
    public static void xuatKhac() {
        for (QuayKhac khac: quaykhacList) {
            System.out.println(khac);
        }
    }

    //out put ra file
    public static void outputFile(String URL) throws IOException {
        File file = new File(URL);
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

        //in quay tuoi song
        outputStreamWriter.write("------------Quay Tuoi Song---------------\n");
        for (QuayTuoiSong tuoiSong: tuoisongList) {
            outputStreamWriter.write(String.valueOf(tuoiSong));
            outputStreamWriter.write("\n");
        }
        outputStreamWriter.flush();
        outputStreamWriter.write("\n\n------------Quay Gia Dung---------------\n");
        for (QuayGiaDung giaDung: giadungList) {
            outputStreamWriter.write(String.valueOf(giaDung));
            outputStreamWriter.write("\n");
        }
        outputStreamWriter.flush();
        outputStreamWriter.write("\n\n------------Quay Tuoi Song---------------\n");
        for (QuayThucPham thucPham: thucphamList) {
            outputStreamWriter.write(String.valueOf(thucPham));
            outputStreamWriter.write("\n");
        }

        outputStreamWriter.flush();
        outputStreamWriter.write("\n\n------------Quay Khac---------------\n");
        for (QuayKhac khac: quaykhacList) {
            outputStreamWriter.write(String.valueOf(khac));
            outputStreamWriter.write("\n");
        }
        outputStreamWriter.flush();
    }
}
