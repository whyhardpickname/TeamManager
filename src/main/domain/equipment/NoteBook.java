package domain.equipment;

/**
 * 笔记本电脑类{@code PC}是应用了设备接口{@code Equipment}的类。
 *
 * <p>笔记本电脑主要作为程序员类{@code Programmer}及其子类领用的电子设备。
 *
 * @author MarkChernNoteBook
 */
public class NoteBook implements Equipment
{
    /**型号*/
    private String model;
    /**价格*/
    private double price;

    /**
     * 构造一个指定型号和价格的笔记本电脑对象。
     *
     * @param model
     *          型号
     * @param price
     *          价格
     */
    public NoteBook(String model, double price)
    {
        this.model = model;
        this.price = price;
    }

    public String getModel()
    {
        return model;
    }

    public double getPrice()
    {
        return price;
    }

    /**
     * 返回该对象的型号和价格的字符串描述。
     * @return 型号和价格的字符串描述
     */
    @Override
    public String getDescription()
    {
        return "NoteBook{" +
                "model=" + model +
                ", price=" + price +
                '}';
    }
}
