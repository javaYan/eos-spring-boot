package eos.oj.enums;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 回答结果状态枚举类
 */
public enum ResultStatusEnum {
    COMPILING       (-2),//-2:正在编译
    RUNNING         (-1),//-1:正在运行
    AC               (0),// 0:已通过
    COMPILE_FAIL     (1),// 1:编译失败
    RUNTIME_EXCEPTION(2),// 2:运行时异常
    RESULT_ERROR     (3);// 3:结果错误
    public int code;
    ResultStatusEnum(int code) {
        this.code = code;
    }
}
