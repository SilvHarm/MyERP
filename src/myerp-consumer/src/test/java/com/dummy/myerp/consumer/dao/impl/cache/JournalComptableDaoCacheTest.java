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
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;

public class JournalComptableDaoCacheTest {
	
	JournalComptableDaoCache manager = new JournalComptableDaoCache();
	
	
	@Test
	public void getByCode() {
		List<JournalComptable> list = new ArrayList<JournalComptable>();
		list.add(new JournalComptable("12", "test"));
		list.add(new JournalComptable("34", "test"));
		list.add(new JournalComptable("56", "test"));
		list.add(new JournalComptable("78", "test"));
		
		
		ComptabiliteDao comptabiliteDaoMock = Mockito.mock(ComptabiliteDao.class);
		
		Mockito.when(comptabiliteDaoMock.getListJournalComptable()).thenReturn(list);
		
		DaoProxy daoProxyMock = new DaoProxyMock(comptabiliteDaoMock);
		ConsumerHelper.configure(daoProxyMock);
		
		
		Assert.assertNull(manager.getByCode(null));
		Assert.assertNotEquals(list.get(2), manager.getByCode("34"));
		Assert.assertEquals(list.get(2), manager.getByCode("56"));
	}
	
}
