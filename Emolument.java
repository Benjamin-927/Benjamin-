/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Emolument {
    // i. Encapsulated data fields
    private double basic_salary;
    private double tax_relief;

    // ii. Constructor to initialize Basic Salary and Tax Relief
    public Emolument(double basic_salary, double tax_relief) {
        this.basic_salary = basic_salary;
        this.tax_relief = tax_relief;
    }

    // iii. Method to return the basic_salary
    public double getBasicSalary() {
        return basic_salary;
    }

    // iv. Method to return the tax_relief
    public double getTaxRelief() {
        return tax_relief;
    }

    // v. Method to compute and return SSNIT contribution
    public double SSNIT() {
        return basic_salary * 0.035;
    }

    // vi. Method to compute and return Taxable Income
    public double taxableIncome() {
        return basic_salary - (tax_relief + SSNIT());
    }

    public static void main(String[] args) {
        // Example usage
        Emolument emolument = new Emolument(5000.0, 200.0);
        System.out.printf("Basic Salary: %.2f%n", emolument.getBasicSalary());
        System.out.printf("Tax Relief: %.2f%n", emolument.getTaxRelief());
        System.out.printf("SSNIT Contribution: %.2f%n", emolument.SSNIT());
        System.out.printf("Taxable Income: %.2f%n", emolument.taxableIncome());
    }
}

