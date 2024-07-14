Step1：write docker file:
FROM openjdk:17-jdk-slim
VOLUME /tmp
ADD ./target/MiniCoins-0.0.1-SNAPSHOT.jar rest.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "rest.jar"]
Step3: modify the pom.xml:
<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>com.spotify</groupId>
                <artifactId>docker-maven-plugin</artifactId>
                <version>1.2.2</version>
                <executions>
                    <execution>
                        <id>build-image</id>
                        <phase>package</phase>
                        <goals>
                            <goal>build</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <imageName>minicoins</imageName>
                    <imageTags>
                        <imageTag>latest</imageTag>
                    </imageTags>
                    <dockerDirectory>${project.basedir}</dockerDirectory>
                    <resources>
                        <resource>
                            <targetPath>/</targetPath>
                            <directory>${project.build.directory}</directory>
                            <include>${project.build.finalName}</include>
                        </resource>
                    </resources>
                </configuration>
            </plugin>
        </plugins>
    </build>
Step4:package the project
Step5:setting docker
In intellijIDE, click Run/Debug configure,create a docker
ImageTag is minicoins:latest
Naming container
binding port 8080
Step6:run the docker
