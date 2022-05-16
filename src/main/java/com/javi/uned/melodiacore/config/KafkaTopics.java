package com.javi.uned.melodiacore.config;

public class KafkaTopics {

    // Web service topics
    public static final String TOPIC_WEBSERVICE_SPECS = "melodia.webservice.specs";
    public static final String TOPIC_WEBSERVICE_RETRYPDF = "melodia.webservice.retry-pdf";
    public static final String TOPIC_WEBSERVICE_RETRYXML = "melodia.webservice.retry-xml";

    // ALL COMPOSERS common topics
    public static final String TOPIC_COMPOSER_PDF = "melodia.composer.pdf";
    public static final String TOPIC_COMPOSER_XML = "melodia.composer.xml";

    // Genetic composer topics
    public static final String TOPIC_COMPOSER_GENETIC_LOGS = "melodia.composer.genetic.logs";

    // Neural network composer topics
    public static final String TOPIC_COMPOSER_NEURALNETWORK_LOGS = "melodia.composer.neuralnetwork.logs";


}
