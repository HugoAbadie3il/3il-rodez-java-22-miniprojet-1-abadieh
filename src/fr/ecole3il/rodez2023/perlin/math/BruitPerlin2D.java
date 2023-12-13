package fr.ecole3il.rodez2023.perlin.math;


import fr.ecole3il.rodez2023.perlin.Utils;

import java.util.stream.IntStream;

/**
 * @author philibert roquart, fainéant
 */
public class BruitPerlin2D extends Bruit2D {

	// Vecteurs de gradient pour le bruit de Perlin
	private static final float[][] GRADIENT_2D = {
			{ -1, 1 }, { 0, 1 }, { 1, 1 },
			{ -1, 0 }, { 1, 0 },
			{ -1, -1 }, { 0, -1 }, { 1, -1 }
	};

	// Tableau de permutations pour le bruit de Perlin
	private int[] permutation;

	public BruitPerlin2D(long graine, double resolution) {
		super(graine, resolution);
		permutation = IntStream.range(0,256).toArray();
		permutation = Utils.melanger(permutation, graine);
	}

	@Override
	public double bruit2D(double x, double y) {
		double distanceX, distanceY;
		int x0, x1, y0, y1;
		int ii, jj, gi0, gi1, gi2, gi3;
		double unit = 1.0f / Math.sqrt(2);
		double s, t, u, v, Cx, Cy, Li1, Li2;
		// Adapter pour la résolution
		x /= getResolution();
		y /= getResolution();

		// Obtenir les coordonnées de la grille associées à (x, y)
		x0 = (int) Math.floor(x);
		x1 = x0 + 1;
		y0 = (int) Math.floor(y);
		y1 = y0 + 1;

		// Masquage pour récupérer les indices de permutation
		ii = x0 & 255;
		jj = y0 & 255;

		// Récupérer les indices de gradient associés aux coins du quadrilatère
		gi0 = permutation[ii + permutation[jj]] % 8;
		gi1 = permutation[ii + 1 + permutation[jj]] % 8;
		gi2 = permutation[ii + permutation[jj + 1]] % 8;
		gi3 = permutation[ii + 1 + permutation[jj + 1]] % 8;

		// Récupérer les distances de x et y
		distanceX = x - x0;
		distanceY = y - y0;

		// Récupérer les vecteurs de gradient et effectuer des interpolations pondérées
		s = GRADIENT_2D[gi0][0] * distanceX + GRADIENT_2D[gi0][1] * distanceY;

		t = GRADIENT_2D[gi1][0] * (distanceX + 1) + GRADIENT_2D[gi1][1] * distanceY;

		u = GRADIENT_2D[gi2][0] * distanceX + GRADIENT_2D[gi2][1] * (distanceY + 1);

		v = GRADIENT_2D[gi3][0] * (distanceX + 1) + GRADIENT_2D[gi3][1] * (distanceY + 1);

		// Interpolations pour lisser les valeurs obtenues
		Cx = 3 * distanceX * distanceX - 2 * distanceX * distanceX * distanceX;

		Li1 = s + Cx * (t - s);
		Li2 = u + Cx * (v - u);

		Cy = 3 * distanceY * distanceY - 2 * distanceY * distanceY * distanceY;

		return Li2 + Cy * (Li2 - Li1);
	}
}
