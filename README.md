
# **Academic Management System**

This repository contains the **Final Project for the Data Structures course** at the Instituto Tecnológico de Sonora (ITSON). The main goal is to apply the data structures learned during the semester by developing a Java-based system for managing students, courses, and enrollments. [Versión Español](./README.es.md)

## **General Objective**

Develop a modular system that allows:
- Registering and managing students.
- Managing courses and their capacity.
- Controlling enrollments, waiting lists, and roles.
- Processing grade requests.
- Implementing undo functionality.

All of this using data structures implemented from scratch and applying **generic programming in Java** (`<T>`).

## **Features**

### 1. Student Management
- Register students with full data.
- Store in a **Binary Search Tree (BST)** by enrollment number.
- Search by enrollment number and display grades.
- Sort students by average grade using an **AVL Tree**.

### 2. Course Catalog
- Add and remove courses using a **Generic Dictionary** (hash table with linked lists).
- List all available courses.

### 3. Enrollments
- Enroll students in courses with capacity verification.
- Store in **singly linked lists**.
- Manage **waiting lists** (doubly circular linked lists).
- Rotate roles (tutor/leader) using **singly circular linked lists**.

### 4. Grades
- Send requests through a **generic queue** (FIFO).
- Process requests and update grades (dynamic arrays).
- Recursively calculate the average grade.

### 5. Undo Operations
- Log actions (registration, enrollment, grading) in a **generic stack (LIFO)**.
- Option to undo the last performed action.

## **Implemented Data Structures**

- `ArbolBST<T>`
- `ArbolAVL<T>`
- `ListaEnlazada<T>`
- `ListaDobleCircular<T>`
- `ListaCircular<T>`
- `Pila<T>`
- `Cola<T>`
- `Diccionario<K, V>`
- `ArregloDinamico<T>`

All structures are implemented using **generic programming (`<T>`)** for reusability and flexibility.

## **Project Requirements**

- Java JDK 23 or higher
- Recommended IDE: NetBeans, IntelliJ IDEA, or Eclipse
- [Draw.io](https://drive.google.com/file/d/1V0-v3KFbcSu_ZoZG00jufblqh6oPrndj/view?usp=sharing_eil_se_dm&ts=681dc6d4) for visualizing class diagrams (optional)

## **License**
This project is licensed under the MIT License. See the [LICENSE](./LICENSE.md) file for more details.