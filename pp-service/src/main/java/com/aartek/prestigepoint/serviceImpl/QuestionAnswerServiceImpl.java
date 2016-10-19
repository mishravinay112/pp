package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.repository.QuestionAnswerRepository;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(QuestionAnswerServiceImpl.class);
	@Autowired
	private QuestionAnswerRepository questionAnswerRepository;

	public List<Subject> getAllSubjectName() {
		List<Subject> list = questionAnswerRepository.getAllSubjectName();
		return list;
	}

	public boolean addQuestionAndAnswer(QuestionAnswer questionAnswer) {
		boolean status = false;
		questionAnswer.setIsDeleted(IConstant.IS_DELETED);
		status = questionAnswerRepository.addQuestionAndAnswer(questionAnswer);
		return status;
	}

	public List<QuestionAnswer> getQuestionAndAnswer(Integer subjectId) {
		List<QuestionAnswer> answerList = questionAnswerRepository.getQuestionAndAnswer(subjectId);
		return answerList;
	}

}
