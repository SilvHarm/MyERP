package com.dummy.myerp.testconsumer.consumer;


import javax.sql.DataSource;

import com.dummy.myerp.consumer.dao.contrat.DaoProxy;


/**
 * Classe mère des classes de test d'intégration de la couche Business
 */
public abstract class ConsumerITCase {
	
	static {
		SpringRegistryITCase.init();
	}
	
	/** {@link DaoProxy} */
	private static final DaoProxy DAO_PROXY = SpringRegistryITCase.getDaoProxy();
	/** {@link DataSource} */
	private static final DataSource DATASOURCE_MYERP = SpringRegistryITCase.getDataSourceMYERP();
	
	
	// ==================== Constructeurs ====================
	/**
	 * Constructeur.
	 */
	public ConsumerITCase() {}
	
	
	// ==================== Getters/Setters ====================
	public static DaoProxy getDaoProxy() {
		return DAO_PROXY;
	}
	
	
	public static DataSource getDataSourceMYERP() {
		return DATASOURCE_MYERP;
	}
}
