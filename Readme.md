### Restaurant Catalogue 

#### git command to clear target
    git rm --cached -r target/

## Command to build with ENV
    export $(cat .env | xargs) && mvn clean install

## Command to run
    mvn spring-boot:run

## Deployment env
    export SPRING_PROFILES_ACTIVE=prod
    export MACHINE_IP=$(hostname -I | awk '{print $1}')


### Docker Command
    docker build -t aariskazi/restaurant_catalogue:v1.0.0 .
    docker run -it --rm --name restaurant-catalogue-container aariskazi/restaurant_catalogue:latest