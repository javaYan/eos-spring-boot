package eos.java.practice.interface_abstract.interfaces;

/**
 * Created by yanyuyu on 2017/3/17.
 */
public class SubA implements A{
    public int id;
    @Override
    public void printfId() {
        System.out.println(id);
    }
}
