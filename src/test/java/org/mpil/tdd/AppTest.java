package org.mpil.tdd;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class AppTest {

	private App app = new App();

	/**
	 * teste le cas d’un achat sans réduction
	 */
	@Test
	public void testCasBasiques() {
		Assert.assertThat(app.montantTotal(), is(0.0));
		Assert.assertThat(app.montantTotal(0), is(8.0));
		Assert.assertThat(app.montantTotal(1), is(8.0));
		Assert.assertThat(app.montantTotal(2), is(8.0));
		Assert.assertThat(app.montantTotal(3), is(8.0));
		Assert.assertThat(app.montantTotal(4), is(8.0));
		Assert.assertThat(app.montantTotal(0, 0), is(8.0 * 2));
		Assert.assertThat(app.montantTotal(1, 1, 1), is(8.0 * 3));

	}

	/**
	 * teste le cas des réductions simples
	 */
	@Test
	public void testReductionsSimples() {
		Assert.assertThat(app.montantTotal(0, 1), is(8.0 * 2 * 0.95));
		Assert.assertThat(app.montantTotal(0, 2, 4), is(8.0 * 3 * 0.9));
		Assert.assertThat(app.montantTotal(0, 1, 2, 4), is(8.0 * 4 * 0.8));
		Assert.assertThat(app.montantTotal(0, 1, 2, 3, 4), is(8.0 * 5 * 0.75));
	}

	/**
	 * teste les cas simples de réductions combinées
	 */
	@Test
	public void testReductionsComplexes() {
		Assert.assertThat(app.montantTotal(0, 0, 1), is(8 + (8 * 2 * 0.95)));
		Assert.assertThat(app.montantTotal(0, 0, 1, 1), is(2 * (8 * 2 * 0.95)));
		Assert.assertThat(app.montantTotal(0, 0, 1, 2, 2, 3), is((8 * 4 * 0.8)
				+ (8 * 2 * 0.95)));
		Assert.assertThat(app.montantTotal(0, 1, 1, 2, 3, 4),
				is(8 + (8 * 5 * 0.75)));
	}

	/**
	 * teste les cas plus compliqués de réductions combinées
	 */
	@Test
	public void testCasTordus() {
		Assert.assertThat(app.montantTotal(0, 0, 1, 1, 2, 2, 3, 3),
				is(2 * (8 * 4 * 0.8)));
		Assert.assertThat(app.montantTotal(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2,
				2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4), is(4 * (8 * 5 * 0.75) + (8 * 3 * 0.9)));
	}

}
