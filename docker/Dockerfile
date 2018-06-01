FROM jenkins

USER root

########################
# Docker
########################
RUN apt-get update \
	&& apt-get -y install \
	apt-transport-https \
	ca-certificates \
	curl \
	software-properties-common

RUN curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add -

RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   xenial \
   stable"

RUN apt-get update \
	&& apt-get -y install docker-ce


########################
# Docker Compose
########################
RUN curl -L https://github.com/docker/compose/releases/download/1.21.2/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose \
	&& chmod +x /usr/local/bin/docker-compose


########################
# Plugins Jenkins
########################
RUN /usr/local/bin/install-plugins.sh github-branch-source
RUN /usr/local/bin/install-plugins.sh maven-plugin
RUN /usr/local/bin/install-plugins.sh workflow-aggregator	#Pipeline
RUN /usr/local/bin/install-plugins.sh pipeline-github-lib
RUN /usr/local/bin/install-plugins.sh pipeline-maven
RUN /usr/local/bin/install-plugins.sh timestamper
