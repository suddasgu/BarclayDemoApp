FROM java:8
EXPOSE 9999
ADD C:\Users\IBM_ADMIN\.jenkins\workspace\BarclayTestPipeline\target\BarclayDemoApp.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
