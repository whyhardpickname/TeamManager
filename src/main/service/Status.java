package service;

/**
 * 状态类{@code Status}是定义开发团队成员状态的枚举类。
 *
 * <P>状态类主要用来标记开发团队成员的状态，有空闲，已加入开发团队和正在休假三种状态。
 *
 * @author MarkChern
 */
public enum Status
{
    /**空闲*/
    FREE,
    /**已加入开发团队*/
    BUSY,
    /**正在休假*/
    VOCATION
}
