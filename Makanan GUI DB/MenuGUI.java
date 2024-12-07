import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MenuGUI {

    private static final String URL = "jdbc:mysql://localhost:3306/menu";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Makanan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Makanan", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(200, 180, 50)); // Background gold
        titleLabel.setForeground(Color.WHITE);

        JPanel menuPanel = new JPanel(new GridLayout(0, 4, 10, 10)); // 4 kolom, spasi antar elemen
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(menuPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        loadMenuFromDatabase(menuPanel);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private static void loadMenuFromDatabase(JPanel menuPanel) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM daftar";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nama = rs.getString("nama");
                int harga = rs.getInt("harga");
                String deskripsi = rs.getString("bahan"); // Deskripsi makanan
                String pathGambar = rs.getString("pathGambar");

                // Panel individu untuk setiap makanan
                JPanel menuItemPanel = new JPanel();
                menuItemPanel.setLayout(new BoxLayout(menuItemPanel, BoxLayout.Y_AXIS));
                menuItemPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                menuItemPanel.setBackground(Color.WHITE);

                // Gambar makanan
                ImageIcon icon = new ImageIcon(pathGambar);
                Image image = icon.getImage();
                Image resizedImage = image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
                JLabel imageLabel = new JLabel(new ImageIcon(resizedImage));
                imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                // Tambahkan jarak padding di atas gambar
                menuItemPanel.add(Box.createVerticalStrut(10)); // Jarak padding di atas gambar

                // Nama makanan
                JLabel nameLabel = new JLabel(nama, SwingConstants.CENTER);
                nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
                nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                // Deskripsi makanan
                JLabel descLabel = new JLabel("<html><div style='text-align:center;'>" + deskripsi + "</div></html>");
                descLabel.setFont(new Font("Serif", Font.PLAIN, 12));
                descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                descLabel.setHorizontalAlignment(SwingConstants.CENTER);

                // Panel untuk harga dan tombol tambah
                JPanel bottomPanel = new JPanel(new BorderLayout());
                bottomPanel.setOpaque(false);

                // Harga makanan (diletakkan di kiri)
                JLabel priceLabel = new JLabel("Rp. " + harga, SwingConstants.LEFT);
                priceLabel.setFont(new Font("Serif", Font.BOLD, 14));
                priceLabel.setForeground(new Color(100, 180, 100)); // Warna hijau

                // Membuat tombol tambah menggunakan ImageIcon untuk ikon plus
                JButton addButton = new JButton();
                ImageIcon plusIcon = new ImageIcon("Images/icon/plus.png"); // Ganti path sesuai dengan lokasi ikon Anda
                addButton.setIcon(new ImageIcon(plusIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

                // Pengaturan tampilan tombol
                addButton.setOpaque(false); // Tombol tanpa background
                addButton.setContentAreaFilled(false); // Menghilangkan area konten yang terisi
                addButton.setBorderPainted(false); // Menghilangkan border tombol
                addButton.setFocusPainted(false); // Menghilangkan efek saat tombol dipilih
                addButton.setAlignmentX(Component.RIGHT_ALIGNMENT); // Penempatan tombol di kanan bawah

                // Menambahkan elemen-elemen ke bottomPanel
                bottomPanel.add(priceLabel, BorderLayout.WEST);
                bottomPanel.add(addButton, BorderLayout.EAST);

                // Menambahkan elemen-elemen lainnya ke menuItemPanel
                menuItemPanel.add(imageLabel);
                menuItemPanel.add(nameLabel);
                menuItemPanel.add(descLabel);
                menuItemPanel.add(bottomPanel);

                // Tambahkan panel makanan ke menuPanel utama
                menuPanel.add(menuItemPanel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
