package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;

import DAO.LapHoaDon_Dao;
import DAO.NhanVien_Dao;
import DAO.SanPham_Dao;
import DAO.XemHoaDon_Dao;
import Database.ConnectDatabase;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.KhuyenMai;
import Entity.NhanVien;
import Entity.sanPham;
import Entity.sanPham.MauSac;
import Entity.sanPham.Size;
import Entity.taiKhoan;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class FrmLapHoaDon extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static DefaultTableModel tablemodel = new DefaultTableModel();
	public static DefaultTableModel modelNEw = new DefaultTableModel();
	private JLabel lblTieuDeTrang;
	static JPanel pnlThongTin;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtDiemTL;
	private JTextField txtMaHD;
	private JTextField txtNgayLap;
	private JTextField txtTongSL;
	private JTextField txtTongTienSP;
	private JTextField txtDiemTichDuoc;
	private JTextField txtDiemSuDung;
	private JTextField txtTienHoanLai;
	private JTextField txtTienKhachDua;
	private JTable table_dscho;
	private JTextField txtTongThanhToan;
	private JButton btnThanhToan;
	private JButton btnHuyHD;
	private JButton btnLamMoiHD;
	private JButton btnHangCho;
	private JComboBox cboTimSP;
	private JTable table_SP;
	private JButton btnLamMoiThanhTimKiem;
	private JButton btnThemSP;
	private JButton btnXoaAllSP;
	public static  taiKhoan taiKhoan;
	public static int i =0;
	private static LapHoaDon_Dao LHD_dao = new LapHoaDon_Dao();
	private	FrmXuatHoaDon frmXuatHD = new FrmXuatHoaDon();
	private XemHoaDon_Dao xem_dao = new XemHoaDon_Dao();
	private NhanVien_Dao dao = new NhanVien_Dao();
	private SanPham_Dao daoSP = new SanPham_Dao();
	public JTable table_CTHD;
	private JTextField txtSoLuong;
	
	DecimalFormat tien = new DecimalFormat(",##0");
	DecimalFormat tienNoString = new DecimalFormat("#.##");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
	private DateTimeFormatter formatter;
	
	int tongSL = 0; // Biến tổng số lượng sản phẩm
    double tongTienSP = 0; // Biến tổng tiền sản phẩm
    double tongThanhToan = 0; // Biến tổng thành toán
    double tyLeDiem = 0.01; // 1%
    float diemTichDuoc = 0; // Biến tổng điểm tích được
    double diemSD =  0;
	private double diemsudung;

	public String tenNhanVien = FrmDangNhap.taiKhoan.getTenDangNhap();
	private JPanel pnlTieuDe;
	private JPanel pnlDanhSachCho;
	private JScrollPane scrDSHD;
	private JLabel lblSoDienThoaiKH;
	private JComboBox cboSDTKH;
	private JPanel panel_DonHang;
	private JPanel pnlThongTinKhachHang;
	private JLabel lblMaKH;
	private JLabel lblTenKH;
	private JLabel ldlSDT;
	private JLabel lblDiemTichLuy;
	private JPanel pnlThongTinHoaDon;
	private JLabel lblTienHoanLoai;
	private JLabel lblTienDua;
	private JLabel lblTongThanhToan;
	private JLabel lblDiemSuDung;
	private JLabel lblDiemTichDuoc;
	private JLabel lblTongTienThanhToan;
	private JLabel lblTongSoLuong;
	private JLabel lblNgayLap;
	private JLabel lblMaHoanDon;
	private JPanel panel_DSSP;
	private JLabel lblMaSP;
	private JPanel panel_CTHD;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLapHoaDon frame = new FrmLapHoaDon();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}}});
		}
	 

	/**
	 * Create the frame.
	 */
	public FrmLapHoaDon() {
		pnlThongTin = new JPanel();
		getContentPane().setBackground(new Color(129, 250, 243));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1347, 843);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		pnlThongTin.setBackground(new Color(255, 255, 255));
		pnlThongTin.setBounds(0, 0, 1333, 806);
		getContentPane().add(pnlThongTin);
		pnlThongTin.setLayout(null);
		javax.swing.border.Border southborder=BorderFactory.createLineBorder(Color.black);
		
		
		pnlTieuDe = new JPanel();
		pnlTieuDe.setBackground(new Color(0, 255, 255));
		pnlTieuDe.setBounds(0, 0, 1343, 41);
		pnlThongTin.add(pnlTieuDe);
		pnlTieuDe.setLayout(null);
		lblTieuDeTrang = new JLabel("LẬP HÓA ĐƠN");
		lblTieuDeTrang.setBounds(512, 12, 305, 25);
		pnlTieuDe.add(lblTieuDeTrang);
		lblTieuDeTrang.setBackground(new Color(0, 255, 255));
		lblTieuDeTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeTrang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		pnlDanhSachCho = new JPanel();
		pnlDanhSachCho.setBorder(new TitledBorder(null, "Danh sách hóa đơn chờ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachCho.setBackground(new Color(255, 255, 255));
		pnlDanhSachCho.setBounds(20, 48, 977, 172);
		pnlThongTin.add(pnlDanhSachCho);
		pnlDanhSachCho.setLayout(null);
		
		scrDSHD = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrDSHD.setPreferredSize(new Dimension(0, 250));
		scrDSHD.setBounds(10, 52, 957, 110);
		pnlDanhSachCho.add(scrDSHD);
		
		table_dscho = new JTable();
		table_dscho.setBackground(new Color(255, 255, 255));
		
		table_dscho.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã HD", "Khách Hàng", "Mã nhân viên", "Số lượng sản phẩm", "Thời gian tạo"
			}
		));
		scrDSHD.setViewportView(table_dscho);
		
		lblSoDienThoaiKH = new JLabel("Nhập số điện thoại khách hàng:");
		lblSoDienThoaiKH.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSoDienThoaiKH.setBounds(10, 28, 170, 15);
		pnlDanhSachCho.add(lblSoDienThoaiKH);
		
		cboSDTKH = new JComboBox();
		cboSDTKH.setEditable(true);
		cboSDTKH.setBounds(190, 21, 339, 21);
		pnlDanhSachCho.add(cboSDTKH);
		
		panel_DonHang = new JPanel();
		panel_DonHang.setForeground(new Color(0, 0, 0));
		panel_DonHang.setBackground(new Color(255, 255, 255));
		panel_DonHang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0110\u01A1n h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_DonHang.setBounds(1007, 48, 298, 748);
		pnlThongTin.add(panel_DonHang);
		panel_DonHang.setLayout(null);
		
		pnlThongTinKhachHang = new JPanel();
		pnlThongTinKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlThongTinKhachHang.setBackground(new Color(255, 255, 255));
		pnlThongTinKhachHang.setBounds(10, 23, 278, 160);
		panel_DonHang.add(pnlThongTinKhachHang);
		pnlThongTinKhachHang.setLayout(null);
		
		lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMaKH.setBounds(10, 10, 116, 18);
		pnlThongTinKhachHang.add(lblMaKH);
		
		lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTenKH.setBounds(10, 48, 116, 18);
		pnlThongTinKhachHang.add(lblTenKH);
		
		ldlSDT = new JLabel("Số điện thoại");
		ldlSDT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ldlSDT.setBounds(10, 84, 116, 18);
		pnlThongTinKhachHang.add(ldlSDT);
		
		lblDiemTichLuy = new JLabel("Điểm tích lũy");
		lblDiemTichLuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDiemTichLuy.setBounds(10, 129, 116, 18);
		pnlThongTinKhachHang.add(lblDiemTichLuy);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(136, 11, 114, 19);
		pnlThongTinKhachHang.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(136, 49, 114, 19);
		pnlThongTinKhachHang.add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(136, 85, 114, 28);
		pnlThongTinKhachHang.add(txtSDT);
		
		txtDiemTL = new JTextField();
		txtDiemTL.setEditable(false);
		txtDiemTL.setColumns(10);
		txtDiemTL.setBounds(136, 130, 114, 19);
		pnlThongTinKhachHang.add(txtDiemTL);
		
		pnlThongTinHoaDon = new JPanel();
		pnlThongTinHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlThongTinHoaDon.setBackground(Color.WHITE);
		pnlThongTinHoaDon.setBounds(10, 193, 278, 461);
		panel_DonHang.add(pnlThongTinHoaDon);
		pnlThongTinHoaDon.setLayout(null);
		
		lblTienHoanLoai = new JLabel("Tiền hoàn lại");
		lblTienHoanLoai.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTienHoanLoai.setBounds(10, 429, 116, 18);
		pnlThongTinHoaDon.add(lblTienHoanLoai);
		
		lblTienDua = new JLabel("Tiền khách đưa");
		lblTienDua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTienDua.setBounds(10, 391, 116, 18);
		pnlThongTinHoaDon.add(lblTienDua);
		
		lblTongThanhToan = new JLabel("Tổng thanh toán");
		lblTongThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTongThanhToan.setBounds(10, 353, 116, 18);
		pnlThongTinHoaDon.add(lblTongThanhToan);
		
		lblDiemSuDung = new JLabel("Điểm sử dụng");
		lblDiemSuDung.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDiemSuDung.setBounds(10, 201, 116, 18);
		pnlThongTinHoaDon.add(lblDiemSuDung);
		
		lblDiemTichDuoc = new JLabel("Điểm tích được");
		lblDiemTichDuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDiemTichDuoc.setBounds(10, 163, 116, 18);
		pnlThongTinHoaDon.add(lblDiemTichDuoc);
		
		lblTongTienThanhToan = new JLabel("Tổng tiền SP");
		lblTongTienThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTongTienThanhToan.setBounds(10, 124, 116, 18);
		pnlThongTinHoaDon.add(lblTongTienThanhToan);
		
		lblTongSoLuong = new JLabel("Tổng số lượng");
		lblTongSoLuong.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTongSoLuong.setBounds(10, 86, 116, 18);
		pnlThongTinHoaDon.add(lblTongSoLuong);
		
		lblNgayLap = new JLabel("Ngày lập");
		lblNgayLap.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNgayLap.setBounds(10, 48, 116, 18);
		pnlThongTinHoaDon.add(lblNgayLap);
		
		lblMaHoanDon = new JLabel("Mã hóa đơn");
		lblMaHoanDon.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMaHoanDon.setBounds(10, 9, 116, 18);
		pnlThongTinHoaDon.add(lblMaHoanDon);
		
		txtMaHD = new JTextField();
		txtMaHD.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaHD.setFont(new Font("Times New Roman", Font.BOLD, 10));
		txtMaHD.setEditable(false);
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(136, 11, 114, 19);
		pnlThongTinHoaDon.add(txtMaHD);
		
		txtNgayLap = new JTextField();
		txtNgayLap.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayLap.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtNgayLap.setEditable(false);
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(136, 49, 114, 19);
		pnlThongTinHoaDon.add(txtNgayLap);
		
		txtTongSL = new JTextField();
		txtTongSL.setEditable(false);
		txtTongSL.setColumns(10);
		txtTongSL.setBounds(136, 87, 114, 19);
		pnlThongTinHoaDon.add(txtTongSL);
		
		txtTongTienSP = new JTextField();
		txtTongTienSP.setEditable(false);
		txtTongTienSP.setColumns(10);
		txtTongTienSP.setBounds(136, 125, 114, 19);
		pnlThongTinHoaDon.add(txtTongTienSP);
		
		txtDiemTichDuoc = new JTextField();
		txtDiemTichDuoc.setEditable(false);
		txtDiemTichDuoc.setColumns(10);
		txtDiemTichDuoc.setBounds(136, 163, 114, 19);
		pnlThongTinHoaDon.add(txtDiemTichDuoc);
		
		txtDiemSuDung = new JTextField();
		txtDiemSuDung.setColumns(10);
		txtDiemSuDung.setBounds(136, 201, 114, 19);
		txtDiemSuDung.setEditable(false);
		pnlThongTinHoaDon.add(txtDiemSuDung);
		
		txtTongThanhToan = new JTextField();
		txtTongThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtTongThanhToan.setEditable(false);
		txtTongThanhToan.setColumns(10);
		txtTongThanhToan.setBounds(136, 353, 114, 19);
		pnlThongTinHoaDon.add(txtTongThanhToan);
		
		txtTienHoanLai = new JTextField();
		txtTienHoanLai.setEditable(false);
		txtTienHoanLai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTienHoanLai.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtTienHoanLai.setColumns(10);
		txtTienHoanLai.setBounds(136, 429, 114, 25);
		pnlThongTinHoaDon.add(txtTienHoanLai);
		
		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setColumns(10);
		txtTienKhachDua.setBounds(136, 391, 114, 25);
		pnlThongTinHoaDon.add(txtTienKhachDua);
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnThanhToan.setIcon(new ImageIcon("Anh\\thanhtoan.png"));
		btnThanhToan.setBackground(new Color(50, 205, 50));
		btnThanhToan.setBounds(10, 703, 137, 35);
		panel_DonHang.add(btnThanhToan);
		
		btnHuyHD = new JButton("Hủy hóa đơn");
		btnHuyHD.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnHuyHD.setIcon(new ImageIcon("Anh\\huy.png"));
		btnHuyHD.setBackground(new Color(0, 255, 255));
		btnHuyHD.setBounds(10, 664, 137, 29);
		panel_DonHang.add(btnHuyHD);
		
		btnLamMoiHD = new JButton("Làm mới");
		btnLamMoiHD.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLamMoiHD.setIcon(new ImageIcon("Anh\\lammoi.png"));
		btnLamMoiHD.setBackground(new Color(0, 255, 255));
		btnLamMoiHD.setBounds(157, 664, 131, 29);
		panel_DonHang.add(btnLamMoiHD);
		
		btnHangCho = new JButton("Hàng chờ");
		btnHangCho.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnHangCho.setIcon(new ImageIcon("Anh\\hangcho.png"));
		btnHangCho.setBackground(new Color(255, 165, 0));
		btnHangCho.setBounds(157, 703, 131, 35);
		panel_DonHang.add(btnHangCho);
		
		panel_DSSP = new JPanel();
		panel_DSSP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_DSSP.setBackground(Color.WHITE);
		panel_DSSP.setBounds(20, 230, 977, 127);
		pnlThongTin.add(panel_DSSP);
		panel_DSSP.setLayout(null);
		
		lblMaSP = new JLabel("Mã sản phẩm:");
		lblMaSP.setBounds(20, 22, 88, 15);
		lblMaSP.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_DSSP.add(lblMaSP);
		
		JScrollPane scrDSNV;
		String[] tb2 = new String[] {"Mã","Tên sản phẩm","Loại sản phẩm","Màu sắc","Size","Chất liệu","Số lượng","Đơn gía","VAT","Khuyến mãi(%)"};
		DefaultTableModel tablemodel = new DefaultTableModel(tb2, 0);
		table_SP = new JTable(tablemodel);

		table_SP.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table_SP.setBackground(new Color(224, 255, 255));
		table_SP.setForeground(new Color(0, 0, 0));
		getContentPane().add(scrDSNV=new JScrollPane(table_SP,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS),BorderLayout.CENTER);
		scrDSNV.setBounds(10, 50, 957, 67);
		panel_DSSP.add(scrDSNV);
		scrDSNV.setPreferredSize(new Dimension(0,250));
		
		cboTimSP = new JComboBox();
		cboTimSP.setEditable(true);
		cboTimSP.setBounds(133, 17, 485, 21);
		panel_DSSP.add(cboTimSP);
		
		btnLamMoiThanhTimKiem = new JButton("Làm mới");
		btnLamMoiThanhTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLamMoiThanhTimKiem.setIcon(new ImageIcon("Anh\\lammoi.png"));
		btnLamMoiThanhTimKiem.setBackground(new Color(0, 255, 255));
		btnLamMoiThanhTimKiem.setBounds(833, 16, 134, 27);
		panel_DSSP.add(btnLamMoiThanhTimKiem);
		
		btnThemSP = new JButton("Thêm sản phẩm");
		btnThemSP.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnThemSP.setIcon(new ImageIcon("Anh\\themsp.png"));
		btnThemSP.setBackground(new Color(0, 255, 255));
		btnThemSP.setBounds(673, 16, 150, 27);
		panel_DSSP.add(btnThemSP);
		
		
		panel_CTHD = new JPanel();
		panel_CTHD.setBorder(new TitledBorder(null, "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_CTHD.setBackground(new Color(255, 255, 255));
		panel_CTHD.setBounds(21, 367, 976, 429);
		pnlThongTin.add(panel_CTHD);
		panel_CTHD.setLayout(null);
		
		btnXoaAllSP = new JButton("Xóa tất cả");
		btnXoaAllSP.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnXoaAllSP.setIcon(new ImageIcon("Anh\\xoaall.png"));
		btnXoaAllSP.setBackground(new Color(0, 255, 255));
		btnXoaAllSP.setBounds(400, 390, 149, 29);
		panel_CTHD.add(btnXoaAllSP);
		
		JScrollPane scrDSNV1;
		String[] tb3 = new String[] {"STT","Tên sản phẩm","Màu sắc","Size","Chất liệu","Đơn giá","Số lượng bán","VAT","Khuyến mãi(%)","Thành tiền"};
		DefaultTableModel modelNEw = new DefaultTableModel(tb3, 0);
		CustomTableModel customTableModel = new CustomTableModel(new Vector<Vector<Object>>(), new Vector<String>(Arrays.asList(tb3)));
		table_CTHD = new JTable(new DefaultTableModel(
			new Object[][] {
			},new String[] { "STT", "Mã sản phẩm","Tên sản phẩm", "Màu sắc", "Size", "Chất liệu", "Đơn giá", "Số lượng bán", "VAT", "Khuyến mãi(%)", "Thành tiền", "Xóa sản phẩm" }));
	
		table_CTHD.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
		table_CTHD.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JTextField(), table_CTHD, table_SP, this, cboTimSP));
		table_CTHD.getColumnModel().getColumn(11).setCellRenderer(new ButtonDelete());
		table_CTHD.getColumnModel().getColumn(11).setCellEditor(new ButtonDeleteEditor(table_CTHD, table_SP, this, cboTimSP));
		table_CTHD.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table_CTHD.setBackground(new Color(224, 255, 255));
		table_CTHD.setForeground(new Color(0, 0, 0));
		getContentPane().add(scrDSNV1=new JScrollPane(table_CTHD,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS),BorderLayout.CENTER);
		scrDSNV1.setBounds(10, 21, 956, 359);
		panel_CTHD.add(scrDSNV1);
		scrDSNV1.setPreferredSize(new Dimension(0,250));
		
		docDuLieuSP();
		updateComBoBox();
		txtMaHD.setText(updateMaHD());
		updateMaHD();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy , hh:mm");
		txtNgayLap.setText(LocalDateTime.now().format(formatter));
		
		lblTongKhuyenMai = new JLabel("Tổng khuyến mãi");
		lblTongKhuyenMai.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTongKhuyenMai.setBounds(10, 277, 116, 18);
		pnlThongTinHoaDon.add(lblTongKhuyenMai);
		
		lblTongThue = new JLabel("Tổng tiền thuế");
		lblTongThue.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTongThue.setBounds(10, 315, 116, 18);
		pnlThongTinHoaDon.add(lblTongThue);
		
		txtTongKhuyenMai = new JTextField();
		txtTongKhuyenMai.setFont(new Font("Times New Roman", Font.BOLD, 10));
		txtTongKhuyenMai.setEditable(false);
		txtTongKhuyenMai.setColumns(10);
		txtTongKhuyenMai.setBounds(136, 277, 114, 19);
		pnlThongTinHoaDon.add(txtTongKhuyenMai);
		
		lblKhuyenMai = new JLabel("Khuyến mãi");
		lblKhuyenMai.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblKhuyenMai.setBounds(10, 239, 116, 18);
		pnlThongTinHoaDon.add(lblKhuyenMai);
		
		cboKhuyenMai = new JComboBox();
		cboKhuyenMai.setEditable(true);
		cboKhuyenMai.setBounds(134, 239, 116, 21);
		for (int i = 0; i <= 100; i += 5) {
            cboKhuyenMai.addItem(i);
        }
		pnlThongTinHoaDon.add(cboKhuyenMai);
		
		txtTongThue = new JTextField();
		txtTongThue.setFont(new Font("Times New Roman", Font.BOLD, 10));
		txtTongThue.setEditable(false);
		txtTongThue.setColumns(10);
		txtTongThue.setBounds(136, 316, 114, 19);
		pnlThongTinHoaDon.add(txtTongThue);
		
		btnLamMoiThanhTimKiem.addActionListener(this);
		btnThemSP.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnLamMoiHD.addActionListener(this);
		btnHuyHD.addActionListener(this);
		btnHangCho.addActionListener(this);
		cboTimSP.addActionListener(this);
		btnXoaAllSP.addActionListener(this);

//		Tự động điền thông tin khách hàng
		txtSDT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						if(txtSDT.getText().length() >= 9 ) {
							timTenVaMaKhachHangBySDT(txtSDT.getText());
						}
						else
							JOptionPane.showMessageDialog(null,"Số điện thoại phải có ít là 10 số!");
					}
				}
				if(LHD_dao.timKhachHangBySDT(txtSDT.getText()).isEmpty()) {
					txtMaKH.setText("Khách lẻ");
					txtTenKH.setText("Khách lẻ");
					txtDiemTL.setText("0");
					txtDiemSuDung.setEditable(false);
					txtDiemSuDung.setText("0");
					txtDiemTichDuoc.setText("0");
					
					txtTongThanhToan.setText(String.valueOf(tien.format(tongThanhToan) + "VNĐ"));
					txtDiemTichDuoc.setText("0");
					
				}else {
					// Tính điểm tích được
			        diemTichDuoc = (float) (tongThanhToan * tyLeDiem);
			        
			        txtTongThanhToan.setText(String.valueOf(tien.format(tongThanhToan) + "VNĐ"));
			        txtDiemTichDuoc.setText(String.valueOf(tien.format(diemTichDuoc)));
			        txtDiemSuDung.setEditable(true);
				
			        timTenVaMaKhachHangBySDT(txtSDT.getText());
			}}
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
//		Tính tiền thừa
		txtTienKhachDua.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}
			private void updateTotal() {
				try {
					if(txtTienKhachDua.getText()=="") {
						int tienNhan =0;
						txtTienKhachDua.setText("0");
						double tienHoanLai = tienNhan - tongThanhToan;
						txtTienHoanLai.setText(tien.format(tienHoanLai)+" VNĐ");
					}
					else {
						double tienNhan = Double.parseDouble(txtTienKhachDua.getText());
						double tienHoanLai = tienNhan - tongThanhToan;
						txtTienHoanLai.setText(tien.format(tienHoanLai)+" VNĐ");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
//		Tính điểm sử dụng
		txtDiemSuDung.getDocument().addDocumentListener(new DocumentListener() {
		   
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTotal();
			}
			private void updateTotal() {
			    try {
			        double diemsudung = Double.parseDouble(txtDiemSuDung.getText());
			        double diemtl = Double.parseDouble(txtDiemTL.getText());

			        if (diemsudung <= diemtl) {
			            tongThanhToan = tongTienSP - diemsudung;
			            txtTongThanhToan.setText(tien.format(tongThanhToan) + " VNĐ");
			        } else {
			            JOptionPane.showMessageDialog(null, "Điểm sử dụng phải nhỏ hơn hoặc bằng điểm tích lũy.");
			            txtDiemSuDung.setText("");
			        }
			    } catch (NumberFormatException ex) {

			    }
			}

		});
		
		txtTienKhachDua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//
				try {
					if(txtTienKhachDua.getText()=="") {
						int tienNhan =0;
						txtTienKhachDua.setText("0");
						double tienHoanLai = tienNhan - tongThanhToan;
						txtTienHoanLai.setText(tien.format(tienHoanLai)+" VNĐ");
					}
					else {
						double tienNhan = Double.parseDouble(txtTienKhachDua.getText());
						double tienHoanLai = tienNhan - tongThanhToan;
						txtTienHoanLai.setText(tien.format(tienHoanLai)+" VNĐ");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});


		// disable edit trong table
				table_CTHD.setDefaultEditor(Object.class, null);

				txtSoLuong = new JTextField();
				txtSoLuong.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
							e.consume();
						}
					}
				});
				txtSoLuong.setEditable(false);
				DefaultCellEditor colSoLuong = new DefaultCellEditor(txtSoLuong);

// Thêm MouseListener cho table_CTHD để lắng nghe sự kiện click vào dòng
		        table_CTHD.addMouseListener((MouseListener) new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                if (e.getClickCount() == 1) { // Click một lần
		                    int selectedRow = table_CTHD.getSelectedRow();
		                
		                }
		            }
		        });
		        
				table_CTHD.getModel().addTableModelListener(new TableModelListener() {
		            @Override
		            public void tableChanged(TableModelEvent e) {
		                if (e.getType() == TableModelEvent.UPDATE) {
		                    int row = e.getFirstRow();
		                    int column = e.getColumn();
		                    if (column != TableModelEvent.ALL_COLUMNS) {
		                        Object data = table_CTHD.getValueAt(row, column);
		                       
		                    }
		                }
		            }
		        });

		        table_dscho.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        int selectedRow = table_dscho.getSelectedRow();
				        if (selectedRow >= 0) {
				            String selectedMaHoaDon = table_dscho.getValueAt(selectedRow, 0).toString();
				            Object hoaDonVaChiTietObj = danhSachHoaDon.get(selectedMaHoaDon);
				            if (hoaDonVaChiTietObj instanceof Map) {
				                Map<String, Object> hoaDonVaChiTiet = (Map<String, Object>) hoaDonVaChiTietObj;
				               
				                // Xóa dòng được chọn từ table_dscho
				                DefaultTableModel model = (DefaultTableModel) table_dscho.getModel();
				                model.removeRow(selectedRow);

				                // Cập nhật lại table_CTHDin hoặc các thành phần khác nếu cần
				                updateTextFieldsWithHoaDonInfo(hoaDonVaChiTiet);
				                updateTableCTHDWithChiTietHoaDon(hoaDonVaChiTiet);

				            } else {
				                System.err.println("Không thể thêm hóa đơn chờ");
				            }
				        }
				    }
				});
		    }
	
	
	
	
//    Thực hiện các chức năng
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnLamMoiThanhTimKiem))
		{
			XoatrangthanhTK();
		}
		else if(o.equals(btnLamMoiHD))
		{
			LammoiHD();
		}
		else if(o.equals(btnHuyHD))
		{
			HuyHD();
			xoatableCTHD();
		}
		else if(o.equals(btnThemSP)) 
		{
			Themsoluong();
		}
		else if(o.equals(btnHangCho)) 
		{
			themHangCho();
		}
		else if (o.equals(btnThanhToan)) 
		{
			thanhToan();
		}
		else if (o.equals(cboTimSP))
		{
			chonSanPham();
		}
		else if (o.equals(btnXoaAllSP)) 
		{
			xoatableCTHD();
		}
	
}
	
	private void updateTextFieldsWithHoaDonInfo(Map<String, Object> hoaDonVaChiTiet) {
   
		txtMaHD.setText(hoaDonVaChiTiet.get("MaHoaDon").toString());
		txtSDT.setText(hoaDonVaChiTiet.get("SoDienThoai").toString());
		txtDiemTichDuoc.setText(hoaDonVaChiTiet.get("DiemTichDuoc").toString());
		txtTongSL.setText(hoaDonVaChiTiet.get("SoLuong").toString());

		txtTongTienSP.setText(hoaDonVaChiTiet.get("TongTienSP").toString());
		txtDiemTL.setText(hoaDonVaChiTiet.get("DiemTichLuy").toString());
		txtDiemSuDung.setText(hoaDonVaChiTiet.get("DiemSuDung").toString());
		//txttongtiensp.setText(hoaDonVaChiTiet.get("TienHoanLai").toString());
		txtTongThanhToan.setText(hoaDonVaChiTiet.get("TongThanhToan").toString());
		txtMaKH.setText(hoaDonVaChiTiet.get("MaKhachHang").toString());
		txtTenKH.setText(hoaDonVaChiTiet.get("TenKhachHang").toString());
//		txttienkhachdua.setText(hoaDonVaChiTiet.get("TienKhachDua").toString());
		tongTienSP = Double.parseDouble(txtTongTienSP.getText().replace("VNĐ", "").replace(",", ""));
		tongSL = Integer.parseInt(txtTongSL.getText());
		
	     tongThanhToan = Double.parseDouble(txtTongThanhToan.getText().replace("VNĐ", "").replace(",", "")); // Biến tổng tiền sản phẩm
	
	}

	private void updateTableCTHDWithChiTietHoaDon(Map<String, Object> hoaDonVaChiTiet) {
	    DefaultTableModel model = (DefaultTableModel) table_CTHD.getModel();
	    model.setRowCount(0);

	    Object chiTietHoaDonObj = hoaDonVaChiTiet.get("ChiTietHoaDon");
	    
	    if (chiTietHoaDonObj instanceof List) {
	        List<?> chiTietHoaDonList = (List<?>) chiTietHoaDonObj;

	        for (Object chiTietObj : chiTietHoaDonList) {
	            if (chiTietObj instanceof Map) {
	                Map<?, ?> chiTiet = (Map<?, ?>) chiTietObj;

	                int stt = Integer.parseInt(chiTiet.get("STT").toString());
	                String maSP = chiTiet.get("MaSanPham").toString();
	                String tenSanPham = chiTiet.get("TenSanPham").toString();
	                String mauSac = chiTiet.get("MauSac").toString();
	                String size = chiTiet.get("Size").toString();
	                String chatLieu = chiTiet.get("ChatLieu").toString();
	                String donGia = chiTiet.get("DonGia").toString();
	                int soLuongBan = Integer.parseInt(chiTiet.get("SoLuongBan").toString());
	                float vat = Float.parseFloat(chiTiet.get("VAT").toString());
	                double khuyenMai = Double.parseDouble(chiTiet.get("KhuyenMai").toString());
	                String thanhTien = chiTiet.get("ThanhTien").toString();
	                model.addRow(new Object[]{stt, maSP, tenSanPham, mauSac, size, chatLieu, donGia, tienNoString.format(soLuongBan), tien.format(vat), tienNoString.format(khuyenMai), thanhTien});
	            }
	        }
	    }
	}

	
	private Map<String, Object> layThongTinHoaDonVaChiTiet() {
        Map<String, Object> hoaDonVaChiTiet = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy , HH:mm");
        String maHoaDon = updateMaHD();
        String nhanVien = LHD_dao.getTenNV(tenNhanVien);
        String ngayLap = LocalDateTime.now().format(formatter);
        String maKH = txtMaKH.getText();
        String hoTenKh = txtTenKH.getText();
        String diemtichluy = txtDiemTL.getText();

        String soDT = txtSDT.getText();
        String tongsl = txtTongSL.getText();
        String diemtichduoc = txtDiemTichDuoc.getText();
        String diemsudung = txtDiemSuDung.getText();
        String tongtiensp = txtTongTienSP.getText();
        String dtlhienco = tinhDTLHienCo(diemtichluy, diemsudung, diemtichduoc);
        
        String tongthanhtoan = txtTongThanhToan.getText();
//        String tienkhachdua = txttienkhachdua.getText();
//        double tkd = Double.parseDouble(tienkhachdua);
//        String tienhoanlai = txttienhoanlai.getText();

        hoaDonVaChiTiet.put("MaHoaDon", maHoaDon);
        hoaDonVaChiTiet.put("NgayLap", ngayLap);
        hoaDonVaChiTiet.put("SoLuong", tongsl);
        hoaDonVaChiTiet.put("TongTienSP", tongtiensp);
        hoaDonVaChiTiet.put("DiemTichDuoc", diemtichduoc);
        hoaDonVaChiTiet.put("DiemSuDung", diemsudung);
 
        hoaDonVaChiTiet.put("TongThanhToan", tongthanhtoan);
//        hoaDonVaChiTiet.put("TienKhachDua", tienkhachdua);
//        hoaDonVaChiTiet.put("TienHoanLai", tienhoanlai);
        hoaDonVaChiTiet.put("SoDienThoai", soDT);
        hoaDonVaChiTiet.put("MaKhachHang", maKH);
        hoaDonVaChiTiet.put("DiemTichLuy", diemtichluy);
        hoaDonVaChiTiet.put("TenKhachHang", hoTenKh);
        hoaDonVaChiTiet.put("TenNhanVien", FrmDangNhap.taiKhoan.getTenDangNhap());

        // Lấy thông tin chi tiết hóa đơn từ bảng
        List<Map<String, Object>> chiTietHoaDonList = new ArrayList<>();
        for (int i = 0; i < table_CTHD.getRowCount(); i++) {
            Map<String, Object> chiTiet = new HashMap<>();
            chiTiet.put("STT", table_CTHD.getValueAt(i, 0));
            chiTiet.put("TenSanPham", table_CTHD.getValueAt(i, 2));
            chiTiet.put("MauSac", table_CTHD.getValueAt(i, 3));
            chiTiet.put("Size", table_CTHD.getValueAt(i, 4));
            chiTiet.put("ChatLieu", table_CTHD.getValueAt(i, 5));
            chiTiet.put("DonGia", table_CTHD.getValueAt(i, 6));
            chiTiet.put("SoLuongBan", table_CTHD.getValueAt(i, 7));
            chiTiet.put("VAT", table_CTHD.getValueAt(i, 8));
            chiTiet.put("KhuyenMai", table_CTHD.getValueAt(i, 9));
            chiTiet.put("ThanhTien", table_CTHD.getValueAt(i, 10));
            chiTiet.put("MaSanPham", table_CTHD.getValueAt(i, 1));
            chiTietHoaDonList.add(chiTiet);
        }

     // Thêm hóa đơn và chi tiết hóa đơn vào Map
        hoaDonVaChiTiet.put("HoaDon", hoaDonVaChiTiet);  // Thay đổi từ "MaHoaDon" thành "HoaDon"
        hoaDonVaChiTiet.put("ChiTietHoaDon", chiTietHoaDonList);
        DefaultTableModel model = (DefaultTableModel) table_CTHD.getModel();

	    model.setRowCount(0);
	    updateMaHD();
		HuyHD();
		xoatableCTHD();
        return hoaDonVaChiTiet;
    }

	private Map<String, Object> danhSachHoaDon = new HashMap<>();
	private JLabel lblTongKhuyenMai;
	private JLabel lblTongThue;
	private JTextField txtTongKhuyenMai;
	private JLabel lblKhuyenMai;
	private JComboBox cboKhuyenMai;
	private JTextField txtTongThue;
//	Kiểm tra trùng sản phẩm
	private boolean kiemTraTrung(String masp) {
		
		for (int i = 0; i < table_CTHD.getRowCount(); i++)
		{
			if(table_CTHD.getValueAt(i, 1).toString().equals(masp))
				return true;
		}
		return false;
	}
//	Lấy ra số lượng ban đầu của sản phẩm
	private int getSoLuongBanDau(String masp) {
		
		for (int i = 0; i < table_SP.getRowCount(); i++)
		{
			if(table_SP.getValueAt(i, 0).toString().equals(masp))
				return Integer.parseInt(table_SP.getValueAt(i, 6).toString());
		}
		return 0;
	}
//	Thêm sản phẩm mới vào danh sách
    public void Themsoluong() {
        int selectedRow = table_SP.getSelectedRow();
        int n = table_CTHD.getRowCount() + 1;

        if (selectedRow >= 0) {
            String masp1 = (String) table_SP.getValueAt(selectedRow, 0);

            if (!kiemTraTrung(masp1)) {
                boolean check = true;

                while (check) {
                    String soLuongSPObj = JOptionPane.showInputDialog("Nhập số lượng sản phẩm mua.", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (soLuongSPObj == null) {
                        check = false;
                    } else if (soLuongSPObj.matches("^[0-9]+$")) {
                        int slInt = Integer.parseInt(soLuongSPObj);
                        int soLuongDaBan = LHD_dao.soLuongSPDaBan(masp1);
                        int soLuongNhap = LHD_dao.soLuongNhap(masp1);

                        if ((slInt) <= soLuongNhap) {
                            sanPham x =  daoSP.getMa(masp1);
                            String Tenkm =  daoSP.getKMTheoTen(x.getKhuyenMai().getMaKhuyenMai()  );
                			int km =  LHD_dao.getKMTheoPhanTram(Tenkm);
                          
                            DefaultTableModel modelNEw = (DefaultTableModel) table_CTHD.getModel();
                            
                        	float VAT = x.getVAT();
                        	if (daoSP.vat(x.getMaSP()) == 1) {

                				VAT = (float) (tinhGiaBan(x.getGiaNhap()) * 0.05);
                			} else
                				VAT = 0;
                            double tongGia = 0;
                            int tongsl = 0;

                                int soLuongBanDau = getSoLuongBanDau(x.getMaSP());
                                int soLuongConLai = soLuongBanDau - slInt;
                                table_SP.setValueAt(soLuongConLai, selectedRow, 6);
                             
                                modelNEw.addRow(new Object[] {
                                		table_CTHD.getRowCount() + 1,x.getMaSP(),x.getTenSP(), x.getMauSac(), x.getSize(), x.getChatLieu().getMaChatLieu(), tien.format(x.getGiaBan()), slInt, tienNoString.format(VAT), km, tien.format( x.getGiaBan() * slInt)
                                });

                                
                                tongsl += slInt;
                                tongGia += x.getGiaBan() * slInt;
                      

                            table_CTHD.setModel(modelNEw);
                            check = false;

                            // Cập nhật các biến tổng sau khi thêm sản phẩm mới vào table_CTHD
                            tongSL += tongsl;
                            tongTienSP += tongGia;
                            tongThanhToan = tongTienSP - diemsudung;
                          
                            diemTichDuoc = (float) (tongTienSP * tyLeDiem);
                            

                            // Cập nhật các JTextField
                            txtTongSL.setText(String.valueOf(tongSL));
                            txtTongTienSP.setText(tien.format(tongTienSP) + "VNĐ");
                            txtTongThanhToan.setText(String.valueOf(tien.format(tongThanhToan) + "VNĐ"));
                            txtDiemTichDuoc.setText(String.valueOf(tien.format(diemTichDuoc)));

                         // Cập nhật dữ liệu vào frmXuatHoaDon
//                            frmXuatHD.setDuLieuFrmInHd(maHoaDon, nhanVien, ngayLap, hoTenKh, diachi, soDT, String.valueOf(tongSL), String.valueOf(diemTichDuoc), String.valueOf(diemSuDung), tien.format(tongTienSP), tien.format(tongThanhToan), tien.format(tienKhachDua), tien.format(tienHoanLai));
                                } else {
                            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm mua vượt quá số lượng còn lại.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập một số nguyên dương.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại trong danh sách chi tiết hóa đơn.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm từ danh sách trước.");
        }
    }
    
    
  // Thêm chi tiết hóa đơn
    
// kiểm tra trùng sản phẩm
	public boolean kiemTraTrungSP(String masp) {
		List data = modelNEw.getDataVector();
		Object[] list1 = data.toArray();
		for(int k=0;k<list1.length;k++) {
			String masptable = modelNEw.getValueAt(k, 1).toString();

			if(masp.equalsIgnoreCase(masptable)) {
				table_CTHD.setRowSelectionInterval(k, k);
				return true;
			}
		}
		return false;
	}
	
	public void timTenVaMaKhachHangBySDT(String sdt) {
	    try {
	        for (KhachHang khachHang : LHD_dao.timKhachHangBySDT(sdt)) {
	            String maKH = khachHang.getMaKH();
	            String tenKH = khachHang.getTenKH();
	            float dtl = LHD_dao.getDiem(sdt);
	            txtMaKH.setText(maKH);
	            txtTenKH.setText(tenKH);
	            txtDiemTL.setText(String.valueOf(dtl));
	        }
	    } catch (Exception e) {
	    }
	}
	
	public void docDuLieuSP() {
        List<sanPham> list = daoSP.getAllSP();
        DefaultTableModel tablemodel = (DefaultTableModel) table_SP.getModel();
        
        
        for (sanPham x : list) {
        	String Tenkm =  daoSP.getKMTheoTen(x.getKhuyenMai().getMaKhuyenMai()  );
			int km =  LHD_dao.getKMTheoPhanTram(Tenkm);
        	double giaBan = x.getGiaBan();
        	float VAT = x.getVAT();
        	if (daoSP.vat(x.getMaSP()) == 1) {

				VAT = (float) (tinhGiaBan(x.getGiaNhap()) * 0.05);
			} else
				VAT = 0;
        }
    }
	public void updateComBoBox()
	{
		 List<sanPham> list = daoSP.getAllSP();        
	        for (sanPham x : list) {        	
	        	cboTimSP.addItem(x.getMaSP());
	        }
	}
	public double tinhGiaBan(double giaNhap)
	{
		
		double m = 0;
	
			m = giaNhap * 2.5;
	
		return m;
	}
	
	public void XoatrangthanhTK() {
		cboTimSP.setSelectedItem("");
		deleteAllDataTable();
		docDuLieuSP();
	}
	
	public void LammoiHD() {
		txtDiemSuDung.setText("");
		txtTienKhachDua.setText("");
		txtTienHoanLai.setText("");
		txtDiemSuDung.requestFocus();
		
	}
	
	public void HuyHD() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtSDT.setText("");
		txtDiemTL.setText("");
		txtDiemSuDung.setText("");
		txtDiemTichDuoc.setText("");
		txtTongSL.setText("");
		txtTienKhachDua.setText("");
		txtTongTienSP.setText("");
		txtTienHoanLai.setText("");
		txtTongThanhToan.setText("");
		txtSDT.requestFocus();
		deleteAllDataTable();
		docDuLieuSP();
		xoatableCTHD();	
	}
// Tính tổng tiền	
	public void tinhTong() {
	    tongSL = 0;
	    tongTienSP = 0;

	    DecimalFormat decimalFormat = new DecimalFormat("#,###.##");

	    for (int i = 0; i < table_CTHD.getRowCount(); i++) {
	        tongSL += Integer.parseInt(table_CTHD.getValueAt(i, 7).toString());
	        tongTienSP += Double.parseDouble(table_CTHD.getValueAt(i, 10).toString().replace(",", ""));
	    }

	    txtTongSL.setText(tongSL + "");
	    txtDiemTichDuoc.setText(decimalFormat.format(tongTienSP/100));
	    txtTongTienSP.setText(decimalFormat.format(tongTienSP) + "VNĐ");
	    txtDiemSuDung.setText("0");
	    txtTongThanhToan.setText(decimalFormat.format(tongTienSP - (Double.parseDouble(txtDiemSuDung.getText()))));
	}

	
// Xóa thông tin bảng
		public void deleteAllDataTable() {
			tablemodel = (DefaultTableModel) table_SP.getModel();
			tablemodel.getDataVector().removeAllElements();
			
		}
	
		public void xoatableCTHD() {
			for (int j= 0; j < table_CTHD.getRowCount(); j++) {
				 for(int i = 0; i < table_SP.getRowCount(); i++) {
		            	if(table_SP.getValueAt(i, 0).toString().equals(table_CTHD.getValueAt(j, 1).toString()))
		            		table_SP.setValueAt(Integer.parseInt(table_SP.getValueAt(i, 6).toString()) + Integer.parseInt(table_CTHD.getValueAt(j, 7).toString()),i, 6);
		            }
			}
		    DefaultTableModel model = (DefaultTableModel) table_CTHD.getModel();
		    model.setRowCount(0); 
		     tongSL = 0;
		     tongTienSP = 0; 
		     tongThanhToan = 0; 
		     tyLeDiem = 0.01; 
		        txtDiemTL.setText("");
		        txtTongSL.setText("");
		        txtDiemTichDuoc.setText("");
		        txtDiemSuDung.setText("");
		        txtTongTienSP.setText("");
		        txtTongThanhToan.setText("");
		        txtTienHoanLai.setText("");
		    // Cập nhật giao diện người dùng
		    model.fireTableDataChanged(); 
		}


	    	public String updateMaHD() {
	    	    // --HĐXXXXNVXXXYYMMDD
	    	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
	    	    String ngayLap = LocalDateTime.now().format(formatter);
	    	    int soLuongHD = LHD_dao.soLuongHD() + 1 + table_dscho.getRowCount();
	    	    String soLuongHDDformatted = String.format("%04d", soLuongHD);
	    	    String maHoaDon = "HD" + soLuongHDDformatted + tenNhanVien + ngayLap;
	    	    int n = 1;
	    	    List<HoaDon> hd = xem_dao.getAllHoaDon();
	    	    for (HoaDon x : hd)
	    	    {
	    	    	if (tenNhanVien.equals("admin"))
	    	    	{
	    	    		maHoaDon = "HD" + soLuongHDDformatted + "NV000" + ngayLap;
	    	    	}
	    	    	else 
	    	    	{
		    	    		while (x.getMaHoaDon().equalsIgnoreCase(maHoaDon))
		    	    	{
		    	    		soLuongHDDformatted = String.format("%04d", n);
		    	    		maHoaDon = "HD" + soLuongHDDformatted + tenNhanVien + ngayLap;
		    	    		n++;
		    	    	}
	    	    	}
	    	    	
	    	    }
	    	    return maHoaDon;
	    	}

	    
// Tính điểm tích lũy hiện có
	    public String tinhDTLHienCo(String diemtichluy, String diemsudung, String diemtichduoc) {
	        double diemtichluyValue = Double.parseDouble(diemtichluy.replace(",", ""));
	        double diemsudungValue = Double.parseDouble(diemsudung.replace(",", ""));
	        double diemtichduocValue = Double.parseDouble(diemtichduoc.replace(",", ""));
	        double dtlhiencoValue = diemtichluyValue - diemsudungValue + diemtichduocValue;
	        return String.valueOf(dtlhiencoValue);
	    }
	 // Tính điểm tích lũy hiện có
	    public double tinhDTLHienCoDouble(String diemtichluy, String diemsudung, String diemtichduoc) {
	        double diemtichluyValue = Double.parseDouble(diemtichluy.replace(",", ""));
	        double diemsudungValue = Double.parseDouble(diemsudung.replace(",", ""));
	        double diemtichduocValue = Double.parseDouble(diemtichduoc.replace(",", ""));
	        double dtlhiencoValue = diemtichluyValue - diemsudungValue + diemtichduocValue;
	        return dtlhiencoValue;
	    } 
	 // Phương thức kiểm tra Double hợp lệ
	    private boolean isValidDouble(String input) {
	        return input.matches("^-?\\d+(\\.\\d+)?$");
	    }
//	    Lấy sản phẩm để bán
	    public void chonSanPham()
	    {
	    	String selectedMaSP = cboTimSP.getSelectedItem().toString();

	        DefaultTableModel tablemodel = (DefaultTableModel) table_SP.getModel();
	        tablemodel.setRowCount(0); // Xóa dữ liệu hiện tại trong bảng
	       
	        List<sanPham> list = daoSP.getAllSP();
	        for (sanPham x : list) {
	        	 int soLuong = x.getSoLuong();
	        	 float vatValue = x.getVAT();
	        	 String vatStatus = (vatValue == 1) ? "Có (5%)" : "Không";
	        	 String km = "Không";
	        	 KhuyenMai khuyenMai = x.getKhuyenMai();

	        	 if (khuyenMai != null) {
	        	     String maKhuyenMai = khuyenMai.getMaKhuyenMai();
	        	     if (maKhuyenMai != null && !maKhuyenMai.isEmpty()) {
	        	         km = maKhuyenMai;
	        	     }
	        	 }

	        	 double giaBan = x.getGiaBan();
	        	
	        	for (int i = 0; i< table_CTHD.getRowCount(); i++)
	        	{
	        		if(table_CTHD.getValueAt(i, 1).toString().equals(selectedMaSP))
	        		{
	        			soLuong = x.getSoLuong() - (int) table_CTHD.getValueAt(i, 7);
	        		}
	        	}
	            if (x.getMaSP().equals(selectedMaSP)) {
	            	tablemodel.addRow(new Object[] {
	            			x.getMaSP(), x.getTenSP(), x.getMaLoai().getMaLoai(), x.getMauSac(), x.getSize(),  x.getChatLieu().getMaChatLieu(), soLuong, giaBan,vatStatus, 
	            			km});    
	            	table_SP.selectAll();
	            }
	        }
	    }

//	    thêm hóa đơn vào hàng chờ
	    private void themVaoDanhSachCho() {
		    DefaultTableModel model = (DefaultTableModel) table_dscho.getModel();
		    model.setRowCount(0);
		    for (Map.Entry<String, Object> entry : danhSachHoaDon.entrySet()) {
		        Map<String, Object> hoaDonVaChiTiet = (Map<String, Object>) entry.getValue();
		        Map<String, Object> hoaDon = (Map<String, Object>) hoaDonVaChiTiet.get("HoaDon");

		        String maHoaDon = (String) hoaDon.get("MaHoaDon");
		        String tenKhachHang = (String) hoaDon.get("SoDienThoai");
		        String tenNhanVien = (String) hoaDon.get("TenNhanVien");
		        String ngayTao = (String) hoaDon.get("NgayLap");
		        String soLuong = (String) hoaDon.get("SoLuong");
		        
		        model.addRow(new Object[]{maHoaDon, tenKhachHang, FrmDangNhap.taiKhoan.getTenDangNhap(), soLuong , ngayTao});
		    }
		}
//	    Bắt lỗi khi thêm vào hàng chờ
	    public void themHangCho()
	    {
	    	if (txtSDT.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại khách hàng trước khi đưa vào hóa đơn chờ.");
		        txtSDT.setText(""); 
		        txtSDT.requestFocus(); 
		        return; 
		    }
			if (table_CTHD.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Hóa đơn trống. Không thể thêm vào hàng chờ.");
            } else {
                Map<String, Object> hoaDonVaChiTiet = layThongTinHoaDonVaChiTiet();
                danhSachHoaDon.put((String) hoaDonVaChiTiet.get("MaHoaDon"), hoaDonVaChiTiet);
                themVaoDanhSachCho();
//                System.out.println("Thông tin hóa đơn:");
//                System.out.println(hoaDonVaChiTiet.get("HoaDon").toString());

                List<Map<String, Object>> chiTietHoaDonList = (List<Map<String, Object>>) hoaDonVaChiTiet.get("ChiTietHoaDon");
//                System.out.println("Thông tin chi tiết hóa đơn:");
                for (Map<String, Object> chiTiet : chiTietHoaDonList) {
//                    System.out.println(chiTiet.toString());
                }
            }
			 txtMaHD.setText(updateMaHD());
		        HuyHD();
	    }
//	    Thanh toán
	    public void thanhToan()
	    {
	    	if (table_CTHD.getRowCount() == 0) {
		        JOptionPane.showMessageDialog(this, "Chưa có sản phẩm nào cần thanh toán.");
		        return; 
		    }
		    if (txtSDT.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại khách hàng trước khi thanh toán.");
		        txtSDT.setText(""); 
		        txtSDT.requestFocus(); 
		        return; 
		    }
		    if (txtDiemSuDung.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Vui lòng nhập số điểm sử dụng trước khi thanh toán.");
		        txtDiemSuDung.setText(""); 
		        txtDiemSuDung.requestFocus(); 
		        return; 
		    }

		    if (txtTienKhachDua.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách đưa trước khi thanh toán.");
		        txtTienKhachDua.setText(""); 
		        txtTienKhachDua.requestFocus(); 
		        return; 
		    }

		    if (!isValidDouble(txtTienKhachDua.getText())) {
		        JOptionPane.showMessageDialog(this, "Vui lòng nhập một giá trị số hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
		        txtTienKhachDua.setText(""); 
		        txtTienKhachDua.requestFocus(); 
		        return;
		    }

		    double tienNhan = Double.parseDouble(txtTienKhachDua.getText());

		    if (tienNhan < tongThanhToan) {
		        JOptionPane.showMessageDialog(this, "Số tiền khách đưa phải lớn hơn hoặc bằng tổng số tiền cần thanh toán.");
		        txtTienKhachDua.setText(""); 
		        txtTienKhachDua.requestFocus(); 
		        return; 
		    }

		    int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thanh toán hóa đơn này? Hóa đơn sẽ được in sau khi bạn đồng ý!");

		    if (dialogResult == JOptionPane.YES_OPTION) {
		 
		    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy , HH:mm");
		        String maHoaDon = updateMaHD();
		        String nhanVien = LHD_dao.getTenNV(tenNhanVien); 
		        String ngayLap = LocalDateTime.now().format(formatter);
		        String maKH = txtMaKH.getText();
		        String hoTenKh = txtTenKH.getText(); 
		        String diemtichluy = txtDiemTL.getText(); 
		        
		        String soDT = txtSDT.getText(); 
		        String tongsl = txtTongSL.getText(); 
		        String diemtichduoc = txtDiemTichDuoc.getText(); 
		        String diemsudung = txtDiemSuDung.getText();
		        String tongtiensp = txtTongTienSP.getText();
		        String dtlhienco = tinhDTLHienCo(diemtichluy, diemsudung, diemtichduoc);
		        
		        String tongthanhtoan = txtTongThanhToan.getText(); 

		        String tienkhachdua = txtTienKhachDua.getText(); 
		        double tkd = Double.parseDouble(tienkhachdua);
		        String tienhoanlai = txtTienHoanLai.getText(); 

		        frmXuatHD.setVisible(true);

		        frmXuatHD.setDuLieuFrmInHd(maHoaDon, nhanVien, ngayLap, hoTenKh, dtlhienco, soDT, tongsl, diemtichduoc, diemsudung, tongtiensp, tongthanhtoan, tienkhachdua, tienhoanlai);
		        
		        LHD_dao.upDateHoaDon(maHoaDon, tkd, diemTichDuoc, tenNhanVien, maKH, tongThanhToan);
		        for(int i = 0; i <table_CTHD.getRowCount(); i++) {
					  
		        	int soLuongBan = Integer.parseInt(table_CTHD.getValueAt(i, 7).toString().replace(",", ""));
		        	String maSanPham = table_CTHD.getValueAt(i, 1).toString();
		        
		        	LHD_dao.addCT_HoaDon(maHoaDon, maSanPham, soLuongBan);
		        }
		        frmXuatHD.capNhatDuLieuTableCTHD((DefaultTableModel) table_CTHD.getModel()); 
		        frmXuatHD.printingHoaDon();
		        txtMaHD.setText(updateMaHD());
		        HuyHD();
				LHD_dao.updateDiem(tinhDTLHienCoDouble(diemtichluy, diemsudung, diemtichduoc), soDT);
				
				

		    }
	    }
//	    xóa sản phẩm ra khỏi chi tiết hóa đơn
	    public void xoaSanPham() {
			  int selectedRow = table_CTHD.getSelectedRow();

		        if (selectedRow != -1) {
		            DefaultTableModel model = (DefaultTableModel) table_CTHD.getModel();
		            int soLuongBan = Integer.parseInt(model.getValueAt(selectedRow, 7).toString());
		            int tongSoLuong = Integer.parseInt(txtTongSL.getText());
		            String cleanedString = txtTongTienSP.getText().replaceAll("[^\\d.]", "");

		            double tongTienSPs = Double.parseDouble(cleanedString);
		            double donGia = Double.parseDouble(model.getValueAt(selectedRow, 6).toString().replace(",", ""));
		            for(int i = 0; i < table_SP.getRowCount(); i++) {
		            	if(table_SP.getValueAt(i, 0).toString().equals(table_CTHD.getValueAt(selectedRow, 1).toString()))
		            		table_SP.setValueAt(Integer.parseInt(table_SP.getValueAt(i, 6).toString()) + soLuongBan,i, 6);
		            }
		            tongSoLuong -= soLuongBan;
		            tongTienSPs -= soLuongBan * donGia;
		            tongSL = tongSoLuong;
		            diemTichDuoc = Float.parseFloat((0.01 * tongTienSPs) + ""); 
		            txtDiemTichDuoc.setText(diemTichDuoc + "");
		            tongTienSP = tongTienSPs;
		            txtTongSL.setText(String.valueOf(tongSoLuong));
		            txtTongTienSP.setText(String.valueOf(tongTienSP));

		            model.removeRow(selectedRow);
		        } else {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa.");
		        }
	    }
}
class CustomTableModel extends AbstractTableModel {
    private Vector<Vector<Object>> data;
    private Vector<String> columnNames;

    public CustomTableModel(Vector<Vector<Object>> data, Vector<String> columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        data.get(rowIndex).set(columnIndex, value);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }
   
}
 class ButtonRenderer implements TableCellRenderer {
    private JPanel panel;
    private JButton btnCong;
    private JButton btnTru;
    private JLabel soLuongBan;

    public ButtonRenderer() {
        panel = new JPanel();
        btnCong = new JButton("+");
        btnTru = new JButton("-");
       
        btnCong = new JButton("+");
        btnCong.setFont(new Font("Times New Roman", Font.BOLD, 20)); 
        btnCong.setOpaque(false);
        btnCong.setContentAreaFilled(false);
        btnCong.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        Dimension btnSize = new Dimension(25, 20); 
        btnCong.setPreferredSize(btnSize);

        btnTru = new JButton("-");
        btnTru.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnTru.setOpaque(false);
        btnTru.setContentAreaFilled(false); 
        btnTru.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        btnTru.setPreferredSize(btnSize);
        
        soLuongBan = new JLabel();
        soLuongBan.setHorizontalAlignment(SwingConstants.CENTER);
        btnCong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int soLuong = Integer.parseInt(soLuongBan.getText());
                soLuongBan.setText(String.valueOf(soLuong + 1));
            }
        });

        btnTru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int soLuong = Integer.parseInt(soLuongBan.getText());
                if (soLuong > 1) {
                    soLuongBan.setText(String.valueOf(soLuong - 1));
                }
            }
        });

        panel.setLayout(new BorderLayout());
        panel.add(btnTru, BorderLayout.WEST);
        panel.add(soLuongBan, BorderLayout.CENTER);
        panel.add(btnCong, BorderLayout.EAST);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        soLuongBan.setText(value == null ? "" : value.toString());
        table.getModel().setValueAt(Integer.parseInt(soLuongBan.getText()), row, 7);
        return panel;
    }
}

 class ButtonEditor extends DefaultCellEditor {
    private JPanel panel;
    private JButton btnCong;
    private JButton btnTru;
    private JLabel soLuongBan;
    private int clickedRow;
    private int clickedColumn;
    private JTable table;
    private JTable table_sp;
    private JComboBox cboTimSP;
    public ButtonEditor(JTextField textField, final JTable table, final JTable table_sp, final FrmLapHoaDon frm, JComboBox cboTimSP) {
        super(textField);
        panel = new JPanel();
        this.table = table;
        this.cboTimSP = cboTimSP;
        this.table_sp = table_sp;
        btnCong = new JButton("+");
        btnCong.setFont(new Font("Times New Roman", Font.BOLD, 20)); 
        btnCong.setOpaque(false);
        btnCong.setContentAreaFilled(false);
        btnCong.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        Dimension btnSize = new Dimension(25, 20); 
        btnCong.setPreferredSize(btnSize);

        btnTru = new JButton("-");
        btnTru.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnTru.setOpaque(false);
        btnTru.setContentAreaFilled(false); 
        btnTru.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        btnTru.setPreferredSize(btnSize);
        
        soLuongBan = new JLabel();
        soLuongBan.setHorizontalAlignment(SwingConstants.CENTER);
        soLuongBan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	chonSanPham();
            	int oldSoLuong = Integer.parseInt(soLuongBan.getText());
                inputSoLuong();
                updateModel();
                for(int i = 0 ; i < table_sp.getRowCount(); i++) {
               	if(table.getRowCount() > 0) {
               		if(table_sp.getValueAt(i, 0).toString().equals(table.getValueAt(clickedRow, 1).toString())) {
               			int soLuongSP = Integer.parseInt(table_sp.getValueAt(i, 6).toString());
               			int soLuongMoi = Integer.parseInt(table.getValueAt(clickedRow, 7).toString());
               			soLuongSP = soLuongSP + (oldSoLuong - soLuongMoi);
               			table_sp.setValueAt(soLuongSP,i, 6);
               			break;
               		}
               	}
               	}
                frm.tinhTong();
            }
        });
        btnCong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	chonSanPham();
            	  int soLuongSP = 0;
                  for(int i = 0 ; i < table_sp.getRowCount(); i++) {
                 		if(table_sp.getValueAt(i, 0).toString().equals(table.getValueAt(clickedRow, 1).toString())) {
                 
                 			soLuongSP = Integer.parseInt(table_sp.getValueAt(i, 6).toString());
                 			
                 		}
                 	}
                int soLuong = Integer.parseInt(soLuongBan.getText());
                if (soLuongSP == 0) {
                	
                    JOptionPane.showMessageDialog(null,"Số lượng vượt quá số lượng tồn","Thông báo",JOptionPane.ERROR_MESSAGE);return;
                
           }
                soLuongBan.setText(String.valueOf(soLuong + 1));
                updateModel();
              	for(int i = 0 ; i < table_sp.getRowCount(); i++) {
               		if(table_sp.getValueAt(i, 0).toString().equals(table.getValueAt(clickedRow, 1).toString())) {
               
               			int soLuongMoi = Integer.parseInt(table_sp.getValueAt(i, 6).toString()) - 1;
               			table_sp.setValueAt(soLuongMoi,i, 6);
               			break;
               		}
               	}
              	frm.tinhTong();
            }
            
        });

        btnTru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	chonSanPham();
                int soLuong = Integer.parseInt(soLuongBan.getText());
                if (soLuong > 1) {
                    soLuongBan.setText(String.valueOf(soLuong - 1));
                    updateModel();
                    for(int i = 0 ; i < table_sp.getRowCount(); i++) {
                   		if(table_sp.getValueAt(i, 0).toString().equals(table.getValueAt(clickedRow, 1).toString())) {
                   
                   			int soLuongMoi = Integer.parseInt(table_sp.getValueAt(i, 6).toString()) + 1;
                   			table_sp.setValueAt(soLuongMoi,i, 6);
                   			break;
                   		}
                   	}
                }
                if(soLuong - 1 == 0 ) {
               	 soLuongBan.setText(String.valueOf(soLuong));
             	chonSanPham();
             	updateModel();
                for(int i = 0 ; i < table_sp.getRowCount(); i++) {
               		if(table_sp.getValueAt(i, 0).toString().equals(table.getValueAt(clickedRow, 1).toString())) {
               
               			int soLuongMoi = Integer.parseInt(table_sp.getValueAt(i, 6).toString()) + 1;
               			table_sp.setValueAt(soLuongMoi,i, 6);
               			break;
               		}
               	}
	                ((DefaultTableModel) table.getModel()).removeRow(clickedRow);
	            
                }
                frm.tinhTong();
            }
            
        });

        panel.setLayout(new BorderLayout());
        panel.add(btnTru, BorderLayout.WEST);
        panel.add(soLuongBan, BorderLayout.CENTER);
        panel.add(btnCong, BorderLayout.EAST);
    }
    public void chonSanPham() {
    		cboTimSP.setSelectedItem(table.getValueAt(clickedRow, 1).toString());
    }
    public void updatethanhTiens() {
        int cotSoLuong = 7;  
        int cotDonGia = 6;     
        int cotThanhTien = 10; 

        for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
            try {
                int soLuong = (int) table.getValueAt(rowIndex, cotSoLuong);
                System.out.println(soLuong);
                double donGia = Double.parseDouble(table.getValueAt(rowIndex, cotDonGia).toString().replace(",", ""));

                DecimalFormat decimalFormat = new DecimalFormat("#,##0");

                double thanhTien = soLuong * donGia;
                String thanhTienDaFormat = decimalFormat.format(thanhTien);

                table.setValueAt(thanhTienDaFormat, rowIndex, cotThanhTien);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void updateModel() {
        int row = table.getEditingRow();
        int column = table.getEditingColumn();
       
        if (row != -1 && column != -1 && table.getRowCount() > 0) {
            Object value = Integer.parseInt(soLuongBan.getText());
            table.getModel().setValueAt(value, row, 7);  
        }
        updatethanhTiens();
        
    }
    private void inputSoLuong() {
        String soLuongHienTai = soLuongBan.getText();

        String input = JOptionPane.showInputDialog(null, "Nhập số lượng mới:", "Chỉnh sửa Số lượng", JOptionPane.QUESTION_MESSAGE);
        int soLuongSP = 0;
        for (int i = 0; i < table_sp.getRowCount(); i++) {
            if (table_sp.getValueAt(i, 0).toString().equals(table.getValueAt(clickedRow, 1).toString())) {
                soLuongSP = Integer.parseInt(table_sp.getValueAt(i, 6).toString());
            }
        }

        if (input != null) {
            try {
                int soLuongNew = Integer.parseInt(input);
                if (soLuongNew > soLuongSP) {
                    JOptionPane.showMessageDialog(null, "Số lượng vượt quá số lượng tồn", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (soLuongNew > 0) {
                    soLuongBan.setText(String.valueOf(soLuongNew));
                } else if (soLuongNew == 0) {
                    chonSanPham();
                    updateModel();
                    for (int i = 0; i < table_sp.getRowCount(); i++) {
                        if (table_sp.getValueAt(i, 0).toString().equals(table.getValueAt(clickedRow, 1).toString())) {
                            int soLuongMoi = Integer.parseInt(table_sp.getValueAt(i, 6).toString()) + Integer.parseInt(soLuongHienTai);
                            table_sp.setValueAt(soLuongMoi, i, 6);
                            break;
                        }
                    }
                    ((DefaultTableModel) table.getModel()).removeRow(clickedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên dương quá", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi. Nhập dữ liệu số không hợp lệ.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        clickedRow = row;
        clickedColumn = column;
        soLuongBan.setText(value == null ? "" : value.toString());
        table.getModel().setValueAt(Integer.parseInt(soLuongBan.getText()), row, 7);
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return soLuongBan.getText();
    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }
}
 class ButtonDelete extends JButton implements TableCellRenderer {
	    public ButtonDelete() {
	        setOpaque(true);
	        // Thêm biểu tượng vào nút
	        setIcon(new ImageIcon("Anh\\xoaall.png"));
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        setText((value == null) ? "" : value.toString());
	        return this;
	    }
	}


 class ButtonDeleteEditor extends DefaultCellEditor {
	    private final JButton button;
	    private int clickedRow;
	    private final JComboBox<String> cboTimSP;
	    private final JTable table;
	    private final JTable table_sp;
	    private final FrmLapHoaDon frmLHD;

	    public ButtonDeleteEditor(final JTable table, final JTable tableSP, final FrmLapHoaDon frm, final JComboBox<String> cboTimSP) {
	        super(new JTextField());
	        button = new JButton();
	        button.setIcon(new ImageIcon("Anh\\xoaall.png"));
	        this.cboTimSP = cboTimSP;
	        this.table = table;
	        this.frmLHD = frm;
	        this.table_sp = tableSP;

	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                chonSanPham();
	                ((DefaultTableModel) table.getModel()).removeRow(clickedRow);
	                frmLHD.tinhTong();
	            }
	        });

	        editorComponent = button;
	    }

	    public void chonSanPham() {
	        String selectedProduct = table.getValueAt(clickedRow, 1).toString();
	        cboTimSP.setSelectedItem(selectedProduct);

	        for (int i = 0; i < table_sp.getRowCount(); i++) {
	            if (table_sp.getValueAt(i, 0).toString().equals(selectedProduct)) {
	                int soLuongMoi = Integer.parseInt(table_sp.getValueAt(i, 6).toString()) +
	                        Integer.parseInt(table.getValueAt(clickedRow, 7).toString());
	                table_sp.setValueAt(soLuongMoi, i, 6);
	                break;
	            }
	        }
	    }

	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        clickedRow = row;
	        return button;
	    }
	}