FROM openjdk
EXPOSE 8091
ADD ./target/BarclayDemoApp.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
