plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "bookstore-project"

include(
    "modules:book-service",
    "modules:helloworld-project"
)

