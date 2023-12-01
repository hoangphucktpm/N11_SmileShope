package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import DAO.NhanVien_Dao;
import Database.ConnectDatabase;
import Entity.taiKhoan;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop.Action;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class FrmDangNhap extends JFrame implements ActionListener{

	JPanel contentPane;
	private JTextField txtUserName;
	private JButton btnDangNhap;
	private JButton btnQMK;
	private JPasswordField txtPassWord;
	private JLabel lblDangNhap;

	public static  taiKhoan taiKhoan;
	private JRadioButton rdHienMK;
	private NhanVien_Dao dao = new NhanVien_Dao();
	public static boolean TrangThaiDangNhapNhanVien = false;
	public static boolean TrangThaiDangNhapQuanLy = false;
	private String tenTaiKhoanAdmin = "admin";
	private String matKhauAdmin = "12345678";
	public static String usernameToGetNhanVien="";
	private JButton btnLamMoi;
	private JLabel lblMessLoiUser;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDangNhap frame = new FrmDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("ĐĂNG NHẬP\r\n");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblTieuDe.setBounds(845, 53, 361, 112);
		contentPane.add(lblTieuDe);
		
		JLabel lblUserName = new JLabel("USERNAME\r\n");
		lblUserName.setBackground(new Color(240, 240, 240));
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUserName.setBounds(449, 55, 337, 35);
		contentPane.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(449, 87, 268, 30);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		
		JLabel lblPassWord = new JLabel("PASSWORD");
		lblPassWord.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassWord.setBounds(449, 127, 160, 35);
		contentPane.add(lblPassWord);
		
		rdHienMK = new JRadioButton("Hiện mật khẩu");
		rdHienMK.setBackground(new Color(255, 255, 255));
		rdHienMK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdHienMK.setBounds(613, 210, 167, 21);
		contentPane.add(rdHienMK);
		
		AbstractAction actionDangNhap = new AbstractAction("Đăng nhập") {
		    public void actionPerformed(ActionEvent e) {
		    }
		};

		btnDangNhap = new JButton(actionDangNhap);
		btnDangNhap.setIcon(new ImageIcon("Anh\\dangnhap.png"));
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDangNhap.setBackground(new Color(0, 255, 0));
		btnDangNhap.setBounds(449, 275, 268, 21);
		contentPane.add(btnDangNhap);

		getRootPane().setDefaultButton(btnDangNhap);

		
		btnQMK = new JButton("Quên mật khẩu ?");
		btnQMK.setIcon(new ImageIcon("Anh\\door_1828377.png"));
		btnQMK.setForeground(new Color(255, 0, 0));
		btnQMK.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnQMK.setBackground(new Color(255, 255, 255));
		btnQMK.setBounds(470, 306, 234, 21);
		btnQMK.setBorderPainted(false);
		contentPane.add(btnQMK);
		
		txtPassWord = new JPasswordField();
		txtPassWord.setBounds(449, 172, 268, 30);
		contentPane.add(txtPassWord);
		
		lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDangNhap.setBounds(483, 10, 199, 35);
		contentPane.add(lblDangNhap);
		
		JLabel lblHinh = new JLabel("New label");
		lblHinh.setIcon(new ImageIcon("Anh\\Anhdn.png"));
		lblHinh.setBounds(-284, -152, 689, 641);
		contentPane.add(lblHinh);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(new Color(0, 0, 0));
		btnLamMoi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setBounds(517, 333, 148, 20);
		btnLamMoi.setBorderPainted(false);
		contentPane.add(btnLamMoi);
		
		lblMessLoiUser = new JLabel("");
		lblMessLoiUser.setForeground(Color.RED);
		lblMessLoiUser.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMessLoiUser.setBounds(443, 237, 337, 28);
		contentPane.add(lblMessLoiUser);

		
		txtUserName.setText("NV001");
		txtPassWord.setText("12345678");
		
		
		btnDangNhap.addActionListener(this);
		btnQMK.addActionListener(this);
		btnLamMoi.addActionListener(this);
	
	   rdHienMK.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (rdHienMK.isSelected()) {
	            txtPassWord.setEchoChar((char) 0); // Hiển thị mật khẩu
	        } else {
	            txtPassWord.setEchoChar('\u25CF'); // Ẩn mật khẩu
	        }
	    }
	});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    Object o = e.getSource();
	    if (o.equals(btnDangNhap)) {

	        logIn();
	        
	    } else if (o.equals(btnQMK)) {
	        FrmQuenMatKhau frmQuenMatKhau = new FrmQuenMatKhau();
	        frmQuenMatKhau.setVisible(true);
	        this.setVisible(false);
	    } else if (o.equals(btnLamMoi)) {
	    	lammoi();
	    }
	}
	
	
	public boolean KiemTraDuLieu() {
		String username = txtUserName.getText();
		// ten dang nhap phai la chu hoac so va khong co ki tu dac biet co toi da tu 5-20 ki tu
		boolean match = username.matches("[a-zA-z0-9 ]{3,20}");
		if(match!=true) {
			lblMessLoiUser.setText("Lỗi: Tên đăng nhập phải là mã nhân viên");
			return false;
		}
		else
			return true;
	}
	
	

	public boolean kiemTraDangNhap(String username, String password) {
		taiKhoan = dao.getTK(username);
//	    System.out.println(taiKhoan);

	    if (username.equalsIgnoreCase(tenTaiKhoanAdmin) && password.equalsIgnoreCase(matKhauAdmin)) {
	        TrangThaiDangNhapNhanVien = true;
	        TrangThaiDangNhapQuanLy = true;
	        return true;
	    } else if (taiKhoan != null) {
	        String tenDangNhap = taiKhoan.getTenDangNhap();

	        if (username.equals(tenDangNhap) && password.equals(taiKhoan.getMatKhau())) {
	            if (tenDangNhap.contains("NV")) {
	                TrangThaiDangNhapNhanVien = true;
	                TrangThaiDangNhapQuanLy = false;
	                return true;
	            } else if (tenDangNhap.contains("QL")) {
	                TrangThaiDangNhapQuanLy = true;
	                TrangThaiDangNhapNhanVien = false;
	                return true;
	            }
	        }
	    }

//	    System.out.println(taiKhoan);
	    return false;
	}

	public void logIn() {
	    try {
	        if (KiemTraDuLieu()) {
	            String username = txtUserName.getText();
	            String password = new String(txtPassWord.getPassword());
//	            System.out.println(username);
//	            System.out.println(password);

	            // Kiểm tra xem tên đăng nhập có tồn tại hay không
	            if (!kiemTraDangNhap(username, password)) {
	            	if (!kiemTraDangNhap(username, password)) {
	            	    lblMessLoiUser.setText("Tên Đăng Nhập hoặc Mật Khẩu Sai.");
	            	    return;
	            	}

	                return; 
	            }
        if (TrangThaiDangNhapNhanVien && TrangThaiDangNhapQuanLy) {
	                // Vai trò: Quản lý và Nhân viên
	            	FrmManHinhChinh frmManHinhChinh = new FrmManHinhChinh(username);
	                frmManHinhChinh.setVisible(true);
	                this.setVisible(false);
	            } else if (TrangThaiDangNhapNhanVien) {
	                FrmManHinhChinh frmManHinhChinh = new FrmManHinhChinh(username);
	                frmManHinhChinh.setVisible(true);
	                this.setVisible(false);
	                frmManHinhChinh.mnNhanVien.setEnabled(false);
	            } else if (TrangThaiDangNhapQuanLy) {
	                // Vai trò: Quản lý
	                FrmManHinhChinh frmManHinhChinh = new FrmManHinhChinh(username);
	                frmManHinhChinh.mntmLapHoaDon.setEnabled(false);
	                frmManHinhChinh.setVisible(true);
	                this.setVisible(false);
	            } else {
	            	lblMessLoiUser.setText("Tên Đăng Nhập hoặc Mật Khẩu Sai.");
	            }
	        }
	    } catch (Exception e2) {
	        e2.printStackTrace();
	        // Xử lý ngoại lệ khác nếu cần thiết
	    }
	}

	public void lammoi() {
		txtUserName.setText("");
		txtPassWord.setText("");
		txtUserName.requestFocus();
	}
}
