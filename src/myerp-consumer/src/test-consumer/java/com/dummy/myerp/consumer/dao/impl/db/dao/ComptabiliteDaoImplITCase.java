package com.dummy.myerp.consumer.dao.impl.db.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.util.Assert;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.consumer.dao.impl.db.dao.ComptabiliteDaoImpl;

public class ComptabiliteDaoImplITCase {
	
	private ComptabiliteDaoImpl manager = new ComptabiliteDaoImpl();
	
	
	@Test
	public void getListCompteComptable() {
		List<CompteComptable> list = manager.getListCompteComptable();
		
		Assert.notNull(list, null);
		Assert.notEmpty(list, null);
	}
	
}
