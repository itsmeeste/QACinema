import javax.swing.*;

public abstract class TransactionScreen {
    private JPanel panel;
    private JLabel lastTransaction;
    private JLabel standardText;
    private JLabel studentText;
    private JLabel oapText;
    private JLabel childText;
    private JLabel discountText;
    private JLabel discountAmount;
    private JLabel totalAmount;
    private JLabel filmTitle;
    private JFrame frame;
    public TransactionScreen()
    {
        frame = new JFrame("Last Purchase");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,300);
        frame.setResizable(false);
    }
    public void SetDetails(String title,int standard,int student,int oap,int child,boolean dicount)
    {
        filmTitle.setText(title);
        standardText.setText("Standard Tickets = " + standard);
        studentText.setText("Student Tickets = " + student);
        oapText.setText("OAP Tickets = " + oap);
        childText.setText("Child Tickets = " + child);

        int total = (standard * 8) + (student * 6) + (oap * 6) + (child * 4);
        int discount = (standard + student + oap + child) * 2;
        if(dicount)
        {
            discountAmount.setText("Discount Amount = £" + discount);
            discountText.setText("Wednesday Discount Applied £2 Off");
            totalAmount.setText("Total Amount = £" + (total - discount) );
        }
        else
        {
            discountText.setText("No Discount Applied");
            totalAmount.setText("Total Amount = £" + total );
        }

    }
    public void ShowScreen()
    {

        frame.setVisible(true);
    }

}
