FROM java:8
EXPOSE 9999
ADD /var/jenkins_home/workspace/Sample-Pipeline/target/BarclayDemoApp.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
