package ua.com.codespace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.com.codespace.entities.Country;
import ua.com.codespace.entities.Ranking;

import java.util.*;

@SpringBootApplication
public class CountryRankingApplication {

	public static void main(String[] args) {
		/*SpringApplication.run(CountryRankingApplication.class, args);*/
		List<Ranking> rankingList = getRankingList();
		System.out.println(rankingList);
	}

	private static List<Ranking> getRankingList( ) {
		List<Ranking> rankingList = new ArrayList<>();
		for (int i = 1990; i < 2000; i++){
			rankingList.add(new Ranking("Population", i, getRankingMap()));
			rankingList.add(new Ranking("AverageLife", i, getRankingMap()));
			rankingList.add(new Ranking("Area", i, getRankingMap()));
		}
		return rankingList;
	}

	private static Map<Country, Integer> getRankingMap() {
		Map<Country, Integer> rankingMap = new HashMap<>();
		rankingMap.put(new Country("Ukraine"), new Random().nextInt(Integer.MAX_VALUE));
		rankingMap.put(new Country("Turkey"), new Random().nextInt(Integer.MAX_VALUE));
		rankingMap.put(new Country("England"), new Random().nextInt(Integer.MAX_VALUE));
		return rankingMap;
	}
}
