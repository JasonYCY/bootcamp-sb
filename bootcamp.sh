docker compose down

# docker rm bc-mtr-station

cd bc-mtr-station
mvn clean install -DskipTests
docker build -t bc-mtr-station:0.0.1 -f Dockerfile .

cd ..
# add script here

docker compose up -d