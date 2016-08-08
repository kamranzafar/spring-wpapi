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

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by kamran on 07/08/16.
 */
@Component
@ConfigurationProperties(prefix="wpapi")
public class WpApiConfig {
    public static final int DEFAULT_PORT = 80;
    public static final String DEFAULT_API_BASE = "wp-json";
    public static final String DEFAULT_API_VERSION_BASE = "wp/v2";

    private String host;
    private int port = DEFAULT_PORT;
    private boolean https;
    private String apiBase = DEFAULT_API_BASE;
    private String apiVersionBase = DEFAULT_API_VERSION_BASE;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isHttps() {
        return https;
    }

    public void setHttps(boolean https) {
        this.https = https;
    }

    public String getApiBase() {
        return apiBase;
    }

    public void setApiBase(String apiBase) {
        this.apiBase = apiBase;
    }

    public String getApiVersionBase() {
        return apiVersionBase;
    }

    public void setApiVersionBase(String apiVersionBase) {
        this.apiVersionBase = apiVersionBase;
    }
}
