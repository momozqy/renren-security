package io.renren.entity.enums;

/**
 * Created by momo on 2017/7/10.
 */
public enum StatusEnum {
    PUBLISH(2,"已发布"),UNPUBLISH(0,"未发布");
    private int index;
    private String name;
    private StatusEnum(int index,String name){
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (StatusEnum c : StatusEnum.values()) {
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
