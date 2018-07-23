import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JComboBox movieCombo;
    private JPanel panel;
    private JSpinner standardValue;
    private JSpinner studentValue;
    private JSpinner oapValue;
    private JSpinner childValue;
    private JButton buyTicketsButton;
    private JCheckBox discountCheckBox;
    private JLabel title;
    private JLabel selectfilm;
    private JLabel standardLabel;
    private JLabel studentLabel;
    private JLabel oapLabel;
    private JLabel childLabel;
    private JLabel discountValue;
    private JLabel wednesdayLabel;
    private JLabel amountValue;
    private JButton lastTransactionButton;

    private int total;
    private int discount;
    private TransactionScreen lastTransaction;
    public static void main(String[] args)
    {
        GUI gui = new GUI();
        gui.Setup();
        gui.AddEventListeners();
        gui.AddMovies();

    }
    public GUI()
    {
        total = 0;
        discount = 0;
        JFrame frame = new JFrame("Cinema Ticket System");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,480);
        frame.setResizable(false);
        frame.setVisible(true);



    }
    public void Setup()
    {
        SpinnerNumberModel standardNum = new SpinnerNumberModel(0,0,10,1);
        SpinnerNumberModel studentNum = new SpinnerNumberModel(0,0,10,1);
        SpinnerNumberModel oapNum = new SpinnerNumberModel(0,0,10,1);
        SpinnerNumberModel childNum = new SpinnerNumberModel(0,0,10,1);
        standardValue.setModel(standardNum);
        studentValue.setModel(studentNum);
        oapValue.setModel(oapNum);
        childValue.setModel(childNum);
    }
    public void AddMovies()
    {
        movieCombo.addItem(new Movie("Skyscapper"));
        movieCombo.addItem(new Movie("The First Purge"));
        movieCombo.addItem(new Movie("Incredibles 2"));

    }
    public void AddEventListeners()
    {
        ChangeListener standardListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                       CalculateTotal(false);
            }
        };
        ChangeListener studentListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                CalculateTotal(false);
            }
        };
        ChangeListener oapListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                CalculateTotal(false);
            }
        };
        ChangeListener childListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                CalculateTotal(false);
            }
        };

        ActionListener discountListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculateTotal(discountCheckBox.isSelected());
            }
        };
        lastTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lastTransaction != null)
                {
                    lastTransaction.ShowScreen();
                }
            }

        });



        buyTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int standard  = (int) standardValue.getValue();
                int student = (int)studentValue.getValue();
                int oap = (int)oapValue.getValue();
                int child = (int)childValue.getValue();
               lastTransaction = new Transaction(standard,student,oap,child,movieCombo.getSelectedItem().toString(),discountCheckBox.isSelected());
               lastTransactionButton.setEnabled(true);
            }
        });

        discountCheckBox.addActionListener(discountListener);
        standardValue.addChangeListener(standardListener);
        studentValue.addChangeListener(studentListener);
        oapValue.addChangeListener(oapListener);
        childValue.addChangeListener(childListener);

    }
    public void CalculateTotal(Boolean apply)
    {
        total =  (int) standardValue.getValue() * 8;
        total += (int)studentValue.getValue() * 6;
        total += (int)oapValue.getValue() * 6;
        total += (int)childValue.getValue() * 4;

        if(apply)
        {
            discount = (int) standardValue.getValue() + (int)studentValue.getValue() + (int)oapValue.getValue() + (int)childValue.getValue();
            discount *= 2;
            total -= discount;
        }
        else
            discount = 0;
        discountValue.setText("Total Discount: £" + discount);
        amountValue.setText("Total Amount: £" + total);
    }
}

