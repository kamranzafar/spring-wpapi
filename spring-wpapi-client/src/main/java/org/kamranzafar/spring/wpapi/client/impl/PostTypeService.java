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

package org.kamranzafar.spring.wpapi.client.impl;

import org.kamranzafar.spring.wpapi.PostType;
import org.kamranzafar.spring.wpapi.client.BaseService;
import org.kamranzafar.spring.wpapi.client.WpApiException;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by kamran on 07/08/16.
 */
@Service
public class PostTypeService extends BaseService<PostType> {
    @Override
    public PostType[] getAll() {
        return restTemplate.getForObject(buildUri(), PostType[].class);
    }

    @Override
    public PostType[] getAll(Map<String, String> params) {
        return restTemplate.getForObject(buildUri(params), PostType[].class);
    }

    @Override
    public String getUrlPostfix() {
        return wpApiConfig.getApiVersionBase() + "/types";
    }

    @Override
    public void create(PostType obj) {
        throw new WpApiException("Not supported");
    }

    @Override
    public void update(PostType obj) {
        throw new WpApiException("Not supported");
    }

    @Override
    public void delete(int id) {
        throw new WpApiException("Not supported");
    }

    @Override
    public Class<PostType> getType() {
        return PostType.class;
    }
}
