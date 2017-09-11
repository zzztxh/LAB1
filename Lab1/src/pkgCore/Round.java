package pkgCore;

import java.util.LinkedList;

public class Round {

	private int ComeOutScore;
	private eGameResult eGameResult;
	private LinkedList<Roll> rolls = new LinkedList<Roll>();

	public Round() {
		Roll r = new Roll();
		rolls.add(r);
		ComeOutScore = r.getScore();

		if (ComeOutScore == 7 || ComeOutScore == 11) {
			eGameResult = pkgCore.eGameResult.NATURAL;
		} else if (ComeOutScore == 2 || ComeOutScore == 3 || ComeOutScore == 12) {
			eGameResult = pkgCore.eGameResult.CRAPS;
		} else {
			do {
				Roll r1 = new Roll();
				rolls.add(r1);
				if (r1.getScore() == ComeOutScore) {
					eGameResult = pkgCore.eGameResult.POINT;
					break;
				} else if (r1.getScore() == 7) {
					eGameResult = pkgCore.eGameResult.SEVEN_OUT;
					break;
				}
			} while (true);
		}

	}

	public int RollCount() {
		return rolls.size();
	}

	public eGameResult geteGameResult() {
		return eGameResult;
	}

	public LinkedList<Roll> getRolls() {
		return rolls;
	}

}
