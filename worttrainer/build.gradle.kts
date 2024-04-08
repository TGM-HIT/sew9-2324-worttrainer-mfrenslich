plugins {
    id("java")
    application
}

group = "at.ac.tgm.mfrenslich"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.googlecode.json-simple:json-simple:1.1.1") // JSON-Simple-Bibliothek hinzu, die das Parsen und Erstellen von JSON-Daten in Java ermöglicht.
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0-rc1") //Fügt die Jackson-Databind-Bibliothek hinzu, die JSON-Daten in Java-Objekte (und umgekehrt) umwandelt.
    implementation("com.fasterxml.jackson.core:jackson-core:2.12.1") //Fügt die Kernbibliothek von Jackson hinzu, die Funktionen für die Verarbeitung von JSON-Daten bereitstellt.
    implementation("commons-validator:commons-validator:1.7") //Fügt die Apache Commons Validator-Bibliothek hinzu, die Validierungsroutinen für verschiedene Datenstrukturen wie E-Mails, URLs, Zahlen
    implementation("org.junit.jupiter:junit-jupiter:5.8.1") // Fügt die JUnit Jupiter-Bibliothek hinzu, die für das Schreiben und Ausführen von Tests in Java verwendet wird.
    implementation("org.json:json:20231013") //Fügt die JSON-Bibliothek hinzu, die Unterstützung für das Arbeiten mit JSON-Daten in Java bietet.
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0-rc1")
    implementation("com.fasterxml.jackson.core:jackson-core:2.12.1")
    implementation("com.google.code.gson:gson:2.10.1") //Fügt die Gson-Bibliothek hinzu, die für die Serialisierung und Deserialisierung von Java-Objekten in und aus JSON verwendet wird.
    testImplementation(platform("org.junit:junit-bom:5.9.1")) //Fügt das JUnit BOM (Bill of Materials) hinzu, das die Version von JUnit für Testzwecke verwaltet.
    testImplementation("org.junit.jupiter:junit-jupiter") // Fügt die JUnit Jupiter-Bibliothek für Tests hinzu.
}

application {
    mainClass.set("at.ac.tgm.mfrenslich.worttrainer.Main")
}

tasks.test {
    useJUnitPlatform()
}