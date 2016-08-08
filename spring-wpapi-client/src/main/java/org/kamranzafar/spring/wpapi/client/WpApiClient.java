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

import org.kamranzafar.spring.wpapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by kamran on 07/08/16.
 */
@Component
public class WpApiClient {
    @Autowired
    List<WpApiService> wpApiServices;

    public <T> WpApiService<T> getService(Class<T> clazz) {
        return wpApiServices.stream()
                .filter(wpApiService -> wpApiService.getType().getName().equals(clazz.getName())).findFirst().get();
    }

    public WpApiService<Post> getPostService(){
        return getService(Post.class);
    }

    public WpApiService<Page> getPageService(){
        return getService(Page.class);
    }

    public WpApiService<Comment> getCommentService(){
        return getService(Comment.class);
    }

    public WpApiService<Media> getMediaService(){
        return getService(Media.class);
    }

    public WpApiService<PostStatus> getPostStatusService(){
        return getService(PostStatus.class);
    }

    public WpApiService<PostType> getPostTypeService(){
        return getService(PostType.class);
    }

    public WpApiService<Tag> getTagService(){
        return getService(Tag.class);
    }

    public WpApiService<Category> getCategoryService(){
        return getService(Category.class);
    }

    public WpApiService<Taxonomy> getTaxonomyService(){
        return getService(Taxonomy.class);
    }
}
