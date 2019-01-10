package org.chatbot.services;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.chatbot.model.DataBase;
import org.chatbot.model.QA;
import org.springframework.stereotype.Service;


@Service
public class QAService {

	private DataBase db;

	
	
	public String getAnswer(String question) {
		return db.answer(question);
	}
	
	public DataBase getDb() {
		return db;
	}

	// Init some users for testing
	@PostConstruct
	private void iniDataForTesting() {

		db = new DataBase();
		QA q1 = new QA("what is litecoin?",
				"Litecoin (LTC) is a peer-to-peer cryptocurrency and open source software project released under the MIT/X11 license. Litecoin is one of the largest, oldest, and most used cryptocurrencies in the world. Similar to Bitcoin, Litecoin uses blockchain technology to process transactions."
						+ "So what's the difference? To process a block, Litecoin takes 2.5 minutes rather than Bitcoins 10 minutes. This allows for faster processing times. Litecoin also has the capability to produce a total of 84 million units, compared to Bitcoins 21 million. In addition, Litecoin uses scrypt in its proof-of-work algorithm, a sequential memory-hard function requiring asymptotically more memory "
						+ "than an algorithm which is not memory-hard.");
		q1.add("litecoin");

		QA q2 = new QA("where can i buy litecoin?",
				"There are many websites and applications where you can buy and sell Litecoin, but make sure the exchange you are using is trusted and secure. "
						+ "Here are some exchanges that are trusted in the cryptocurrency community: coinbase, Bittrex , Quadrigacx");
		q2.add("where can i sell litecoin?");
		q2.add("how to buy litecoin?");
		q2.add("how to sell litecoin?");
		q2.add("how can i sell my litecoin?");
		q2.add("sell");
		q2.add("buy");

		QA q3 = new QA("where can i spend litecoin?",
				"Litecoin is in the top ten of all cryptocurrencies by market capitalization. Websites are rapidly adopting Litecoin as a method of payment as well. If you yourself want to accept LTC as a business, you can refer to these merchant manuals.");
		q3.add("how to use litecoin?");
		q3.add("where can i use my litecoin?");
		q3.add("use");
		q3.add("use litecoin");

		QA q4 = new QA("where can i discuss litecoin?",
				"The Litecoin community is extremely kind and robust. There are many forums and places where you can discuss Litecoin with others who are interested in the currency.");
		q4.add("discuss");

		QA q5 = new QA("where can i securely store litecoin?",
				"Litecoin (and other cryptocurrencies) is stored in a digital wallet. When storing Litecoin, you want to make sure you trust the place you store them. This is why it is best to store them yourself through the electrum wallet.");
		q5.add("where to keep my litecoin?");
		q5.add("where to hide my litecoin?");

		QA q6 = new QA("how much litecoin worth?", "litecoin worth around 1$");
		q6.add("what is litecoin exchange rate?");
		q6.add("what is the price of litecoin");

		QA q7 = new QA("hello", "hello");
		q7.add("hi");
		q7.add("hey");

		db.add(q1);
		db.add(q2);
		db.add(q3);
		db.add(q4);
		db.add(q5);
		db.add(q6);
		db.add(q7);

	}
}
