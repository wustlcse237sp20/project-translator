package destination;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Keyword {
	
	private String searchUrl, keyword;
	private Map<String,Integer> map;
	private int howMany;
	
	
	
	public Keyword(String keyword, int howMany) {
		this.howMany = howMany;
		this.keyword = keyword;
		this.searchUrl = "https://www.google.com/search?safe=active&sxsrf=ALeKk02xGe5IKSx5SUBgyhCycaYUvl175Q%3A1588595551355&source=hp&ei=XwuwXreeE860tQa0jKCYCw&q=" + keyword +
				"+place+to+visit&gs_lcp=CgZwc3ktYWIQAzIICCEQFhAdEB4yCAghEBYQHRAeMggIIRAWEB0QHjIICCEQFhAdEB4yCAghEBYQHRAeMggIIRAWEB0QHjIICCEQFhAdEB4yCAghEBYQHRAeMggIIRAWEB0QHjIICCEQFhAdEB46BwgjEOoCECc6BAgjECc6BQgAEIMBOgIIADoECAAQQzoFCAAQkQI6BwgAEBQQhwI6BggAEBYQHlC4YVjmnwFgvqEBaANwAHgBgAFtiAHnDpIBBDI0LjOYAQCgAQGqAQdnd3Mtd2l6sAEK&sclient=psy-ab&ved=0ahUKEwj3yZzMm5rpAhVOWs0KHTQGCLMQ4dUDCAk&uact=5";
		this.map = new HashMap<String, Integer>();
	}
	
	public List<String> getKeywords() throws IOException {
		Document doc = Jsoup.connect(this.searchUrl).get();
		String result = doc.body().text();
		String[] resultParsed = result.split(" ");
		for (String s : resultParsed) {
			if (s != null) {
				s = s.toLowerCase();
				map.compute(s, (key,val) -> (val == null) ? 1 : val + 1);
			}
		}
		List<Map.Entry<String, Integer>> sorting = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(sorting, new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue() - o1.getValue();
			}
			
		});
		List<String> fin = new LinkedList<String>();
		Set<String> filter = new HashSet<String>();
		String[] f = {"in", "...", "-", "a", "the", "attractions", "the", "to", "on", "do", "cached", "and", "is", "place", "places", "search", "things", "more", "moreover", "with", "what"
				,"best", "are", "of", "at", "go", "similar", "shopping", "you", "must", "for", "most", "blog", "accessibility", "feedback", "your", "visit", "results", "click", "it", "as"};
		for (String s : f) {
			filter.add(s);
		}
		filter.add(keyword.toLowerCase());
		for (Map.Entry<String, Integer> e : sorting) {
			if (fin.size() < this.howMany && !filter.contains(e.getKey()) && Pattern.compile("[a-z]*").matcher(e.getKey()).matches()) {
				
				fin.add(e.getKey());
			}
		}
		System.out.println(fin.toString());
		return fin;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Keyword k = new Keyword("tibet", 20);
		k.getKeywords();
	}

}
