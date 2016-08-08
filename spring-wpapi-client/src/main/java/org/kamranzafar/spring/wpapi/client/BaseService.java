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

 package org.kamranzafar.spring.wpapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * Created by kamran on 07/08/16.
 */
public abstract class BaseService<T> implements WpApiService<T> {
    @Autowired
    protected WpApiConfig wpApiConfig;

    @Autowired
    protected RestTemplate restTemplate;

    @Override
    public T get(int id) {
        return restTemplate.getForObject(buildUri() + "/" + id, getType());
    }

    @Override
    public T get(int id, Map<String, String> params) {
        return restTemplate.getForObject(buildUri(buildUri() + "/" + id, params), getType());
    }

    @Override
    public void create(T obj) {
        restTemplate.postForLocation(buildUri(), obj);
    }

    @Override
    public void update(T obj) {
        restTemplate.postForLocation(buildUri(), obj);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(buildUri() + "/" + id);
    }

    protected String buildUri() {
        return (wpApiConfig.isHttps() ? "https://" : "http://") + wpApiConfig.getHost() + ":" + wpApiConfig.getPort() + "/" + wpApiConfig.getApiBase() + "/" + getUrlPostfix();
    }

    protected URI buildUri(String uri, Map<String, String> params) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(uri);

        params.forEach((k, v) -> uriComponentsBuilder.queryParam(k, v));

        return uriComponentsBuilder.build().toUri();
    }

    protected URI buildUri(Map<String, String> params) {
        return buildUri(buildUri(), params);
    }

    protected abstract String getUrlPostfix();
}
