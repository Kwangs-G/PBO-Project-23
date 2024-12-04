package checkout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class CheckoutGUI {

    private static JLabel backgroundLabel;
    private static JLabel titleLabel;
    private static JLabel qrCodeLabel;
    private static JButton payButton;

    public static void main(String[] args) {
        // Membuat frame utama
        JFrame frame = new JFrame("SiPeMa - Sistem Pemesanan Makanan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(null);

        // Layered Pane untuk mengatur layer
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.add(layeredPane);

        // Label Background
        backgroundLabel = new JLabel();
        ImageIcon originalBackgroundIcon = new ImageIcon("Images/Backgorund.jpeg");
        Image scaledBackgroundImage = originalBackgroundIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledBackgroundImage));
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Panel Header
        JPanel headerPanel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(172, 154, 21));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        headerPanel.setBounds(0, 0, frame.getWidth(), 80);
        layeredPane.add(headerPanel, JLayeredPane.PALETTE_LAYER);

        // Menambahkan Label Checkout dengan font kustom
        titleLabel = new JLabel("Checkout", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);

        try {
            // Memuat font kustom dari file
            Font irishGroverFont = Font.createFont(Font.TRUETYPE_FONT, new File("Images/fonts/IrishGrover.ttf")).deriveFont(47f);
            titleLabel.setFont(irishGroverFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        }

        titleLabel.setBounds(0, 20, frame.getWidth(), 40);
        headerPanel.add(titleLabel);

        // QR Code Label
        qrCodeLabel = new JLabel();
        ImageIcon qrCodeIcon = new ImageIcon("Images/QRcode.jpg");
        Image qrCodeImage = qrCodeIcon.getImage().getScaledInstance(400, 430, Image.SCALE_SMOOTH);
        qrCodeLabel.setIcon(new ImageIcon(qrCodeImage));
        qrCodeLabel.setBounds((frame.getWidth() - 400) / 2, (frame.getHeight() - 430) / 2, 400, 430);
        layeredPane.add(qrCodeLabel, JLayeredPane.PALETTE_LAYER);

        // Event untuk menyesuaikan elemen-elemen saat ukuran frame berubah
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int frameWidth = frame.getWidth();
                int frameHeight = frame.getHeight();

                // Sesuaikan ukuran background
                Image scaledBackground = originalBackgroundIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_SMOOTH);
                backgroundLabel.setIcon(new ImageIcon(scaledBackground));
                backgroundLabel.setBounds(0, 0, frameWidth, frameHeight);

                // Sesuaikan posisi "Checkout" Label
                titleLabel.setBounds(0, 20, frameWidth, 40);

                // Sesuaikan posisi QR code
                qrCodeLabel.setBounds((frameWidth - 400) / 2, (frameHeight - 430) / 2, 400, 430);
            }
        });

        // Menambahkan Tombol Bayar
        payButton = new JButton("Bayar");
        payButton.setFont(new Font("Arial", Font.BOLD, 18));
        payButton.setBounds((frame.getWidth() - 200) / 2, frame.getHeight() - 130, 200, 50);
        payButton.setBackground(new Color(255, 195, 0));
        payButton.setForeground(Color.WHITE);
        payButton.setFocusPainted(false);
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Pembayaran berhasil!", "Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        layeredPane.add(payButton, JLayeredPane.MODAL_LAYER);

        // Set visibilitas frame
        frame.setVisible(true);
    }
}
