package com.dummy.myerp.consumer.dao.impl.cache;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.dummy.myerp.consumer.ConsumerHelper;
import com.dummy.myerp.consumer.dao.DaoProxyMock;
import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;

public class CompteComptableDaoCacheTest {
	
	CompteComptableDaoCache manager = new CompteComptableDaoCache();
	
	
	@Test
	public void getByNumero() {
		List<CompteComptable> list = new ArrayList<CompteComptable>();
		list.add(new CompteComptable(12, "test"));
		list.add(new CompteComptable(34, "test"));
		list.add(new CompteComptable(56, "test"));
		list.add(new CompteComptable(78, "test"));
		
		
		ComptabiliteDao comptabiliteDaoMock = Mockito.mock(ComptabiliteDao.class);
		
		Mockito.when(comptabiliteDaoMock.getListCompteComptable()).thenReturn(list);
		
		DaoProxy daoProxyMock = new DaoProxyMock(comptabiliteDaoMock);
		ConsumerHelper.configure(daoProxyMock);
		
		
		Assert.assertNull(manager.getByNumero(null));
		Assert.assertNotEquals(list.get(2), manager.getByNumero(34));
		Assert.assertEquals(list.get(2), manager.getByNumero(56));
	}
	
}
