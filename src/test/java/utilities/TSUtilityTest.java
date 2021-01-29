package utilities;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class TSUtilityTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private  ByteArrayInputStream in;

    @BeforeEach
    void setUp()
    {

    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void readMenuSelection()
    {
        //备份原输入输出
        InputStream sysBackup = System.in;
        PrintStream originalOut = System.out;
        //模拟输入,保存输出
        String simulatedUserInput = "0" + System.getProperty("line.separator") + "1";
        in = new ByteArrayInputStream(simulatedUserInput.getBytes());

        System.setIn(in);
        System.setOut(new PrintStream(outContent));

        assertEquals('0', TSUtility.readMenuSelection());
        assertEquals("error: enter again.", outContent.toString());


        //恢复
        System.setIn(sysBackup);
        System.setOut(originalOut);
    }

    @Test
    void readReturn()
    {

    }

    @Test
    void readInt()
    {

    }

    @Test
    void readConfirmSelection()
    {
    }

    @Test
    void readKeyBoard() throws Exception
    {
        Method method =
                TSUtility.class.getDeclaredMethod("readKeyBoard", int.class, boolean.class);

        method.setAccessible(true);
        TSUtility utility = new TSUtility();

        //备份原输入输出
        InputStream sysBackup = System.in;
        PrintStream originalOut = System.out;

        //空白输入+ false + 正确输入
        String simulatedUserInput = "" + System.getProperty("line.separator") + "1" +
                System.getProperty("line.separator");
        in = new ByteArrayInputStream(simulatedUserInput.getBytes());

        //模拟输入,保存输出
        System.setIn(in);
        System.setOut(new PrintStream(outContent));

        assertEquals("1", method.invoke(utility, 1, false));
        assertEquals("输入长度错误，请重新输入：", outContent.toString());

        /*System.setIn(in);
        System.setOut(new PrintStream(outContent));
        //空白输入+ true
        simulatedUserInput = "";
        in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        assertEquals("", method.invoke(utility, 1, false));
        assertNull(outContent.toString());*/

        //恢复
        System.setIn(sysBackup);
        System.setOut(originalOut);
    }
}