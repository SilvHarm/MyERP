package com.dummy.myerp.model.bean.comptabilite;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CompteComptableTest {
	
	@Test
	public void getByNumero() {
		Assert.assertNull(CompteComptable.getByNumero(null, null));
		
		
		List<CompteComptable> testList = new ArrayList<CompteComptable>();
		Assert.assertNull(CompteComptable.getByNumero(testList, null));
		
		
		CompteComptable testCompte = new CompteComptable();
		testList.add(testCompte);
		testCompte.setNumero(10);
		testList.add(testCompte);
		testCompte.setNumero(22);
		testList.add(testCompte);
		
		Assert.assertNull(CompteComptable.getByNumero(testList, 42));
		Assert.assertEquals(testCompte, CompteComptable.getByNumero(testList, 22));
	}
	
}
