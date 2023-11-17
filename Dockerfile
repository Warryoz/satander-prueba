FROM eclipse-temurin:17

#Metadata the maintainer name
LABEL mentainer="geronimovelasco060@gmail.com"

# The directory is going to be created when the container is running
WORKDIR /app

#The things we want to copy from the project to the container
# The jar from that target folder                           to this directory
                                                            # we can rename the things we copy
COPY build/libs/productosatander-0.0.1-SNAPSHOT.jar /app/productosatander-0.0.1-SNAPSHOT.jar

EXPOSE 8080

#To run a command in the container
ENTRYPOINT ["java", "-jar", "productosatander-0.0.1-SNAPSHOT.jar"]