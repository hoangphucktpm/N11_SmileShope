package GUI;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import DAO.NhanVien_Dao;
import DAO.ThongKeHoaDon_Dao;

import Entity.NhanVien;
import Entity.ThongKeHoaDon;


import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JButton;
import javax.swing.ImageIcon;



public class FrmThongKeHoaDon extends JFrame implements ActionListener{

	public static DefaultTableModel tablemodel = new DefaultTableModel();
	private JTable table_1;
	private static final long serialVersionUID = 1L;
	private JTextField txtTenNV;
	private JLabel lblTieuDeTrang;
	JPanel pnlThongTin;
	private JPanel pnlThongTinTK;
	private JLabel lblHHDLTT;
	private JLabel lblSPDBTT;
	private JLabel lblTTTT;
	private JRadioButton rdQL;
	private JRadioButton rdNV;
	private JLabel lblChucVu;
	private JPanel pnlHinhThuc;
	private JLabel lblDate;
	private JDateChooser txtChonNgay;
	private JLabel lblNV;
	private JComboBox cbNV;
	private JLabel lblTenNV;
	private JLabel lblCa;
	private JComboBox cbCa;
	private JPanel pnTable;
	private JButton btnXem;
	private JPanel pnlTieuDe;
	private JTextField textHDDL;
	private JTextField textSPDB;
	private JTextField textTT;
	
	private ThongKeHoaDon_Dao dao = new ThongKeHoaDon_Dao();
	
	private NhanVien_Dao daoNV = new NhanVien_Dao();
	private JPanel pnlBieuDo;
	public ChartPanel chartPanel;

	public FrmThongKeHoaDon() {
		
		pnlThongTin = new JPanel();
		getContentPane().setBackground(new Color(129, 250, 243));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1347, 843);
		setLocationRelativeTo(null);
		setResizable(false);
		
		lblTieuDeTrang = new JLabel("THỐNG KÊ HÓA ĐƠN ĐÃ LẬP");
		lblTieuDeTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeTrang.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblTieuDeTrang.setBounds(512, 12, 305, 25);
		lblTieuDeTrang.setBounds(0, 0, 1343, 41);
		pnlThongTin.add(lblTieuDeTrang);
		
		
		pnlThongTin.setBackground(new Color(255, 255, 255));
		pnlThongTin.setBounds(0, 0, 1333, 806);
		getContentPane().add(pnlThongTin);
		pnlThongTin.setLayout(null);
		
		pnlThongTinTK = new JPanel();
		pnlThongTinTK.setBackground(new Color(255, 255, 255));
		pnlThongTinTK.setBounds(20, 52, 353, 227);
		pnlThongTin.add(pnlThongTinTK);
		javax.swing.border.Border southborder=BorderFactory.createLineBorder(Color.black);
		TitledBorder southTitleBorder2=new TitledBorder(southborder,"Thông tin thống kê");
		southTitleBorder2.setTitleColor(Color.black);
		pnlThongTinTK.setBorder(southTitleBorder2);
		pnlThongTin.add(pnlThongTinTK);
		pnlThongTinTK.setLayout(null);
		
		lblHHDLTT = new JLabel("Số hóa đơn đã lập:");
		lblHHDLTT.setBounds(37, 51, 133, 15);
		pnlThongTinTK.add(lblHHDLTT);
		lblHHDLTT.setHorizontalAlignment(SwingConstants.LEFT);
		lblHHDLTT.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textHDDL = new JTextField();
		textHDDL.setBounds(173, 46, 123, 24);
		pnlThongTinTK.add(textHDDL);
		textHDDL.setEditable(false);
		textHDDL.setHorizontalAlignment(SwingConstants.LEFT);
		textHDDL.setForeground(new Color(0, 0, 0));
		textHDDL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textHDDL.setColumns(10);
		textHDDL.setBackground(new Color(255, 255, 255));
		
		lblSPDBTT = new JLabel("Số sản phẩm đã bán:");
		lblSPDBTT.setBounds(37, 103, 133, 15);
		pnlThongTinTK.add(lblSPDBTT);
		lblSPDBTT.setHorizontalAlignment(SwingConstants.LEFT);
		lblSPDBTT.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textSPDB = new JTextField();
		textSPDB.setBounds(173, 98, 123, 24);
		pnlThongTinTK.add(textSPDB);
		textSPDB.setEditable(false);
		textSPDB.setHorizontalAlignment(SwingConstants.LEFT);
		textSPDB.setForeground(new Color(0, 0, 0));
		textSPDB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textSPDB.setColumns(10);
		textSPDB.setBackground(new Color(255, 255, 255));
		
		lblTTTT = new JLabel("Tổng tiền bán:\r\n");
		lblTTTT.setBounds(37, 154, 133, 15);
		pnlThongTinTK.add(lblTTTT);
		lblTTTT.setHorizontalAlignment(SwingConstants.LEFT);
		lblTTTT.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textTT = new JTextField();
		textTT.setBounds(173, 149, 123, 24);
		pnlThongTinTK.add(textTT);
		textTT.setEditable(false);
		textTT.setHorizontalAlignment(SwingConstants.LEFT);
		textTT.setForeground(new Color(0, 0, 0));
		textTT.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textTT.setColumns(10);
		textTT.setBackground(new Color(255, 255, 255));
		
		rdQL= new JRadioButton("Quản lý");
		rdQL.setEnabled(false);
		rdQL.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdQL.setBackground(new Color(255, 255, 255));
		rdQL.setBounds(133, 286, 119, 33);
		pnlThongTin.add(rdQL);
		
		rdNV = new JRadioButton("Nhân viên");
		rdNV.setEnabled(false);
		rdNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdNV.setBackground(new Color(255, 255, 255));
		rdNV.setBounds(254, 286, 119, 33);
		pnlThongTin.add(rdNV);
		
		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblChucVu.setBounds(30, 289, 85, 27);
		pnlThongTin.add(lblChucVu);
		
		pnlHinhThuc = new JPanel();
		pnlHinhThuc.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "H\u00ECnh th\u1EE9c th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlHinhThuc.setBackground(new Color(255, 255, 255));
		pnlHinhThuc.setBounds(20, 326, 1280, 81);
		pnlThongTin.add(pnlHinhThuc);
		pnlHinhThuc.setLayout(null);
		
		lblDate = new JLabel("Ngày:");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDate.setBounds(29, 32, 45, 27);
		pnlHinhThuc.add(lblDate);
		
		txtChonNgay = new JDateChooser();
		txtChonNgay.setBounds(74, 32, 115, 27);
		txtChonNgay.setForeground(new Color(0, 0, 0));
		txtChonNgay.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtChonNgay.setLocale(new Locale("vi", "VN"));
		txtChonNgay.setDateFormatString("dd/MM/yyyy");
		txtChonNgay.setDate(new Date(System.currentTimeMillis()));
		
	
		
		pnlHinhThuc.add(txtChonNgay);
		
		lblNV = new JLabel("Mã nhân viên:");
		lblNV.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblNV.setBounds(298, 33, 99, 27);
		pnlHinhThuc.add(lblNV);
		
		cbNV = new JComboBox();
		cbNV.setBounds(399, 32, 131, 27);
		pnlHinhThuc.add(cbNV);
		
		lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTenNV.setBounds(678, 32, 106, 27);
		pnlHinhThuc.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtTenNV.setEditable(false);
		txtTenNV.setBounds(785, 32, 162, 27);
		pnlHinhThuc.add(txtTenNV);
		txtTenNV.setColumns(10);
		
		lblCa = new JLabel("Ca làm việc:");
		lblCa.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCa.setBounds(1083, 32, 92, 27);
		pnlHinhThuc.add(lblCa);
		
		cbCa = new JComboBox();
		cbCa.setBounds(1166, 33, 92, 27);
		pnlHinhThuc.add(cbCa);
		
		pnTable = new JPanel();
		pnTable.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh s\u00E1ch:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTable.setBackground(new Color(255, 255, 255));
		pnTable.setBounds(20, 418, 1280, 316);
		pnlThongTin.add(pnTable);
		pnTable.setLayout(null);
		
		JScrollPane scrDSHD;
		String[] tb1 = new String[] {"STT","Mã Hóa Đơn","Mã Nhân viên","Ca Làm Việc","Số lượng","Ngày Lập","Loại Khách","Doanh thu"};
		tablemodel = new DefaultTableModel(tb1, 0);
		table_1 = new JTable(tablemodel);

		table_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table_1.setBackground(new Color(224, 255, 255));
		table_1.setForeground(new Color(0, 0, 0));
		getContentPane().add(scrDSHD=new JScrollPane(table_1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS),BorderLayout.CENTER);
		scrDSHD.setBounds(10, 21, 1270, 326);
		pnTable.add(scrDSHD);
		scrDSHD.setPreferredSize(new Dimension(0,250));
		
		btnXem = new JButton("Xem báo cáo");
		btnXem.setIcon(new ImageIcon("Anh\\xembaocao.png"));
		btnXem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXem.setBackground(new Color(0, 255, 255));
		btnXem.setBounds(537, 745, 188, 50);
		pnlThongTin.add(btnXem);
		
		pnlTieuDe = new JPanel();
		pnlTieuDe.setBackground(new Color(0, 255, 255));
		pnlTieuDe.setBounds(0, 0, 1338, 38);
		pnlThongTin.add(pnlTieuDe);
		
		pnlBieuDo = new JPanel();
		javax.swing.border.Border borderBieuDo = BorderFactory.createLineBorder(Color.black);
		TitledBorder borderBieuDo2 =new TitledBorder(borderBieuDo,"Top nhân viên");
		borderBieuDo2.setTitleColor(Color.black);
		pnlBieuDo.setBorder(borderBieuDo2);
		pnlBieuDo.setLayout(null);
		pnlBieuDo.setBackground(Color.WHITE);
		pnlBieuDo.setBounds(417, 52, 883, 227);
		pnlThongTin.add(pnlBieuDo);
		chartPanel = new ChartPanel(bieuDo());
		
		chartPanel.setMaximumDrawWidth(2000);
		chartPanel.setMaximumDrawHeight(1000);
		chartPanel.setBackground(new Color(255, 255, 255));
		chartPanel.setSize(863, 193);
		chartPanel.setLocation(10, 23);

		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		
		pnlBieuDo.add(chartPanel);
		chartPanel.repaint();
		
		upDateComboBox();
		phanQuyen();
		
		cbNV.addActionListener(this);
		btnXem.addActionListener(this);
;
	}
	public static void main(String[] args) {
		FrmThongKeHoaDon frm = new FrmThongKeHoaDon();
		frm.setVisible(true);
	}
	public void xoaAllDataTable() {
		tablemodel.addRow(new Object[] {});
		tablemodel = (DefaultTableModel) table_1.getModel();
		tablemodel.getDataVector().removeAllElements();

	}
//	Cập nhật các comboBox
	public void upDateComboBox()
	{
		cbCa.removeAllItems();
		cbNV.removeAllItems();
		cbCa.addItem("Tất cả");
		cbCa.addItem(1);
		cbCa.addItem(2);
		
		List<NhanVien> listNV = daoNV.getAllNV();
		if (listNV != null && !listNV.isEmpty())
		{
			cbNV.addItem("Tất cả");
			 for (NhanVien n : listNV)
			 {
				 if (!n.getMaNhanVien().contains("QL"))
						 {
					 cbNV.addItem(n.getMaNhanVien());
						 }
				 
			 }
		}

	}
//	Hàm lấy tên nhân viên
	private void chonTenNhanVien() {

		List<NhanVien> listNV = daoNV.getAllNV();
		String ma = (String) cbNV.getSelectedItem();
		 for (NhanVien n : listNV)
		 {
			 if (ma.equalsIgnoreCase(n.getMaNhanVien()))
			 txtTenNV.setText(n.getTenNV());
			 else if (ma.equalsIgnoreCase("Tất cả"))
				 txtTenNV.setText("");
		 }
	}

	public void hoaDonTheoNgayVaCa() throws ParseException
	{
		int n = 1;
		int ca = 0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
		String ngayBan = dateFormat.format(txtChonNgay.getDate());
		java.util.Date ngayBan1 = dateFormat.parse(ngayBan);
		Date ngayBansql = new Date(ngayBan1.getTime());
		
		Calendar ngayCld = Calendar.getInstance();
		ngayCld.setTime(txtChonNgay.getDate());
		
		int day = ngayCld.get(Calendar.DATE);
		int month = ngayCld.get(Calendar.MONTH) + 1;
		int year = ngayCld.get(Calendar.YEAR);
		
		if(cbCa.getSelectedItem().equals("Tất cả"))
		ca = 0;
		else if ((int) cbCa.getSelectedItem() == 1)
			ca = 1;
		else if ((int) cbCa.getSelectedItem() == 2)
			ca = 2;
		if(cbNV.getSelectedItem().equals("Tất cả"))
		{
			List<ThongKeHoaDon> list = dao.getHoaDonTheoNgayVaCa(day, month, year , ca);
			if (list != null && !list.isEmpty())
			docDuLieu(list, n);
			else
			{
				JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn");
				textHDDL.setText(String.valueOf(0));
				textSPDB.setText(String.valueOf(0));
				textTT.setText(String.valueOf(0));
			}
				
			}
		else {
			String maNV = (String) cbNV.getSelectedItem();
			List<ThongKeHoaDon> listNV = dao.getHoaDonTheoNV(day, month, year, maNV, ca);
			if (listNV != null && !listNV.isEmpty())
			docDuLieu(listNV, n);
			else
			{
				JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn");
				textHDDL.setText(String.valueOf(0));
				textSPDB.setText(String.valueOf(0));
				textTT.setText(String.valueOf(0));
			}
				
		}
	}
	public void docDuLieu(List<ThongKeHoaDon> list, int n)
	{
		DecimalFormat tien = new DecimalFormat("#,##0 VND");
		int soSP = 0;
		double sum = 0;
		for (ThongKeHoaDon hd : list)
		{
			tablemodel.addRow(new Object[] {
					n++, hd.getMaHoaDon(), hd.getMaNhanVien(), hd.getCaLamViec(), hd.getSoLuongSP(), hd.getNgayLap(), hd.getLoaiKH(), tien.format(hd.getDoanhThu())
					
			});
			soSP += hd.getSoLuongSP();
			sum += hd.getDoanhThu();
			
		}
		table_1.setModel(tablemodel);
		textHDDL.setText(String.valueOf(n - 1));
		textSPDB.setText(String.valueOf(soSP));
		textTT.setText(String.valueOf(tien.format(sum)));
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		chonTenNhanVien();
		if(o.equals(btnXem))
		{
			xoaAllDataTable();
			try {
				hoaDonTheoNgayVaCa();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
//	Phân quyền chức năng người dùng
	public void phanQuyen ()
	{
		if (!FrmDangNhap.TrangThaiDangNhapNhanVien && FrmDangNhap.TrangThaiDangNhapQuanLy)
		{
			rdQL.setSelected(true);
			
		}
		else if (FrmDangNhap.TrangThaiDangNhapNhanVien && !FrmDangNhap.TrangThaiDangNhapQuanLy)
		{
			rdNV.setSelected(true);
			String nhanVienDN = FrmDangNhap.taiKhoan.getTenDangNhap();
			List<NhanVien> listNV = daoNV.getAllNV();
			cbNV.setSelectedItem(nhanVienDN);
			 for (NhanVien n : listNV)
			 {
				 if (nhanVienDN.equalsIgnoreCase(n.getMaNhanVien()))
				 {
					  txtTenNV.setText(n.getTenNV());
				 cbCa.setSelectedItem(n.getCaLamViec());
				 }
				
			 }
			cbNV.setEnabled(false);
			cbCa.setEnabled(false);
			
		}
	}
	public  JFreeChart bieuDo()
	{
		JFreeChart barChart = ChartFactory.createBarChart(
                "NHÂN VIÊN LẬP ĐƯỢC NHIỀU HÓA ĐƠN NHẤT TRONG THÁNG",
                null, "Số hóa đơn",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
		
			CategoryPlot plot = (CategoryPlot) barChart.getPlot();
			BarRenderer renderer = (BarRenderer) plot.getRenderer();
			
			// Tùy chỉnh trục x (CategoryAxis)
	        CategoryAxis xAxis = plot.getDomainAxis();
	        xAxis.setTickLabelFont(new Font("Times New Roman", Font.PLAIN, 13));

	        // Tùy chỉnh trục y (NumberAxis)
	        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
	        yAxis.setTickLabelFont(new Font("Times New Roman", Font.PLAIN, 13));
	        
	        
			renderer.setSeriesPaint(0, new Color(52, 155, 235));
			renderer.setBarPainter(new StandardBarPainter());
			renderer.setMaximumBarWidth(0.05);  
			plot.setBackgroundPaint(new Color(223, 229, 235));
			return barChart;
	}
	 public  CategoryDataset createDataset() {
	        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        for (int i = 1; i<= 5; i++)
	        {
	        	int tongHoaDon = dao.tongHoaDon(i);
	        	String nhanVienTop = dao.nhanVienTop(i);
	        	System.out.println(tongHoaDon);
	        	if (tongHoaDon != 0)
	        	{
	        		dataset.addValue(tongHoaDon, "Số tiền", nhanVienTop);
	        	}
	        }    
	        return dataset;
	    }
	 public void capNhatBieuDo() {
		    chartPanel.setChart(bieuDo());
		    chartPanel.repaint();
		}
}