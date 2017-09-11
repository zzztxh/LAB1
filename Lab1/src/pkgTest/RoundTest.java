package pkgTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Round;
import pkgCore.eGameResult;

public class RoundTest {

	@Test
	public void test() {
		for (int a = 0; a < 10000; a++) {
			Round x = new Round();
			if (x.RollCount() == 1) {

				if (x.geteGameResult() == eGameResult.CRAPS) {
					if ((x.getRolls().getLast().getScore() == 2) || (x.getRolls().getLast().getScore() == 3)	|| (x.getRolls().getLast().getScore() == 12)) {

					} else {
						fail("Should be craps, not 2 3 or 12");
					}

				} else if (x.geteGameResult() == eGameResult.NATURAL) {
					if ((x.getRolls().getLast().getScore() == 7) || (x.getRolls().getLast().getScore() == 11)) {

					} else {
						fail("Should be natural, not 7 or 11");
					}
				}
			}
			else
			{
				if (x.geteGameResult() == eGameResult.POINT)
				{
					if (x.getRolls().getFirst().getScore() != x.getRolls().getLast().getScore())
					{
						fail ("Point is made, but last roll isn't point");
					}
				}
				else if (x.geteGameResult() == eGameResult.SEVEN_OUT)
				{
					if (x.getRolls().getLast().getScore() != 7)
					{
						fail ("seven out, but last roll is not seven");
					}
				}
			}
		}

	}

}
