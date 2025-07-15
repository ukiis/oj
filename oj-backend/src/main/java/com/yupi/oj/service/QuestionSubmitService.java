package com.yupi.oj.service;

import com.yupi.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.oj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.oj.model.entity.User;

/**
* @author 么么哒
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2025-07-14 22:39:56
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {


    /**
     * 提交
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


}
