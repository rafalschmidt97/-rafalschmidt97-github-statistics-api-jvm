plugins {
  java
  id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

subprojects {
  group = "com.rafalschmidt.github"
  version = "1.0.0"

  apply(plugin = "java")
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "java-library")

  repositories {
    mavenCentral()
    jcenter()
  }

  dependencies {
    compileOnly("org.projectlombok:lombok:1.18.10")
    annotationProcessor("org.projectlombok:lombok:1.18.10")
  }

  dependencyManagement {
    dependencies {
      dependency("org.springframework.boot:spring-boot-dependencies:2.3.0.RELEASE")
    }
  }
}
