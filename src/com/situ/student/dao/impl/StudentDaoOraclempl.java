package com.situ.student.dao.impl;

import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.entity.Student;
import com.situ.student.vo.SearchCondition;

public class StudentDaoOraclempl implements IStudentDao{

	@Override
	public boolean add(Student student) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean update(Student student) {
		return false;
	}

	@Override
	public List<Student> findAll() {
		return null;
	}

	@Override
	public Student findById(int id) {
		return null;
	}

	@Override
	public boolean checkStudent(Student student) {
		return false;
	}

	@Override
	public List<Student> findByName(String name) {
		return null;
	}

	@Override
	public List<Student> findByAge(int begin, int end) {
		return null;
	}

	@Override
	public List<Student> findByGender(String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByBirthday(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> searchByCondition(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> findPageBeanList(int index, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCountByCondition(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return 0;
	}

}
