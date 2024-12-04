import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MenuGUI {

    private static final String URL = "jdbc:mysql://localhost:3306/menu";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        frame.add(new JScrollPane(menuPanel));

        loadMenuFromDatabase(menuPanel);

        frame.setSize(400, 600);
        frame.setVisible(true);
    }

    private static void loadMenuFromDatabase(JPanel menuPanel) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM menus";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nama = rs.getString("nama");
                int harga = rs.getInt("harga");
                String bahan = rs.getString("bahan");
                String pathGambar = rs.getString("pathGambar");
                String kategori = rs.getString("kategori");

                JPanel menuItemPanel = new JPanel();
                menuItemPanel.setLayout(new FlowLayout());

                JLabel label = new JLabel(nama + " - Rp. " + harga);
                menuItemPanel.add(label);

                String[] gambarPaths = pathGambar.split(",");

                for (String gambarPath : gambarPaths) {
                    ImageIcon icon = new ImageIcon(gambarPath);
                    Image image = icon.getImage();
                    Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(resizedImage);
                    JLabel imageLabel = new JLabel(icon);
                    menuItemPanel.add(imageLabel);
                }

                menuPanel.add(menuItemPanel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
