package org.hcl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class BankManager {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static List<BankAccount> getMappedAccount(List<BankAccount> banklists,
			List<BankTransaction> banktransactions) throws IOException {
		System.out.println("Enter the user name to search");
		String name = bufferedReader.readLine();

		BankAccount newe = new BankAccount();
		newe.setName(name);

		List<BankAccount> bankUsers = new ArrayList<>();

		for (BankAccount bank : banklists) {
			if (bank.getName().equals(name)) {
				bankUsers.add(new BankAccount(bank.getName(), bank.getAge(), bank.getGender(), bank.getBank(),
						bank.getCardNumber(), bank.getCreditLimit()));

			}
		}

		List<BankAccount> finalMappedUser = new ArrayList<>();

		for (BankAccount bnk : bankUsers) {
			//System.err.println(bnk.getName());
			BankAccount banks = getTransactions(bnk, banktransactions);
			if (banks != null) {
				finalMappedUser.add(banks);
			}
		}

		return finalMappedUser;
	}

	private static BankAccount getTransactions(BankAccount bank, List<BankTransaction> lists) {
		List<BankTransaction> tlist = new ArrayList<>();
		for (BankTransaction banktrans : lists) {
			if (banktrans.getCardNumber().equals(bank.getCardNumber())) {
				tlist.add(banktrans);
			}
		}

		Map<String, List<BankTransaction>> finalbank = new TreeMap<>();

		finalbank.put(bank.getBank(), tlist);

		return new BankAccount(finalbank, bank.getName(), bank.getAge(), bank.getGender(), bank.getBank(),
				bank.getCardNumber(), bank.getCreditLimit());

	}

}