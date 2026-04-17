import javax.swing.JOptionPane;
public class ex115{
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1=JOptionPane.showInputDialog(null,"Please enter the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2=JOptionPane.showInputDialog(null,"Please enter the second number: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num1=Double.parseDouble(strNum1);
        double num2=Double.parseDouble(strNum2);
        double sum=num1+num2;
        double diff=num1-num2;
        double product=num1*num2;
        double quotient=num1/num2;
        String strNotification= "The sum of "+num1+" and "+num2+" is: "+sum+"\n"+
                                "The difference of "+num1+" and "+num2+" is: "+diff+"\n"+
                                "The product of "+num1+" and "+num2+" is: "+product+"\n"+
                                "The quotient of "+num1+" and "+num2+" is: "+quotient;
        JOptionPane.showMessageDialog(null, strNotification,"Results", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
