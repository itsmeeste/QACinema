import java.util.ArrayList;
import java.util.List;

public class Transaction extends TransactionScreen
{
    private int standard,student,oap,child;
    private String title;
    private boolean isDiscount;
    public Transaction(int standard,int student,int oap,int child,String title,boolean discount)
    {
        this.standard = standard;
        this.student = student;
        this.oap = oap;
        this.child = child;

        SetDetails(title,standard,student,oap,child,discount);

    }
}
