FROM amazoncorretto:21
ADD target/demo-restful-api-0.0.1-SNAPSHOT.jar demo-restful-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","demo-restful-api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080



# docker build -t demo-restful-api:0.0.1 -f Dockerfile .

# docker network create bootcamp-network

# docker pull postgres:latest

# docker run -d --network bootcamp-network --name postgres-container -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=admin1234 -e POSTGRES_DB=bootcamp_2512 -p 5532:5432 postgres:latest

# docker pull redis:latest

# docker run -d --network bootcamp-network --name redis-container -p 6479:6379 redis:latest

# docker run -d --name demo-restful-app --network bootcamp-network -p 8180:8080 demo-restful-api:0.0.1