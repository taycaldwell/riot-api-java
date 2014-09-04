package util;

public final class Convert {
	
	public static String longToString(long... summonerIds){
		String ids = "";
		for(int i = 0; i < summonerIds.length; i++){
			if(i != (summonerIds.length - 1)){ ids = ids + summonerIds[i] + ", "; }
			else { ids = ids + summonerIds[i]; }
		}
		return ids;
	}
}
