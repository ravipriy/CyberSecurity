package myPack;

import javax.swing.*;

public class Hill {
	public int[][] getKeyMatrix() {
		int dimension = Integer.parseInt(JOptionPane.showInputDialog("Enter the dimension of the key matrix "));

		int[][] keyMatrix = new int[dimension][dimension];

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				String input = JOptionPane
						.showInputDialog("Enter element at row " + (i + 1) + " and column " + (j + 1) + ":");
				keyMatrix[i][j] = Integer.parseInt(input);
			}
		}

		return keyMatrix;
	}

	public String encrypt(String plaintext, int[][] keyMatrix) {
		int dimension = keyMatrix.length;
		StringBuilder ciphertext = new StringBuilder();

		while (plaintext.length() % dimension != 0) {
			plaintext += 'X';
		}

		int blockSize = dimension;

		for (int i = 0; i < plaintext.length(); i += blockSize) {
			String block = plaintext.substring(i, i + blockSize);

			int[] blockVector = new int[blockSize];
			for (int j = 0; j < blockSize; j++) {
				blockVector[j] = block.charAt(j) - 'A';
			}
			int[] resultVector = new int[blockSize];
			for (int j = 0; j < blockSize; j++) {
				for (int k = 0; k < blockSize; k++) {
					resultVector[j] += keyMatrix[j][k] * blockVector[k];
				}
				resultVector[j] %= 26;
			}

			for (int j : resultVector) {
				ciphertext.append((char) (j + 'A'));
			}
		}
		return ciphertext.toString();
	}
}
