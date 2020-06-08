plugins {
  id("org.springframework.boot") version "2.3.0.RELEASE"
}

dependencies {
  implementation(project(":src:common"))
  implementation(project(":src:application"))

  implementation("org.springframework.boot:spring-boot-starter-web")
}
