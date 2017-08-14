package eos.java.practice.algorithm;

/**
 * 逻辑运算操作演示
 */
public class LogicOperation {
    /**
     * 异或运算 相同为0 不同为1
     * --任何数和自己异或运算都是0
     * --任何数和0异或运算都是自己本身
     * 用法：有一组数 成对出现 只有一个是单个的 求这个数 （可以将所有数异或运算，结果为要找的数）
     */
    public int xorOperator(int ... numbers) {
        int length = numbers.length;
        int result = numbers[0];
        for(int i = 1; i < length; i ++) {
            result ^= numbers[i];
        }
        OperationLog.info(numbers, result);
        return result;
    }


    /**
     * 或运算 有1则1 否则为0
     * --任何数和0进行或运算都是自己本身
     * --任何数和自己进行或运算都是自己本身
     * @param numbers
     */
    public int orOperator(int ... numbers) {
        int length = numbers.length;
        int result = numbers[0];
        for(int i = 1; i < length; i ++) {
            result |= numbers[i];
        }
        OperationLog.info(numbers, result);
        return result;
    }

    /**
     * 与运算 同1则1 否则为0
     * --任何数和自己进行与运算都是自己本身
     * --任何数和0进行与运算都是0
     * @param numbers
     * @return
     */
    public int andOperator(int ... numbers) {
        int length = numbers.length;
        int result = numbers[0];
        for(int i = 1; i < length; i ++) {
            result &= numbers[i];
        }
        OperationLog.info(numbers, result);
        return result;
    }

    /**
     * 非运算  1则0 0则1
     * --有符号运算中，任何数a的非运算为 -a-1
     */
    public int norOperator(int ... numbers) {
        int result = ~numbers[0];
        OperationLog.info(numbers, result);
        return result;
    }

    /**
     * 二进制转换
     * @param o
     * @return
     */
    public static String convertBinary(Object o) {
        int result = 0;
        if(o instanceof  Integer || o instanceof  String) {
            result = Integer.parseInt(o.toString());
        } else if (o instanceof  Long) {
            result = (int) o;
        }
        return Integer.toBinaryString(result);
    }

    /**
     * 匿名日志类
     */
    private static class OperationLog {
        public static void info(int[] numbers, int result) {
            StringBuilder builder = new StringBuilder("\n");
            int length = numbers.length;
            for(int i = 0; i < length; i ++ ) {
                builder.append(String.format("%32s", LogicOperation.convertBinary(numbers[i])))
                        .append(" (").append(numbers[i]).append(")")
                        .append("\n");
            }
            builder.append("--------------------------------")
                   .append("\n")
                   .append(String.format("%32s", LogicOperation.convertBinary(result)))
                   .append(" (").append(result).append(")");
            System.out.println(builder.toString());
        }
    }


    public static void main(String [] args ) {
        LogicOperation l = new LogicOperation();

        /**
         * 异或运算
         */
        //l.xorOperator(10,0);

        /**
         * 或运算
         */
        l.orOperator(11,11);

        /**
         * 与运算
         */
        l.andOperator(125,0);

        /**
         * 非运算
         */
        l.norOperator(10);

    }
}
