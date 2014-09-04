package constant;
	
public enum Region {
	     
		BR("br.api.pvp.net", "br"),
		EUNE("eune.api.pvp.net", "eune"),
		EUW("euw.api.pvp.net", "euw"),
		KR("kr.api.pvp.net", "kr"),
		LAS("las.api.pvp.net", "las"),
		LAN("lan.api.pvp.net", "lan"),
		NA("na.api.pvp.net", "na"),
		OCE("oce.api.pvp.net", "oce"),
		TR("tr.api.pvp.net", "tr"),
		RU("ru.api.pvp.net", "ru"),
		GLOBAL("global.api.pvp.net", "global");

	    private String endpoint;
	    private String region;
	    
	    Region(String endpoint, String region) {
	        this.endpoint = endpoint;
	        this.region = region;
	    }

	    public String getEndpoint() {
	        return endpoint;
	    }
	    
	    public String getName() {
	        return region;
	    }
}
