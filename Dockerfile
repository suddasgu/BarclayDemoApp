FROM openjdk
EXPOSE 8095
ADD ./target/BarclayDemoApp.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
