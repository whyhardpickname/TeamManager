package domain.equipment;

import java.util.Objects;

/**
 * 显示屏类{@code Printer}是应用了设备接口{@code Equipment}的类。
 *
 * <p>显示屏主要作为程序员类{@code Programmer}及其子类领用的电子设备。
 *
 * @author MarkChernNoteBook
 */
public class Printer implements Equipment
{
    /**打印机类型*/
    private String type;
    /**打印机名字*/
    private String name;

    /**
     * 构造一个指定类型和名字的打印机对象
     * @param type
     *      类型
     * @param name
     *      名字
     */
    public Printer(String type, String name)
    {
        this.type = type;
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    /**
     * 返回该对象的类型和名字和字符串描述。
     * @return 类型和名字和字符串描述。
     */
    @Override
    public String getDescription()
    {
        return "Printer{" +
                "type=" + type +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printer printer = (Printer) o;
        return Objects.equals(type, printer.getType()) &&
                Objects.equals(name, printer.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(type, name);
    }
}
