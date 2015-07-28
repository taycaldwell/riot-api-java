package constant;

/*
 * Copyright 2014 Taylor Caldwell
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
 */
public enum Region {

    BR("br.api.pvp.net", "br", "BR1"),
    EUNE("eune.api.pvp.net", "eune", "EUN1"),
    EUW("euw.api.pvp.net", "euw", "EUW1"),
    KR("kr.api.pvp.net", "kr", "KR"),
    LAS("las.api.pvp.net", "las", "LA2"),
    LAN("lan.api.pvp.net", "lan", "LA1"),
    NA("na.api.pvp.net", "na", "NA1"),
    OCE("oce.api.pvp.net", "oce", "OC1"),
    TR("tr.api.pvp.net", "tr", "TR1"),
    RU("ru.api.pvp.net", "ru", "RU"),
    PBE("global.api.pvp.net", "pbe", "PBE1"),
    GLOBAL("global.api.pvp.net", "global", "");

    private String endpoint;
    private String region;
    private String platformId;

    Region(String endpoint, String region, String platformId) {
        this.endpoint = endpoint;
        this.region = region;
        this.platformId = platformId;
    }

    public String getEndpoint() {
        return "https://" + endpoint + "/api/lol/";
    }

    public String getName() {
        return region;
    }

    public String getPlatformId() {
        return platformId;
    }
    
}
