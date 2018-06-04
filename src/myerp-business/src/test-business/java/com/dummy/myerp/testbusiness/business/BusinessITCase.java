package com.dummy.myerp.testbusiness.business;


import com.dummy.myerp.business.contrat.BusinessProxy;
import com.dummy.myerp.business.impl.TransactionManager;


/**
 * Classe mère des classes de test d'intégration de la couche Business
 */
public abstract class BusinessITCase {
	
	static {
		SpringRegistryITCase.init();
	}
	
	/** {@link BusinessProxy} */
	private static final BusinessProxy BUSINESS_PROXY = SpringRegistryITCase.getBusinessProxy();
	/** {@link TransactionManager} */
	private static final TransactionManager TRANSACTION_MANAGER = SpringRegistryITCase.getTransactionManager();
	
	
	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public BusinessITCase() {}
	
	
	// ==================== Getters/Setters ====================
	public static BusinessProxy getBusinessProxy() {
		return BUSINESS_PROXY;
	}
	
	
	public static TransactionManager getTransactionManager() {
		return TRANSACTION_MANAGER;
	}
}