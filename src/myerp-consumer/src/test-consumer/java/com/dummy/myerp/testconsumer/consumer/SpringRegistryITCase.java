package com.dummy.myerp.testconsumer.consumer;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dummy.myerp.consumer.dao.contrat.DaoProxy;


/**
 * Registre des Beans Spring.
 */
public final class SpringRegistryITCase {
	
	/** Logger Log4j pour la classe */
	private static final Logger LOGGER = LogManager.getLogger(SpringRegistryITCase.class);
	
	
	/** Instance unique de la classe (design pattern Singleton) */
	private static final SpringRegistryITCase INSTANCE = new SpringRegistryITCase();
	
	
	/** Nom des fichiers de contexte de l'application */
	private static final String CONTEXT_APPLI_LOCATION = "classpath:/com/dummy/myerp/testconsumer/consumer/bootstrapContext.xml";
	
	/** Le context spring de l'application */
	private ApplicationContext contextAppli;
	
	
	// ==================== ID des Beans Spring ====================
	
	
	/**
	 * Constructeur.
	 */
	private SpringRegistryITCase() {
		super();
		SpringRegistryITCase.LOGGER.debug("[DEBUT] SpringRegistryITCase() - Initialisation du contexte Spring");
		this.contextAppli = new ClassPathXmlApplicationContext(SpringRegistryITCase.CONTEXT_APPLI_LOCATION);
		SpringRegistryITCase.LOGGER.debug("[FIN] SpringRegistryITCase() - Initialisation du contexte Spring");
	}
	
	
	/**
	 * Renvoie l'instance unique de la classe (design pattern Singleton).
	 *
	 * @return SpringRegistryITCase
	 */
	protected static final SpringRegistryITCase getInstance() {
		return SpringRegistryITCase.INSTANCE;
	}
	
	
	/**
	 * Initialise et charge le contexte Spring
	 *
	 * @return ApplicationContext
	 */
	public static final ApplicationContext init() {
		// le fait d'appeler cette méthode, déclanche l'appel des initialisation static
		// et donc le chargement du context
		return getInstance().contextAppli;
	}
	
	
	/**
	 * Récupération d'un bean via Spring.
	 *
	 * @param pBeanId
	 *           ID du bean
	 * @return Object
	 */
	protected static Object getBean(String pBeanId) {
		SpringRegistryITCase.LOGGER.debug("[DEBUT] SpringRegistryITCase.getBean() - Bean ID : " + pBeanId);
		Object vBean = SpringRegistryITCase.getInstance().contextAppli.getBean(pBeanId);
		SpringRegistryITCase.LOGGER.debug("[FIN] SpringRegistryITCase.getBean() - Bean ID : " + pBeanId);
		return vBean;
	}
	
	
	/**
	 * Renvoie l'instance de {@link DaoProxy} de l'application
	 *
	 * @return {@link DaoProxy}
	 */
	public static DaoProxy getDaoProxy() {
		return (DaoProxy) SpringRegistryITCase.getBean("DaoProxy");
	}
	
	
	/**
	 * Renvoie une instance de {@link DataSource} pour MYERP
	 *
	 * @return {@link DataSource}
	 */
	public static DataSource getDataSourceMYERP() {
		return (DataSource) SpringRegistryITCase.getBean("dataSourceMYERP");
	}
}
