package myPack;

public class CeaserCipher {
	public String encrypt(String plaintext, int key) {

		StringBuilder encryptedText = new StringBuilder();

		for (int i = 0; i < plaintext.length(); i++) {
			char currentChar = plaintext.charAt(i);

			if (Character.isLetter(currentChar)) {
				char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
				int shiftedChar = (currentChar - base + key) % 26;

				if (shiftedChar < 0) {
					shiftedChar += 26;
				}

				encryptedText.append((char) (base + shiftedChar));
			} else {
				encryptedText.append(currentChar);
			}
		}

		return encryptedText.toString();
	}

	public String decrypt(String encryptedText, int key) {
		return encrypt(encryptedText, -key);
	}
}
