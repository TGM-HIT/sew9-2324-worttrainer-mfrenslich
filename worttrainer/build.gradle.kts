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
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0-rc1")
    implementation("com.fasterxml.jackson.core:jackson-core:2.12.1")
    implementation("commons-validator:commons-validator:1.7")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    implementation("org.json:json:20231013")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0-rc1")
    implementation("com.fasterxml.jackson.core:jackson-core:2.12.1")
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("at.ac.tgm.mfrenslich.worttrainer.Main")
}

tasks.test {
    useJUnitPlatform()
}