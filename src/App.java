import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        double salaryPerHour = 0;
        double workedHours = 0;
        boolean validInput = false;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        while (!validInput) {
            String input_1 = JOptionPane.showInputDialog(null, "Valor recebido por hora trabalhada");
            String input_2 = JOptionPane.showInputDialog(null, "Horas trabalhadas no mês");
            try {
                salaryPerHour = Double.parseDouble(input_1);
                workedHours = Double.parseDouble(input_2);
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!");
            }
        }

        double grossSalary = salaryPerHour * workedHours;
        double ir = grossSalary * 0.11;
        double inss = grossSalary * 0.08;
        double sindicate = grossSalary * 0.05;
        double netSalary = grossSalary - ir - inss - sindicate; 

        if (grossSalary > 0) {
            JOptionPane.showMessageDialog(null, "+ Salário Bruto: R$ " + grossSalary
            + "\n- IR (11%): R$ " + ir
            + "\n- INSS (8%): R$ " + inss
            + "\n- Sindicato (5%): R$ " + sindicate
            + "\n———————————————"
            + "\n= Salário Líquido (5%): R$ " + numberFormat.format(netSalary));
        } else {
            JOptionPane.showMessageDialog(null, "Entrada inválida!");
        }
        
    }
}