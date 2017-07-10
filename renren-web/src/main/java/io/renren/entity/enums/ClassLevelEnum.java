package io.renren.entity.enums;

/**
 * Created by momo on 2017/7/10.
 */
public enum ClassLevelEnum {
    LEVEL1(1,"L1 3-4岁"),LEVEL2(2,"L1 5-7岁"),LEVEL3(3,"L3 7-9岁"),LEVEL4(4,"L4 9-10岁"),LEVEL5(5,"L5 10-12岁");
    private int index;
    private String name;
    private ClassLevelEnum(int index,String name){
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (ClassLevelEnum c : ClassLevelEnum.values()) {
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
