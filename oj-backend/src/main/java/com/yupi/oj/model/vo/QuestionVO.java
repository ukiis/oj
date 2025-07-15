package com.yupi.oj.model.vo;

import cn.hutool.json.JSONUtil;
import com.yupi.oj.model.dto.question.JudgeCase;
import com.yupi.oj.model.dto.question.JudgeConfig;
import com.yupi.oj.model.entity.Post;
import com.yupi.oj.model.entity.Question;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

/**
 * 题目
 * @TableName question
 */
@Data
public class QuestionVO {
    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目提交数
     */
    private Integer submitNum;

    /**
     * 判题用例（json 数组）
     */
    private List<JudgeCase> judgeCase;

    /**
     * 判题配置（json 对象）
     */
    private JudgeConfig judgeConfig;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建题目人信息
     *
     */

    private UserVO userVO;

    private static final long serialVersionUID = 1L;


    /**
     * 包装类转对象
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tagList = questionVO.getTags();
        if (tagList == null){
            question.setTags(JSONUtil.toJsonStr(tagList));
        }
        JudgeConfig judgeConfigVo = questionVO.getJudgeConfig();
        if (judgeConfigVo == null){
            question.setJudgeConfig(JSONUtil.toJsonStr(judgeConfigVo));
        }
        return question;
    }

    /**
     * 对象转包装类
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        List<String> list = JSONUtil.toList(question.getTags(), String.class);
        String judgeConfigStr = question.getJudgeConfig();
        questionVO.setJudgeConfig(JSONUtil.toBean(judgeConfigStr, JudgeConfig.class));
        return questionVO;
    }
}