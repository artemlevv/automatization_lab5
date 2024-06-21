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
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/artemlevv/automatization_lab5")
            credentials {
                username = System.getenv("GH_USERNAME")
                password = System.getenv("GH_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("main") {
            groupId = "org.example"
            artifactId = "Lab5"
            version = "1.0"
            from(components["java"])
        }
    }
}
