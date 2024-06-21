plugins {
    id("maven-publish")
    id("java-library")
}

group = "org.example"
version = "1.0-SNAPSHOT"

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
            groupId = "rg.example"
            artifactId = "Lab5"
            version = "0.3.5"
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "LocalRepo"
            url = uri("$buildDir/publish")
        }

        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/artemlevv/automatization_lab5")
            credentials {
                username = artemlevv
                password = System.getenv("GH_TOKEN")
            }
        }
    }
}
