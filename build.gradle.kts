plugins {
    id("maven-publish")
    id("java-library")
}

group = "org.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("main") {
            groupId = "org.example"
            artifactId = "Lab5"
            version = "1.0"
            from(components["java"])
        }
    }
}
