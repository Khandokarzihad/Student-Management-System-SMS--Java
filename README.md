# 🎓 Student Management System (Console-Based in Java)

This is a **console-based Student Management System (SMS)** built with **Java**, using `RandomAccessFile` for file handling.  
It allows **admins** to manage students, courses, and authentication securely, all from the command line.

---

## ⚡ Quick Start Login
> 🟢 **Use the following credentials to log in as Admin (first time):**  
> **Admin ID:** `10110`  
> **Password:** `12345678`

---

## 🚀 Features

### 👩‍🎓 Student Management
- Add new students with **ID, Name, Program, Batch, Password, and CGPA**
- View all registered students
- Search students by ID
- Data stored persistently in **Students.txt**

### 📚 Course Management
- Assign multiple courses to students
- Add new courses for an existing student
- Search and view assigned courses
- Data stored persistently in **Courses.txt**

### 🔑 Admin & Authentication
- Admin login with **ID and Password** (from `Authentication.txt`)
- Add new admins (with password validation)
- Change admin password (must be exactly 8 characters)
- Secure authentication system before accessing menu

### 🖥️ Menu System
- Interactive console menu with options for:
  1. Add Student  
  2. View Students  
  3. Search Students  
  4. Assign Courses  
  5. Search Courses  
  6. Admin Section  
  0. Exit  

---

## 🛠️ Tech Stack
- **Language:** Java  
- **File Handling:** RandomAccessFile (for persistent storage)  
- **Storage:** Text files (`Students.txt`, `Courses.txt`, `Authentication.txt`)  

---

## 📂 Project Structure

├── Main.java         # Main driver class, menu & core functions

├── Students.java     # Student class with attributes & file format handling

├── Courses.java      # Course assignment handling

├── LogInInfo.java    # Admin login info & authentication

├── Students.txt      # Stores student records

├── Courses.txt       # Stores student courses

└── Authentication.txt # Stores admin login info

---

## ⚙️ How to Run
1. Clone the repo:
   ```bash
   git clone https: https://github.com/Khandokarzihad/Student-Management-System-SMS--Java.git
   
2. Open in any Java IDE (IntelliJ, Eclipse, VS Code, etc.) or compile via terminal:

   ```bash
   javac Main.java
   java Main
   ```
3. Enter **Admin ID & Password** to log in.
4. Start managing students & courses from the menu.

---

## ✅ Future Improvements

* Switch from text files to a **database (MySQL/SQLite)** for scalability
* Add **student login portal** for self-service
* Implement **data validation & error handling improvements**
* GUI version using **JavaFX / Swing**

---

## 📜 License

This project is open-source and available under the [MIT License](LICENSE).

