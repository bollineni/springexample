package info._7chapters.spring.core.advancedContainer._07I18n;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;

public class I18nApp { 
	public static void main(String args[]) {

//		ResourceBundle r = ResourceBundle.getBundle("com/excel/core_01/applicationContextContainer/_07I18n/app");

		Locale locale = new Locale("en", "gb");
//		Locale locale = new Locale("en");
		ResourceBundle r = ResourceBundle.getBundle("com/excel/core_01/applicationContextContainer/_07I18n/app",locale);

		JFrame jf = new JFrame();

		Container cp = jf.getContentPane();

		JButton b1 = new JButton(r.getString("str1"));
		JButton b2 = new JButton(r.getString("str2"));
		JButton b3 = new JButton(r.getString("str3"));
		JButton b4 = new JButton(r.getString("str4"));

		cp.setLayout(new FlowLayout());

		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
		cp.add(b4);

		jf.pack();

		jf.show();
	}
}
