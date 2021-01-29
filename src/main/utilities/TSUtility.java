package utilities;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
        return '1';
    }

    /**
     * {@code readReturn}方法提示并等待，直到用户按回车键后返回。
     */
    public static void readReturn()
    {

    }

    /**
     * {@code readInt}方法从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     * @return
     */
    public static int readInt()
    {
        return 0;
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
    private String readKeyBoard(int limit, boolean blankReturn)
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
                else
                {
                    continue;
                }
            }

            if (line.length() < 1 || line.length() > limit)
            {
                System.out.println("输入长度错误，请重新输入：");
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

    public static void main(String[] args)
    {
        simulateInput();
    }
}
