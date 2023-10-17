import myPack.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class myframe extends JFrame implements ItemListener, ActionListener {
	JTextField etext;
	JTextArea result;
	JButton convert;
	JComboBox<String> menu;

	int h = 35;
	int w = 150;
	String methods[] = { "PlayFair", "Vigenere", "Ceaser", "Hill Cipher", "RailFence" };

	myframe() {
		setSize(500, 500);
		setTitle("Encrpytion Decription");

		etext = new JTextField("Enter Your Text Here");
		result = new JTextArea();
		convert = new JButton("Encrypt");
		menu = new JComboBox<>(methods);

		setLayout(null);
		etext.setBounds(50, 50, 300, h);

		convert.setBounds(250, 100, w, h);
		menu.setBounds(50, 100, w, h);

		result.setBounds(50, 280, 350, 150);

		result.setFont(new Font("Arial", Font.PLAIN, 24));
		result.setEditable(false);

		etext.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				etext.setText("");
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});

		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(etext.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Enter Some Text then Convert");
					return;

				}

				if (menu.getSelectedItem() == "PlayFair") {
					playFairMethod();
				}
				if (menu.getSelectedItem() == "Vigenere") {
					VigenereMethod();

				}
				if (menu.getSelectedItem() == "Ceaser") {
					CaesarMethod();

				}
				if (menu.getSelectedItem() == "Hill Cipher") {
					HillMethod();
				}

				if (menu.getSelectedItem() == "RailFence") {
					railFenceMethod();

				}
			}
		});

		add(etext);
		add(result);
		add(convert);
		add(menu);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	}

	String getKey() {
		String str = JOptionPane.showInputDialog(null, "Enter Your Key");
		if (str == null) {
			JOptionPane.showMessageDialog(null, "Hey i am taking by default key as 1");
			return "1";
		}
		return str;
	}

	// Method
	void playFairMethod() {
		String key1 = getKey();
		String plainText1 = etext.getText();
		Playfair pfc1 = new Playfair(key1, plainText1);
		pfc1.cleanPlayFairKey();
		pfc1.generateCipherKey();
		String encText1 = pfc1.encryptMessage();
		result.setText(encText1);
	}

	void VigenereMethod() {
		Vigenere obj = new Vigenere();
		String Str = etext.getText();
		String Keyword = getKey();

		String str = obj.LowerToUpper(Str);
		String keyword = obj.LowerToUpper(Keyword);

		String key = obj.generateKey(str, keyword);
		String cipher_text = obj.cipherText(str, key);
		result.setText(cipher_text);
	}

	void CaesarMethod() {
		CeaserCipher obj = new CeaserCipher();

		String plaintext = etext.getText();

		try {
			int key = Integer.parseInt(getKey());
			String encryptedText = obj.encrypt(plaintext, key);
			// String decryptedText = decrypt(encryptedText, key);
			result.setText(encryptedText);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Key Should be Integer ");
		}

	}

	void HillMethod() {
		Hill obj = new Hill();

		try {
			String plaintext = etext.getText();
			int[][] keyMatrix = obj.getKeyMatrix();
			String ciphertext = obj.encrypt(plaintext, keyMatrix);
			result.setText(ciphertext);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Exception Occur In HillMethod");
		}
	}

	void railFenceMethod() {
		RailFence obj = new RailFence();
		String plaintext = etext.getText();

		try {
			int numRails = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rails:"));
			if (numRails > plaintext.length()) {
				int len=etext.getText().length();
				JOptionPane.showMessageDialog(null, "Number of Rails Must be less than Plain Text Length ( "+len+" )"+"\nPlain Text Length is "+len);
				return;
			}
			String ciphertext = obj.encrypt(plaintext, numRails);

			result.setText(ciphertext);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Number Rail Should be Integer");
		}
	}
}

class cyber {
	public static void main(String[] args) {
		new myframe();
	}

}