# 🚀 Pressure Vessel Analyzer (Java GUI Application)

## 📌 Project Overview

This project is a Java-based application designed to calculate the required thickness of thin and thick pressure vessels using standard mechanical engineering formulas.

The application includes a graphical user interface (GUI) for easy input and result visualization.

---

## 🎯 Objectives

* To calculate thickness of pressure vessels
* To classify vessels as Thin or Thick
* To verify design safety
* To provide a user-friendly interface using Java Swing

---

## ⚙️ Features

✔ GUI-based application (Java Swing)
✔ Material selection (Steel, Aluminum, Titanium)
✔ Thin vessel calculation
✔ Thick vessel calculation using Lame’s equation
✔ Safety validation (Safe / Unsafe)
✔ Input validation and error handling
✔ Clear result explanation

---

## 🧠 Inputs Required

* Internal Pressure (MPa)
* Internal Diameter (mm)
* Material Selection
* Safety Factor

---

## 📊 Outputs

* Type of Vessel (Thin / Thick)
* Required Thickness
* Safety Status
* Explanation of result

---

## 📐 Formulas Used

### 🔹 Thin Pressure Vessel

t = (P × D) / (2 × σ_allow)

### 🔹 Thick Pressure Vessel (Lame’s Equation)

ro = ri × √((σ_allow + P) / (σ_allow - P))
t = ro - ri

---

## 🖥️ How to Run

1. Compile the code:

```
javac MainApp.java
```

2. Run the program:

```
java MainApp
```

---

## 📷 Application Preview

(Add screenshots of your GUI here)

---

## 🧰 Technologies Used

* Java
* Java Swing (GUI)
* GitHub

---

## 📈 Future Enhancements

* Graph visualization (Stress vs Thickness)
* PDF report generation
* Integration with MATLAB/FEA tools
* AI-based design optimization

---

## 👩‍💻 Author

Bhavana Balingal

---

## ⭐ Conclusion

This application successfully demonstrates the integration of mechanical engineering design principles with software development, providing an efficient tool for pressure vessel analysis.

