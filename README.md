# 🛒 Sistema de Gestión de E-Commerce (API REST + Frontend)

Este proyecto consiste en una aplicación completa de comercio electrónico desarrollada con **Java y Spring Boot** para el Backend, y una interfaz de usuario **Single Page Application (SPA)** construida con HTML5, JavaScript y Bootstrap.

El sistema permite la gestión integral de un catálogo de productos, control de stock en tiempo real y la generación de pedidos con validaciones de negocio complejas.

## 🚀 Tecnologías Utilizadas

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot 3 (Spring Web, Spring Data JPA)
* **Base de Datos:** MySQL
* **Validaciones:** Bean Validation (Jakarta Validation)
* **Utilidades:** Lombok
* **Frontend:** HTML5, CSS3, Bootstrap 5, Vanilla JavaScript (Fetch API)

## ✨ Características Destacadas

### Backend (API RESTful)
* **Arquitectura en Capas:** Controller, Service (Lógica de Negocio), Repository.
* **Patrón DTO:** Uso de Data Transfer Objects para desacoplar la entidad de la base de datos de la vista pública.
* **Persistencia de Imágenes:** Almacenamiento de imágenes en Base64 utilizando `LONGTEXT` en MySQL.
* **Transaccionalidad:** Uso de `@Transactional` para asegurar la integridad de datos al crear pedidos y descontar stock.
* **CORS:** Configuración global para permitir peticiones desde clientes externos.

### Frontend (SPA)
* **Carrito de Compras:** Persistencia local usando `localStorage`.
* **Gestión de Imágenes:** Conversión automática de archivos locales a Base64.
* **Feedback al Usuario:** Uso de Modals de Bootstrap para notificaciones de éxito/error.
* **Diseño Responsivo:** Adaptable a dispositivos móviles y de escritorio.

---

## 🛠️ Instalación y Ejecución

### 1. Prerrequisitos
* Java JDK 17 o superior.
* Maven.
* MySQL Server corriendo.
