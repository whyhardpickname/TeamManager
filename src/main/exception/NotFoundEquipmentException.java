package exception;

/**
 * {@code NotFoundEmployeeException}是当找不到指定员工时抛出的异常。
 * @author MarkChern
 */
public class NotFoundEquipmentException extends TeamException
{
    /**
     * {@code NotFoundEquipmentException}是在无法找到对应设备时抛出的异常。
     */
    public NotFoundEquipmentException()
    {
        super("The specified equipment"  + " couldn't found.");
    }
}
