package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FrmTroGiup extends JFrame implements ActionListener {

    private JButton btnHoTro;

    public FrmTroGiup() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1347, 843);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(129, 250, 243));
        getContentPane().setLayout(null);

        JPanel pnlTieuDe = new JPanel();
        pnlTieuDe.setBackground(new Color(0, 255, 255));
        pnlTieuDe.setBounds(0, 0, 1343, 41);
        getContentPane().add(pnlTieuDe);
        pnlTieuDe.setLayout(null);

        JLabel lblTieuDeTrang = new JLabel("TRỢ GIÚP");
        lblTieuDeTrang.setBounds(512, 12, 305, 25);
        pnlTieuDe.add(lblTieuDeTrang);
        lblTieuDeTrang.setBackground(new Color(0, 255, 255));
        lblTieuDeTrang.setHorizontalAlignment(SwingConstants.CENTER);
        lblTieuDeTrang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));

        JPanel pnlThongTin = new JPanel();
        pnlThongTin.setBackground(new Color(255, 255, 255));
        pnlThongTin.setBounds(0, 41, 1343, 802);
        getContentPane().add(pnlThongTin);
        pnlThongTin.setLayout(null);

        btnHoTro = new JButton("Hỗ Trợ");
        btnHoTro.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnHoTro.setBackground(Color.CYAN);
        btnHoTro.setBounds(536, 383, 152, 29);
        pnlThongTin.add(btnHoTro);

        btnHoTro.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHoTro) {
            try {
                URI uri = new URI("https://www.facebook.com/"); // Thay đổi URL tại đây
                Desktop.getDesktop().browse(uri);
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new FrmTroGiup();
        });
    }
}
