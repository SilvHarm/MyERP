package com.dummy.myerp.business.contrat.manager;

import java.util.List;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.technical.exception.FunctionalException;


/**
 * Interface du manager du package comptabilite.
 */
public interface ComptabiliteManager {
	
	public final static String RG2_EXCEPTION = "L'écriture comptable n'est pas équilibrée.",
			RG3_EXCEPTION = "L'écriture comptable doit avoir au moins deux lignes : une ligne au débit et une ligne au crédit.",
			RG5_CODE_EXCEPTION = "Le code journal doit être le même dans la référence",
			RG5_DATE_EXCEPTION = "La date de l'écriture comptable doit être la même dans la référence",
			RG6_EXCEPTION = "Une autre écriture comptable existe déjà avec la même référence.",
			VIOLATION_EXCEPTION = "L'écriture comptable ne respecte pas les règles de gestion.";
	
	
	/**
	 * Renvoie la liste des comptes comptables.
	 *
	 * @return {@link List}
	 */
	List<CompteComptable> getListCompteComptable();
	
	
	/**
	 * Renvoie la liste des journaux comptables.
	 *
	 * @return {@link List}
	 */
	List<JournalComptable> getListJournalComptable();
	
	
	/**
	 * Renvoie la liste des écritures comptables.
	 *
	 * @return {@link List}
	 */
	List<EcritureComptable> getListEcritureComptable();
	
	
	/**
	 * Ajoute une référence à l'écriture comptable.
	 *
	 * <strong>RG_Compta_5 : </strong> La référence d'une écriture comptable est
	 * composée du code du journal dans lequel figure l'écriture suivi de l'année et
	 * d'un numéro de séquence (propre à chaque journal) sur 5 chiffres incrémenté
	 * automatiquement à chaque écriture. Le formatage de la référence est :
	 * XX-AAAA/#####. <br>
	 * Ex : Journal de banque (BQ), écriture au 31/12/2016
	 * 
	 * <pre>
	 * BQ - 2016 / 00001
	 * </pre>
	 *
	 * <p>
	 * <strong>Attention :</strong> l'écriture n'est pas enregistrée en persistance
	 * </p>
	 * 
	 * @param pEcritureComptable
	 *           L'écriture comptable concernée
	 */
	void addReference(EcritureComptable pEcritureComptable);
	
	
	/**
	 * Vérifie que l'Ecriture comptable respecte les règles de gestion.
	 *
	 * @param pEcritureComptable
	 *           -
	 * @throws FunctionalException
	 *            Si l'Ecriture comptable ne respecte pas les règles de gestion
	 */
	void checkEcritureComptable(EcritureComptable pEcritureComptable) throws FunctionalException;
	
	
	/**
	 * Insert une nouvelle écriture comptable.
	 *
	 * @param pEcritureComptable
	 *           -
	 * @throws FunctionalException
	 *            Si l'Ecriture comptable ne respecte pas les règles de gestion
	 */
	void insertEcritureComptable(EcritureComptable pEcritureComptable) throws FunctionalException;
	
	
	/**
	 * Met à jour l'écriture comptable.
	 *
	 * @param pEcritureComptable
	 *           -
	 * @throws FunctionalException
	 *            Si l'Ecriture comptable ne respecte pas les règles de gestion
	 */
	void updateEcritureComptable(EcritureComptable pEcritureComptable) throws FunctionalException;
	
	
	/**
	 * Supprime l'écriture comptable d'id {@code pId}.
	 *
	 * @param pId
	 *           l'id de l'écriture
	 */
	void deleteEcritureComptable(Integer pId);
}
