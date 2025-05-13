# **Academic Management System**

Este repositorio contiene el **Proyecto Final del curso de Estructura de Datos** del Instituto Tecnológico de Sonora (ITSON). El objetivo principal es aplicar las estructuras de datos aprendidas durante el semestre mediante el desarrollo de un sistema en Java para la gestión académica de estudiantes, cursos e inscripciones.

## **Objetivo General**

Desarrollar un sistema modular que permita:
- Registrar y gestionar estudiantes.
- Administrar cursos y su capacidad.
- Controlar inscripciones, listas de espera y roles.
- Procesar solicitudes de calificaciones.
- Implementar funcionalidades de deshacer (undo).

Todo ello utilizando estructuras de datos implementadas desde cero y aplicando **programación genérica en Java** (`<T>`).


## **Funcionalidades**

### 1. Gestión de Estudiantes
- Registro de estudiantes con datos completos.
- Almacenamiento en un **Árbol Binario de Búsqueda (BST)** por matrícula.
- Búsqueda por matrícula con visualización de calificaciones.
- Ordenamiento de estudiantes por promedio con un **Árbol AVL**.

### 2. Catálogo de Cursos
- Alta y baja de cursos mediante un **Diccionario genérico** (tabla hash con listas enlazadas).
- Listado de todos los cursos disponibles.

### 3. Inscripciones
- Inscripción a cursos con verificación de capacidad.
- Almacenamiento en **listas enlazadas simples**.
- Manejo de **listas de espera** (listas dobles circulares).
- Rotación de roles (tutor/líder) mediante **listas circulares simples**.

### 4. Calificaciones
- Envío de solicitudes a través de una **cola genérica** (FIFO).
- Procesamiento de solicitudes y actualización de calificaciones (vectores dinámicos).
- Cálculo de promedio de manera recursiva.

### 5. Deshacer Operaciones
- Registro de acciones (registro, inscripción, calificación) en una **pila genérica (LIFO)**.
- Opción para deshacer la última acción realizada.


## **Estructuras de Datos Implementadas**

- `ArbolBST<T>`
- `ArbolAVL<T>`
- `ListaEnlazada<T>`
- `ListaDobleCircular<T>`
- `ListaCircular<T>`
- `Pila<T>`
- `Cola<T>`
- `Diccionario<K, V>`
- `ArregloDinamico<T>`

Todas las estructuras se implementan usando **programación genérica (`<T>`)** para su reutilización y flexibilidad.


## **Requisitos del Proyecto**

- Java JDK 23 o superior
- IDE recomendado: NetBeans, IntelliJ IDEA o Eclipse
- [Draw.io](https://drive.google.com/file/d/1V0-v3KFbcSu_ZoZG00jufblqh6oPrndj/view?usp=sharing_eil_se_dm&ts=681dc6d4) para visualizar diagramas de clases (opcional)


## **Licencia**
Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](./LICENSE.md) para más detalles.