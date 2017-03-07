package eos.java.practice.enums;

/**
 * Created by yanyuyu on 2017/3/7.
 */
public enum HumanEnum {

    Child (1,"小孩"),
    Teenager (2,"青年"),
    Adult(3,"成年人"),
    Elderly(4,"老年人");


    public int code;
    public String value;

    HumanEnum(int c, String v) {
        code = c;
        value = v;
    }

    public static void main(String[] args) {
        System.out.println(HumanEnum.Adult.code);
        System.out.println(HumanEnum.Elderly.value);
    }
}
