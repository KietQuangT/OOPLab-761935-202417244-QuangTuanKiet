package the_num_of_day_of_a_month;
import javax.swing.JOptionPane;
public class the_num_of_day_of_a_month {
	public static void main(String[] args) {
		String[] month= {"January", "February", "March", "April","May","June","July","August","September","October","November","December"};
		String[] abbre= {"Jan.","Feb.","Mar.", "Apr.","May","June","July","Aug.","Sept.","Oct.","Nov.","Dec."};
		String[] tletters= {"Jan","Feb","Mar","Apr","May","Jun", "Jul", "Aug","Sep","Oct","Nov","Dec"};
		String[] num= {"1","2","3","4","5","6","7","8","9","10","11","12"};
		int[] comyear= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String Month=JOptionPane.showInputDialog(null,"Nhập tháng: ");
		int nummon = 0;
		if (Month == null) System.exit(0);
		Month = Month.trim();
		int isValid=0;
		while (isValid==0) {
			for (int i=0;i<12;i++)
				if (Month.equalsIgnoreCase(month[i]) || Month.equalsIgnoreCase(abbre[i]) || Month.equalsIgnoreCase(tletters[i]) ||Month.equalsIgnoreCase(num[i])) {
					isValid=1;
					nummon=i+1;
					break;
				}
			if (isValid==0){
				Month=JOptionPane.showInputDialog(null,"Tháng được nhập không hợp lệ, vui lòng nhập lại: ");
				if (Month == null) System.exit(0);
				Month = Month.trim();
			}
		}
		String year=JOptionPane.showInputDialog(null,"Nhập năm: ");
		if (year==null) System.exit(0);
		year = year.trim();
		while (!year.matches("\\d+")) {
			year = JOptionPane.showInputDialog(null, "Sai định dạng! Nhập lại năm (vd: 1999): ");
			if (year==null) System.exit(0);
			year = year.trim();
		}
		int Year=Integer.parseInt(year);
		if (nummon!=2)
			JOptionPane.showMessageDialog(null, "Số ngày của tháng "+nummon+" năm "+Year+" là: "+comyear[nummon-1]+"\n");
		else
			if ((Year % 4==0 && Year %100!=0) || Year%400==0)
				JOptionPane.showMessageDialog(null, "Số ngày của tháng 2 năm "+Year+" là: 29");
			else
				JOptionPane.showMessageDialog(null, "Số ngày của tháng 2 năm "+Year+" là: 28");
		System.exit(0);
	}
	
}
