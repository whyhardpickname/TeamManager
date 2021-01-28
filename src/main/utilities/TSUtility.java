package utilities;

/**
 * {@code TSUtility}类提供实现键盘访问的方法。
 * @author MarkChern
 */
public class TSUtility
{
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
}
