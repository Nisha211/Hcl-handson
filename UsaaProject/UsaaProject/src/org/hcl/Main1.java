package org.hcl;

import java.util.List;
import java.util.Set;

public class Main1 {

	public static void main(String[] args) {
		try {

			List<BankAccount> banklist = BankImpl.getDetails();
			
			List<BankTransaction> bank1 = BankTransactionImpl.getTransaction();
			
			List<BankAccount> lists = BankManager.getMappedAccount(banklist, bank1);
			//System.out.println(lists);
			System.out.format("\n%-5s %-20s %-20s %-20s %-20s %-20s %-20s", "S.No", "Name", "Bank", "Age", "Gender",
					"TranscationDate", "TransactionAmount");

			for (BankAccount bank : lists) {

				Set<String> keysets = bank.getMapped().keySet();
				int sno = 1;
				int index = 0;
				for (String key : keysets) {
					
					List<BankTransaction> list = bank.getMapped().get(key);
					for (BankTransaction bnk : list) {
						if (index == 0)
							System.out.format("\n%-5s %-20s %-20s %-20s %-20s %-20s %-20s", sno, bank.getName(),
									bank.getBank(), bank.getAge(), bank.getGender(), bnk.getTransactionDate(),
									bnk.getAmount());
						else
							System.out.format("\n%-5s %-20s %-20s %-20s %-20s %-20s %-20s", sno, bank.getName(),
									bank.getBank(), bank.getAge(), bank.getGender(), bnk.getTransactionDate(),
									bnk.getAmount());
						index++;
						sno++;
					}
					
				}
				

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
