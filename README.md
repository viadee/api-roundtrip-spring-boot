# API Roundtrip Spring Boot Example


## API
A REST-full API server provided as Spring Boot application.
The Application makes use of automated tools for documenting and generating OpenAPI specifications and Swagger UIs for comfortable user access based.

## Tool Chain Execution

Running the full build cycle for OpenAPI and client/integration test generation with maven from the repositories base directory

```bash
mvn verify
```

Running the integration tests in the integrationtest sub directory

```bash
mvn verify -P integrationtest
```


### Spring Doc for API Documentation and Generation
[https://springdoc.org/](https://springdoc.org/)    
Annotation based documentation for REST APIs implemented with Spring Web/Rest.

When the application is running, there is a browser access for

- SWAGGER UI [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- OpenAPI File [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

### OpenAPI Generator for API client and integration test generation
[https://openapi-generator.tech/](https://openapi-generator.tech/)    
