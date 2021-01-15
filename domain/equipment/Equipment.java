package domain.equipment;

/**
 * 设备接口{@code Equipment}是程序员及其子类{@code Programmer}领用的电子设备，包括笔记本电脑，台式电脑和显示屏。
 *
 * <p>设备主要作为程序员类及其子类的关联属性。
 *
 * @author MarkChern
 */
public interface Equipment
{
    /**
     * 该方法用于获取电子设备的描述，例如型号和价格。
     * @return 电子设备的描述
     */
    String getDescription();
}
