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

package org.kamranzafar.spring.wpapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by kamran on 07/08/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostStatus implements Serializable {
    private String name;
    @JsonProperty("public")
    private boolean postPublic;
    @JsonProperty("private")
    private boolean postPrivate;
    @JsonProperty("protected")
    private boolean postProtected;
    private boolean queryable;
    @JsonProperty("show_in_list")
    private boolean showInList;
    private String slug;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPostPublic() {
        return postPublic;
    }

    public void setPostPublic(boolean postPublic) {
        this.postPublic = postPublic;
    }

    public boolean isPostPrivate() {
        return postPrivate;
    }

    public void setPostPrivate(boolean postPrivate) {
        this.postPrivate = postPrivate;
    }

    public boolean isPostProtected() {
        return postProtected;
    }

    public void setPostProtected(boolean postProtected) {
        this.postProtected = postProtected;
    }

    public boolean isQueryable() {
        return queryable;
    }

    public void setQueryable(boolean queryable) {
        this.queryable = queryable;
    }

    public boolean isShowInList() {
        return showInList;
    }

    public void setShowInList(boolean showInList) {
        this.showInList = showInList;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
