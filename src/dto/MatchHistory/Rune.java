package dto.MatchHistory;

import java.io.Serializable;

/**
 * @deprecated  As of release 3.6.0
 */
public class Rune implements Serializable {
	
	private static final long serialVersionUID = -3403728498506953457L;
	private long rank, runeId;

	public long getRank() {
		return rank;
	}

	public long getRuneId() {
		return runeId;
	}
	
	
}
