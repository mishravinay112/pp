package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.model.Subject;

public interface QuestionAnswerRepository {

	public List<Subject> getAllSubjectName();

	public boolean addQuestionAndAnswer(QuestionAnswer questionAnswer);

	public List<QuestionAnswer> getQuestionAndAnswer(Integer subjectId);

}
