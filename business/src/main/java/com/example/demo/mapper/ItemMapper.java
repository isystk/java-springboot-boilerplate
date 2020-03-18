package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Item;

@Mapper
public interface ItemMapper {
	List<Item> findAll();
	
	Item findOne(Long id);
	
	void save(Item item);
	
	void update(Item item);
	
	void delete(Long id);
}
