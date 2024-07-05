<h3>for docs go to:</h3>
	http://localhost:8080/swagger-ui/index.html <br>
	http://localhost:8080/v3/api-docs <br><br>
	
<h3>content negotiation:</h3>
needed when e.g different content type(xml and json) or different languages(en and tr) will be used. <br><br>

<h3>internationalization</h3>
to server multiple languages, HTTP Request Header- Accept Language is used.	<br><br>

<h3>filtering</h3>
static filtering: ignoring one field for every response (like when u want passwords never to be shown as a response), use @JsonIgnore OR @JsonIgnoreProperties<br>
dynamic filtering: Used for specific requests, not all of them. @FilterProvider, @MappingJacksonValue, @JsonFilter.
<br><br>

<h3>actuator- monitoring the app during prod</h3> 
localhost:8080/actuator <br>
management.endpoints.web.exposure.include=* <br><br>

<h3>HAL explorer: for linking things</h3>
localhost:8080/explorer <br><br>

<h3>Basic Auth with Spring Security</h3>
g4stly:neMutluTurkumDiyene<br>
use it for both on /login and "Authorization: " while sending any request 
