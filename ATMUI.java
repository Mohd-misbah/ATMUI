import java.awt.*;
import java.awt.event.*;

public class ATMUI {
    public static void main(String... args) {
        Frame frame = new Frame("MY ATM");
        frame.setSize(1200, 600);
        frame.setLayout(null);

	frame.setBackground(new Color(220, 220, 220));

        // Labels
        Label welcomeLabel = new Label("WELCOME TO UNITED BANK");
        welcomeLabel.setBounds(450, 50, 300, 30);

        Label optionLabel = new Label("PLEASE SELECT AN OPTION");
        optionLabel.setBounds(450, 100, 300, 30);

        Label pinLabel = new Label("PLEASE ENTER PIN");
        pinLabel.setBounds(450, 200, 300, 30);

        Label amountLabel = new Label("PLEASE ENTER AMOUNT");
        amountLabel.setBounds(450, 300, 300, 30);

        Label accountInfoLabel = new Label("");
        accountInfoLabel.setBounds(450, 250, 400, 30);

        Label balanceLabel = new Label("");
        balanceLabel.setBounds(450, 350, 300, 30);

        Label messageLabel = new Label("");
        messageLabel.setBounds(450, 400, 400, 30);

        Label receiptLabel = new Label("");
        receiptLabel.setBounds(450, 450, 400, 30);

        // Text Fields
        TextField pinTextField = new TextField();
        pinTextField.setBounds(450, 230, 300, 30);

        TextField amountTextField = new TextField();
        amountTextField.setBounds(450, 330, 300, 30);

        // Checkbox
        Checkbox receiptCheckbox = new Checkbox("TAKE RECEIPT");
        receiptCheckbox.setBounds(450, 470, 150, 30);

        // Buttons - Three on the left side
        Button internetBankingButton = new Button("INTERNET BANKING");
        internetBankingButton.setBounds(50, 200, 200, 30);

        Button otpGenerationButton = new Button("OTP GENERATION");
        otpGenerationButton.setBounds(50, 250, 200, 30);

        Button cashWithdrawalButton = new Button("CASH WITHDRAWAL");
        cashWithdrawalButton.setBounds(50, 300, 200, 30);

        // Buttons - Three on the right side
        Button fastCashButton = new Button("FAST CASH");
        fastCashButton.setBounds(950, 200, 200, 30);

        Button checkBalanceButton = new Button("CHECK BALANCE");
        checkBalanceButton.setBounds(950, 250, 200, 30);

        Button miniStatementButton = new Button("MINI STATEMENT");
        miniStatementButton.setBounds(950, 300, 200, 30);

	// Clear Button
        Button clearButton = new Button("CLEAR");
        clearButton.setBounds(450, 520, 100, 30);

        TextField[] textFields = { pinTextField, amountTextField }; // List of text fields to clear

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (TextField textField : textFields) {
                    textField.setText(""); // Clear text fields
                }
            }
        });

        // Add action listeners to buttons
        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int pin = Integer.parseInt(pinTextField.getText());
                    if (pin == 9876) {
                        accountInfoLabel.setText("ACCOUNT HOLDER NAME: MOHD BILAL");
                        balanceLabel.setText("ACCOUNT NUMBER: 18459");
                        messageLabel.setText("BALANCE: $5,200,000");
                    } else if (pin == 1234) {
                        accountInfoLabel.setText("ACCOUNT HOLDER NAME: MOHD AMAN");
                        balanceLabel.setText("ACCOUNT NUMBER: 8954");
                        messageLabel.setText("BALANCE: $5,400,000");
                    } else if (pin == 3563) {
                        accountInfoLabel.setText("ACCOUNT HOLDER NAME: MOHD AKBAR");
                        balanceLabel.setText("ACCOUNT NUMBER: 2348");
                        messageLabel.setText("BALANCE: $1,000,000,000");
                    } else {
                        messageLabel.setText("INVALID PIN");
                    }
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Please enter a valid PIN (numeric only).");
                }
            }
        });

        cashWithdrawalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int currentBalance = 5400000;
                    int withdrawalAmount = Integer.parseInt(amountTextField.getText());

                    if (withdrawalAmount > 0 && withdrawalAmount <= currentBalance) {
                        int newBalance = currentBalance - withdrawalAmount;
                        balanceLabel.setText("NEW BALANCE: $" + newBalance);
                        messageLabel.setText("THANKS FOR VISITING");

                        if (receiptCheckbox.getState()) {
                            receiptLabel.setText("RECEIPT: $" + withdrawalAmount + " withdrawn");
                        }
                    } else {
                        messageLabel.setText("Invalid withdrawal amount or insufficient balance.");
                    }
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Please enter a valid amount (numeric only).");
                }
            }
        });

	// Add a window listener to exit the program when the window is closed
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0); // Exit the program
            }
        });

        // Add UI elements to the frame
        frame.add(welcomeLabel);
        frame.add(optionLabel);
        frame.add(pinLabel);
        frame.add(amountLabel);
        frame.add(accountInfoLabel);
        frame.add(balanceLabel);
        frame.add(messageLabel);
        frame.add(receiptLabel);
        frame.add(pinTextField);
        frame.add(amountTextField);
        frame.add(receiptCheckbox);
        frame.add(internetBankingButton);
        frame.add(otpGenerationButton);
        frame.add(cashWithdrawalButton);
        frame.add(fastCashButton);
        frame.add(checkBalanceButton);
        frame.add(miniStatementButton);
	frame.add(clearButton);

        frame.setVisible(true);
    }
}
