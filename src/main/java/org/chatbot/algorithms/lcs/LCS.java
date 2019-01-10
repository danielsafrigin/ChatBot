package org.chatbot.algorithms.lcs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LCS {

	private static Set<String> lcsList = new HashSet<>();

	/**
	 * 
	 * @param a
	 *            characters will be represented in the row
	 * @param b
	 *            characters will be represented in the col
	 * @return array containing LCS
	 */
	public static int[][] twoStringMatrix(String a, String b) {
		int arr[][] = new int[a.length() + 1][b.length() + 1];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
				}
			}
		}
		return arr;
	}

	public static int Len(String a, String b) {
		int[][] matrix = twoStringMatrix(a, b);
		return matrix[matrix.length - 1][matrix[0].length - 1];
	}

	public String onePath(String a, String b, int arr[][]) {
		String s = "";
		int i = arr.length - 1;
		int j = arr[0].length - 1;
		while (i > 0 && j > 0) {
			if (a.charAt(i) == b.charAt(j)) {
				s = a.charAt(i) + s;
				i--;
				j--;
			} else if (arr[i][j - 1] > arr[i - 1][j]) {
				j--;
			} else if (arr[i][j - 1] < arr[i - 1][j]) {
				i--;
			} else {
				i--;
			}
		}
		return s;
	}

	public static void allPaths(String a, String b, int i, int j, String s, int arr[][]) {
		if (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				allPaths(a, b, i - 1, j - 1, a.charAt(i - 1) + s, arr);
			} else if (arr[i][j - 1] == arr[i - 1][j]) {
				allPaths(a, b, i, j - 1, s, arr);
				allPaths(a, b, i - 1, j, s, arr);
			} else if (arr[i][j - 1] > arr[i - 1][j]) {
				allPaths(a, b, i, j - 1, s, arr);
			} else if (arr[i][j - 1] < arr[i - 1][j]) {
				allPaths(a, b, i - 1, j, s, arr);
			}
		} else {
			lcsList.add(s);
		}

	}

	public static void getAll(String a, String b, int i, int j, String s, int arr[][]) {
		allPaths(a, b, a.length(), b.length(), "", twoStringMatrix(a, b));
		System.out.println("Lcs Length = " + lcsList.iterator().next().length());
		System.out.println(lcsList);
		lcsList.clear();

	}

	public static float match(String a, String b) {
		return (float) Len(a, b) / Math.max(a.length(), b.length());
	}

	public static void main(String[] args) {

		String b = "abbaecde";
		String a = "abacbae";

		getAll(a, b, a.length(), b.length(), "", twoStringMatrix(a, b));

		String c = "ab";
		String d = "a";

		System.out.println(match(a, b));

		getAll(c, d, c.length(), d.length(), "", twoStringMatrix(c, d));

	}

}
