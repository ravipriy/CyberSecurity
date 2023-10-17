package myPack;
public class RailFence {

	public String encrypt(String plaintext, int numRails) {

		StringBuilder[] railMatrix = new StringBuilder[numRails];

		for (int i = 0; i < numRails; i++) {
			railMatrix[i] = new StringBuilder();
		}

		int rail = 0;
		boolean down = true;

		for (int i = 0; i < plaintext.length(); i++) {
			railMatrix[rail].append(plaintext.charAt(i));

			if (rail == 0) {
				down = true;
			} else if (rail == numRails - 1) {
				down = false;
			}

			if (down) {
				rail++;
			} else {
				rail--;
			}
		}

		StringBuilder ciphertext = new StringBuilder();
		for (int i = 0; i < numRails; i++) {
			ciphertext.append(railMatrix[i]);
		}

		return ciphertext.toString();
	}
}
