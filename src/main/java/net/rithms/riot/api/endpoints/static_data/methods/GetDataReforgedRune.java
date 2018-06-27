package net.rithms.riot.api.endpoints.static_data.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.UrlParameter;
import net.rithms.riot.api.endpoints.static_data.StaticDataApiMethod;
import net.rithms.riot.api.endpoints.static_data.constant.Locale;
import net.rithms.riot.api.endpoints.static_data.constant.RuneTags;
import net.rithms.riot.api.endpoints.static_data.dto.ReforgedRune;
import net.rithms.riot.api.endpoints.static_data.dto.Rune;
import net.rithms.riot.constant.Platform;

public class GetDataReforgedRune extends StaticDataApiMethod {

    public GetDataReforgedRune(ApiConfig config, Platform platform, int id, Locale locale, String version) {
        super(config);
        setPlatform(platform);
        setReturnType(ReforgedRune.class);
        setUrlBase(platform.getHost() + "/lol/static-data/v3/reforged-runes/" + id);
        if (locale != null) {
            add(new UrlParameter("locale", locale));
        }
        if (version != null) {
            add(new UrlParameter("version", version));
        }
        addApiKeyParameter();
    }
}
