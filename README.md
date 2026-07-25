# Hospital Billing System

A simple Java console application that models a hospital billing workflow using core Object-Oriented Programming principles — **abstraction, inheritance, encapsulation, and polymorphism**.

## Overview

The system calculates a patient's final bill differently depending on patient type:

- **GeneralPatient** — no insurance; a ₹5,000 discount is applied automatically if the treatment cost exceeds ₹50,000.
- **InsuredPatient** — insurance covers 70% of the treatment cost; an additional ₹3,000 discount is applied if the treatment cost is ₹50,000 or more.

Both patient types extend a common abstract `Patient` class, which defines shared fields, getters/setters, and an abstract `calculateBill()` method that each subclass implements according to its own billing rules.

## Design

```
Patient (abstract)
 ├── patientId       (auto-generated via static counter)
 ├── patientName
 ├── treatmentCost
 ├── generatePatientId()   [protected]
 └── calculateBill()       [abstract]
        │
        ├── GeneralPatient
        │     └── calculateBill()   → flat discount rule
        │
        └── InsuredPatient
              └── calculateBill()   → insurance coverage + additional discount rule
```

- **Encapsulation** — all fields are private, accessed only through getters/setters.
- **Abstraction** — `Patient` defines the contract (`calculateBill()`) without implementation.
- **Inheritance** — `GeneralPatient` and `InsuredPatient` extend `Patient`.
- **Polymorphism** — each subclass overrides `calculateBill()` with its own billing logic.
- **Static counter** — `patientId` values (e.g. `P1001`, `P1002`, ...) are generated automatically and guaranteed unique across all patients.

## Sample Output

```
Bill Generated Successfully

Patient ID: P1001
Name: Rahul
Treatment Cost: 60000.0
Discount Applied: 5000.0
Final Bill: 55000.0

--------------------------------

Bill Generated Successfully

Patient ID: P1002
Name: Sneha
Treatment Cost: 50000.0
Insurance coverage applied
Additional Discount Applied: 3000.0
Final Bill: 12000.0
```

## Tech Stack

- **Language:** Java
- **Concepts:** Abstract classes, Inheritance, Encapsulation, Polymorphism, Static members

## How to Run

```bash
javac HospitalBillingSystem.java
java HospitalBillingSystem
```

## Project Structure

```
├── Patient.java              # Abstract base class
├── GeneralPatient.java       # Handles non-insured billing logic
├── InsuredPatient.java       # Handles insured billing logic
├── HospitalBillingSystem.java # Main class with driver code
└── README.md
```

## Author

**Soham Palmal**
[LinkedIn](https://www.linkedin.com/in/soham-palmal-277322222/) · [GitHub](https://github.com/SohamPalmal)
