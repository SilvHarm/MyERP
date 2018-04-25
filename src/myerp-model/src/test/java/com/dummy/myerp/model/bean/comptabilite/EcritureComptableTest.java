package com.dummy.myerp.model.bean.comptabilite;

import java.math.BigDecimal;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.Test;


public class EcritureComptableTest {
	
	private LigneEcritureComptable createLigne(Integer pCompteComptableNumero, String pDebit, String pCredit) {
		BigDecimal vDebit = pDebit == null ? null : new BigDecimal(pDebit);
		BigDecimal vCredit = pCredit == null ? null : new BigDecimal(pCredit);
		String vLibelle = ObjectUtils.defaultIfNull(vDebit, BigDecimal.ZERO)
				.subtract(ObjectUtils.defaultIfNull(vCredit, BigDecimal.ZERO)).toPlainString();
		LigneEcritureComptable vRetour = new LigneEcritureComptable(new CompteComptable(pCompteComptableNumero), vLibelle,
				vDebit, vCredit);
		return vRetour;
	}
	
	
	@Test
	public void getTotalCrebit() {
		EcritureComptable vEcriture;
		vEcriture = new EcritureComptable();
		
		Assert.assertSame(BigDecimal.ZERO, vEcriture.getTotalCredit());
		
		vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "1"));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "8"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "6"));
		Assert.assertEquals(BigDecimal.valueOf(15), vEcriture.getTotalCredit());
		
		vEcriture.getListLigneEcriture().clear();
		vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "10"));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "11"));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "10"));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, null, null));
		Assert.assertEquals(BigDecimal.valueOf(31), vEcriture.getTotalCredit());
		
		vEcriture.getListLigneEcriture().clear();
		vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "10"));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "11.55"));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "0.45"));
		Assert.assertEquals(BigDecimal.valueOf(22), vEcriture.getTotalCredit());
	}
	
	
	@Test
	public void getTotalDebit() {
		EcritureComptable vEcriture;
		vEcriture = new EcritureComptable();
		
		Assert.assertSame(BigDecimal.ZERO, vEcriture.getTotalDebit());
		
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "1", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "8", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, "6", null));
		Assert.assertEquals(BigDecimal.valueOf(15), vEcriture.getTotalDebit());
		
		vEcriture.getListLigneEcriture().clear();
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "10", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "11", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "10", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, null, null));
		Assert.assertEquals(BigDecimal.valueOf(31), vEcriture.getTotalDebit());
		
		vEcriture.getListLigneEcriture().clear();
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "10", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "11.55", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "0.55", null));
		Assert.assertEquals(BigDecimal.valueOf(22.1), vEcriture.getTotalDebit());
	}
	
	
	@Test
	public void isEquilibree() {
		EcritureComptable vEcriture;
		vEcriture = new EcritureComptable();
		
		vEcriture.setLibelle("Equilibrée");
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
		Assert.assertTrue(vEcriture.toString(), vEcriture.isEquilibree());
		
		vEcriture.getListLigneEcriture().clear();
		vEcriture.setLibelle("Non équilibrée");
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "10", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "20", "1"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "30"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, "1", "2"));
		Assert.assertFalse(vEcriture.toString(), vEcriture.isEquilibree());
	}
	
}
