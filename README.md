# 🎓 Hibernate Student Management System

![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-brown?logo=hibernate)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?logo=mysql)
![Maven](https://img.shields.io/badge/Maven-Build-red?logo=apachemaven)
![JUnit](https://img.shields.io/badge/JUnit-Testing-green?logo=junit5)

A Java-based Student Management System developed using **Hibernate ORM** and **MySQL**.  
The project demonstrates CRUD operations, entity relationships, database persistence, and Hibernate configuration.

---

## ✨ Features

- 👨‍🎓 Student CRUD operations
- 👨‍🏫 Instructor CRUD operations
- 📚 Course CRUD operations
- 👤 Instructor profile entity with one-to-one relationship
- 🔗 Many-to-many relationship between Students and Courses
- 🔗 Many-to-one relationship between Courses and Instructors
- 🗄️ MySQL database integration using Hibernate ORM
- 🧪 JUnit testing support
- 📦 Maven-based project configuration

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| ☕ Java | Application development |
| 🔄 Hibernate ORM | Object-relational mapping and persistence |
| 🗄️ MySQL | Database management |
| 📦 Maven | Dependency and build management |
| 🧪 JUnit | Testing |

---

## 📂 Project Structure

```text
HibernateProject/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── code/
│   │   │           │
│   │   │           ├── App.java
│   │   │           │
│   │   │           ├── demo/
│   │   │           │   ├── CreateStudent.java
│   │   │           │   ├── ReadStudent.java
│   │   │           │   ├── UpdateStudent.java
│   │   │           │   ├── DeleteStudent.java
│   │   │           │   │
│   │   │           │   ├── CreateInstructor.java
│   │   │           │   ├── ReadInstructor.java
│   │   │           │   ├── UpdateInstructor.java
│   │   │           │   ├── DeleteInstructor.java
│   │   │           │   │
│   │   │           │   ├── CreateCourse.java
│   │   │           │   ├── ReadCourse.java
│   │   │           │   ├── UpdateCourse.java
│   │   │           │   └── DeleteCourse.java
│   │   │           │
│   │   │           └── entity/
│   │   │               ├── Student.java
│   │   │               ├── Instructor.java
│   │   │               ├── InstructorProfile.java
│   │   │               └── Course.java
│   │   │
│   │   └── resources/
│   │       └── hibernate.cfg.xml
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── code/
│                   └── AppTest.java
│
├── pom.xml
└── README.md
```

---

## ⚙️ How It Works

1. 🧱 **Entity Classes** define the application data model and database relationships.
2. 🔄 **Hibernate ORM** maps Java entities to MySQL database tables.
3. ➕ **Create classes** insert new Student, Instructor, and Course records.
4. 🔍 **Read classes** retrieve existing records from the database.
5. ✏️ **Update classes** modify existing records.
6. 🗑️ **Delete classes** remove records from the database.
7. 🔗 Hibernate manages relationships between Students, Courses, Instructors, and Instructor Profiles.

---

## 📦 Package Responsibilities

### `com.code.entity`

Contains the Hibernate entity classes responsible for representing database tables and relationships.

- 👨‍🎓 **Student.java** — Stores student information and maintains a many-to-many relationship with courses.
- 👨‍🏫 **Instructor.java** — Stores instructor information.
- 👤 **InstructorProfile.java** — Stores instructor profile information and maintains a one-to-one relationship with an instructor.
- 📚 **Course.java** — Stores course information and maintains a many-to-one relationship with an instructor.

### `com.code.demo`

Contains the individual CRUD operation classes.

#### 👨‍🎓 Student Operations

- **CreateStudent.java** — Creates and saves student records.
- **ReadStudent.java** — Retrieves student records.
- **UpdateStudent.java** — Updates existing student information.
- **DeleteStudent.java** — Deletes student records.

#### 👨‍🏫 Instructor Operations

- **CreateInstructor.java** — Creates and saves instructor records.
- **ReadInstructor.java** — Retrieves instructor records.
- **UpdateInstructor.java** — Updates existing instructor information.
- **DeleteInstructor.java** — Deletes instructor records.

#### 📚 Course Operations

- **CreateCourse.java** — Creates and saves course records.
- **ReadCourse.java** — Retrieves course records.
- **UpdateCourse.java** — Updates existing course information.
- **DeleteCourse.java** — Deletes course records.

### `App.java`

Main application class used to execute and demonstrate the implemented Hibernate operations.

### `hibernate.cfg.xml`

Contains the Hibernate configuration required for database connectivity, Hibernate properties, and entity mapping.

### `AppTest.java`

Contains the JUnit test configuration for testing the project.

---

## 🔗 Entity Relationships

```text
Student
   │
   │ Many-to-Many
   ▼
Course
   │
   │ Many-to-One
   ▼
Instructor
   │
   │ One-to-One
   ▼
InstructorProfile
```

### Relationships Used

- 👨‍🎓 **Student ↔ Course** — Many-to-Many
- 📚 **Course → Instructor** — Many-to-One
- 👨‍🏫 **Instructor ↔ InstructorProfile** — One-to-One

---

## 🚀 How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/hibernate-student-management-system.git
```

### 2. Open the Project

Open the cloned project in **Eclipse, IntelliJ IDEA, or VS Code** as a Maven project.

### 3. Configure MySQL

Create a MySQL database and update the database connection details in:

```text
src/main/resources/hibernate.cfg.xml
```

Configure:

- Database URL
- Username
- Password
- Hibernate properties

### 4. Install Maven Dependencies

```bash
mvn clean install
```

### 5. Run the Application

Run:

```text
src/main/java/com/code/App.java
```

The application will execute the configured Hibernate operations and interact with the MySQL database.

---

## 🧪 Testing

Run the available JUnit tests using:

```bash
mvn test
```

---

## 📌 Project Status

**Completed — Academic / Learning Project**

This project was developed to practice **Java, Hibernate ORM, CRUD operations, entity relationships, MySQL integration, and Maven-based project development**.

---

## 👨‍💻 Author

**Srinjoy Sil**
