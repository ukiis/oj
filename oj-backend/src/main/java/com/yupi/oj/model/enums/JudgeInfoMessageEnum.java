package com.yupi.oj.model.enums;

import org.apache.commons.lang3.ObjectUtils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 判题信息枚举类型枚举
 *

 */
public enum JudgeInfoMessageEnum {
    ACCEPTED("Accepted", "成功"),
    WRONG_ANSWER("WrongAnswer", "答案错误"),
    COMPILE_ERROR("CompileError", "编译错误"),
    MEMORY_LIMIT_EXCEEDED("MemoryLimitExceeded", "内存溢出"),
    TIME_LIMIT_EXCEEDED("TimeLimitExceeded", "超时"),
    PRESENTATION_ERROR("PresentationError", "展示错误"),
    OUTPUT_LIMIT_EXCEEDED("OutputLimitExceeded", "输出溢出"),
    WAITING("Waiting", "等待中"),
    DANGEROUS_OPERATION("DangerousOperation", "危险操作"),
    RUNTIME_ERROR("RuntimeError", "运行错误"),
    SYSTEM_ERROR("SystemError", "系统错误");



    private final String text;

    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
