# Spring WordPress WP-API Client

This is a Spring client for [WordPress REST plugin](https://github.com/WP-API/), which makes it easy to integrate Spring Boot applications with WordPress CMS.

## Usage

Add the following dependency to your Spring Boot Application

<pre><code>&lt;dependency&gt;
    &lt;groupId&gt;org.kamranzafar.spring.wpapi&lt;/groupId&gt;
    &lt;artifactId&gt;spring-wpapi&lt;/artifactId&gt;
    &lt;version&gt;0.1&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>

Below is a sample configuration we need in the application.properties file

<pre><code>wpapi.host=yoursite.com
wpapi.port=443   # Optional, default is 80
wpapi.https=true # Optional, default is false
</code></pre>

The Spring WP-API client needs the RestTemplate so lets create a bean in our Application and autowire the Spring client. 
We also need to add component scan annotation so that Spring finds and autowires all the required dependencies.

<pre><code>@SpringBootApplication
@ComponentScan("org.kamranzafar.spring.wpapi")
public class Application implements CommandLineRunner {
    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }
 
    @Autowired
    private WpApiClient wpApiClient;
 
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
</code></pre>

Now just use client to call the WordPress services

<pre><code>Map<String, String> params = new HashMap<>();
params.put("search", "Spring");
params.put("per_page", "2"); // results per page
params.put("page", "1"); // current page
 
// See WP-API Documentation more parameters
// http://v2.wp-api.org/reference/
 
Post[] posts = wpApiClient.getPostService().getAll(params);
 
for (Post p : posts) {
    log.info("Post: " + p.getId());
    log.info("" + p.getContent());
}
</code></pre>

## License

Apache Software License 2.0