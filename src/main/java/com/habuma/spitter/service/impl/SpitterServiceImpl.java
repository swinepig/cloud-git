package com.habuma.spitter.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.habuma.spitter.dao.SpitterDao;
import com.habuma.spitter.service.ISpitterService;


@Service("spitterService")
public class SpitterServiceImpl implements ISpitterService{

	@Resource(name="spitterDao")
	private SpitterDao spitterDao;


	@Override
	public void save() {
		spitterDao.save();
	}
	
}
