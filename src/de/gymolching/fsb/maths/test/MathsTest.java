package de.gymolching.fsb.maths.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.gymolching.fsb.api.FSBPosition;
import de.gymolching.fsb.regulation.Regulation;

public class MathsTest {

	public MathsTest() {

	}

	@Test
	public void testCalculatePosition() {
		FSBPosition pos = Regulation.calculatePosition(0, 0, 0, 0, 0, 0);
		FSBPosition posExpected = new FSBPosition(14, 14, 14, 14, 14, 14);
		assertEquals(posExpected, pos);
	}
}