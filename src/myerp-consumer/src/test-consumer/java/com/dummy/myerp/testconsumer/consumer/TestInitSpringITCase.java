package com.dummy.myerp.testconsumer.consumer;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * Classe de test de l'initialisation du contexte Spring
 */
public class TestInitSpringITCase extends ConsumerITCase {
	
	/**
	 * Constructeur.
	 */
	public TestInitSpringITCase() {
		super();
	}
	
	
	/**
	 * Teste l'initialisation du contexte Spring
	 */
	@Test
	public void testInit() {
		SpringRegistryITCase.init();
		assertNotNull(SpringRegistryITCase.getDaoProxy());
		assertNotNull(SpringRegistryITCase.getDataSourceMYERP());
	}
}
