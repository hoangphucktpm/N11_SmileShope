package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Entity.NhanVien;
import Entity.taiKhoan;

import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class FrmQuenMatKhau extends JFrame implements ActionListener{

	JPanel contentPane;
	private JTextField txtUserName;
	private JButton btnQuenMK;
	private JLabel lblTieuDe;
	private JTextField txtMail;
	private JButton btnQMK;
	private JTextField yourPasswordField;
	private JButton btnQuayLai;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuenMatKhau frame = new FrmQuenMatKhau();
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
	public FrmQuenMatKhau() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnQuayLai = new JButton("");
		btnQuayLai.setBackground(new Color(255, 255, 255));
		btnQuayLai.setIcon(new ImageIcon("Anh\\quaylai.png"));
		btnQuayLai.setBounds(10, 10, 85, 30);
		btnQuayLai.setBorderPainted(false);
		contentPane.add(btnQuayLai);
		
		JLabel lblUserName = new JLabel("USERNAME\r\n");
		lblUserName.setBackground(new Color(240, 240, 240));
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUserName.setBounds(449, 55, 337, 35);
		contentPane.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(449, 100, 268, 30);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblMail = new JLabel("EMAIL");
		lblMail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMail.setBounds(449, 140, 160, 35);
		contentPane.add(lblMail);
		
		btnQuenMK = new JButton("Cấp lại mật khẩu");
		btnQuenMK.setIcon(new ImageIcon("Anh\\door_1828377.png"));
		btnQuenMK.setBackground(Color.GREEN);
		btnQuenMK.setBackground(new Color(0, 255, 0));
		btnQuenMK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuenMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuenMK.setBounds(449, 248, 268, 35);
		contentPane.add(btnQuenMK);
		
		lblTieuDe = new JLabel("QUÊN MẬT KHẨU");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTieuDe.setBounds(451, 10, 325, 35);
		contentPane.add(lblTieuDe);
		
		JLabel lblHinh = new JLabel("New label");
		lblHinh.setIcon(new ImageIcon("Anh\\Anhdn.png"));
		lblHinh.setBounds(-284, -152, 689, 641);
		contentPane.add(lblHinh);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(449, 185, 268, 30);
		contentPane.add(txtMail);
		
		btnQuenMK.addActionListener(this);
		btnQuayLai.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		 if(o.equals(btnQMK)) {
			FrmQuenMatKhau frmQuenMatKhau = new FrmQuenMatKhau();
			frmQuenMatKhau.setVisible(true);
			
			this.setVisible(false);
		}
		 else if(o.equals(btnQuayLai)) {
			 FrmDangNhap frmDangNhap = new FrmDangNhap();
			 frmDangNhap.setVisible(true);
		     this.setVisible(false);
		 }
	}
	public Object validateData() {
	    String user = txtUserName.getText().trim();
	    if (user.isEmpty()) {
	        ShowErrorField("Tên đăng nhập không được rỗng", txtUserName);
	        return null;
	    }

	    String email = txtMail.getText().trim();
	    if (email.isEmpty()) {
	        ShowErrorField("Email không được rỗng", txtMail);
	        return null;
	    } else if (!isValidEmail(email)) {
	        ShowErrorField("Vui lòng nhập đúng địa chỉ email hợp lệ", txtMail);
	        return null;
	    }

	    String password = getPasswordFromYourPasswordField(); // Replace with the actual method to get the password.
	    if (password.isEmpty()) {
	        ShowErrorField("Mật khẩu không được rỗng", yourPasswordField);
	        return null;
	    } else if (!isValidPassword(password)) {
	        ShowErrorField("Vui lòng nhập mật khẩu hợp lệ", yourPasswordField);
	        return null;
	    }

	    // Nếu tất cả ràng buộc được thỏa mãn, bạn có thể trả về email hoặc mật khẩu hoặc cả hai tùy theo yêu cầu của bạn.
	    return email;
	}

	private String getPasswordFromYourPasswordField() {
		// TODO Auto-generated method stub
		return null;
	}

	private void ShowErrorField(String string, JTextField textField2) {
		// TODO Auto-generated method stub
		
	}

	private boolean isValidEmail(String email) {
	    // Sử dụng biểu thức chính quy hợp lệ để kiểm tra email.
	    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	    return email.matches(emailRegex);
	}

	private boolean isValidPassword(String password) {
	    // Thêm ràng buộc cho mật khẩu nếu cần.
	    return password.length() >= 8; // Ví dụ: Mật khẩu phải có ít nhất 8 ký tự.
	}
}
