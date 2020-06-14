plugins {
  id("org.springframework.boot") version "2.3.0.RELEASE"
}

dependencies {
  implementation(project(":src:common"))
  implementation(project(":src:application"))

  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("io.springfox:springfox-swagger-ui:2.9.2")
  implementation("io.springfox:springfox-swagger2:2.9.2")
}
