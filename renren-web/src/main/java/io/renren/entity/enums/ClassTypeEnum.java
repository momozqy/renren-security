package io.renren.entity.enums;

/**
 * Created by momo on 2017/8/9.
 */
public enum ClassTypeEnum {
    NORMAL(1,"NORMAL"),FREE(2,"FREE"),VIP(3,"VIP");
    private int index;
    private String name;
    ClassTypeEnum(int index,String name){
        this.index = index;
        this.name = name;
    }
    // 普通方法
    public static String getName(int index) {
        for (ClassTypeEnum c : ClassTypeEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
