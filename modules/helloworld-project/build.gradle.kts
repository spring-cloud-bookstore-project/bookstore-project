
plugins {
    java
    application
}

group = "me.xtopz"
version = "0.0.1-SNAPSHOT"

val mainClassName = "me.xtopz.helloworld.Application"

application {
    mainClass = mainClassName
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = mainClassName
    }
}

repositories {
    mavenCentral()
}
