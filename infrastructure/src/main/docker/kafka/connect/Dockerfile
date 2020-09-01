FROM strimzi/kafka:0.19.0-kafka-2.5.0
USER root:root
RUN mkdir -p /opt/kafka/plugins/twitter
COPY twitter-connector /opt/kafka/plugins/twitter/
USER 1001
