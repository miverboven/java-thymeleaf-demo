# Applying DevOps with GitHub Actions to a Spring Boot Thymeleaf application

To complete this exercise setup the following steps have been taken:

1. Initialize a repository and set up a remote on GitHub
2. Create the `Dockerfile`
3. Create the `workflow.yml` in a new `.github/workflow` folder
4. Set the right GitHub secrets for the `DOCKER_USERNAME` and `DOCKER_PASSWORD` values
5. Push to your remote GitHub and observe the workflow
6. Create the `docker-compose.yml` file (of course with your own Docker Hub account name to get the container from) and test the deployment by visiting `localhost:8080` after the `docker compose up` command
7. Create the `DishTest` test file in the `src/test/fact/it/examplemvc` folder
8. See if the additional test runs in the workflow after a push