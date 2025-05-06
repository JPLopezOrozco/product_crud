# Product CRUD API

Proyecto backend desarrollado con **Spring Boot** y **PostgreSQL**. La API permite gestionar un inventario de vapes, incluyendo operaciones CRUD, búsqueda por nombre parcial, filtrado por stock, flavour, brand y rango de precios.

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## 🗃️ Estructura del Proyecto
src/
├── main/
│   ├── java/
│   │   └── com.example.productcrud/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── service/
│   │       └── exceptions/
│   └── resources/
│       └── application.properties
└── test/
## ⚙️ Configuración de la base de datos

En `src/main/resources/application.properties`:

```properties
spring.application.name=product_crud
server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/productdb
spring.datasource.username=dev
spring.datasource.password=123456789
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
## 🧩 Importar la base de datos

# Crear la base de datos vacía
createdb -U postgres productdb

# Importar el .sql
psql -U postgres -d productdb -f database/productdb.sql

## 🧪 Endpoints disponibles

| Método | Endpoint                          | Descripción                         |
|--------|-----------------------------------|-------------------------------------|
| GET    | /vapes                            | Lista todos los vapes              |
| GET    | /vapes/{id}                       | Busca vape por ID                  |
| POST   | /vapes                            | Crea un nuevo vape                 |
| PUT    | /vapes/{id}                       | Actualiza un vape                  |
| DELETE | /vapes/{id}                       | Elimina un vape                    |
| PUT    | /vapes/{id}/stock                 | Agrega stock a un vape             |
| GET    | /vapes/stock                      | Lista los vapes con stock disponible |
| GET    | /vapes/no-stock                   | Lista los vapes sin stock          |
| GET    | /vapes/brand/{brand}              | Busca vapes por marca (parcial)    |
| GET    | /vapes/flavour/{flavour}          | Busca vapes por sabor exacto       |
| GET    | /vapes/partial?partialName=xxx    | Busca vapes por nombre parcial     |
| GET    | /vapes/range?min=10&max=30        | Busca vapes por rango de precio    |

## 📥 Ejemplo de creación de vape

```
POST /vapes
{
  "name": "V150",
  "brand": "Ignite",
  "flavour": "Banana ice",
  "puffs": 15000,
  "price": 20000,
  "stock": 10
}
```
## ✅ Próximas mejoras
#### Seguridad con Spring Security

## 👨‍💻 Autor
### Juan Pablo Lopez Orozco
### 📍 Argentina
### 🔗 GitHub - [@JPLopezOrozco](https://github.com/JPLopezOrozco)