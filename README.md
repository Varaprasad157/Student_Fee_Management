# 🎓 Student Fee Management System

## 📌 Features
- Add Student  
- View Student  
- Delete Student  
- Fee Payment  
- Receipt Generation  

## 🛠 Technologies Used
- Java  
- JDBC  
- MySQL  

## 👨‍💻 Author
T. S. V. Vara Prasad

## 🗄 Database Schema

### Student Table
| Column Name | Data Type |
|------------|----------|
| id         | INT (PK) |
| name       | VARCHAR  |
| course     | VARCHAR  |
| total_fee  | DOUBLE   |

### Receipt Table
| Column Name  | Data Type |
|-------------|----------|
| receipt_id  | INT (PK) |
| student_id  | INT (FK) |
| amount_paid | DOUBLE   |
| date        | DATE     |

### SQL Tables Creation

```sql
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(50),
    total_fee DOUBLE
);

CREATE TABLE receipt (
    receipt_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    amount_paid DOUBLE,
    date DATE,
    FOREIGN KEY (student_id) REFERENCES student(id)
);
