# STATS-V2-BE

<h2>RUN APP:</h2>

Execute spring boot application in stats package -> StatsV2Application.java

OR

Via command line using maven.
<ul>
<li>mvn clean install</li>
<li>mvn spring-boot:run</li>
</ul>

<h2>API LIST:</h2>

pre-load db data:

baseUrl: localhost:8080 | deployUrl

http://baseUrl/api/db/load/constructors

http://baseUrl/api/db/load/drivers

http://baseUrl/api/db/load/races

fetch data:

GET -> http://baseUrl/api/drivers

GET -> http://baseUrl/api/drivers/:id

GET -> http://baseUrl/api/races

GET -> http://baseUrl/api/races/:id

GET -> http://baseUrl/api/constructors

GET -> http://baseUrl/api/constructors/:id
