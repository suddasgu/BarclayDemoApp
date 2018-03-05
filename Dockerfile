FROM openjdk
EXPOSE 9999
ADD ./target/BarclayDemoApp.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
