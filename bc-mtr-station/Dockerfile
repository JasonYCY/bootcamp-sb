FROM amazoncorretto:21
ADD target/bc-mtr-station-0.0.1-SNAPSHOT.jar bc-mtr-station-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","bc-mtr-station-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081


# docker build -t bc-mtr-station:0.0.1 -f Dockerfile .

# docker network create bootcamp-network

# docker pull postgres:latest

# docker run -d --network bootcamp-network --name postgres-container -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=admin1234 -e POSTGRES_DB=bootcamp_2512 -p 5532:5432 postgres:latest

# docker pull redis:latest

# docker run -d --network bootcamp-network --name redis-container -p 6479:6379 redis:latest

# docker run -d --name bc-mtr-station --network bootcamp-network -p 8181:8081 bc-mtr-station:0.0.1