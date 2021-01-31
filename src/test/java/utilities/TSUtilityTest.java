package utilities;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class TSUtilityTest
{
    private  ByteArrayInputStream in;
    private InputStream originalInBackup;
    private PrintStream originalOutBackup;

    void setOriginalIOBackup()
    {
        originalInBackup = System.in;
        originalOutBackup = System.out;
    }

    void restoredOriginalIOBackup()
    {
        System.setIn(originalInBackup);
        System.setOut(originalOutBackup);
    }

    @BeforeEach
    void setUp()
    {

    }

    @AfterEach
    void tearDown()
    {
        System.setIn(originalInBackup);
        System.setOut(originalOutBackup);
    }

    @Test
    void readMenuSelection()
    {
        setOriginalIOBackup();

        String input = "0" + System.getProperty("line.separator") +
                "1" + System.getProperty("line.separator");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
        TSUtility.setScanner(new Scanner(inputStream));

        assertEquals('1', TSUtility.readMenuSelection());
        assertEquals("选择错误，请重新输入：", outputStream.toString());
        assertEquals("选择错误，请重新输入：", outputStream.toString());

        restoredOriginalIOBackup();
    }

    @Test
    void readReturn() throws IOException
    {
        setOriginalIOBackup();

        String input = System.getProperty("line.separator") +
                "abc" + System.getProperty("line.separator");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
        TSUtility.setScanner(new Scanner(inputStream));

        TSUtility.readReturn();
        assertEquals("请按回车键继续...", outputStream.toString());
        outputStream.reset();
        TSUtility.readReturn();
        assertEquals("请按回车键继续...", outputStream.toString());

        restoredOriginalIOBackup();
    }

    @Test
    void readInt()
    {
        setOriginalIOBackup();

        String input = "abc" + System.getProperty("line.separator") +
                "1" + System.getProperty("line.separator");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
        TSUtility.setScanner(new Scanner(inputStream));

        TSUtility.readReturn();
        assertEquals("请按回车键继续...", outputStream.toString());
        outputStream.reset();
        TSUtility.readReturn();
        assertEquals("请按回车键继续...", outputStream.toString());

        restoredOriginalIOBackup();
    }

    @Test
    void readConfirmSelection()
    {
    }

    @Test
    void readKeyBoard() throws Exception
    {
        //备份
        setOriginalIOBackup();

        Method method =
                TSUtility.class.getDeclaredMethod("readKeyBoard", int.class, boolean.class);

        method.setAccessible(true);
        TSUtility utility = new TSUtility();

        //空白输入+ false + 正确输入
        String simulatedUserInput = System.getProperty("line.separator") + "1" + System.getProperty("line.separator");
        in = new ByteArrayInputStream(simulatedUserInput.getBytes());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //模拟输入,保存输出
        System.setIn(in);
        System.setOut(new PrintStream(outContent));

        TSUtility.setScanner(new Scanner(in));
        assertEquals("1", method.invoke(utility, 1, false));
        assertEquals("输入长度错误，请重新输入：", outContent.toString());

        //空白输入 + true；
        assertEquals("", method.invoke(utility, 1, true));

        //恢复
        restoredOriginalIOBackup();
    }
}