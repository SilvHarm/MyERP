# MyERP

## Organisation du répertoire

*	`doc` : documentation
*	`docker` : répertoire relatifs aux conteneurs _docker_ utiles pour le projet
	*	`dev` : environnement de développement
	*	`Jenkins` : image _docker_ de Jenkins
		*	`Jenkins_Config` : configuration Jenkins à utiliser
*	`src` : code source de l'application


### Environnement de développement

Les composants nécessaires lors du développement sont disponibles via des conteneurs _docker_.
L'environnement de développement est assemblé grâce à _docker-compose_
(cf docker/dev/docker-compose.yml).

Il comporte :

*	une base de données _PostgreSQL_ contenant un jeu de données de démo (`postgresql://127.0.0.1:9032/db_myerp`)


#### Lancement

	cd docker/dev
	docker-compose up


#### Arrêt

	cd docker/dev
	docker-compose stop


#### Remise à zero

	cd docker/dev
	docker-compose stop
	docker-compose rm -v
	docker-compose up


## Intégration Continue

Pour faciliter l'intégration continue, ce projet contient de quoi créer une image _docker_ basée sur l'outil Jenkins et la configuration de celui ci.


### Pré-requis

*	Avoir _Docker_ installé sur la machine hôte et ayant une version compatible avec celle de l'image; celle ci utilisant la dernière version stable disponible pour Ubuntu 16.04 (xenial) au moment de sa création.
*	Les ports 8080 et 9032 ne doivent pas être utilisés sur la machine hôte au lancement et tant que l'image _docker_ n'est pas arrêtée.


### Les Variables

Expliquation des différentes variables utilisés dans les commandes _docker_ :

*	`<image_name>` : nom de l'image docker; doit être identique à chacune des utilisations
*	`<host_docker.sock>` : chemin du docker.sock de la machine hôte
*	`<host_volume>` : chemin du dossier de persistence de Jenkins


### Création de l'image docker

	cd docker
	docker build -t <image_name> .


### Utilisation de l'image

Copier le contenu de `docker/Jenkins/Jenkins_Config` dans `<host_volume>` avant d'exécuter la commande suivante.

	docker run -d \
		-v <host_docker.sock>:/var/run/docker.sock \
		-v <host_volume>:/var/jenkins_home \
		--net="host" \
		<image_name>

exemple :

	docker run -d \
		-v /var/run/docker.sock:/var/run/docker.sock \
		-v /exemple/DossierExemple:/var/jenkins_home \
		--net="host" \
		myerp
