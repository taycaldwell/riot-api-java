package net.rithms.riot.dto.MatchList;

import java.io.Serializable;
import java.util.List;

public class MatchList implements Serializable {

	private static final long serialVersionUID = 939383850419752274L;

	private int endIndex, startIndex, totalGames;
	private List<MatchReference> matches;

	public int getEndIndex() {
		return endIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public int getTotalGames() {
		return totalGames;
	}

	public List<MatchReference> getMatches() {
		return matches;
	}
}