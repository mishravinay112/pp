package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.repository.QuestionAnswerRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class QuestionAnswerRepositoryImpl implements QuestionAnswerRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(QuestionAnswerRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Subject> getAllSubjectName() {
		List<Subject> list = hibernateTemplate.find("from Subject s where s.isDeleted=" + IConstant.IS_DELETED);
		return list;
	}

	public boolean addQuestionAndAnswer(QuestionAnswer questionAnswer) {
		if (questionAnswer != null) {
			hibernateTemplate.saveOrUpdate(questionAnswer);
			return true;
		} else {
			return false;
		}
	}

	public List<QuestionAnswer> getQuestionAndAnswer(Integer subjectId) {
		List<QuestionAnswer> list = hibernateTemplate.find("from QuestionAnswer q where q.isDeleted="
				+ IConstant.IS_DELETED + "and q.subject.subjectId=" + subjectId);
		return list;
	}
}
