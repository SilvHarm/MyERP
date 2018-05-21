FROM jenkins


########################
# Plugins Jenkins
########################
RUN /usr/local/bin/install-plugins.sh github-branch-source
RUN /usr/local/bin/install-plugins.sh maven-plugin
RUN /usr/local/bin/install-plugins.sh workflow-aggregator	#Pipeline
RUN /usr/local/bin/install-plugins.sh pipeline-github-lib
RUN /usr/local/bin/install-plugins.sh pipeline-maven
RUN /usr/local/bin/install-plugins.sh timestamper
