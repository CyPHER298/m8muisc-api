# music-api (M&Music / Complice)

Spring Boot 3 + Java 17 + JPA/Hibernate + Validation + Lombok  
Perfis: **dev (H2)** e **oracle**.  
Escopo conforme DER (avaliação ficará no .NET).

## Rodar (dev/H2)
```bash
mvn spring-boot:run
# H2 console: http://localhost:8080/h2-console  (JDBC URL: jdbc:h2:mem:music)
```

## Rodar (Oracle)
Edite `application.yml` (profile `oracle`) e execute:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=oracle
```

## Endpoints
- `POST /api/clientes` | `GET /api/clientes`
- `POST /api/cantores` | `GET /api/cantores`
- `POST /api/musicas`  | `GET /api/musicas` | `GET /api/musicas/search?q=...`
- `POST /api/pedidos`  | `GET /api/pedidos`

## Postman (exemplos)
Crie a Collection e inclua, por exemplo:
- Criar Cliente:
```http
POST http://localhost:8080/api/clientes
Content-Type: application/json

{ "nome": "Yuri Ferreira" }
```
- Criar Cantor:
```http
POST http://localhost:8080/api/cantores
Content-Type: application/json

{ "nome": "Ana", "email": "ana@mmusic.com", "senha": "1234" }
```
- Criar Música (use `cantorId` gerado acima):
```http
POST http://localhost:8080/api/musicas
Content-Type: application/json

{ "titulo":"Tempo Bom", "artista":"Ana", "genero":"Pop", "cantorId": 1 }
```
- Criar Pedido (use `clienteId` e `musicaId`):
```http
POST http://localhost:8080/api/pedidos
Content-Type: application/json

{ "clienteId": 1, "musicaId": 1 }
```

## Scripts Oracle (referência)
Veja `docs/oracle.sql`.

## Diagramas
- `docs/der.puml` e `docs/classes.puml` (PlantUML).
