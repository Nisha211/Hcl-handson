package org.hcl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankImpl {
	public static List<BankAccount> getDetails() throws Exception {
		List<BankAccount> ar = new ArrayList<BankAccount>();
		try {

			BankAccount Bank = null;
			String line = "";
			File csvFile = new File("C:\\Users\\nisha-munirathinam3\\eclipse-workspace\\UsaaProject\\src\\org\\hcl\\Bankacct.csv");
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();// little modification
			while (line != null) {

				String[] arr = line.split(",");
				if (arr.length > 0) {
					Bank = new BankAccount();
					Bank.setName(arr[0]);
					Bank.setAge(Integer.parseInt(arr[1]));
					Bank.setGender(arr[2]);
					Bank.setBank(arr[3]);
					Bank.setCardNumber(arr[4]);
					Bank.setCreditLimit(Long.parseLong(arr[5]));
					ar.add(Bank);

				}
				line = br.readLine();
			}
			br.close();

			for (BankAccount b : ar) {
				System.out.printf("Name:%s, age:%d, Gender:%s, BankName:%s, Cardnumber:%s, CreditLimit:%d\n",
						b.getName(), b.getAge(), b.getGender(), b.getBank(), b.getCardNumber(), b.getCreditLimit());

			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}

		finally {

		}
		return ar;
	}
}