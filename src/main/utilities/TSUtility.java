package utilities;

import javax.xml.transform.Source;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * {@code TSUtility}类提供实现键盘访问的方法。
 * @author MarkChern
 */
public class TSUtility
{
    /** 读取用户输入 */
    private static Scanner scanner = new Scanner(System.in);
    /**
     * {@code readMenuSelection}方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。
     * 返回值为用户键入字符。
     * @return
     */
    public static char readMenuSelection()
    {
        char selection;

        while (true)
        {
            selection = readKeyBoard(1, false).charAt(0);

            if (selection == '1' || selection == '2' || selection == '3' || selection == '4')
            {
                return selection;
            }
            else
            {
                System.out.print("选择错误，请重新输入：");
            }
        }
    }

    /**
     * {@code readReturn}方法提示并等待，直到用户按回车键后返回。
     */
    public static void readReturn()
    {
        System.out.print("请按回车键继续...");
        readKeyBoard(100, true);
    }

    /**
     * {@code readInt}方法从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     * @return
     */
    public static int readInt()
    {
        boolean isInt = false;
        int n = 0;
        do
        {
            String in = readKeyBoard(2, false);
            try
            {
                n = Integer.parseInt(in);
            }
            catch (NumberFormatException e)
            {
                System.out.println("错误：请输入不超过2位的整数");
                isInt = true;
            }
        }
        while (!isInt);
        return n;
    }

    /**
     * {@code readConfirmSelection}方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     * @return
     */
    public static char readConfirmSelection()
    {
        return 'N';
    }

    /**
     * {@code readKeyBoard}方法从键盘读取最长{@code limit}的输入。
     * @param limit
     *      最长输入
     * @param blankReturn
     *      换行标识
     * @return
     *      读取的行
     */
    private static String readKeyBoard(int limit, boolean blankReturn)
    {
        String line = "";
        while (scanner.hasNextLine())
        {
            line = scanner.nextLine();
            if (line.length() == 0)
            {
                if (blankReturn)
                {
                    return line;
                }
            }

            if (line.length() < 1 || line.length() > limit)
            {
                System.out.print("输入长度错误，请重新输入：");
                continue;
            }
            break;
        }
        return  line;
    }

    public static void simulateInput()
    {
        InputStream backup = System.in;
        ByteArrayInputStream input = new ByteArrayInputStream("1".getBytes());
        System.setIn(input);
        scanner = new Scanner(System.in);
        if (scanner.nextInt() == 1)
        {
            System.out.println("ok");
        }
        else
        {
            System.out.println("not ok");
        }

        System.setIn(backup);
    }

    public static void simplePrint()
    {
        System.out.println("ok");
    }
    public static void testMethodSideEffect()
    {
        PrintStream original = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        TSUtility.simulateInput();
        System.setOut(original);

        System.out.println(out.toString() + "!");
    }
    public static void main(String[] args)
    {
//        simulateInput();
//        testMethodSideEffect();
        TSUtility.readKeyBoard(1, false);
    }

    public static Scanner getScanner()
    {
        return scanner;
    }

    public static void setScanner(Scanner scanner)
    {
        TSUtility.scanner = scanner;
    }
}
