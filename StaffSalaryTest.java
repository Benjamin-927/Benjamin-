/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import java.util.Scanner;

class MyEmoluments {
    private double basicSalary;
    private double taxRelief;
    private double ssnitContribution;
    private double taxableIncome;
    private double incomeTax;
    private double totalDeduction;
    private double netSalary;

    public MyEmoluments(double basicSalary) {
        this.basicSalary = basicSalary;
        this.taxRelief = calculateTaxRelief();
        this.ssnitContribution = calculateSsnitContribution();
        this.taxableIncome = calculateTaxableIncome();
        this.incomeTax = calculateIncomeTax();
        this.totalDeduction = calculateTotalDeduction();
        this.netSalary = calculateNetSalary();
    }

    private double calculateTaxRelief() {
        return basicSalary * 0.13;
    }

    private double calculateSsnitContribution() {
        return basicSalary * 0.055;
    }

    private double calculateTaxableIncome() {
        return basicSalary - taxRelief;
    }

    private double calculateIncomeTax() {
        return taxableIncome * 0.15;
    }

    private double calculateTotalDeduction() {
        return ssnitContribution + incomeTax;
    }

    private double calculateNetSalary() {
        return basicSalary - totalDeduction;
    }

    public void displayDetails() {
        System.out.printf("Basic Salary: %.2f%n", basicSalary);
        System.out.printf("Tax Relief: %.2f%n", taxRelief);
        System.out.printf("SSNIT Contribution: %.2f%n", ssnitContribution);
        System.out.printf("Taxable Income: %.2f%n", taxableIncome);
        System.out.printf("Income Tax: %.2f%n", incomeTax);
        System.out.printf("Total Deduction: %.2f%n", totalDeduction);
        System.out.printf("Net Salary: %.2f%n", netSalary);
    }
}

public class StaffSalaryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the Basic Salary: ");
            double basicSalaryInput = scanner.nextDouble();

            MyEmoluments staffSalary = new MyEmoluments(basicSalaryInput);
            System.out.println("\nSalary Details:\n----------------");
            staffSalary.displayDetails();
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a numeric value for the Basic Salary.");
        } finally {
            scanner.close();
        }
    }
}
