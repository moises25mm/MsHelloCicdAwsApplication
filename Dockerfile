
FROM openjdk:21-slim
WORKDIR /
COPY "./target/ms-hello-cicd-aws-0.0.1-SNAPSHOT.jar" "ms-hello-cicd-aws.jar"
EXPOSE 8090
ENTRYPOINT ["java","-jar","ms-hello-cicd-aws.jar"]
