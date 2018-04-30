package com.dummy.myerp.business.impl.manager;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.dummy.myerp.consumer.dao.ComptabiliteDaoMock;
import com.dummy.myerp.consumer.dao.DaoProxyMock;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;


public class ComptabiliteManagerImplTest {
	
	private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DaoProxy daoProxy = new DaoProxyMock(new ComptabiliteDaoMock());
		
		ComptabiliteManagerImpl.configure(null, daoProxy, null);
	}
	
	
	@Test
	public void checkEcritureComptable() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setId(22);
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setReference("AC-" + vEcritureComptable.getDate().toString().substring(25, 29) + "/00022");
		vEcritureComptable.setLibelle("Libelle");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(2), null, null, new BigDecimal(123)));
		
		
		manager.checkEcritureComptable(vEcritureComptable);
	}
	
	
	@Test
	public void checkEcritureComptableUnit() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setLibelle("Libelle");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(2), null, null, new BigDecimal(123)));
		
		
		manager.checkEcritureComptableUnit(vEcritureComptable);
		
		vEcritureComptable.setReference("AC-" + vEcritureComptable.getDate().toString().substring(25, 29) + "/00022");
		manager.checkEcritureComptableUnit(vEcritureComptable);
	}
	
	
	@Test
	public void checkEcritureComptableUnitViolation() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		
		thrown.expect(FunctionalException.class);
		
		
		thrown.expectMessage(ComptabiliteManagerImpl.VIOLATION_EXCEPTION);
		manager.checkEcritureComptableUnit(vEcritureComptable);
	}
	
	
	@Test
	public void checkEcritureComptableUnitRG2() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setLibelle("Libelle");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(2), null, null, new BigDecimal(1234)));
		
		thrown.expect(FunctionalException.class);
		
		
		thrown.expectMessage(ComptabiliteManagerImpl.RG2_EXCEPTION);
		manager.checkEcritureComptableUnit(vEcritureComptable);
	}
	
	
	@Test
	public void checkEcritureComptableUnitRG3() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setLibelle("Libelle");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(-123), null));
		
		thrown.expect(FunctionalException.class);
		
		
		thrown.expectMessage(ComptabiliteManagerImpl.RG3_EXCEPTION);
		manager.checkEcritureComptableUnit(vEcritureComptable);
	}
	
	
	@Test
	public void checkEcritureComptableUnitRG5() throws Exception {
		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setLibelle("Libelle");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(2), null, null, new BigDecimal(123)));
		
		thrown.expect(FunctionalException.class);
		
		
		thrown.expectMessage(ComptabiliteManagerImpl.RG5_DATE_EXCEPTION);
		vEcritureComptable.setReference("AC-1963/00022");
		manager.checkEcritureComptableUnit(vEcritureComptable);
		
		thrown.expectMessage(ComptabiliteManagerImpl.RG5_CODE_EXCEPTION);
		vEcritureComptable.setReference("AV-" + vEcritureComptable.getDate().toString().substring(25, 29) + "/00022");
		manager.checkEcritureComptableUnit(vEcritureComptable);
	}
	
}
