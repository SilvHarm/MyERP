package com.dummy.myerp.business.impl.manager;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
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

public class ComptabiliteManagerImplITCase {
	
	private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();
	private EcritureComptable vEcritureComptable;
	private static SimpleDateFormat dateFormat;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dateFormat = new SimpleDateFormat("yyyy");
	}
	
	
	@Before
	public void setUp() {
		// Doit être une EcritureComptable valide
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setId(22);
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setReference("AC-" + dateFormat.format(vEcritureComptable.getDate()) + "/00022");
		vEcritureComptable.setLibelle("Libelle");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(2), null, null, new BigDecimal(123)));
	}
	
	
	@Test
	public void addReference() {
		manager.addReference(vEcritureComptable);
	}
	
	
	@Test
	public void checkEcritureComptable() throws Exception {
		manager.checkEcritureComptable(vEcritureComptable);
	}
}
