import javax.swing.JOptionPane;
public class ex116 {
    public static void main(String[] args) {
        String select=JOptionPane.showInputDialog(null,"Please select which you want to perform: \n1. The first-degree equation (linear equation) with one variable \n2. The system of first-degree equations (linear system) with two variables \n3. The second-degree equation with one variable ","Select the operation", JOptionPane.INFORMATION_MESSAGE);
        int intSelect=Integer.parseInt(select);
        while (1>intSelect || intSelect>3){
            JOptionPane.showMessageDialog(null, "Please type the correct number");
            select=JOptionPane.showInputDialog(null,"Please select which you want to perform: \n1. The first-degree equation (linear equation) with one variable \n2. The system of first-degree equations (linear system) with two variables \n3. The second-degree equation with one variable ","Select the operation", JOptionPane.INFORMATION_MESSAGE);
            intSelect=Integer.parseInt(select);
        }
        if (intSelect==1){
            String a=JOptionPane.showInputDialog(null,"Please enter the coefficient a: ","Input the coefficient a", JOptionPane.INFORMATION_MESSAGE);
            String b=JOptionPane.showInputDialog(null,"Please enter the coefficient b: ","Input the coefficient b", JOptionPane.INFORMATION_MESSAGE);
            Double A=Double.parseDouble(a);
            Double B=Double.parseDouble(b);
            JOptionPane.showMessageDialog(null, "The solution of the equation "+A+"x + "+B+" = 0 is: x = "+(-B/A),"Result", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (intSelect==2){
            String a11=JOptionPane.showInputDialog(null,"Please enter the coefficient a11: ","Input the coefficient a11", JOptionPane.INFORMATION_MESSAGE);
            String a12=JOptionPane.showInputDialog(null,"Please enter the coefficient a12: ","Input the coefficient a12", JOptionPane.INFORMATION_MESSAGE);
            String a21=JOptionPane.showInputDialog(null,"Please enter the coefficient a21: ","Input the coefficient a21", JOptionPane.INFORMATION_MESSAGE);
            String a22=JOptionPane.showInputDialog(null,"Please enter the coefficient a22: ","Input the coefficient a22", JOptionPane.INFORMATION_MESSAGE);
            String b1=JOptionPane.showInputDialog(null,"Please enter the constant b1: ","Input the constant b1", JOptionPane.INFORMATION_MESSAGE);
            String b2=JOptionPane.showInputDialog(null,"Please enter the constant b2: ","Input the constant b2", JOptionPane.INFORMATION_MESSAGE);
            Double A11=Double.parseDouble(a11);
            Double A12=Double.parseDouble(a12);
            Double A21=Double.parseDouble(a21);
            Double A22=Double.parseDouble(a22);
            Double B1=Double.parseDouble(b1);
            Double B2=Double.parseDouble(b2);
            Double D=A11*A22-A12*A21;
            Double Dx=B1*A22-B2*A12;
            Double Dy=A11*B2-A21*B1;
            if (D!=0){
                JOptionPane.showMessageDialog(null, "The solution of the system is: x = "+(Dx/D)+" and y = "+(Dy/D),"Result", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (D==0 && Dx==0 && Dy==0){
                JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.","Result", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "The system has no solution.","Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            String a=JOptionPane.showInputDialog(null,"Please enter the coefficient a: ","Input the coefficient a", JOptionPane.INFORMATION_MESSAGE);
            String b=JOptionPane.showInputDialog(null,"Please enter the coefficient b: ","Input the coefficient b", JOptionPane.INFORMATION_MESSAGE);
            String c=JOptionPane.showInputDialog(null,"Please enter the coefficient c: ","Input the coefficient c", JOptionPane.INFORMATION_MESSAGE);
            Double A=Double.parseDouble(a);
            Double B=Double.parseDouble(b);
            Double C=Double.parseDouble(c);
            Double delta=B*B-4*A*C;
            if (delta>0){
                JOptionPane.showMessageDialog(null, "The solutions of the equation "+A+"x^2 + "+B+"x + "+C+" = 0 are: x1 = "+((-B+Math.sqrt(delta))/(2*A))+" and x2 = "+((-B-Math.sqrt(delta))/(2*A)),"Result", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (delta==0){
                JOptionPane.showMessageDialog(null, "The solution of the equation "+A+"x^2 + "+B+"x + "+C+" = 0 is: x = "+(-B/(2*A)),"Result", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "The equation has no real solution.","Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        System.exit(0);
    }
}
