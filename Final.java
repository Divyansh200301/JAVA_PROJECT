import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Final {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "db@23012003#!";
    //private  static Connection connection;
    private static String pan;
    private static String aadhar;
    private static String name;
    private static String suggestionResult;
    private static String locality;
    private static String job;
    private static double annualIncome;
    private static int age;
    private static boolean taxSavingInvestments;
    private static boolean investForTaxSaving;
    private static boolean medicalInsurance;
    private static boolean homeLoan;
    private static boolean educationalLoan;
    private static boolean dependents;
    private static boolean retirementSavings;
    private static boolean disability;
    private static boolean npsContribution;
    private static String taxRegime;
    private static double standardDeduction;
    private static double section80C;
    private static double section80D;
    private static double section24;
    private static double capitalGains;
    private static double propertyIncome;
    private static double otherIncome;
    public static  void main(String args[]){
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver");

          Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            
        }
      catch (SQLException e) {
            e.printStackTrace();
        }
        
        firstScreen();
    }
    
        
        public static void firstScreen() {
            JFrame frame = new JFrame("User Registration");
            frame.setSize(400, 600); // Set dimensions to 300x600
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center-align the buttons
    
            JTextField panField = new JTextField(35);
            JTextField aadharField = new JTextField(30);
            JTextField nameField = new JTextField(35);
            JTextField localityField = new JTextField(35);
    
            JLabel panLabel = new JLabel("PAN Number:");
            JLabel aadharLabel = new JLabel("Aadhar Card Number:");
            JLabel nameLabel = new JLabel("Name:");
            JLabel localityLabel = new JLabel("Locality:");
            
    
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    pan = panField.getText();
                aadhar = aadharField.getText();
                name = nameField.getText();
                locality = localityField.getText();
                    secondScreen();
                    
                }
            });
             panel.add(nameLabel);
            panel.add(nameField);
            panel.add(aadharLabel);
            panel.add(aadharField);
            panel.add(panLabel);
            panel.add(panField);
            
           
            panel.add(localityLabel);
            panel.add(localityField);
            panel.add(submitButton); // Each button on a new row
    
            frame.add(panel);
    
            frame.setVisible(true);
        }
        public static void secondScreen() {
        JFrame frame = new JFrame("Tax Regime Suggestion");
    frame.setSize(400, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(0,2));

    JTextField jobField = new JTextField(10);
    JTextField IncomeField = new JTextField(10);
    JTextField ageField = new JTextField(10);

    createLabelAndInput(panel, "Job:", jobField);
    createLabelAndInput(panel, "Annual Income:", IncomeField);
    createLabelAndInput(panel, "Age:", ageField);

    JCheckBox taxSavingInvestmentsCheckBox = new JCheckBox();
    JCheckBox investForTaxSavingCheckBox = new JCheckBox();
    JCheckBox medicalInsuranceCheckBox = new JCheckBox();
    JCheckBox homeLoanCheckBox = new JCheckBox();
    JCheckBox educationalLoanCheckBox = new JCheckBox();
    JCheckBox dependentsCheckBox = new JCheckBox();
    JCheckBox retirementSavingsCheckBox = new JCheckBox();
    JCheckBox disabilityCheckBox = new JCheckBox();
    JCheckBox npsContributionCheckBox = new JCheckBox();

    createLabelAndCheckBox(panel, "Investments in tax-saving instruments:", taxSavingInvestmentsCheckBox);
    createLabelAndCheckBox(panel, "Invest for tax saving:", investForTaxSavingCheckBox);
    createLabelAndCheckBox(panel, "Medical Insurance:", medicalInsuranceCheckBox);
    createLabelAndCheckBox(panel, "Home Loan:", homeLoanCheckBox);
    createLabelAndCheckBox(panel, "Educational Loan:", educationalLoanCheckBox);
    createLabelAndCheckBox(panel, "Dependents:", dependentsCheckBox);
    createLabelAndCheckBox(panel, "Retirement Savings:", retirementSavingsCheckBox);
    createLabelAndCheckBox(panel, "Disability:", disabilityCheckBox);
    createLabelAndCheckBox(panel, "NPS Contribution:", npsContributionCheckBox);

    JButton suggestButton = new JButton("Suggest");
    JButton nexButton = new JButton("Next");

    suggestButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
             job = jobField.getText();
            taxSavingInvestments = taxSavingInvestmentsCheckBox.isSelected();
            investForTaxSaving = investForTaxSavingCheckBox.isSelected();
            medicalInsurance = medicalInsuranceCheckBox.isSelected();
            homeLoan = homeLoanCheckBox.isSelected();
            educationalLoan = educationalLoanCheckBox.isSelected();
            dependents = dependentsCheckBox.isSelected();
            retirementSavings = retirementSavingsCheckBox.isSelected();
            disability = disabilityCheckBox.isSelected();
            npsContribution = npsContributionCheckBox.isSelected();
           
             String hi=IncomeField.getText();
            annualIncome=Double.parseDouble(hi);
            

            hi=ageField.getText();
         age = Integer.parseInt(hi);
        
            int score = 0;
    String suggestionText ;

    if (taxSavingInvestments) {
        score++;
        suggestionText="- Investments in tax-saving instruments can provide significant deductions under Section 80C of the Income Tax Act in the old regime.\n";
    }
    if (investForTaxSaving) {
        score++;
        suggestionText="- Investing just for the sake of saving taxes can be more beneficial in the old regime due to various deductions.\n";
    }
    if (medicalInsurance) {
        score++;
        suggestionText="- Medical insurance premiums can provide deductions under Section 80D in the old regime.\n";
    }
    if (homeLoan) {
        score++;
        suggestionText="- Home loan principal and interest payments can provide deductions under Section 80C and Section 24 respectively in the old regime.\n";
    }
    if (educationalLoan) {
        score++;
        suggestionText="- Educational loan interest payments can provide deductions under Section 80E in the old regime.\n";
    }
    if (dependents) {
        score++;
        suggestionText="- Having dependents can lead to additional deductions in the old regime.\n";
    }
    if (retirementSavings) {
        score++;
        suggestionText="- Contributions to retirement savings accounts like EPF, PPF can provide deductions under Section 80C in the old regime.\n";
    }
    if (disability) {
        score++;
        suggestionText="- Disability can lead to additional deductions under sections 80U, 80DD, and 80DDB in the old regime.\n";
    }
    if (npsContribution) {
        score++;
        suggestionText="- Contributions to NPS can provide additional deductions under Section 80CCD(1B) in the old regime.\n";
    }

    // If the final score is greater than 5, suggest the Old Tax Regime, otherwise suggest the New Tax Regime
    if (score > 5) {
        suggestionResult+= "Old Tax Regime might be more beneficial for you because your suggestion score is " + score + ", which indicates that you have multiple factors that could lead to significant tax deductions under the old regime.";
    } else {
        suggestionResult += "New Tax Regime might be more beneficial for you because your suggestion score is " + score + ", which indicates that you may not have many factors leading to significant tax deductions under the old regime.";
    }

    // Print the suggestion to the console (optional)
    JOptionPane.showMessageDialog(null, suggestionResult, "Tax Regime Suggestion", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(age+job+"Hello");
           
        }
    });
    nexButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            job = jobField.getText();
            taxSavingInvestments = taxSavingInvestmentsCheckBox.isSelected();
            investForTaxSaving = investForTaxSavingCheckBox.isSelected();
            medicalInsurance = medicalInsuranceCheckBox.isSelected();
            homeLoan = homeLoanCheckBox.isSelected();
            educationalLoan = educationalLoanCheckBox.isSelected();
            dependents = dependentsCheckBox.isSelected();
            retirementSavings = retirementSavingsCheckBox.isSelected();
            disability = disabilityCheckBox.isSelected();
            npsContribution = npsContributionCheckBox.isSelected();
           
             String hi=IncomeField.getText();
            annualIncome=Double.parseDouble(hi);
            

            hi=ageField.getText();
         age = Integer.parseInt(hi);
            screenThree();
        }
    });

    //panel.add(new JLabel("Suggestion Result:"));
    panel.add(suggestButton);
    panel.add(nexButton);

    frame.add(panel);
    frame.setVisible(true);
}

private static void createLabelAndInput(JPanel panel, String labelText, JTextField inputField) {
    panel.add(new JLabel(labelText));
    
    panel.add(inputField);
}

private static void createLabelAndCheckBox(JPanel panel, String labelText, JCheckBox checkBox) {
    panel.add(new JLabel(labelText));

    panel.add(checkBox);
}
public static void screenThree(){
     JTextField taxRegimeField;
     JTextField standardDeductionField;
     JTextField section80CField;
     JTextField annualIncomeField;
     JTextField section80DField;
     JTextField section24Field;
     JTextField capitalGainsField;
     JTextField propertyIncomeField;
     JTextField otherIncomeField;
    JFrame frame = new JFrame("Tax Saving Suggestion");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2)); // Multiple rows, two columns

        // Create JLabel and JTextField for annual income
        panel.add(new JLabel("Annual Income:"));
        annualIncomeField = new JTextField(10);
        panel.add(annualIncomeField);

        // Create JLabel and JTextField for tax regime
        panel.add(new JLabel("Tax Regime (old/new):"));
        taxRegimeField = new JTextField(10);
        panel.add(taxRegimeField);

        // Create JLabel and JTextField for standard deduction
        panel.add(new JLabel("Standard Deduction:"));
        standardDeductionField = new JTextField(10);
        panel.add(standardDeductionField);

        // Create JLabel and JTextField for Section 80C deduction
        panel.add(new JLabel("Section 80C Deduction:"));
        section80CField = new JTextField(10);
        panel.add(section80CField);

        // Create JLabel and JTextField for Section 80D deduction
        panel.add(new JLabel("Section 80D Deduction:"));
        section80DField = new JTextField(10);
        panel.add(section80DField);

        // Create JLabel and JTextField for Section 24 deduction
        panel.add(new JLabel("Section 24 Deduction:"));
        section24Field = new JTextField(10);
        panel.add(section24Field);

        // Create JLabel and JTextField for capital gains
        panel.add(new JLabel("Capital Gains:"));
        capitalGainsField = new JTextField(10);
        panel.add(capitalGainsField);

        // Create JLabel and JTextField for property income
        panel.add(new JLabel("Property Income:"));
        propertyIncomeField = new JTextField(10);
        panel.add(propertyIncomeField);

        // Create JLabel and JTextField for other income
        panel.add(new JLabel("Other Income:"));
        otherIncomeField = new JTextField(10);
        panel.add(otherIncomeField);

        // Add a button to get the tax suggestion
        JButton suggestButton = new JButton("Save Data");
        JButton TaxSuggestion=new JButton("Tax saving tips");
        JButton CalculateTax=new JButton("Tax calcualtion");
        suggestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taxRegime = taxRegimeField.getText();
            standardDeduction = Double.parseDouble(standardDeductionField.getText());
            section80C = Double.parseDouble(section80CField.getText());
            section80D = Double.parseDouble(section80DField.getText());
            section24 = Double.parseDouble(section24Field.getText());
            capitalGains = Double.parseDouble(capitalGainsField.getText());
            propertyIncome = Double.parseDouble(propertyIncomeField.getText());
            otherIncome = Double.parseDouble(otherIncomeField.getText());
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
                String sql = "INSERT INTO users (id,pan, aadhar, name, locality, job, annual_income, age, is_tax_saving_investments, " +
                        "is_invest_for_tax_saving, has_medical_insurance, has_home_loan, has_educational_loan, has_dependents, " +
                        "has_retirement_savings, has_disability, has_nps_contribution, tax_regime, standard_deduction, " +
                        "section_80C, section_80D, section_24, capital_gains, property_income, other_income) " +
                        "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
    
                // Set the values for the placeholders
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2,pan);
                preparedStatement.setString(3, aadhar);
                preparedStatement.setString(4, name);
                preparedStatement.setString(5, locality);
                preparedStatement.setString(6, job);
                preparedStatement.setDouble(7, annualIncome);
                preparedStatement.setInt(8, age);
                preparedStatement.setBoolean(9, taxSavingInvestments);
                preparedStatement.setBoolean(10, investForTaxSaving);
                preparedStatement.setBoolean(11, medicalInsurance);
                preparedStatement.setBoolean(12, homeLoan);
                preparedStatement.setBoolean(13, educationalLoan);
                preparedStatement.setBoolean(14, dependents);

                preparedStatement.setBoolean(15, retirementSavings);
                preparedStatement.setBoolean(16, disability);
                preparedStatement.setBoolean(17, npsContribution);
                preparedStatement.setString(18, taxRegime);
                preparedStatement.setDouble(19, standardDeduction);
                preparedStatement.setDouble(20,section80C );
                preparedStatement.setDouble(21, section80D);
                preparedStatement.setDouble(22, section24);
                preparedStatement.setDouble(23, capitalGains);
                preparedStatement.setDouble(24, propertyIncome);
                preparedStatement.setDouble(25, otherIncome);
    
                int rowsInserted = preparedStatement.executeUpdate();
    
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("Failed to insert data.");
                }
            } catch(SQLException g) {
                g.printStackTrace(); 
                System.err.println("SQL Exception: " + g.getMessage());
            }
        

            }
        });
        TaxSuggestion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(taxRegime=="old"){
                    suggestOldRegime();
                }
                else{
                    suggestNewRegime();
                }
            }
        });
        CalculateTax.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                calculateTax();
            }
        });

        // Add the result area
        

        //panel.add(new JLabel("Tax Saving Suggestion:"));
        //panel.add(resultArea);
        panel.add(suggestButton);
        panel.add(TaxSuggestion);
        panel.add(CalculateTax);

        frame.add(panel);
        frame.setVisible(true);
}
public static void suggestOldRegime() {
    int score = 0;
    StringBuilder suggestionText = new StringBuilder();

    // Suggest tax saving based on the deductions in the old regime
    if (standardDeduction < 50000) {
        score++;
        suggestionText.append("- Try to maximize your standard deduction up to Rs.50,000.\n");
    }

    if (section80C < 150000) {
        score++;
        suggestionText.append("- Consider investing more in Section 80C eligible investments up to Rs.1,50,000.\n");
    }

    if (section80D < 25000) {
        score++;
        suggestionText.append("- If you don't have medical insurance, consider getting one. You can claim deductions up to Rs.25,000 under Section 80D.\n");
    }

    if (section24 < 200000) {
        score++;
        suggestionText.append("- If you have a home loan, make sure you're claiming the maximum deduction of Rs.2,00,000 under Section 24.\n");
    }

    // Additional scoring for more deductions in the old regime
    

    // Print the final score in the old regime
    suggestionText.append("Your tax saving score in the old regime is: " + score);
    
    // Display the suggestions in a dialog box
    JOptionPane.showMessageDialog(null, suggestionText.toString(), "Tax Saving Suggestions (Old Regime)", JOptionPane.INFORMATION_MESSAGE);
}

// ...

public static void suggestNewRegime() {
    int score = 0;
    StringBuilder suggestionText = new StringBuilder();

    // Suggest tax saving based on the deductions in the new regime
    if (standardDeduction < 50000) {
        score++;
        suggestionText.append("- Try to maximize your standard deduction up to Rs.50,000.\n");
    }

    // Additional scoring for more deductions in the new regime
   
    // Print the final score in the new regime
    suggestionText.append("Your tax saving score in the new regime is: " + score);

    // Display the suggestions in a dialog box
    JOptionPane.showMessageDialog(null, suggestionText.toString(), "Tax Saving Suggestions (New Regime)", JOptionPane.INFORMATION_MESSAGE);
}
    public static void calculateTax(){
        double totalIncome = annualIncome + capitalGains + propertyIncome + 
otherIncome;
 double totalDeductions = standardDeduction + section80C + section80D + 
section24;
 double taxableIncome = totalIncome - totalDeductions;
 double tax = 0.0;
 if (taxRegime.equals("old")) {
 // Calculate tax based on old regime slabs
 if (taxableIncome <= 250000) {
 tax = 0.0; // No tax for income up to Rs. 2,50,000
 } else if (taxableIncome <= 500000) {
 tax = 0.05 * (taxableIncome - 250000); // 5% for income from Rs. 

 } else if (taxableIncome <= 1000000) {
 tax = 12500 + 0.2 * (taxableIncome - 500000); // Rs. 12,500 + 20% of 
 } else {
 tax = 112500 + 0.3 * (taxableIncome - 1000000); // Rs. 1,12,500 +
 }
 } else {
 // Calculate tax based on new regime slabs
 if (taxableIncome <= 250000) {
 tax = 0.0; 
 } else if (taxableIncome <= 500000) {
 tax = taxableIncome * .05; 
 } else if (taxableIncome <=750000) {
 tax = taxableIncome * .1; 
 } else if (taxableIncome <=1000000) {
 tax = taxableIncome * .15; 
 } else if (taxableIncome <=1250000) {
 tax = taxableIncome * .2; 
 } else if (taxableIncome <=1500000) {
 tax = taxableIncome * .25; 
 } else {
 tax = taxableIncome * .3; 
 }
 }
 String s=""+tax;
 JOptionPane.showMessageDialog(null,Double.toString(tax),"Total Taxable Amount",JOptionPane.INFORMATION_MESSAGE);
    }

}