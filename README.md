📱 Flashcard App

A personal study prototype developed in Kotlin with Android Studio. Allows you to create, edit, and review flashcards quickly and in an organized way.

🔹 Features

Create, edit, and delete flashcards

Easy navigation between flashcards

Clean and organized layout

Fully built with Kotlin in Android Studio

🛠 Technologies Used

Language: Kotlin

IDE: Android Studio

Design: XML Layouts

Version Control: Git/GitHub

🖼 Screenshots

Main Screen (Flashcards List):
<img width="431" height="882" alt="Screenshot 2025-10-06 173858" src="https://github.com/user-attachments/assets/6abdf43c-f403-4097-892e-8b5ef11e6023" />


Question Screen:
<img width="458" height="907" alt="QuestionScreen" src="https://github.com/user-attachments/assets/ac325ec7-99b2-4c41-a73d-adfe57d80e0c" />


Score Screen:
<img width="442" height="886" alt="ScoreScreen" src="https://github.com/user-attachments/assets/30d0ffa0-ec06-4c9e-8f90-b4e7941eaec5" />








📝 Personal Development / Problems & Solutions

Problem: The welcome TextView was not showing
Solution: Replaced LinearLayout with ConstraintLayout and adjusted app:layout_constraintTop_toTopOf="parent" with proper margins

Problem: Android Studio temporary files appeared in commits
Solution: Created .gitignore with /.idea/, *.iml, /build and removed temporary files before committing

CI/CD: Set up a workflow in .github/workflows/android.yml that runs ./gradlew build on Ubuntu with each push to main. This ensures the project compiles automatically and notifies me if something breaks

🚀 How to Run Locally


https://github.com/FernandoIIE/Flashcardapp.git
Open the project in Android Studio

Run on an emulator or a physical device

💡 Final Notes

This project is a personal prototype. If you want to test or contribute, open an issue in the repository.
Most of the development was done by me, using Android Studio, Git/GitHub, and GitHub Actions for CI.
