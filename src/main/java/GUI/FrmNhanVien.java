package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Container;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Label;
import com.toedter.calendar.JDateChooser;
import java.util.Locale;
import java.util.Set;

import DAO.NhanVien_Dao;
import Entity.NhaCungCap;
import Entity.NhanVien;

import java.util.List;


public class FrmNhanVien extends JFrame implements ActionListener, MouseListener, ItemListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtMaNV;
	private JTextField textTen;
	private JTextField textSdt;
	private JTextField textCCCD;
	private JTextField textEmail;
	private JTextField txtDiaChi;
	private JPanel contentPane;
	private JLabel lblTieuDeTrang;
	private NhanVien_Dao dao = new NhanVien_Dao();
	private DefaultTableModel tablemodel;
	private JTable table_DSKH;
	private JDateChooser txtNgay;
	private JComboBox cbChucVu;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private JRadioButton rdĐangLam;
	private JRadioButton rdNghi;
	private JRadioButton rdCa2;
	private JRadioButton rdCa1;
	private JButton btnThem;
	private ButtonGroup buttonGroupTK;
	private JPanel pnlDanhSach;
	private JLabel lblThongTinTim;
	private JComboBox cbThongTinTim;
	private JLabel lblTim;
	private JRadioButton rdMaNV;
	private JRadioButton rdTenNV;
	private JRadioButton rdSDT;
	private JRadioButton rdCa;
	private JButton btnTimkiem;
	private JButton btnLamMoiThanh;
	private JRadioButton rdChuc;
	private JLabel lblGioiTinh;
	private JLabel lblCa;
	private JLabel lblTrangThai;
	private Container lblHinhAnh;
	
	private DefaultComboBoxModel cboModeChucVu=  new DefaultComboBoxModel();
	private List<String> listChucVu= new ArrayList<>();
	private DefaultComboBoxModel cboModelChucVu;
	private JComboBox comboBox;
	private JButton btnLamMoi;
	private ButtonGroup gr1;
	private ButtonGroup gr2;
	private ButtonGroup gr3;
	private ButtonGroup buttonGroupGT;
	private JButton btnSua;
	private ButtonGroup buttonGroupCLV;
	private ButtonGroup gr4;
	private Component label;
	private String folderName;
	private String filename = null;
	private JButton btnChonAnh;
	private JLabel lblKhungHinh;
	
	boolean lock = false;
	boolean chkThem = false;
	boolean chkSua = false;
	private JButton btnLuu;
	String maBanDau = "";



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhanVien frame = new FrmNhanVien();
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
	public FrmNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1347, 843);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBackground(new Color(0, 255, 255));
		pnlTieuDe.setBounds(0, 0, 1343, 41);
		contentPane.add(pnlTieuDe);
		pnlTieuDe.setLayout(null);
		lblTieuDeTrang = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTieuDeTrang.setBounds(512, 12, 305, 25);
		pnlTieuDe.add(lblTieuDeTrang);
		lblTieuDeTrang.setBackground(new Color(0, 255, 255));
		lblTieuDeTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeTrang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		JPanel pnlNhapThongTin = new JPanel();
		pnlNhapThongTin.setBackground(new Color(255, 255, 255));
		pnlNhapThongTin.setLayout(null);
		pnlNhapThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thi\u1EBFt l\u1EADp th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlNhapThongTin.setBounds(20, 48, 1282, 302);
		contentPane.add(pnlNhapThongTin);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMaNV.setBounds(10, 28, 114, 12);
		pnlNhapThongTin.add(lblMaNV);
		

		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(128, 28, 204, 20);
		txtMaNV.setText(defaultID());
		pnlNhapThongTin.add(txtMaNV);
		
		lblCa = new JLabel("Ca làm việc");
		lblCa.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCa.setBounds(342, 28, 71, 12);
		pnlNhapThongTin.add(lblCa);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTenNV.setBounds(10, 74, 96, 15);
		pnlNhapThongTin.add(lblTenNV);
		
		textTen = new JTextField();
		textTen.setColumns(10);
		textTen.setBounds(128, 77, 204, 20);
		pnlNhapThongTin.add(textTen);
		textTen.requestFocus();

		
		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSDT.setBounds(10, 124, 96, 13);
		pnlNhapThongTin.add(lblSDT);
		
		textSdt = new JTextField();
		textSdt.setColumns(10);
		textSdt.setBounds(128, 124, 204, 20);
		pnlNhapThongTin.add(textSdt);
		
		JLabel lblCCCD = new JLabel("CCCD");
		lblCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCCCD.setBounds(10, 262, 45, 13);
		pnlNhapThongTin.add(lblCCCD);
		
		textCCCD = new JTextField();
		textCCCD.setColumns(10);
		textCCCD.setBounds(128, 259, 204, 20);
		pnlNhapThongTin.add(textCCCD);
		
		JLabel lblMail = new JLabel("Email");
		lblMail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMail.setBounds(10, 165, 45, 13);
		pnlNhapThongTin.add(lblMail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(128, 165, 204, 20);
		pnlNhapThongTin.add(textEmail);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNgaySinh.setBounds(342, 170, 114, 13);
		pnlNhapThongTin.add(lblNgaySinh);
		
		JLabel lblDiaChi = new JLabel(" Địa chỉ");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDiaChi.setBounds(10, 212, 108, 13);
		pnlNhapThongTin.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(128, 211, 204, 20);
		pnlNhapThongTin.add(txtDiaChi);
		
		JLabel cbChuc = new JLabel("Chức vụ");
		cbChuc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cbChuc.setBounds(342, 212, 108, 13);
		pnlNhapThongTin.add(cbChuc);
		
		cbChucVu = new JComboBox();
		cbChucVu.setBounds(450, 211, 204, 20);
		pnlNhapThongTin.add(cbChucVu);
		
		rdCa1 = new JRadioButton("Ca 1");
		rdCa1.setBackground(new Color(255, 255, 255));
		rdCa1.setBounds(450, 24, 132, 20);
		pnlNhapThongTin.add(rdCa1);
		
		rdCa2 = new JRadioButton("Ca 2");
		rdCa2.setBackground(new Color(255, 255, 255));
		rdCa2.setBounds(589, 24, 103, 20);
		pnlNhapThongTin.add(rdCa2);
		
		buttonGroupCLV = new ButtonGroup();
        
        // Thêm các nút radio vào ButtonGroup
		buttonGroupCLV.add(rdCa1);
		buttonGroupCLV.add(rdCa2);
		
		JPanel pnlNutChucNang = new JPanel();
		pnlNutChucNang.setBackground(new Color(255, 255, 255));
		pnlNutChucNang.setLayout(null);
		pnlNutChucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlNutChucNang.setBounds(1030, 58, 230, 189);
		pnlNhapThongTin.add(pnlNutChucNang);
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(0, 255, 255));
		btnThem.setIcon(new ImageIcon("Anh\\them.png"));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBounds(36, 24, 160, 30);
		pnlNutChucNang.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(0, 255, 255));
		btnSua.setIcon(new ImageIcon("Anh\\sua.png"));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setBounds(36, 65, 160, 30);
		pnlNutChucNang.add(btnSua);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(0, 255, 255));
		btnLamMoi.setIcon(new ImageIcon("Anh\\lammoi.png"));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLamMoi.setBounds(36, 105, 160, 30);
		pnlNutChucNang.add(btnLamMoi);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLuu.setBackground(Color.CYAN);
		btnLuu.setBounds(36, 143, 160, 30);
		btnLuu.setIcon(new ImageIcon("Anh\\luu.png"));
		pnlNutChucNang.add(btnLuu);
		
		lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblGioiTinh.setBounds(342, 78, 71, 12);
		pnlNhapThongTin.add(lblGioiTinh);
		
		rdNam = new JRadioButton("Nam");
		rdNam.setBackground(new Color(255, 255, 255));
		rdNam.setBounds(450, 74, 132, 20);
		pnlNhapThongTin.add(rdNam);
		
		rdNu = new JRadioButton("Nữ");
		rdNu.setBackground(new Color(255, 255, 255));
		rdNu.setBounds(589, 74, 103, 20);
		pnlNhapThongTin.add(rdNu);
	
		
		lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTrangThai.setBounds(342, 128, 71, 12);
		pnlNhapThongTin.add(lblTrangThai);
		
		rdĐangLam = new JRadioButton("Đang làm");
		rdĐangLam.setBackground(new Color(255, 255, 255));
		rdĐangLam.setBounds(450, 124, 132, 20);
		pnlNhapThongTin.add(rdĐangLam);
		
		rdNghi = new JRadioButton("Đã nghỉ");
		rdNghi.setBackground(new Color(255, 255, 255));
		rdNghi.setBounds(589, 124, 103, 20);
		pnlNhapThongTin.add(rdNghi);
		
		JLabel lblHinhAnh = new JLabel("Hình ảnh");
		lblHinhAnh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblHinhAnh.setBounds(718, 29, 76, 13);
		pnlNhapThongTin.add(lblHinhAnh);
		
		btnChonAnh = new JButton("Chọn ảnh");
		btnChonAnh.setBounds(855, 226, 130, 35);
		btnChonAnh.setBackground(new Color(0, 255, 255));
		btnChonAnh.setIcon(new ImageIcon("Anh\\chonanh.png"));
		pnlNhapThongTin.add(btnChonAnh);
		
		lblKhungHinh = new JLabel(" ");
		lblKhungHinh.setBackground(new Color(255, 255, 255));
		lblKhungHinh.setBounds(816, 28, 204, 178);
		pnlNhapThongTin.add(lblKhungHinh);
		lblKhungHinh.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblKhungHinh.setOpaque(true);
		lblKhungHinh.setBackground(Color.WHITE);
		

		
		txtNgay = new JDateChooser();
		txtNgay.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtNgay.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtNgay.setLocale(new Locale("vi", "VN"));
		txtNgay.setForeground(Color.BLACK);
		txtNgay.setDateFormatString("dd/MM/yyyy");
		txtNgay.setBounds(450, 165, 204, 20);
		txtNgay.setDate(new Date(System.currentTimeMillis()));
		pnlNhapThongTin.add(txtNgay);
		
		pnlDanhSach = new JPanel();
		pnlDanhSach.setBackground(new Color(255, 255, 255));
		pnlDanhSach.setLayout(null);
		pnlDanhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDanhSach.setBounds(20, 360, 1284, 414);
		contentPane.add(pnlDanhSach);
		
		lblThongTinTim = new JLabel("Nhập thông tin tìm kiếm");
		lblThongTinTim.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblThongTinTim.setBounds(10, 20, 134, 13);
		pnlDanhSach.add(lblThongTinTim);
		
		cbThongTinTim = new JComboBox();
		cbThongTinTim.setBounds(154, 20, 851, 20);
		pnlDanhSach.add(cbThongTinTim);
		
		lblTim = new JLabel("Tìm theo");
		lblTim.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTim.setBounds(10, 61, 45, 13);
		pnlDanhSach.add(lblTim);
		
		rdMaNV = new JRadioButton("Mã nhân viên");
		rdMaNV.setBackground(new Color(255, 255, 255));
		rdMaNV.setBounds(154, 61, 172, 20);
		pnlDanhSach.add(rdMaNV);
		
		rdTenNV = new JRadioButton("Tên nhân viên");
		rdTenNV.setBackground(new Color(255, 255, 255));
		rdTenNV.setBounds(338, 61, 127, 20);
		pnlDanhSach.add(rdTenNV);
		
		rdSDT = new JRadioButton("Số điện thoại");
		rdSDT.setBackground(new Color(255, 255, 255));
		rdSDT.setBounds(518, 61, 172, 20);
		pnlDanhSach.add(rdSDT);
		
		rdCa = new JRadioButton("Ca làm việc");
		rdCa.setBackground(new Color(255, 255, 255));
		rdCa.setBounds(717, 61, 127, 20);
		pnlDanhSach.add(rdCa);
		
		btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.setBackground(new Color(0, 255, 255));
		btnTimkiem.setIcon(new ImageIcon("Anh\\timkiem.png"));
		btnTimkiem.setBounds(1075, 20, 130, 30);
		pnlDanhSach.add(btnTimkiem);
		
		btnLamMoiThanh = new JButton("Làm mới");
		btnLamMoiThanh.setBackground(new Color(0, 255, 255));
		btnLamMoiThanh.setIcon(new ImageIcon("Anh\\lammoi.png"));
		btnLamMoiThanh.setBounds(1075, 65, 130, 30);
		pnlDanhSach.add(btnLamMoiThanh);
		
		rdChuc = new JRadioButton("Chức vụ");
		rdChuc.setBackground(new Color(255, 255, 255));
		rdChuc.setBounds(894, 61, 101, 20);
		pnlDanhSach.add(rdChuc);

		
		gr4 = new ButtonGroup();
		gr4.add(rdMaNV);
		gr4.add(rdTenNV);
		gr4.add(rdChuc);
		gr4.add(rdSDT);
		gr4.add(rdCa);

		JScrollPane scrDSNV;
		String[] tb1 = new String[] {"STT","Mã NV","Tên NV","NgaySinh","CCCD","Sdt","GioiTinh","TrangThai","CaLamViec","ChucVu","Email","DiaChi"};
		tablemodel = new DefaultTableModel(tb1, 0);
		table_DSKH = new JTable(tablemodel);

		table_DSKH.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table_DSKH.setBackground(new Color(224, 255, 255));
		table_DSKH.setForeground(new Color(0, 0, 0));
		getContentPane().add(scrDSNV=new JScrollPane(table_DSKH,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS),BorderLayout.CENTER);
		scrDSNV.setBounds(10, 104, 1262, 300);
		pnlDanhSach.add(scrDSNV);
		scrDSNV.setPreferredSize(new Dimension(0,250));
		
		gr1 = new ButtonGroup();
		gr1.add(rdCa1);
		gr1.add(rdCa2);
		
		gr2 = new ButtonGroup();
		gr2.add(rdNam);
		gr2.add(rdNu);
		
		gr3 = new ButtonGroup();
		gr3.add(rdĐangLam);
		gr3.add(rdNghi);
		
		
		
		docDuLieu();
		UpdateComBoBox();
		upDateComBoBoxChucVu();
		khoaText(lock);
		
		table_DSKH.addMouseListener(this);
		
		btnThem.addActionListener(this);
		btnChonAnh.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimkiem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLamMoiThanh.addActionListener(this);
		
		rdMaNV.addActionListener(this);
        rdTenNV.addActionListener(this);
        rdSDT.addActionListener(this);
        rdCa.addActionListener(this);
        rdChuc.addActionListener(this);
        
        
		cbChucVu.addItemListener(this);
		
		
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		btnThem.setEnabled(false);
	    int d = 1;
	    int row = table_DSKH.getSelectedRow();
	    txtMaNV.setText(tablemodel.getValueAt(row, 1).toString());
	    maBanDau = tablemodel.getValueAt(row, 1).toString();
	    textTen.setText(tablemodel.getValueAt(row, 2).toString());
	    Date ngaySinh = (Date) tablemodel.getValueAt(row, 3);
	    txtNgay.setDate(ngaySinh);
	    textCCCD.setText(tablemodel.getValueAt(row, 4).toString());
	    textSdt.setText(tablemodel.getValueAt(row, 5).toString());
	    String cbGioiTinh = tablemodel.getValueAt(row, 6).toString();
	    String cbTrangThai = tablemodel.getValueAt(row, 7).toString();
	    String cbCa = tablemodel.getValueAt(row, 8).toString();
		// Lấy giá trị chức vụ từ dòng đã chọn
		String  selectedChucVu = (String) tablemodel.getValueAt(row, 9); // columnIndex là vị trí cột chức vụ
		// Đặt giá trị vào ComboBox
		cboModeChucVu.setSelectedItem(selectedChucVu);
	    textEmail.setText(tablemodel.getValueAt(row, 10).toString());
	    txtDiaChi.setText(tablemodel.getValueAt(row, 11).toString());
	    List<NhanVien> list = dao.getAllNV();
	    for (NhanVien x : list) {
	        if (x.getMaNhanVien().equals(tablemodel.getValueAt(row, 1).toString())) {
	            if (x.trangThai == true) {
	                rdĐangLam.setSelected(true);
	                rdNghi.setSelected(false);
	            } else {
	                rdĐangLam.setSelected(false);
	                rdNghi.setSelected(true);
	            }

	            if (x.getGioiTinh() == 1) {
	                rdNam.setSelected(true);
	                rdNu.setSelected(false);
	            } else {
	                rdNam.setSelected(false);
	                rdNu.setSelected(true);
	            }

	            if (x.getCaLamViec() == 1) {
	                rdCa1.setSelected(true);
	                rdCa2.setSelected(false);
	            } else {
	                rdCa1.setSelected(false);
	                rdCa2.setSelected(true);
	            }
	            ImageIcon imageIcon = new ImageIcon(
						new ImageIcon(dao.getNVTHeoMa(tablemodel.getValueAt(row, 1).toString()).getHinhAnh()).getImage()
								.getScaledInstance(lblKhungHinh.getWidth(), lblKhungHinh.getHeight(), Image.SCALE_SMOOTH));
	            lblKhungHinh.setIcon(imageIcon);
			}
	        }
	    }

	public void upDateComBoBoxChucVu()
	{
		List<NhanVien> list = dao.getAllNV();
		String chuc = "";
		HashSet<String> cvnv = new HashSet<>();
		
		
		cboModeChucVu.addElement("Nhân Viên");
		cboModeChucVu.addElement("Quản Lý");
		
		for (NhanVien nv : list)
		{
			if (nv.getChucVu() == 1)
				chuc = "Quản lý";
			else if (nv.getChucVu() == 0)
				chuc = "Nhân viên";
			cvnv.add(chuc);
			
		}
		 // Đặt lại mô hình của combobox
	
	    cbChucVu.setModel(cboModeChucVu);
	}
	public void docDuLieu() {
		
		
	    int d = 1;
	    List<NhanVien> list = dao.getAllNV();
	    List<Integer> addedChucVu = new ArrayList<>(); // Sử dụng List để kiểm tra giá trị đã được thêm

	    // Xóa tất cả các dòng hiện có trong bảng
	    DefaultTableModel tablemodel = (DefaultTableModel) table_DSKH.getModel();
	    tablemodel.setRowCount(0);
	    

	    for (NhanVien x : list) {
	        int chucVu = x.getChucVu();
	        String chucVuText = "";

	        if (chucVu == 1) {
	            chucVuText = "Quản lý";
	        } else  {
	            chucVuText = "Nhân viên";
	        }

	        String trangThaiText = x.isTrangThai() ? "Đang làm việc" : "Đã nghỉ";

	        String gioiTinhText = x.getGioiTinh() == 1 ? "Nam" : "Nữ";
	        if (x.getCaLamViec() == 1)
	        {
	        	
	        }
//	        String calam = x.getCaLamViec();

	        tablemodel.addRow(new Object[] {
	            d++, x.getMaNhanVien(), x.getTenNV(), x.getNgaySinh(), x.getCmnd(), x.getSoDienThoai(), gioiTinhText, trangThaiText, x.getCaLamViec(), chucVuText,  x.getEmail(), x.getDiaChi()
	        });
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem))
		{
			if (chkThem == false)
				them();
			else if (chkThem == true)
			{
				luuThanhCong();
			}
		}
		else if(o.equals(btnLamMoi))
		{
			xoaTrang();
			
		}
		
		else if(o.equals(btnTimkiem))
		{
			deleteAllDataTable();
			tim();
		}
		else if (o.equals(btnChonAnh)) {
		chonAnh();
		}
		else if(o.equals(btnSua))
		{
			if (chkSua == false)
				sua();
			else if (chkSua == true)
			{
				luuThanhCong();
			}
		}
		else if(o.equals(btnLamMoiThanh))
		{
			try {
				xoaTrangThanhTK();
				xoaTrang();
				cbThongTinTim.removeAllItems();
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		else if (o.equals(btnLuu))
		{
			try {
				luuThongTin();
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (o.equals(rdCa) || o.equals(rdChuc) ||  o.equals(rdMaNV) || o.equals(rdSDT) || o.equals(rdTenNV))
		{
			UpdateComBoBox();
		}
		
	}
	public void phatSinhMa()
	{
		
	}
	public void luuThongTin() throws ParseException
	{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String maNV = txtMaNV.getText();
			String tenNV = textTen.getText();
			String ngaySinh1 = dateFormat.format(txtNgay.getDate());
			java.util.Date ngaySinh2 = dateFormat.parse(ngaySinh1);
			Date ngaySinhsql = new Date(ngaySinh2.getTime());
			String Cccd = textCCCD.getText();
			String Sdt = textSdt.getText();
			int gioiTinh = 0;
			int trangThai= 1;
			int caLamViec = 1;
			int chucVu =0;
			String chucVuCbb = (String) cboModeChucVu.getSelectedItem();
			if(chucVuCbb.equalsIgnoreCase("Quản lý"))
			{
				chucVu = 1;
			}
			else if (chucVuCbb.equalsIgnoreCase("Nhân viên"))
				chucVu = 0;
			String chucVuText = "";
			String img = folderName;
			String Email = textEmail.getText();
			String diaChi = txtDiaChi.getText();
			
			 if(rdNam.isSelected())
 			{
 				gioiTinh = 1;
 			}
 			else if (rdNu.isSelected())
 			{
 				gioiTinh = 0;
 			}
 			
 			if(rdĐangLam.isSelected())
 			{
 				trangThai = 1;
 			}
 			else if (rdNghi.isSelected())
 			{
 				trangThai = 0;
 			}
 			if(rdCa1.isSelected())
 			{
 				caLamViec = 1;
 			}
 			else if (rdCa2.isSelected())
 			{
 				caLamViec = 2;
 			}
 			NhanVien nv = valiData();
 			if(nv == null)
 				return;
 			else {
 				if (chkThem == true && chkSua == false)
					{
 					try {
 	 	                boolean moi = dao.them(maNV ,tenNV, ngaySinhsql, Cccd, Sdt, gioiTinh, caLamViec, trangThai, chucVu, img, Email, diaChi);
 	 	                if (moi == true) {
 	 	                	dao.addTaiKhoan(maNV);
 	 	                	System.out.println(maNV);
 	 	                    xoaTrang();
 	 	                    deleteAllDataTable();
 	 	                    docDuLieu();
 	 	                    txtMaNV.setText(defaultID());
 	 	                    JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
 	 	                    luuThanhCong();
 	 	                } else {
 	 	                    JOptionPane.showMessageDialog(this, "Thêm nhân viên không thành công");
 	 	                }
 	 	                
 	 	            } catch (Exception e) {
 	 	                e.printStackTrace();
 	 	          
 	 	            }
					}
 				else if (chkSua == true && chkThem == false)
 				{
			            if(img != null) {
			            	boolean moi = dao.sua(maBanDau, tenNV, ngaySinhsql, Cccd, Sdt, gioiTinh, trangThai, caLamViec, chucVu, Email, diaChi, img, maNV);
				            if (moi== true) {
				                xoaTrang();
				                deleteAllDataTable();
				                docDuLieu();
				                txtMaNV.setText(defaultID());
				                JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công");
				                luuThanhCong();
				            } else 
				                JOptionPane.showMessageDialog(this, "Cập nhật nhân viên không thành công!");
				            }
				            else
				            {
				            	boolean moi = dao.suakhonganh(maBanDau, tenNV, ngaySinhsql, Cccd, Sdt, gioiTinh, trangThai, caLamViec, chucVu, Email, diaChi, maNV);
			            if (moi== true) {
			                xoaTrang();
			                deleteAllDataTable();
			                docDuLieu();
			                txtMaNV.setText(defaultID());
			                JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công");
			                luuThanhCong();
			                
			            } else {
			                JOptionPane.showMessageDialog(this, "Cập nhật nhân viên không thành công!");
			            }
				            }
 				}				
 			}
}
//	Hàm xử lý sau khi lưu thay đổi thành công
	public void luuThanhCong()
	{
		chkSua = false;
		chkThem = false;
		btnSua.setText("Sửa");
		btnThem.setText("Thêm");
		lock = false;
		khoaText(lock);
		btnThem.setEnabled(true);
		btnThem.setIcon(new ImageIcon("Anh\\them.png"));
		btnSua.setIcon(new ImageIcon("Anh\\sua.png"));
		btnSua.setEnabled(true);
	}
	public void deleteAllDataTable() {
		tablemodel = (DefaultTableModel) table_DSKH.getModel();
		tablemodel.getDataVector().removeAllElements();
	}

	private void xoaTrang() {
		txtMaNV.setText(defaultID());
		textTen.setText("");
		txtNgay.setDate(new Date(System.currentTimeMillis()));
		textCCCD.setText("");
		textSdt.setText("");
		rdNam.setSelected(false);
		rdNu.setSelected(false);
		rdĐangLam.setSelected(false);
		rdNghi.setSelected(false);
		rdCa1.setSelected(false);
		rdCa2.setSelected(false);
		textEmail.setText("");
		txtDiaChi.setText("");
		btnThem.setEnabled(true);
		btnSua.setEnabled(true);
		gr1.clearSelection();
		gr2.clearSelection();
		gr3.clearSelection();
		textTen.requestFocus();	
		
		deleteAllDataTable();
		docDuLieu();

	}

	private String defaultID() {
		int n = dao.soLuongNV() + 1;
		String soLuongNV = String.format("%03d", n);
		String deFault = "NV" + soLuongNV;
		return deFault;
	}
	

	private void UpdateComBoBox()
	{
		
		
//		Lưu dữ liệu vào comboBOx

			List<NhanVien> listNV = dao.getAllNV();
			List<String> trangThaiList = new ArrayList<>();
			cbThongTinTim.removeAllItems();
			
			
			for (NhanVien n : listNV)
			{
				if(rdMaNV.isSelected())
				{
						cbThongTinTim.addItem(n.getMaNhanVien());
				}
				else if (rdTenNV.isSelected()){
					cbThongTinTim.addItem(n.getTenNV());
					
				}
				else if (rdSDT.isSelected()){
					cbThongTinTim.addItem(n.getSoDienThoai());
					
				}
			}
		   if (rdCa.isSelected()){
				cbThongTinTim.addItem("1");
				cbThongTinTim.addItem("2");
			}
			if (rdChuc.isSelected()){
				cbThongTinTim.addItem("Quản lý");
				cbThongTinTim.addItem("Nhân viên");		
			}
	}
	public void sua()
	{
		lock = true;
		khoaText(lock);
		btnSua.setText("Hủy");
		btnSua.setIcon(new ImageIcon("Anh\\huy.png"));
		btnThem.setEnabled(false);
		chkSua = true;
		
	}
	public void them()
	{
		lock = true;
		khoaText(lock);
		btnThem.setText("Hủy");
		btnThem.setIcon(new ImageIcon("Anh\\huy.png"));
		btnSua.setEnabled(false);
		chkThem = true;
		
	}
	public NhanVien valiData() {
		NhanVien nv;
		String maNV = txtMaNV.getText().trim();
//		txtmanv.setText(defaultID());
		if (textTen.getText().isEmpty() || textTen.getText().trim() == "") {
			ShowErrorField("Tên khách hàng không được rỗng", textTen);
			return null;
		}
		String tenNV = textTen.getText().trim();
		if (textSdt.getText().isEmpty() || textSdt.getText().trim() == "") {
			ShowErrorField("Số điện thoại khách hàng không được rỗng", textSdt);
			return null;
		} else if (textSdt.getText().trim().matches("^[0]\\d{9}$") == false) {
			ShowErrorField("Vui lòng nhập số điện thoại khách hàng bằng số và gồm 10 chữ số bất đầu bằng số 0 !",
					textSdt);
			return null;
		}
		String sdt = textSdt.getText().trim();

		if (textEmail.getText().isEmpty() || textEmail.getText().trim() == "") {
			ShowErrorField("Email khách hàng không được rỗng", textEmail);
			return null;
		} else if (textEmail.getText().trim().matches("^\\b[\\w.%+-]+@[\\w.-]+\\.com\\b$") == false) {
			ShowErrorField("Vui lòng nhập đúng email khách hàng !\\n ví dụ:quoc@gmail.com", textEmail);
			return null;
		}
		String mail = textEmail.getText().trim();
		if (txtDiaChi.getText().isEmpty() || txtDiaChi.getText().trim() == "") {
			ShowErrorField("Địa chỉ không được rỗng", txtDiaChi);
			return null;
		}
		String diaChi = txtDiaChi.getText().trim();

		int gioiTinh = 2;
		if (rdNam.isSelected()) {
			gioiTinh = 1;
		} else if (rdNu.isSelected()) {
			gioiTinh = 2;
		} else if (gioiTinh == 0) {
			JOptionPane.showMessageDialog(null, "Chưa chọn giới tính?");
			return null;
		}
		String CCCD = textCCCD.getText().trim();
		if (textCCCD.getText().isEmpty() || textCCCD.getText().trim() == "") {
			ShowErrorField("Căn cước công dân khách hàng không được rỗng", textCCCD);
			return null;
		} else if (textCCCD.getText().trim().matches("^[0]\\d{11}$") == false) {
			ShowErrorField("Vui lòng nhập Căn cước công dân khách hàng bằng số và gồm 12 chữ số bất đầu bằng số 0 !",
					textCCCD);
			return null;
		}
		java.util.Date ngaySinh = txtNgay.getDate();
		if (ngaySinh == null) {
			JOptionPane.showMessageDialog(this, "Ngày sinh không được rỗng");
			return null;
		}
		else {
			
	        LocalDate ngaySinhLocal = ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        LocalDate ngayHienTaiLocal = LocalDate.now();

	        int tuoi = Period.between(ngaySinhLocal, ngayHienTaiLocal).getYears();

	        // Kiểm tra xem người dùng có đủ 18 tuổi không
	        if (tuoi >= 18) {
	            // Người dùng đủ tuổi
	        } else {
	            JOptionPane.showMessageDialog(this, "Bạn chưa đủ 18 tuổi");
	            return null;
	        }
		}
		try {
			nv = new NhanVien(maNV, 0, tenNV, ngaySinh, gioiTinh, CCCD, mail, sdt, 0, true, diaChi, CCCD);
			return nv;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
	
	private void ShowErrorField(String string, JTextField txt) {
		JOptionPane.showMessageDialog(null, string);
		txt.requestFocus();
		
	}

	private void xoaTrangThanhTK() throws ClassNotFoundException, SQLException {
		gr4.clearSelection();
		cbThongTinTim.setSelectedItem("");
		deleteAllDataTable();
		docDuLieu();
	}
	
	
	//chon anh
	public String chonAnh() {
		try {
			String user = System.getProperty("user.dir");
			JFileChooser fileChooser = new JFileChooser(user + "\\AnhNhanVien");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("png file", "png");
			FileNameExtensionFilter filterJPG = new FileNameExtensionFilter("jpg file", "jpg");
			
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.addChoosableFileFilter(filterJPG);
			int result = fileChooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				String filePath = selectedFile.getAbsolutePath();

				// Load the selected image into the label
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage()
						.getScaledInstance(lblKhungHinh.getWidth(), lblKhungHinh.getHeight(), Image.SCALE_SMOOTH));
				lblKhungHinh.setIcon(imageIcon);
				File file = new File(filePath);

				String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
				folderName = file.getParentFile().getName() + "\\\\" + fileName;

//				System.out.println(folderName);
				return folderName; // Return the file path
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return folderName;
	}

	public void tim()
	{
		deleteAllDataTable();
		int d = 1;
	    List<NhanVien> list = dao.getAllNV();
	    List<Integer> addedChucVu = new ArrayList<>(); // Sử dụng List để kiểm tra giá trị đã được thêm

	    // Xóa tất cả các dòng hiện có trong bảng
	    DefaultTableModel tablemodel = (DefaultTableModel) table_DSKH.getModel();
	    tablemodel.setRowCount(0);
	    for (NhanVien x : list) {
	    String trangThaiText = x.isTrangThai() ? "Đang làm việc" : "Đã nghỉ";
	    int ca = 2;
		String tim = "";
		try {
			tim = cbThongTinTim.getSelectedItem().toString();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (tim.equalsIgnoreCase(""))
		{
			JOptionPane.showMessageDialog(this, "Hãy chọn và nhập phương thức tìm kiếm!");
			return;
		}
//			Tìm theo tên
			if(rdTenNV.isSelected())
			{
				deleteAllDataTable();
				
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				NhanVien nv = dao.getNVTHeoTen(tim);
				bangTimKiem(nv, d);
			}
//			tìm theo mã
			else if  (rdMaNV.isSelected())
			{
				deleteAllDataTable();
				
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				NhanVien nv = dao.getNVTHeoMa(tim);
				 bangTimKiem(nv, d);
			}
//			Tìm theo số điện thoại
			else if (rdSDT.isSelected())
			{
                deleteAllDataTable();
				
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				NhanVien nv = dao.getNVTHeoSdt(tim);
				bangTimKiem(nv, d);
			}
//			Tìm theo Ca làm việc
			else if (rdCa.isSelected())
			{
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				deleteAllDataTable();
				if (cbThongTinTim.getSelectedItem().equals("1")) {
					ca = 1;
				} else if (cbThongTinTim.getSelectedItem().equals("2"))
					ca = 2;
				
				List<NhanVien> listNV = dao.getNVTHeoCa(ca);
				int index = 0;
				for (NhanVien nv : listNV) {
					 bangTimKiem(nv, ++index);
				}
			}
//			Tìm theo chức vụ
			else if (rdChuc.isSelected())
				
			{
                deleteAllDataTable();
                
				String chuc = cbThongTinTim.getSelectedItem().toString();
				int indexChuc = 0;
				if(chuc.equalsIgnoreCase("Quản lý"))
					indexChuc = 1;
				else
					indexChuc = 0;
				
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				ArrayList<NhanVien> listChucVu = dao.getNVTHeoChuc(indexChuc);
				int index = 0;
				for(NhanVien nv : listChucVu)
	
				if(nv.getChucVu()==1) {
					bangTimKiem(nv, ++index);
				} else {
					bangTimKiem(nv, ++index);
				}
}}}
//	Xuất kết quả tìm kiếm
	public void bangTimKiem (NhanVien nv, int d)
	{
		 int cv = nv.getChucVu();
	        String chucVuText = "";
	        if (cv == 0) {
	        	chucVuText = "Nhân viên";
	        } else  if (cv != 0){
	        	chucVuText = "Quản lý";
	        }
	        String gend = nv.getGioiTinh() == 1 ? "Nam" : "Nữ";
	        String status = nv.isTrangThai() ? "Đang làm việc" : "Đã nghỉ";
		tablemodel.addRow(new Object[] {
	            d, nv.getMaNhanVien(), nv.getTenNV(), nv.getNgaySinh(), nv.getCmnd(), nv.getSoDienThoai(), gend, status, nv.getCaLamViec(), chucVuText,  nv.getEmail(), nv.getDiaChi()
	        });
	}
//	Khóa các textField
	public void khoaText (boolean lock)
	{
		txtDiaChi.setEditable(lock);
		textTen.setEditable(lock);
		textEmail.setEditable(lock);
		textSdt.setEditable(lock);
		textCCCD.setEditable(lock);
		btnLuu.setEnabled(lock);
		cbChucVu.setEditable(lock);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object o = e.getSource();
		if (o.equals(cbChucVu))
		{
			if (e.getStateChange() == ItemEvent.SELECTED && !isEventFromTable())
			 {
				String chucVu = "";
				if(cboModeChucVu.getSelectedItem().toString().equalsIgnoreCase("Nhân viên"))
				{	
					int soLuongNVDL = dao.soLuongNV();
					List<NhanVien> list = dao.getAllNV();
					int n = 1;
					chucVu = "NV";
					String soLuongNV = String.format("%03d", n);
					String deFault = "";
					if (soLuongNVDL <= 0)
					{
						deFault = chucVu + soLuongNV;
					}
					else
					{
						for (NhanVien nv : list)
						{
							while(nv.getMaNhanVien().equalsIgnoreCase(chucVu + soLuongNV))
							{

									n++;
									soLuongNV = String.format("%03d", n);
									deFault = chucVu + soLuongNV;
									
							}
						}
					}
					
					txtMaNV.setText(deFault);
			}
			else
			{
				int l =  1;
				int soLuongQLDL = dao.soLuongQL();
				String soLuongQL = String.format("%03d", l);
				chucVu = "QL";
				String deFaultQL = chucVu + soLuongQL;
				List<NhanVien> list = dao.getAllNV();
				if (soLuongQLDL <= 0)
				{
					deFaultQL = chucVu + soLuongQL;
				}
				else 
				{
					for (NhanVien nv : list)
					{
						while(nv.getMaNhanVien().equalsIgnoreCase(chucVu + soLuongQL))
					{

							l++;
							soLuongQL = String.format("%03d", l);
							deFaultQL = chucVu + soLuongQL;
					}
				}
				
				txtMaNV.setText(deFaultQL);
				}
				
			}
				
			 }		
		}
		 
	}
	// Kiểm tra xem sự kiện có phát sinh từ table hay không
    // Trong trường hợp này, giả sử table_DSKH là đối tượng JTable
	private boolean isEventFromTable() {
	    
	    return table_DSKH.isFocusOwner();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

