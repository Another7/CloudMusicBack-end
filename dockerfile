FROM java:8
VOLUME /tmp
ADD cloud-0.0.1-SNAPSHOT.jar /cloud-music.jar
CMD ["java","-jar","/cloud-music.jar"]