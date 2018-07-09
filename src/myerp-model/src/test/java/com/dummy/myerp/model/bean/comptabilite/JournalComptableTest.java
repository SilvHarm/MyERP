package com.dummy.myerp.model.bean.comptabilite;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class JournalComptableTest {
	
	@Test
	public void getByCode() {
		Assert.assertNull(JournalComptable.getByCode(null, null));
		
		
		List<JournalComptable> testList = new ArrayList<JournalComptable>();
		Assert.assertNull(JournalComptable.getByCode(testList, null));
		
		
		JournalComptable testJournal = new JournalComptable();
		testList.add(testJournal);
		testJournal.setCode("10");
		testList.add(testJournal);
		testJournal.setCode("22");
		testList.add(testJournal);
		
		
		Assert.assertNull(JournalComptable.getByCode(testList, "42"));
		Assert.assertEquals(testJournal, JournalComptable.getByCode(testList, "22"));
	}
	
}
