package andytran.apis.string.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.test.context.junit4.SpringRunner;

import andytran.apis.string.models.Trie;
import andytran.apis.string.utils.StringUtils;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PrepareForTest(StringUtils.class)
public class StringServiceImplTest {
	
	@InjectMocks
	private StringServiceImpl stringService;
	
	@Before
	public void setup(){
		PowerMockito.mockStatic(StringUtils.class);
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testReverse(){
		assertEquals("ydna", stringService.reverse("andy"));
		assertEquals("oy", stringService.reverse("yo"));
		assertEquals("nart ydna", stringService.reverse("andy tran"));
	}
	
	@Test
	public void testIsPalidrome(){
		assertEquals(true, stringService.isPalindrome("racecar"));
		assertEquals(false, stringService.isPalindrome("hello"));
	}
	
	@Test
	public void testPigLatin(){
		assertEquals("igpay", stringService.pigLatin("pig"));
		assertEquals("oveglay", stringService.pigLatin("glove"));
		assertEquals("eatway", stringService.pigLatin("eat"));
		assertEquals("omeletway", stringService.pigLatin("omelet"));
	}
	
	@Test
	public void testLongestNonRepeatingSubstring(){
		assertEquals(null, stringService.longestNonRepeatingSubstring(null));
		assertEquals("a", stringService.longestNonRepeatingSubstring("a"));
		assertEquals("abc", stringService.longestNonRepeatingSubstring("abcabcbb"));
		assertEquals("b", stringService.longestNonRepeatingSubstring("bbbbb"));
		assertEquals("EKSFORG", stringService.longestNonRepeatingSubstring("GEEKSFORGEEKS"));
	}
	
	@Test
	public void testUnscramble(){
		List<String> dummy = new ArrayList<>();
		dummy.add("quinn");
		dummy.add("question");
		dummy.add("queen");
		dummy.add("qfsdfn");
		
		when(StringUtils.searchTrie(any(Character.class),
				any(Character.class), 
				any(Trie.class)))
			.thenReturn(dummy);
		
		List<String> unscrambledWords = stringService.unscramble("qwertyuytresdftyuioknn");
		assertEquals(true, unscrambledWords.contains(dummy.get(0)));
		assertEquals(true, unscrambledWords.contains(dummy.get(1)));
		assertEquals(true, unscrambledWords.contains(dummy.get(2)));
		assertEquals(false, unscrambledWords.contains(dummy.get(3)));
	}
	
	@Test
	public void testDankify(){
		List<String> dummy = new ArrayList<>();
		dummy.add("donut");
		dummy.add("dah");
		
		when(StringUtils.searchTrie(any(Character.class),
				any(Character.class), 
				any(Trie.class)))
			.thenReturn(dummy);
		
		List<String> results = stringService.dankify("Donald Knuth");
		assertEquals(true, results.contains(dummy.get(0)));
		assertEquals(false, results.contains(dummy.get(1)));
	}
	
	@Test
	public void testLongestPalindrome(){
		assertEquals("elle", stringService.longestPalindrome("hellen"));
		assertEquals("aabbaa", stringService.longestPalindrome("aabbaabab"));
	}
	
}
