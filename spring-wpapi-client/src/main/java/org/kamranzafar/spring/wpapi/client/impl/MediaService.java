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

import org.kamranzafar.spring.wpapi.Media;
import org.kamranzafar.spring.wpapi.client.BaseService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by kamran on 07/08/16.
 */
@Service
public class MediaService extends BaseService<Media> {
    @Override
    public Media[] getAll() {
        return restTemplate.getForObject(buildUri(), Media[].class);
    }

    @Override
    public Media[] getAll(Map<String, String> params) {
        return restTemplate.getForObject(buildUri(params), Media[].class);
    }

    @Override
    public String getUrlPostfix() {
        return wpApiConfig.getApiVersionBase() + "/media";
    }

    @Override
    public Class<Media> getType() {
        return Media.class;
    }
}
