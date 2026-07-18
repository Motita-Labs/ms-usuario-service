# ms-usuario-service

Microservicio de usuarios (Spring Boot 4, Java 17).

## Endpoints

Base: `/api/v1/usuario`

| Método | Ruta                 | Descripción         |
|--------|----------------------|---------------------|
| POST   | /api/v1/usuario      | Crear usuario       |
| GET    | /api/v1/usuario      | Listar usuarios     |
| GET    | /api/v1/usuario/{id} | Obtener por id      |
| PUT    | /api/v1/usuario/{id} | Editar usuario      |
| DELETE | /api/v1/usuario/{id} | Eliminar usuario    |

Puerto: `8082`. Health: `/actuator/health`.

## Build y test

```bash
mvn clean verify
```

## Docker

```bash
docker build -t arriendos/ms-usuario:latest .
docker run -p 8082:8082 -e DB_URL=jdbc:mysql://host:3306/usuario arriendos/ms-usuario:latest
```

Variables: `DB_URL`, `DB_USER`, `DB_PASSWORD`.

## CI/CD

`.github/workflows/ci-cd.yml`: build + test (`mvn verify`) y publicación de imagen en GHCR.
