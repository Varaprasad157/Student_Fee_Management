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

## ▶️ How to Run

1. Create MySQL database: fee_management  
2. Run the SQL queries above  
3. Update DBConnection.java with your MySQL username & password  
4. Run MainApp.java  

## 👨‍💻 Author
T. S. V. Vara Prasad

## 🗄 Database Schema

### Students Table
| Column Name | Data Type |
|------------|----------|
| id         | VARCHAR  |
| name       | VARCHAR  |
| course     | VARCHAR  |
| total_fee  | DOUBLE   |
| paid_fee   | DOUBLE   |

### Receipts Table
| Column Name  | Data Type |
|-------------|----------|
| id          | INT (PK) |
| student_id  | VARCHAR  |
| amount      | DOUBLE   |
| date        | TIMESTAMP |

### SQL Tables Creation

```sql
CREATE TABLE students (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(50),
    total_fee DOUBLE,
    paid_fee DOUBLE
);

CREATE TABLE receipts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(20),
    amount DOUBLE,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

