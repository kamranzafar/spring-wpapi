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

import org.kamranzafar.spring.wpapi.Comment;
import org.kamranzafar.spring.wpapi.client.BaseService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by kamran on 07/08/16.
 */
@Service
public class CommentService extends BaseService<Comment> {
    @Override
    public Comment[] getAll() {
        return restTemplate.getForObject(buildUri(), Comment[].class);
    }

    @Override
    public Comment[] getAll(Map<String, String> params) {
        return restTemplate.getForObject(buildUri(params), Comment[].class);
    }

    @Override
    public String getUrlPostfix() {
        return wpApiConfig.getApiVersionBase() + "/comments";
    }

    @Override
    public Class<Comment> getType() {
        return Comment.class;
    }
}
