import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
public class DemoTest extends BaseClass
    {
        @Test(priority = 1)
        public void openTheWebsite() throws Exception {
            initialSetup();
        }
        @Test(priority = 2)
        public void login() throws Exception
        {
            loginTowebsite();
        }
        @Test(priority = 3)
        public void select() throws Exception
        {
            selectingitem();
        }
        @Test(priority = 4)
        public void check() throws Exception
        {
            checkingPrice();
        }
        @Test(priority = 5)
        public void least()throws Exception
        {
            addingLeastExpensive();
        }
        @Test(priority = 6)
        public void checkout() throws Exception
        {
            checkOut();
        }
        @Test(priority = 7)
        public void checkCorrection() throws Exception
        {
            checkingCorretion();
        }
        @Test(priority = 8)
        public void finall() throws Exception{
            finish();
        }
        @AfterTest
        public void exits()throws Exception{
            exit();

        }
    }

