package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

import DAO.KhachHang_Dao;
import Database.ConnectDatabase;
import Entity.KhachHang;
import Entity.KhuyenMai;
import Entity.LoaiKhachHang;
import Entity.LoaiSanPham;

public class FrmKhachHang extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private JTextField txtDTL;
	private DefaultTableModel dataModel;
	private JTable table;
	private JTable table_1;
	private JPanel pnTable;
	private DefaultTableModel tablemodel;
	private JPanel pnl1;
	private JLabel lblTieuDeTrang;
	private JDateChooser txtChonNgay;
	KhachHang_Dao khDao = new KhachHang_Dao();

	List<LoaiKhachHang> listLKH = khDao.getLoaiKH();
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private JComboBox cboLoaiKhachHang;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnReset;
	private JButton btnTim;
	private JButton btnReset2;
	private JComboBox cboTim;
	private JRadioButton rdMaKH;
	private JRadioButton rdTenKH;
	private JRadioButton rdGend;
	private JRadioButton rdLoaiKH;
	private ButtonGroup buttonGroupTK;
	private ButtonGroup buttonGroupGT;
	private JLabel lblMaKH;
	private JLabel lblGend;
	private JLabel lblTenKH;
	private JLabel lblDiaChi;
	private JLabel lblSDT;
	private JLabel lblCCCD;
	private Container lblEmail;
	private JLabel lblBirth;
	private JLabel lblDTL;
	private JLabel lblLKH;
	private JPanel panel_2;
	private JButton btnLuu;
	private JLabel lblThongTinTim;
	private JLabel lblTim;

	private boolean chkThem = false;
	private boolean chkSua = false;
	private boolean lock = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectDatabase.getInstance().connect();
					FrmKhachHang frame = new FrmKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmKhachHang() {

		setTitle("Quản lí cửa hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1347, 843);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBackground(new Color(0, 255, 255));
		pnlTieuDe.setBounds(0, 0, 1343, 41);
		contentPane.add(pnlTieuDe);
		pnlTieuDe.setLayout(null);
		lblTieuDeTrang = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblTieuDeTrang.setBounds(512, 12, 305, 25);
		pnlTieuDe.add(lblTieuDeTrang);
		lblTieuDeTrang.setBackground(new Color(0, 255, 255));
		lblTieuDeTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeTrang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));

		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setForeground(new Color(0, 0, 0));
		pnlThongTin.setBackground(new Color(255, 255, 255));
		pnlThongTin.setBounds(20, 48, 1292, 252);
		javax.swing.border.Border southborder = BorderFactory.createLineBorder(Color.black);
		pnlThongTin.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thi\u1EBFt l\u1EADp th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		contentPane.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setBounds(10, 28, 114, 20);
		lblMaKH.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pnlThongTin.add(lblMaKH);

		txtMaKH = new JTextField(deFaultID());
		txtMaKH.setBounds(128, 28, 350, 20);
		txtMaKH.setEditable(false);
		pnlThongTin.add(txtMaKH);
		txtMaKH.setColumns(10);

		lblGend = new JLabel("Giới tính");
		lblGend.setBounds(578, 28, 71, 12);
		lblGend.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pnlThongTin.add(lblGend);

		lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTenKH.setBounds(10, 74, 96, 15);
		pnlThongTin.add(lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setBounds(128, 77, 350, 20);
		pnlThongTin.add(txtTenKH);
		txtTenKH.setColumns(10);

		lblDiaChi = new JLabel(" Địa chỉ");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDiaChi.setBounds(578, 75, 45, 13);
		pnlThongTin.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(686, 75, 350, 20);
		pnlThongTin.add(txtDiaChi);
		txtDiaChi.setColumns(10);

		lblSDT = new JLabel("Số điện thoại");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSDT.setBounds(10, 124, 96, 13);
		pnlThongTin.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setBounds(128, 124, 350, 20);
		pnlThongTin.add(txtSDT);
		txtSDT.setColumns(10);

		lblCCCD = new JLabel("CCCD");
		lblCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCCCD.setBounds(578, 124, 45, 13);
		pnlThongTin.add(lblCCCD);

		txtCCCD = new JTextField();
		txtCCCD.setBounds(686, 124, 350, 20);
		pnlThongTin.add(txtCCCD);
		txtCCCD.setColumns(10);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEmail.setBounds(10, 165, 45, 13);
		pnlThongTin.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(128, 165, 350, 20);
		pnlThongTin.add(txtEmail);
		txtEmail.setColumns(10);

		lblBirth = new JLabel("Ngày sinh");
		lblBirth.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblBirth.setBounds(578, 165, 114, 13);
		pnlThongTin.add(lblBirth);

		txtChonNgay = new JDateChooser();
		txtChonNgay.setBounds(686, 158, 350, 20);
		txtChonNgay.setForeground(new Color(0, 0, 0));
		txtChonNgay.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtChonNgay.setLocale(new Locale("vi", "VN"));
		txtChonNgay.setDateFormatString("dd/MM/yyyy");
		txtChonNgay.setDate(new Date(System.currentTimeMillis()));

		pnlThongTin.add(txtChonNgay);

		lblDTL = new JLabel("Điểm tích lũy");
		lblDTL.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDTL.setBounds(10, 212, 108, 13);
		pnlThongTin.add(lblDTL);

		txtDTL = new JTextField();
		txtDTL.setBounds(128, 211, 350, 20);
		txtDTL.setEditable(false);
		pnlThongTin.add(txtDTL);
		txtDTL.setColumns(10);

		lblLKH = new JLabel("Loại khách hàng");
		lblLKH.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLKH.setBounds(578, 212, 108, 13);
		pnlThongTin.add(lblLKH);

		cboLoaiKhachHang = new JComboBox();
		cboLoaiKhachHang.setBounds(686, 211, 350, 20);
		pnlThongTin.add(cboLoaiKhachHang);
		cboLoaiKhachHang.setEnabled(false);

		rdNam = new JRadioButton("Nam");
		rdNam.setBackground(new Color(255, 255, 255));
		rdNam.setBounds(686, 24, 132, 20);
		pnlThongTin.add(rdNam);

		rdNu = new JRadioButton("Nữ");
		rdNu.setBackground(new Color(255, 255, 255));
		rdNu.setBounds(825, 24, 103, 20);
		pnlThongTin.add(rdNu);

		 buttonGroupGT = new ButtonGroup();

		// Thêm các nút radio vào ButtonGroup
		buttonGroupGT.add(rdNam);
		buttonGroupGT.add(rdNu);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(
				new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(1051, 32, 241, 189);
		pnlThongTin.add(panel_2);
		panel_2.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(0, 255, 255));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setIcon(new ImageIcon("Anh\\them.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setBounds(39, 21, 160, 30);
		panel_2.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(0, 255, 255));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setIcon(new ImageIcon("Anh\\sua.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.setBounds(39, 61, 160, 30);
		panel_2.add(btnSua);

		btnReset = new JButton("Làm mới");
		btnReset.setBackground(new Color(0, 255, 255));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setIcon(new ImageIcon("Anh\\lammoi.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setBounds(39, 101, 160, 30);
		panel_2.add(btnReset);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("Anh\\luu.png"));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLuu.setBackground(Color.CYAN);
		btnLuu.setBounds(39, 141, 160, 30);
		panel_2.add(btnLuu);

		JPanel lblTable = new JPanel();
		lblTable.setBackground(new Color(255, 255, 255));
		lblTable.setBorder(new TitledBorder(null, "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		lblTable.setBounds(20, 310, 1292, 486);
		contentPane.add(lblTable);
		lblTable.setLayout(null);

		lblThongTinTim = new JLabel("Nhập thông tin tìm kiếm");
		lblThongTinTim.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblThongTinTim.setBounds(10, 24, 134, 13);
		lblTable.add(lblThongTinTim);

		cboTim = new JComboBox();
		cboTim.setBounds(154, 20, 851, 20);
		lblTable.add(cboTim);
		

		lblTim = new JLabel("Tìm theo");
		lblTim.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTim.setBounds(10, 61, 81, 13);
		lblTable.add(lblTim);

		rdMaKH = new JRadioButton("Mã khách hàng");
		rdMaKH.setBackground(new Color(255, 255, 255));
		rdMaKH.setBounds(154, 57, 232, 20);
		lblTable.add(rdMaKH);

		rdTenKH = new JRadioButton("Tên khách hàng");
		rdTenKH.setBackground(new Color(255, 255, 255));
		rdTenKH.setBounds(388, 57, 219, 20);
		lblTable.add(rdTenKH);

		rdGend = new JRadioButton("Giới tính");
		rdGend.setBackground(new Color(255, 255, 255));
		rdGend.setBounds(623, 57, 172, 20);
		lblTable.add(rdGend);

		rdLoaiKH = new JRadioButton("Loại khách hàng");
		rdLoaiKH.setBackground(new Color(255, 255, 255));
		rdLoaiKH.setBounds(797, 57, 208, 20);
		lblTable.add(rdLoaiKH);

		 buttonGroupTK = new ButtonGroup();

		// Thêm các nút radio vào ButtonGroup
		buttonGroupTK.add(rdMaKH);
		buttonGroupTK.add(rdTenKH);
		buttonGroupTK.add(rdGend);
		buttonGroupTK.add(rdLoaiKH);

		btnTim = new JButton("Tìm kiếm");
		btnTim.setBackground(new Color(0, 255, 255));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setIcon(new ImageIcon("Anh\\timkiem.png"));
		btnTim.setBounds(1027, 44, 125, 30);
		lblTable.add(btnTim);

		btnReset2 = new JButton("Làm mới");
		btnReset2.setBackground(new Color(0, 255, 255));
		btnReset2.setIcon(new ImageIcon("Anh\\lammoi.png"));
		btnReset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset2.setBounds(1162, 44, 120, 30);
		lblTable.add(btnReset2);

		JScrollPane scrDSKH;
		String[] tb1 = new String[] { "Mã KH", "Tên KH", "Giới tính", "SĐT", "CCCD", "Ngày sinh", "Email", " Địa chỉ",
				" Điểm tích lũy", "Loại KH" };
		tablemodel = new DefaultTableModel(tb1, 0);
		table_1 = new JTable(tablemodel);

		table_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table_1.setBackground(new Color(224, 255, 255));
		table_1.setForeground(new Color(0, 0, 0));
		getContentPane().add(scrDSKH = new JScrollPane(table_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.CENTER);
		scrDSKH.setBounds(10, 104, 1272, 372);
		lblTable.add(scrDSKH);
		scrDSKH.setPreferredSize(new Dimension(0, 250));
		khoaTXT(lock);
		
		
//		 cboModelLKH = new DefaultComboBoxModel<String>();
//		List<KhachHang> list = new ArrayList<>();
//		for (KhachHang kh : list) {
//			cboModelLKH.addElement(kh.getLoaiKH().getMaLoai());
//			comboBox.setModel(cboModelLKH);
////		}
		docDuLieu();
		updateCBBox();
		table_1.addMouseListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnReset.addActionListener(this);
		btnTim.addActionListener(this);
		btnReset2.addActionListener(this);
		btnLuu.addActionListener(this);
		rdMaKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateCBBoxTim();

			}
		});
		rdTenKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateCBBoxTim();

			}
		});
		rdGend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateCBBoxTim();

			}
		});
		rdLoaiKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateCBBoxTim();

			}
		});
	}

	private void docDuLieu() {
	    try {
	        List<KhachHang> list = khDao.getAllKhachHang();

	        for (KhachHang khachHang : list) {
	            String gioiTinhText = dinhDangGT(khachHang);
	            float diemTichLuy = khDao.getDiem(khachHang.getMaKH());
	            String loaiKhachHang = khDao.getTenLoaiKH(khachHang.getMaKH());

	            // Kiểm tra điều kiện và cập nhật loại khách hàng
	            if (diemTichLuy >= 50000) {
	                loaiKhachHang = "VIP";
	            }

	            tablemodel.addRow(new Object[] { khachHang.getMaKH(), khachHang.getTenKH(), gioiTinhText,
	                    khachHang.getSdt(), khachHang.getCCCD(), khachHang.getNgaySinh(), khachHang.getEmail(),
	                    khachHang.getDiaChi(), diemTichLuy, loaiKhachHang });
	        }
	        table_1.setModel(tablemodel);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if(chkThem == false)
			{
				themKH();
			}
				
			else if (chkThem == true)
			{
				lock = false;
				khoaTXT(lock);
				btnThem.setText("Thêm");
				chkThem = false;
				btnSua.setEnabled(true);
				btnThem.setIcon(new ImageIcon("Anh\\them.png"));
			}
		}
		if (o.equals(btnSua)) {
			if(chkSua == false)
			{
				sua();
			}
				
			else if (chkSua == true)
			{
				lock = false;
				khoaTXT(lock);
				btnSua.setText("Sửa");
				chkSua = false;
				btnThem.setEnabled(true);
				btnSua.setIcon(new ImageIcon("Anh\\sua.png"));
				
			}
		}
		if (o.equals(btnReset)) {
			xoaTrang();
		}
		if (o.equals(btnTim)) {
			tim();
		}
		if (o.equals(btnReset2)) {
			xoaTrangTimKiem();
		}
		else if (o.equals(btnLuu))
		{
			try {
				luuThayDoi();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int d = 1;
		int row = table_1.getSelectedRow();
		txtMaKH.setText(tablemodel.getValueAt(row, 0).toString());
		txtTenKH.setText(tablemodel.getValueAt(row, 1).toString());

		txtSDT.setText(tablemodel.getValueAt(row, 3).toString());
		txtCCCD.setText(tablemodel.getValueAt(row, 4).toString());
		txtChonNgay.setDate(khDao.getAllKhachHang().get(row).getNgaySinh());
		txtEmail.setText(tablemodel.getValueAt(row, 6).toString());
		txtDiaChi.setText(tablemodel.getValueAt(row, 7).toString());
		txtDTL.setText(tablemodel.getValueAt(row, 8).toString());
		cboLoaiKhachHang.setSelectedItem(tablemodel.getValueAt(row, 9).toString());
//		updateCBBox();
		List<KhachHang> list = khDao.getAllKhachHang();
		for (KhachHang x : list) {
			if (x.maKH.equals(tablemodel.getValueAt(row, 0).toString())) {
				if (x.gioiTinh == 1) {
					rdNam.setSelected(true);
					rdNu.setSelected(false);
				}

				else {
					rdNam.setSelected(false);
					rdNu.setSelected(true);
				}

			}
		}
		btnThem.setEnabled(false);
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

	public void updateCBBox() {
		cboLoaiKhachHang.removeAllItems();

//		for (KhachHang n : listN) {
//			comboBox.addItem(n.getLoaiKH().getMaLoai());
//
//		}
		List<LoaiKhachHang> kh = khDao.getLoaiKH();
		HashSet<String> lkh = new HashSet<>();

		for (LoaiKhachHang x : kh) {
			String d = x.getTenLoai();
			lkh.add(d);
		}
		for (String loaiKH : lkh) {
			cboLoaiKhachHang.addItem(loaiKH);
		}
	}

	public void updateCBBoxTim() {
		cboTim.removeAllItems();
		List<KhachHang> listN = khDao.getAllKhachHang();
		for (KhachHang n : listN) {
			if (rdMaKH.isSelected()) {
				cboTim.addItem(n.getMaKH());
			} else if (rdTenKH.isSelected()) {
				cboTim.addItem(n.getTenKH());
			} else if (rdGend.isSelected()) {
				List<KhachHang> kh = khDao.getAllKhachHang();
				HashSet<String> lkh = new HashSet<>();
				for (KhachHang x : kh) {
					String gend = dinhDangGT(x);
					lkh.add(gend);
				}
				cboTim.removeAllItems();
				for (String GT : lkh) {
					cboTim.addItem(GT);
				}

			} else if (rdLoaiKH.isSelected()) {
				List<KhachHang> kh = khDao.getAllKhachHang();
				HashSet<String> lkh = new HashSet<>();

				for (KhachHang x : kh) {
					String o = khDao.getTenLoaiKH(x.getMaKH());

					lkh.add(o);
				}
				cboTim.removeAllItems();
				for (String loaiKH : lkh) {
					cboTim.addItem(loaiKH);
				}
			}
		}

	}
	public void khoaTXT(boolean x) {
		txtEmail.setEditable(x);
		txtSDT.setEditable(x);
		txtTenKH.setEditable(x);
		txtCCCD.setEditable(x);
		txtDiaChi.setEditable(x);
		btnLuu.setEnabled(x);
	}
public void themKH()
{
	lock = true;
	khoaTXT(lock);
	chkThem = true;
	btnThem.setText("Hủy");
	btnSua.setEnabled(false);
	txtTenKH.requestFocus();
	btnThem.setIcon(new ImageIcon("Anh\\huy.png"));
}
	public void luuThayDoi() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String MaKH = txtMaKH.getText();
		String tenKH = txtTenKH.getText();
		String Sdt = txtSDT.getText();
		String CCCD = txtCCCD.getText();
		String ngaySinh1 = dateFormat.format(txtChonNgay.getDate());
		java.util.Date ngaySinh2 = dateFormat.parse(ngaySinh1);
		Date ngaySinh = new Date(ngaySinh2.getTime());
		String email = txtEmail.getText();
		String diaChi = txtDiaChi.getText();
		String maLoai = (String) cboLoaiKhachHang.getSelectedItem();
		int gioiTinh = 2;
		float dtluy = 0;
		

		if (rdNam.isSelected()) {
			gioiTinh = 1;
		} else if (rdNu.isSelected()) {
			gioiTinh = 0;
		}
		for (LoaiKhachHang l : listLKH) {
			if (l.getTenLoai().equalsIgnoreCase(maLoai))
				maLoai = l.getMaLoai();
		}
		KhachHang kh = valiData();
		if(kh == null)
			return;
		else {
			if (chkThem == true && chkSua == false)
			{
				try {

				boolean newL = khDao.them(tenKH, Sdt, CCCD, ngaySinh, diaChi, gioiTinh, maLoai, email, dtluy);
				if (newL == true) {
					btnThem.setText("Thêm");
					xoaTrang();
					deleteAllDataTable();
					docDuLieu();
						 txtMaKH.setText(deFaultID());
						 chkSua = false;
							chkThem = false;
							lock = false;
							btnSua.setIcon(new ImageIcon("Anh\\sua.png"));
							btnThem.setIcon(new ImageIcon("Anh\\them.png"));
							btnSua.setEnabled(true);
							btnThem.setEnabled(true);
					JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
				} else

					JOptionPane.showMessageDialog(this, "Thêm khách hàng không thành công");
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
			else if (chkSua == true && chkThem == false)
			{
				float dlLuyNew = Float.parseFloat(txtDTL.getText());
				boolean newL = khDao.sua(tenKH, Sdt, CCCD, ngaySinh, diaChi, gioiTinh, maLoai, email,dlLuyNew, MaKH);

				if (newL) {
					btnSua.setText("Sửa");
					// Cập nhật dữ liệu bảng trước khi hiển thị thông báo thành công
					deleteAllDataTable();
					docDuLieu();
					xoaTrang();
					JOptionPane.showMessageDialog(this, "Sửa Thành Công");
					chkSua = false;
					chkThem = false;
					lock = false;
					btnSua.setIcon(new ImageIcon("Anh\\sua.png"));
					btnThem.setIcon(new ImageIcon("Anh\\them.png"));
					btnSua.setEnabled(true);
					btnThem.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(this, "Sửa Không Thành Công");
				}
			}
			
		}

	}

//	Sửa thông tin khach hang
	public void sua(){
		lock = true;
		khoaTXT(lock);
		chkSua = true;
		btnSua.setText("Hủy");
		btnThem.setEnabled(false);
		btnSua.setIcon(new ImageIcon("Anh\\huy.png"));
//		txtTenKH.requestFocus();
	}

	public void tim() {
		deleteAllDataTable();
		int d = 1;
		String tim = "";
		int gioiTinh = 0;
		try {
			tim = cboTim.getSelectedItem().toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (tim.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Rỗng!");
			return;
		}

		if (rdTenKH.isSelected()) {
			KhachHang kh = khDao.getTen(tim);
			String gioiTinhText = dinhDangGT(kh);
			taiBang(kh, kh.getMaKH(), kh.getTenKH(), gioiTinhText, khDao.getTenLoaiKH(kh.getMaKH()));

		} else if (rdMaKH.isSelected()) {
			KhachHang kh = khDao.getMa(tim);
			String gioiTinhText = dinhDangGT(kh);
			taiBang(kh, kh.getMaKH(), kh.getTenKH(), gioiTinhText, khDao.getTenLoaiKH(kh.getMaKH()));

		} else if (rdGend.isSelected()) {
			if (cboTim.getSelectedItem().equals("Nam")) {
				gioiTinh = 1;
			} else if (cboTim.getSelectedItem().equals("Nữ"))
				gioiTinh = 0;
			List<KhachHang> listKH = khDao.getGT(gioiTinh);
			for (KhachHang kh : listKH) {
				String gioiTinhText = dinhDangGT(kh);

				taiBang(kh, kh.getMaKH(), kh.getTenKH(), gioiTinhText, khDao.getTenLoaiKH(kh.getMaKH()));
			}

		} else if (rdLoaiKH.isSelected()) {
					List<KhachHang> list = khDao.getlistLKH(tim);
				for (KhachHang kh : list) {
					String gioiTinhText = dinhDangGT(kh);
					taiBang(kh, kh.getTenKH(), kh.getTenKH(), gioiTinhText, khDao.getTenLoaiKH(kh.getMaKH()));
				}	
			
		}
	}
//	ĐỊnh đang giới tính
	public String dinhDangGT (KhachHang kh)
	{
		String gend = kh.getGioiTinh() == 1 ? "Nam" : "Nữ";
		return gend;
	}
//	tải lên bảng thông tin tìm kiếm
	public void taiBang (KhachHang kh, String maKH, String tenKH, String gioiTinhText, String loaiKH)
	{
		tablemodel.addRow(new Object[] { maKH, tenKH, gioiTinhText, kh.getSdt(), kh.getCCCD(),
				kh.getNgaySinh(), kh.getEmail(), kh.getDiaChi(), khDao.getDiem(kh.getMaKH()),
				loaiKH});
	}

//	Kiểm tra thông tin nhà cung cấp trước khi thêm
	public KhachHang valiData() {
		KhachHang kh;
		float dTichLuy = 0;
		String maKH = txtMaKH.getText().trim();
		if (txtTenKH.getText().isEmpty() || txtTenKH.getText().trim() == "") {
			ShowErrorField("Tên khách hàng không được rỗng", txtTenKH);
			return null;
		}
		String tenKH = txtTenKH.getText().trim();
		if (txtSDT.getText().isEmpty() || txtSDT.getText().trim() == "") {
			ShowErrorField("Số điện thoại khách hàng không được rỗng", txtSDT);
			return null;
		} else if (txtSDT.getText().trim().matches("^[0]\\d{9}$") == false) {
			ShowErrorField("Vui lòng nhập số điện thoại khách hàng bằng số và gồm 10 chữ số bất đầu bằng số 0 !",
					txtSDT);
			return null;
		}
		String sdt = txtSDT.getText().trim();

		if (txtEmail.getText().isEmpty() || txtEmail.getText().trim() == "") {
			ShowErrorField("Email khách hàng không được rỗng", txtEmail);
			return null;
		} else if (txtEmail.getText().trim().matches("^\\b[\\w.%+-]+@[\\w.-]+\\.com\\b$") == false) {
			ShowErrorField("Vui lòng nhập đúng email khách hàng !\\n ví dụ:quoc@gmail.com", txtEmail);
			return null;
		}
		String mail = txtEmail.getText().trim();
		if (txtDiaChi.getText().isEmpty() || txtDiaChi.getText().trim() == "") {
			ShowErrorField("Địa chỉ không được rỗng", txtDiaChi);
			return null;
		}
		String diaChi = txtDiaChi.getText().trim();

		int gioiTinh = 2;
		if (rdNam.isSelected()) {
			gioiTinh = 1;
		} else if (rdNu.isSelected()) {
			gioiTinh = 0;
		} else if (gioiTinh == 2) {
			JOptionPane.showMessageDialog(null, "Chưa chọn giới tính?");
			return null;
		}
		String CCCD = txtCCCD.getText().trim();
		if (txtCCCD.getText().isEmpty() || txtCCCD.getText().trim() == "") {
			ShowErrorField("Căn cước công dân khách hàng không được rỗng", txtCCCD);
			return null;
		} else if (txtCCCD.getText().trim().matches("^[0]\\d{11}$") == false) {
			ShowErrorField("Vui lòng nhập Căn cước công dân khách hàng bằng số và gồm 12 chữ số bất đầu bằng số 0 !",
					txtCCCD);
			return null;
		}
		java.util.Date ngaySinh = txtChonNgay.getDate();
		if (ngaySinh == null) {
			JOptionPane.showMessageDialog(this, "Ngày sinh không được rỗng");
			return null;
		}

		try {
			kh = new KhachHang(maKH, tenKH, sdt, CCCD, ngaySinh, diaChi, gioiTinh, null, mail,dTichLuy);
			return kh;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

	}

	private void ShowErrorField(String string, JTextField txt) {
		JOptionPane.showMessageDialog(null, string);
		txt.requestFocus();

	}
	public String deFaultID()
	{
		int n = khDao.soLuongKH() + 1;
		String soLuongMa  = String.format("%03d", n);
		String deFault =  soLuongMa;
		return deFault;
	}
	public void xoaTrang() {

		txtMaKH.setText(deFaultID());
		txtTenKH.setText("");
		txtSDT.setText("");
		txtCCCD.setText("");
		txtChonNgay.setDate(new Date(System.currentTimeMillis()));
		txtDiaChi.setText("");
		buttonGroupGT.clearSelection();
		cboLoaiKhachHang.setSelectedItem("");
		txtEmail.setText("");
		txtDTL.setText("");
		txtTenKH.requestFocus();
		deleteAllDataTable();
		docDuLieu();
	}

	public void xoaTrangTimKiem() {
		buttonGroupTK.clearSelection();
		cboTim.removeAllItems();
		deleteAllDataTable();
		docDuLieu();
	}

	public void deleteAllDataTable() {
		tablemodel = (DefaultTableModel) table_1.getModel();
		tablemodel.getDataVector().removeAllElements();
	}
}
