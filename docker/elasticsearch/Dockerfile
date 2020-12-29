FROM docker.elastic.co/elasticsearch/elasticsearch:7.7.1

RUN echo 'discovery.type: single-node' >> config/elasticsearch.yml
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/e1f115e4ca285c3c24e847c4dd4be955e0ed51c2/wait-for-it.sh /utils/wait-for-it.sh
ADD data/products.sh /products.sh
RUN docker-entrypoint.sh elasticsearch -p /tmp/epid & /bin/bash /utils/wait-for-it.sh -t 0 localhost:9200 -- /products.sh; kill $(cat /tmp/epid) && wait $(cat /tmp/epid); exit 0;