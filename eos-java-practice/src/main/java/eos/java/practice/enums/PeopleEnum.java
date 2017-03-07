package eos.java.practice.enums;

/**
 * Created by yanyuyu on 2017/3/7.
 */
public enum PeopleEnum {

    Child (1,"小孩"),
    Teenager (2,"青年"),
    Adult(3,"成年人"),
    Elderly(4,"老年人");


    private int code;
    private String value;

    PeopleEnum(int c, String v) {
        code = c;
        value = v;
    }

    public static String getValue(PeopleEnum peopleEnum) {
        for(PeopleEnum people : PeopleEnum.values()) {
            if(people.equals(peopleEnum)) {
                return people.value;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(PeopleEnum.getValue(PeopleEnum.Adult));
        System.out.println(PeopleEnum.valueOf("Elderly"));
    }
}
