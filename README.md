# Hotel Management System

A secure and user-friendly **JavaFX-based desktop application** for managing hotel employees and room bookings. This system enables both administrators and users to interact with hotel data through a visually intuitive interface.

## 🎯 Features

- **Admin Login & Access Control**
  - Secure login using bcrypt-hashed passwords
  - Admin dashboard to manage room and user data

- **Employee and Room Management**
  - Add, update, delete hotel rooms and employee profiles
  - View and manage all guest bookings

- **User Features**
  - Browse available rooms
  - Book rooms through an interactive UI
  - View booking history

## 🛠️ Tech Stack

- **Java, JavaFX**
- **SQLite** for lightweight local database
- **FXML** for clean UI design
- **bcrypt** for secure password encryption

## 📁 Project Structure

```
Hotel_Management/
├── bin/
├── lib/
├── src/
│   ├── Controller/
│   │   ├── AdminController.java
│   │   ├── BookingController.java
│   │   └── DashboardController.java
│   ├── Main/
│   │   └── Main.java
│   ├── Models/
│   │   ├── Guests.java
│   │   ├── Rooms.java
│   │   └── Users.java
│   └── Views/
│       ├── Dashboard.fxml
│       ├── BookingForm.fxml
│       └── ...
├── videos/
│   ├── 1-Admin-Login.mov
│   ├── 2-Admin-AddNewRoom.mov
│   └── ...
└── hm.jar
```

## 📽️ Demo Videos

Find recorded demos for:
- Admin Login
- Room and User Management
- Room Booking Workflow

## 🚀 Getting Started

1. Clone the repo:
```bash
git clone https://github.com/SruthiSanjana/Hotel-Management-System.git
```

2. Open the project in an IDE like IntelliJ or Eclipse.

3. Make sure you have JavaFX and SQLite libraries configured.

4. Run the `Main.java` file to launch the app.

---

Built with ❤️ by SruthiSanjana
