package myPack;

public class Vigenere {
	public String generateKey(String str, String key) {
		int x = str.length();

		for (int i = 0;; i++) {
			if (x == i)
				i = 0;
			if (key.length() == str.length())
				break;
			key += (key.charAt(i));
		}
		return key;
	}

	public String cipherText(String str, String key) {
		String cipher_text = "";

		for (int i = 0; i < str.length(); i++) {
			int x = (str.charAt(i) + key.charAt(i)) % 26;

			x += 'A';

			cipher_text += (char) (x);
		}
		return cipher_text;
	}

	public String originalText(String cipher_text, String key) {
		String orig_text = "";

		for (int i = 0; i < cipher_text.length() &&
				i < key.length(); i++) {
			int x = (cipher_text.charAt(i) -
					key.charAt(i) + 26) % 26;

			x += 'A';
			orig_text += (char) (x);
		}
		return orig_text;
	}

	public String LowerToUpper(String s) {
		StringBuffer str = new StringBuffer(s);
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLowerCase(s.charAt(i))) {
				str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
			}
		}
		s = str.toString();
		return s;
	}
}