package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Item;
import com.example.demo.mapper.ItemMapper;

@Service
public class ItemService {

	@Autowired
	private ItemMapper itemMapper;

	@Transactional
	public List<Item> findAll() {
		return itemMapper.findAll();
	}

	@Transactional
	public Item findOne(Long id) {
		return itemMapper.findOne(id);
	}

	@Transactional
	public void save(Item item) {
		itemMapper.save(item);
	}

	@Transactional
	public void update(Item item) {
		itemMapper.update(item);
	}

	@Transactional
	public void delete(Long id) {
		itemMapper.delete(id);
	}

}
