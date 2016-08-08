/**
 * Copyright 2016 Kamran Zafar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.kamranzafar.spring.wpapi.test;

import org.kamranzafar.spring.wpapi.Post;
import org.kamranzafar.spring.wpapi.client.WpApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kamran on 05/08/16.
 */
@SpringBootApplication
@ComponentScan("org.kamranzafar.spring.wpapi")
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    private WpApiClient wpApiClient;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String, String> params = new HashMap<>();
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
    }
}
