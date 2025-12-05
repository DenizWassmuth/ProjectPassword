> **Projektziel:**  
> Dieses Projekt stellt eine kleine Java-Bibliothek zur Passwortvalidierung bereit – inklusive automatisierter Tests (JUnit 5), Maven-Build und GitHub Actions CI.

---

## Passwort-Policy

Die aktuelle Basis-Policy bewertet ein Passwort als **gültig**, wenn alle folgenden Bedingungen erfüllt sind:

- Mindestlänge: mindestens 8 Zeichen
- Ziffer: mindestens eine Ziffer (`0–9`) ist enthalten
- Groß- und Kleinbuchstaben: mindestens ein Großbuchstabe und ein Kleinbuchstabe sind enthalten
- Kein häufiges Passwort: das Passwort steht nicht in einer internen Liste häufiger/schwacher Passwörter  
  (z. B. `password`, `Passwort1`, `12345678`, `Aa345678`, …)
- Sonderzeichen: mindestens ein erlaubtes Sonderzeichen (z. B. `!@#$%^&*()-_+=?.,;:`)
  
  // nocht nicht integriert
- Zeichengruppen: Mindestanzahl verschiedener Zeichentypen (z. B. 3 von 4: Großbuchstaben, Kleinbuchstaben, Ziffern, Sonderzeichen)

Die genaue Policy ist im Code (z. B. in `PasswordValidator.isValid(...)`) und in den Unit-Tests nachvollziehbar dokumentiert.

---

## Projektstruktur (Kurzüberblick)

- `src/main/java/.../PasswordValidator.java`  
  Zentrale Klasse unter Utils ist die PasswordValidator Klasse mit Methoden wie `hasMinLength`, `containsDigit`, `containsUpperAndLower`, `isCommonPassword` und `isValid`.
- `src/test/java/.../PasswordValidatorTest.java`  
  JUnit-5-Tests, die die einzelnen Regeln und die Gesamtsicht prüfen.
- `pom.xml`  
  Maven-Konfiguration inkl. JUnit Jupiter, Surefire-Plugin und Java-Version.
