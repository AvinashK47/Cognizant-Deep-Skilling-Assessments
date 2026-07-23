# Cognizant Deep Skilling Assessments Solutions

A comprehensive repository containing weekly solutions for the Cognizant Deep Skilling Assessments program. This repository documents progress through mandatory hands-on assessment challenges on a week-by-week basis.

---

## 📁 Repository Structure

```
.
├── README.md
├── Week-1/                   # Engineering Concepts & Algorithms / Design Patterns
├── Week-2/                   # JUnit 5, Mockito & SLF4J / PL SQL Programming
├── Week-3/
│   ├── SpringCore_and_Maven/ # LibraryManagement Spring Core App
│   └── SpringData/           # orm-learn Spring Data JPA App & DIFFERENCE.md
├── Week-4/
│   └── spring-learn/         # Spring REST, Country Services & JWT Authentication
├── Week-5/
│   ├── account/              # Account Microservice (Port 8080)
│   └── loan/                 # Loan Microservice (Port 8081)
└── Week-6/
    ├── myfirstreact/         # Hands-on 1: React introductory app
    ├── StudentApp/           # Hands-on 2: Student Management Portal (Class components)
    ├── scorecalculatorapp/   # Hands-on 3: CalculateScore component & CSS styling
    ├── blogapp/              # Hands-on 4: Fetch API, componentDidMount & Error boundaries
    └── cohortapp/            # Hands-on 5: Cohort Details Dashboard with CSS Modules
```

---

## 📅 Weekly Progress

| Week | Status | Skill / Topics Covered | Key Artifacts / Projects |
|:---:|:---:|:---|:---|
| **Week 1** | Completed | Engineering Concepts, Data Structures & Design Patterns | `Engineering concepts`, `GIT` |
| **Week 2** | Completed | TDD using JUnit5 & Mockito, SLF4J Logging, PL/SQL | `JUnit`, `Mockito`, `SLF4J`, `PL/SQL` |
| **Week 3** | Completed | Spring Core & Maven, Spring Data JPA with Spring Boot | `LibraryManagement`, `orm-learn`, `DIFFERENCE.md` |
| **Week 4** | Completed | Spring REST Web Services & JWT Security | `spring-learn` (REST APIs, JWT Auth Filter) |
| **Week 5** | Completed | Microservices with Spring Boot 3 | `account` (Port 8080), `loan` (Port 8081) |
| **Week 6** | Completed | ReactJS Foundations & Component Lifecycle | `myfirstreact`, `StudentApp`, `scorecalculatorapp`, `blogapp`, `cohortapp` |

---

## 🚀 Execution Instructions

### Week 3: Spring Core & Spring Data JPA
- **LibraryManagement**:
  ```bash
  mvn clean test -f Week-3/SpringCore_and_Maven/LibraryManagement/pom.xml
  ```
- **orm-learn**:
  ```bash
  mvn clean test -f Week-3/SpringData/orm-learn/pom.xml
  ```

### Week 4: Spring REST & JWT Authentication
```bash
mvn clean test -f Week-4/spring-learn/pom.xml
```

### Week 5: Microservices
- **Account Microservice**:
  ```bash
  mvn clean test -f Week-5/account/pom.xml
  ```
- **Loan Microservice**:
  ```bash
  mvn clean test -f Week-5/loan/pom.xml
  ```

### Week 6: React Projects
Navigate to any project directory under `Week-6/` and run:
```bash
npm install
npm start
```

---

**Last Updated:** July 2026
