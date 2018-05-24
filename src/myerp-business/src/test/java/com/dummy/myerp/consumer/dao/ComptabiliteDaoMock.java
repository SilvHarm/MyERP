package com.dummy.myerp.consumer.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;
import com.dummy.myerp.technical.exception.NotFoundException;


public class ComptabiliteDaoMock implements ComptabiliteDao {
	
	@Override
	public List<CompteComptable> getListCompteComptable() {
		return null;
	}
	
	
	@Override
	public List<JournalComptable> getListJournalComptable() {
		return null;
	}
	
	
	@Override
	public SequenceEcritureComptable getSequenceEcritureComptableByCodeYear(String codeJournal, int year) {
		return new SequenceEcritureComptable(Integer.getInteger(new SimpleDateFormat("yyyy").format(new Date())), 1024);
	}
	
	
	@Override
	public void insertSequenceEcritureComptable(String codeJournal,
			SequenceEcritureComptable pSequenceEcritureComptable) {
		
	}
	
	
	@Override
	public void updateSequenceEcritureComptable(String codeJournal,
			SequenceEcritureComptable pSequenceEcritureComptable) {
		
	}
	
	
	@Override
	public List<EcritureComptable> getListEcritureComptable() {
		return null;
	}
	
	
	@Override
	public EcritureComptable getEcritureComptable(Integer pId) throws NotFoundException {
		return null;
	}
	
	
	@Override
	public EcritureComptable getEcritureComptableByRef(String pReference) throws NotFoundException {
		EcritureComptable vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setId(22);
		vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		vEcritureComptable.setDate(new Date());
		vEcritureComptable
				.setReference("AC-" + new SimpleDateFormat("yyyy").format(vEcritureComptable.getDate()) + "/00022");
		vEcritureComptable.setLibelle("Libelle");
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null));
		vEcritureComptable.getListLigneEcriture()
				.add(new LigneEcritureComptable(new CompteComptable(2), null, null, new BigDecimal(123)));
		
		return vEcritureComptable;
	}
	
	
	@Override
	public void loadListLigneEcriture(EcritureComptable pEcritureComptable) {
		
	}
	
	
	@Override
	public void insertEcritureComptable(EcritureComptable pEcritureComptable) {
		
	}
	
	
	@Override
	public void updateEcritureComptable(EcritureComptable pEcritureComptable) {
		
	}
	
	
	@Override
	public void deleteEcritureComptable(Integer pId) {
		
	}
	
}
