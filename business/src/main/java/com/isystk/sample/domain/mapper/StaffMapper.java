package com.isystk.sample.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.isystk.sample.domain.entity.Staff;

@Mapper
public interface StaffMapper {
	List<Staff> findAll();

	Staff findOne(Long id);

	void save(Staff item);

	void update(Staff item);

	void delete(Long id);

	Staff findByEmail(String email);

}
