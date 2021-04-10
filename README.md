# **PlayList Service**

Playlist Service is a service where users can create music lists and share them with others.

# **Prerequisites**

JDK 11,
Gradle 6.8.3,
IntelliJ IDEA

Plugins: Lombok

# **How to setup and run playlist service in local:**

1. Clone the project repository from github : https://github.com/404-bug-not-found/playlist-service
2. Setup project in IntelliJ IDEA
3. Fetch and pull latest code from branch main.
4. Run the integration test - PlayListServiceIT
5. download the postgres image: `docker pull postgres`
6. start the postgres container: `docker run --name postgres -e POSTGRES_PASSWORD=open -p 5432:5432 -d postgres`
7. Create the docker network: `docker network create --driver bridge playlist-network`
8. Start Database Server on Network: `docker run --name postgres-db-cotainer --network playlist-network -e POSTGRES_PASSWORD=open -e POSTGRES_DB=postgres -d postgres`
9. Build local docker image of project: `docker build -t playlist-image .`
10. Start Docker Container based on Image: `docker run --name playlist_postgres_container --network playlist-network -e PORT=8080 -e SPRING_PROFILES_ACTIVE=postgres -p 9000:8080 -d playlist-image:latest`
11. Run the GuestBook service with postgres DB : `http://localhost:9000/playlist`
12. Refer the REST Documentation for end point details
    

**Heroku App Url:** `https://playlist-service-01.herokuapp.com/`

# **End Point Details (REST Documentation):**

Rest documentation of end point details can be found at this url : https://playlist-service-01.herokuapp.com/docs/index.html

# **TODO List for Next Sprint:**

1. Update Playlist entity with List<String> of songs, so multiple songs added to same PlayList can be stored in same PlayList object.
2. Add more feature for remaining acceptance criteria and more tests for them.