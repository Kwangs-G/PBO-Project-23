import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HalamanKeranjang {
    private Keranjang keranjang;

    public HalamanKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;

        // Membuat frame untuk tampilan Keranjang
        JFrame keranjangFrame = new JFrame("Keranjang Belanja");
        keranjangFrame.setSize(900, 700); // Ukuran frame diperbesar untuk menampung semua elemen
        keranjangFrame.setLayout(new BorderLayout());

        // Panel utama (konten) untuk keranjang
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Background Panel
        JLabel backgroundLabel = new JLabel();
        ImageIcon originalBackgroundIcon = new ImageIcon("Images/Backgorund.jpeg");
        backgroundLabel.setIcon(originalBackgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());
        mainPanel.add(backgroundLabel, BorderLayout.CENTER);

        // Panel Header
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(172, 154, 21)); // Warna header
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        headerPanel.setPreferredSize(new Dimension(keranjangFrame.getWidth(), 80));
        headerPanel.setOpaque(false); // Agar panel transparan
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Label Header
        JLabel titleLabel = new JLabel("Keranjang", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        try {
            Font irishGrover = Font.createFont(Font.TRUETYPE_FONT, new java.io.File("Images/fonts/IrishGrover.ttf")).deriveFont(47f);
            titleLabel.setFont(irishGrover.deriveFont(Font.BOLD, 47)); // Font Irish Grover
        } catch (Exception e) {
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 30)); // Font default jika gagal
            e.printStackTrace();
        }
        titleLabel.setBounds(0, 20, keranjangFrame.getWidth(), 40);
        headerPanel.add(titleLabel);

        // Panel utama untuk menampilkan item dalam keranjang
        JPanel keranjangPanel = new JPanel();
        keranjangPanel.setLayout(new BoxLayout(keranjangPanel, BoxLayout.Y_AXIS));

        // Mendapatkan daftar item yang ada di keranjang
        ArrayList<Jajan> items = keranjang.getItems();

        // Jika keranjang kosong
        if (items.isEmpty()) {
            keranjangPanel.add(new JLabel("Keranjang Anda kosong!"));
        } else {
            // Menambahkan item ke dalam panel
            for (Jajan item : items) {
                JPanel itemPanel = new JPanel(new BorderLayout());
                itemPanel.setPreferredSize(new Dimension(550, 120));

                // Menggunakan border melengkung untuk panel item
                itemPanel.setOpaque(false); // Agar panel transparan
                itemPanel.setBorder(BorderFactory.createLineBorder(new Color(172, 154, 21), 2)); // Border dengan warna header

                // Gambar item
                JLabel itemImage = new JLabel(new ImageIcon(new ImageIcon(item.getGambarPath()).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
                itemPanel.add(itemImage, BorderLayout.WEST);

                // Nama dan harga item
                JPanel textPanel = new JPanel();
                textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
                JLabel itemLabel = new JLabel(item.getNama(), SwingConstants.LEFT);
                itemLabel.setFont(new Font("Arial", Font.BOLD, 16));
                JLabel priceLabel = new JLabel("Rp " + item.getHarga(), SwingConstants.LEFT);
                priceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                priceLabel.setForeground(Color.RED); // Warna harga merah

                textPanel.add(itemLabel);
                textPanel.add(priceLabel);

                itemPanel.add(textPanel, BorderLayout.CENTER);

                // Menambahkan panel item ke keranjangPanel
                keranjangPanel.add(itemPanel);
            }

            // Menambahkan total harga
            int totalHarga = 0;
            for (Jajan item : items) {
                totalHarga += item.getHarga();
            }
            JLabel totalLabel = new JLabel("Total: Rp " + totalHarga, SwingConstants.CENTER);
            totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
            keranjangPanel.add(totalLabel);
        }

        // Panel Footer dengan tombol Checkout dan Kosongkan Keranjang
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(new Font("Arial", Font.BOLD, 14));
        checkoutButton.setBackground(new Color(172, 154, 21));
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.addActionListener(e -> {
            // Tambahkan logika checkout (misalnya ke halaman pembayaran)
            JOptionPane.showMessageDialog(keranjangFrame, "Proses Checkout sedang diproses...");
        });

        JButton clearButton = new JButton("Kosongkan Keranjang");
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setBackground(new Color(255, 75, 75));
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(e -> {
            // Kosongkan keranjang
            keranjang.clear();
            keranjangPanel.removeAll();
            keranjangPanel.add(new JLabel("Keranjang Anda kosong!"));
            keranjangPanel.revalidate();
            keranjangPanel.repaint();
            JOptionPane.showMessageDialog(keranjangFrame, "Keranjang Anda telah dikosongkan.");
        });

        footerPanel.add(checkoutButton);
        footerPanel.add(clearButton);
        keranjangPanel.add(footerPanel);

        // Menambahkan scroll panel agar bisa menggulir jika item banyak
        JScrollPane scrollPane = new JScrollPane(keranjangPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        keranjangFrame.add(mainPanel); // Menambahkan mainPanel ke frame utama
        keranjangFrame.setVisible(true);
        keranjangFrame.setLocationRelativeTo(null); // Menampilkan di tengah layar
    }
}