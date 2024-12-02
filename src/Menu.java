public class Menu {
    private String nama;
    private double harga;
    private String bahan;
    private String pathGambar;
    private String kategori;
    // ooooo

    public Menu(String nama, double harga, String bahan, String pathGambar, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.bahan = bahan;
        this.pathGambar = pathGambar;
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public double hitungHarga() {
        return this.harga;
    }

    public String getBahan() {
        return bahan;
    }

    public String getPathGambar() {
        return pathGambar;
    }

    public String getKategori() {
        return kategori;
    }
}

class Makanan extends Menu {
    public Makanan(String nama, double harga, String bahan, String pathGambar) {
        super(nama, harga, bahan, pathGambar, "Makanan");
    }
}

class Minuman extends Menu {
    public Minuman(String nama, double harga, String bahan, String pathGambar) {
        super(nama, harga, bahan, pathGambar, "Minuman");
    }
}

class Jajan extends Menu {
    public Jajan(String nama, double harga, String bahan, String pathGambar) {
        super(nama, harga, bahan, pathGambar, "Jajan");
    }
}