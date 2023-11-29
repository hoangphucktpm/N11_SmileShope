package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;


public class FrmXuatHoaDon extends JFrame implements Printable,ActionListener {

	private static JPanel contentPane;
	public static JTable table_CTHDin;
	public static JLabel lblSmile;
	public static JLabel lblDiaChi;
	public static JLabel lblDienThoai;
	public static JLabel lblMHDon ;
	public static JLabel lblNgayLap;
	private static JPanel panel;
	public static DefaultTableModel tableModel ;
	public JLabel lblMaHD;
	public JLabel lblTieuDe;
	public JLabel lblGiaThue;
	public JLabel lblSDTCuaHang;
	public JLabel lblDiaChiCuaHang;
	public JLabel lblNhanVienLap;
	public JLabel lblSDTKH;
	public JLabel lblTenNV;
	public JLabel lblDate;
	public JLabel lbltenKH;
	public JLabel lblGetDienTichLuy;
	public JLabel lblGetSDT;
	public JLabel lblGetSoLuong;
	public JLabel lblTongTienSP;
	public JLabel getTongSoLuong;
	public JLabel getDiemTichDuoc;
	public JLabel getDiemSuDung;
	public JLabel getTongTien;
	public JLabel getTongThanhToan;
	public JLabel getTienKhachDua;
	public JLabel getTienHoan;
	private JScrollBar table_CTHD;
	private DefaultTableModel tableModelCTHD;
	private JLabel lblVN3;
	private JLabel lblVN2;
	private JLabel lblVN1;
	private JLabel lblVN;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmXuatHoaDon frame = new FrmXuatHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	
	public FrmXuatHoaDon() {
		setTitle("HÓA ĐƠN NHÀ THUỐC HẠNH PHÚC");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setSize( 1199, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(432, 11, 613, 756);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		lblSmile = new JLabel("C\u1EECA H\u00C0NG TH\u1EDCI TRANG SMILE");
		lblSmile.setBounds(164, 20, 309, 27);
		lblSmile.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSmile.setForeground(new Color(255, 0, 0));
		panel.add(lblSmile);
		
		lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(34, 52, 58, 21);
		lblDiaChi.setForeground(Color.BLUE);
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblDiaChi);
		
		lblDienThoai = new JLabel("Số điện thoại:");
		lblDienThoai.setBounds(34, 83, 96, 22);
		lblDienThoai.setForeground(Color.BLUE);
		lblDienThoai.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblDienThoai);
		
		lblMHDon = new JLabel("Mã hóa đơn:");
		lblMHDon.setBounds(34, 152, 83, 14);
		lblMHDon.setForeground(Color.BLUE);
		lblMHDon.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblMHDon);
		
		lblNgayLap = new JLabel("Ngày lập:");
		lblNgayLap.setBounds(34, 214, 75, 20);
		lblNgayLap.setForeground(Color.BLUE);
		lblNgayLap.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblNgayLap);
		
		lblTieuDe = new JLabel("HÓA ĐƠN THANH TOÁN");
		lblTieuDe.setBounds(199, 113, 235, 27);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(new Color(0, 0, 255));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblTieuDe);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 244, 596, 305);
		panel.add(scrollPane_1);
		
		
		String[] tb = new String[] {"STT","Tên sản phẩm","Màu sắc","Size","Chất liệu","Đơn giá","Số lượng","VAT","Khuyến mãi (%)","Thành tiền"};

		tableModel = new DefaultTableModel(tb,0);
		table_CTHDin = new JTable(tableModel);
		table_CTHDin.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		table_CTHDin.setBackground(Color.WHITE);
		
		
		table_CTHDin.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_CTHDin.getColumnModel().getColumn(1).setPreferredWidth(140);
		table_CTHDin.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_CTHDin.getColumnModel().getColumn(3).setPreferredWidth(50);
		table_CTHDin.getColumnModel().getColumn(5).setPreferredWidth(120);
		table_CTHDin.getColumnModel().getColumn(6).setPreferredWidth(80);
		table_CTHDin.getColumnModel().getColumn(8).setPreferredWidth(120);
		table_CTHDin.getColumnModel().getColumn(9).setPreferredWidth(120);
		scrollPane_1.setViewportView(table_CTHDin);
		
		lblGiaThue = new JLabel("(Giá đã bao gồm thuế VAT (5%) và Khuyến mãi trên từng sản phẩm (nếu có) )");
		lblGiaThue.setBounds(69, 684, 493, 21);
		lblGiaThue.setForeground(Color.BLUE);
		lblGiaThue.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		panel.add(lblGiaThue);
		
		lblSDTCuaHang = new JLabel("0368.564.833  - 0333.319.121");
		lblSDTCuaHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSDTCuaHang.setBounds(141, 86, 199, 14);
		panel.add(lblSDTCuaHang);
		
		lblDiaChiCuaHang = new JLabel("12 Nguyễn Văn Bảo - Phường 4 - Gò Vấp - Thành phố Hồ Chí Minh");
		lblDiaChiCuaHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDiaChiCuaHang.setBounds(141, 49, 450, 27);
		panel.add(lblDiaChiCuaHang);
		
		lblNhanVienLap = new JLabel("Nhân viên lập:");
		lblNhanVienLap.setForeground(Color.BLUE);
		lblNhanVienLap.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNhanVienLap.setBounds(34, 184, 113, 20);
		panel.add(lblNhanVienLap);
		
		lblSDTKH = new JLabel("Số điện thoại:");
		lblSDTKH.setForeground(Color.BLUE);
		lblSDTKH.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSDTKH.setBounds(332, 186, 96, 16);
		panel.add(lblSDTKH);
		
		JLabel lblDiemTichHC = new JLabel("Điểm tích lũy hiện có:");
		lblDiemTichHC.setForeground(Color.BLUE);
		lblDiemTichHC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDiemTichHC.setBounds(332, 214, 158, 17);
		panel.add(lblDiemTichHC);
		
		JLabel lblKhachHang = new JLabel("Khách hàng: ");
		lblKhachHang.setForeground(Color.BLUE);
		lblKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblKhachHang.setBounds(332, 146, 158, 27);
		panel.add(lblKhachHang);
		
		lblMaHD = new JLabel("");
		lblMaHD.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblMaHD.setBounds(141, 152, 168, 14);
		panel.add(lblMaHD);
		
		lblTenNV = new JLabel("");
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTenNV.setBounds(141, 189, 168, 14);
		panel.add(lblTenNV);
		
		lblDate = new JLabel("");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDate.setBounds(141, 219, 168, 14);
		panel.add(lblDate);
		
		lbltenKH = new JLabel("");
		lbltenKH.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbltenKH.setBounds(423, 150, 168, 14);
		panel.add(lbltenKH);
		
		lblGetDienTichLuy = new JLabel("");
		lblGetDienTichLuy.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGetDienTichLuy.setBounds(483, 214, 108, 14);
		panel.add(lblGetDienTichLuy);
		
		lblGetSDT = new JLabel("");
		lblGetSDT.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGetSDT.setBounds(423, 189, 168, 14);
		panel.add(lblGetSDT);
		
		lblGetSoLuong = new JLabel("Tổng số lượng:");
		lblGetSoLuong.setForeground(Color.BLUE);
		lblGetSoLuong.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGetSoLuong.setBounds(41, 559, 118, 20);
		panel.add(lblGetSoLuong);
		
		lblTongTienSP = new JLabel("Tổng tiền SP:");
		lblTongTienSP.setForeground(Color.BLUE);
		lblTongTienSP.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTongTienSP.setBounds(320, 559, 118, 20);
		panel.add(lblTongTienSP);
		
		JLabel lblDiemTichDuoc = new JLabel("Điểm tích được:");
		lblDiemTichDuoc.setForeground(Color.BLUE);
		lblDiemTichDuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDiemTichDuoc.setBounds(41, 589, 118, 20);
		panel.add(lblDiemTichDuoc);
		
		JLabel lblDiemSuaDung = new JLabel("Điểm sử dụng:");
		lblDiemSuaDung.setForeground(Color.BLUE);
		lblDiemSuaDung.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDiemSuaDung.setBounds(41, 619, 118, 20);
		panel.add(lblDiemSuaDung);
		
		JLabel lblTongTienThanhToan = new JLabel("Tổng thanh toán:");
		lblTongTienThanhToan.setForeground(Color.BLUE);
		lblTongTienThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTongTienThanhToan.setBounds(320, 589, 118, 20);
		panel.add(lblTongTienThanhToan);
		
		JLabel lblTienKhach = new JLabel("Tiền khách đưa:");
		lblTienKhach.setForeground(Color.BLUE);
		lblTienKhach.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTienKhach.setBounds(320, 619, 118, 20);
		panel.add(lblTienKhach);
		
		JLabel lblTienHoan = new JLabel("Tiền hoàn lại:");
		lblTienHoan.setForeground(Color.BLUE);
		lblTienHoan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTienHoan.setBounds(320, 652, 118, 20);
		panel.add(lblTienHoan);
		
		JLabel lblLoiCamOn = new JLabel("Xin cảm ơn quý khách, hẹn gặp lại !");
		lblLoiCamOn.setForeground(Color.BLUE);
		lblLoiCamOn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLoiCamOn.setBounds(185, 697, 250, 27);
		panel.add(lblLoiCamOn);
		
		getTongSoLuong = new JLabel("");
		getTongSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		getTongSoLuong.setBounds(152, 564, 162, 14);
		panel.add(getTongSoLuong);
		
		getDiemTichDuoc = new JLabel("");
		getDiemTichDuoc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		getDiemTichDuoc.setBounds(147, 594, 162, 14);
		panel.add(getDiemTichDuoc);
		
		getDiemSuDung = new JLabel("");
		getDiemSuDung.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		getDiemSuDung.setBounds(147, 624, 162, 14);
		panel.add(getDiemSuDung);
		
		getTongTien = new JLabel("");
		getTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		getTongTien.setBounds(435, 564, 162, 14);
		panel.add(getTongTien);
		
		getTongThanhToan = new JLabel("");
		getTongThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		getTongThanhToan.setBounds(435, 594, 162, 14);
		panel.add(getTongThanhToan);
		
		getTienKhachDua = new JLabel("");
		getTienKhachDua.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		getTienKhachDua.setBounds(435, 624, 162, 14);
		panel.add(getTienKhachDua);
		
		getTienHoan = new JLabel("");
		getTienHoan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		getTienHoan.setBounds(435, 658, 162, 14);
		panel.add(getTienHoan);
		
		lblVN = new JLabel("VNĐ");
		lblVN.setForeground(Color.BLUE);
		lblVN.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVN.setBounds(572, 559, 34, 21);
		panel.add(lblVN);
		
		lblVN1 = new JLabel("VNĐ");
		lblVN1.setForeground(Color.BLUE);
		lblVN1.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVN1.setBounds(572, 589, 34, 21);
		panel.add(lblVN1);
		
		lblVN2 = new JLabel("VNĐ");
		lblVN2.setForeground(Color.BLUE);
		lblVN2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVN2.setBounds(572, 618, 34, 21);
		panel.add(lblVN2);
		
		lblVN3 = new JLabel("VNĐ");
		lblVN3.setForeground(Color.BLUE);
		lblVN3.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblVN3.setBounds(572, 652, 34, 21);
		panel.add(lblVN3);
		
	}
	
	public void printingHoaDon() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if(ok) {
			try {
				job.print();
			} catch (Exception e2) {
					// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
			Graphics2D g2d = (Graphics2D) graphics;
			if(pageIndex>0) {
				return NO_SUCH_PAGE;
			}
			g2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
			panel.printAll(graphics);
			return PAGE_EXISTS;
		}



// Đưa dữ liệu vào hóa đơn
	public void setDuLieuFrmInHd(String maHoaDon,String nhanVien,String ngayLap,String hoTenKh,String dtlhienco,String soDT,String tongsl,String diemtichduoc,String diemsudung,String tongtiensp,String tongthanhtoan,String tienkhachdua,String tienhoanlai ) {

		lblMaHD.setText(maHoaDon);
		lblTenNV.setText(nhanVien);
		lblDate.setText(ngayLap);
		lbltenKH.setText(hoTenKh);
		lblGetDienTichLuy.setText(dtlhienco);
		lblGetSDT.setText(soDT);
		getTongSoLuong.setText(tongsl);
		getDiemTichDuoc.setText(diemtichduoc);
		getDiemSuDung.setText(diemsudung);
		getTongTien.setText(tongtiensp);
		getTongThanhToan.setText(tongthanhtoan);
		getTienKhachDua.setText(tienkhachdua);
		getTienHoan.setText(tienhoanlai);
		
		
		
	}
	
	public void capNhatDuLieuTableCTHD(DefaultTableModel modelNew) {
	    tableModel = (DefaultTableModel) table_CTHDin.getModel();

	    for (int row = 0; row < modelNew.getRowCount(); row++) {
	        Object[] rowData = new Object[modelNew.getColumnCount() - 1]; // Giảm một cột
	        for (int col = 1; col < modelNew.getColumnCount(); col++) {
	            rowData[col - 1] = modelNew.getValueAt(row, col);
	        }
	        tableModel.addRow(rowData);
	    }
	}


	
}
