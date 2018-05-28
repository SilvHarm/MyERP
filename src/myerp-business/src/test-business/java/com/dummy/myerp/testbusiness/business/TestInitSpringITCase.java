package com.dummy.myerp.testbusiness.business;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * Classe de test de l'initialisation du contexte Spring
 */
public class TestInitSpringITCase extends BusinessITCase {
	
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
		assertNotNull(SpringRegistryITCase.getBusinessProxy());
		assertNotNull(SpringRegistryITCase.getTransactionManager());
	}
}
