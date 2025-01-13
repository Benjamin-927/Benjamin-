/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import javax.swing.JOptionPane;

public class MyEmolument extends Emolument {
      // i. Encapsulated data fields
    private double basic_salary;
    private double tax_relief;

    // ii. Non-arg constructor with default values
    public MyEmolument() {
        super(0, 0);
        this.basic_salary = 0;
        this.tax_relief = 0;
    }

    // iii. Constructor with specified basic salary and tax relief
    public MyEmolument(double basic_salary, double tax_relief) {
        super(basic_salary, tax_relief);
        this.basic_salary = basic_salary;
        this.tax_relief = tax_relief;
    }

    // iv. Method to compute Income Tax
    public double incomeTax() {
        double taxableIncome = taxableIncome(); // From parent class
        double incomeTax = 0;

        if (taxableIncome <= 500) {
            incomeTax = taxableIncome * 0.05;
        } else if (taxableIncome <= 1000) {
            incomeTax = (500 * 0.05) + ((taxableIncome - 500) * 0.125);
        } else {
            incomeTax = (500 * 0.05) + (500 * 0.125) + ((taxableIncome - 1000) * 0.175);
        }

        return incomeTax;
    }

    // v. Method to compute Total Deduction
    public double totalDeduction() {
        return SSNIT() + incomeTax();
    }

    // vi. Method to compute Net Salary
    public double netSalary() {
        return getBasicSalary() - totalDeduction();
    }

    public static void main(String[] args) {
        // Accept input from user using input dialog
        String basicSalaryInput = JOptionPane.showInputDialog("Enter Basic Salary:");
        String taxReliefInput = JOptionPane.showInputDialog("Enter Tax Relief:");

        double basic_salary = Double.parseDouble(basicSalaryInput);
        double tax_relief = Double.parseDouble(taxReliefInput);

        // Create MyEmolument object
        MyEmolument staff_Salary = new MyEmolument(basic_salary, tax_relief);

        // Display details
        String message = String.format(
            "Basic Salary: %.2f\n" + 
            "Tax Relief: %.2f\n" +
            "SSNIT Contribution: %.2f\n" +
            "Taxable Income: %.2f\n" +
            "Income Tax: %.2f\n" +
            "Total Deduction: %.2f\n" +
            "Net Salary: %.2f",
            staff_Salary.getBasicSalary(),
            staff_Salary.getTaxRelief(),
            staff_Salary.SSNIT(),
            staff_Salary.taxableIncome(),
            staff_Salary.incomeTax(),
            staff_Salary.totalDeduction(),
            staff_Salary.netSalary()
        );

        JOptionPane.showMessageDialog(null, message, "Salary Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
