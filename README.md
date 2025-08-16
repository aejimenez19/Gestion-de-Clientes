# 🚀 Proyecto: Gestión de Clientes

API REST en **Spring Boot** para la gestión de clientes, diseñada como un ejemplo práctico para aplicar buenas prácticas de arquitectura en capas, uso de DTOs, validaciones, mapeo con **MapStruct** y manejo de excepciones.

---

## 📌 Características
- Registro de clientes (`POST /api/clientes`).
- Consulta de clientes por ID (`GET /api/clientes/{id}`).
- DTOs separados para entrada (request) y salida (response).
- Validaciones con `javax.validation` (`@NotBlank`, `@Email`, etc.).
- Conversión entre entidad y DTO con **MapStruct**.
- Base de datos en memoria **H2**.
- Manejo global de errores con `@ControllerAdvice`.

---

## 🏗️ Arquitectura
El proyecto sigue una arquitectura en capas:

- **Controller** → Expone los endpoints REST.
- **Service** → Contiene la lógica de negocio.
- **Repository** → Acceso a la base de datos (Spring Data JPA).
- **DTOs** → Separan la entidad de la representación de entrada/salida.
- **Mapper (MapStruct)** → Convierte entre Entidad y DTO.

---

## 📦 Tecnologías usadas
- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database
- MapStruct
- Lombok

---

## ▶️ Cómo ejecutar

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/gestion-clientes.git
   cd gestion-clientes
