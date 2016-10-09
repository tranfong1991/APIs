package andytran.apis.services.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StringServiceImplTest {
	
	@InjectMocks
	private StringServiceImpl stringService;
	
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
	public void testLongestSubstring(){
		assertEquals(null, stringService.longestSubstring(null));
		assertEquals("a", stringService.longestSubstring("a"));
		assertEquals("abc", stringService.longestSubstring("abcabcbb"));
		assertEquals("b", stringService.longestSubstring("bbbbb"));
		assertEquals("EKSFORG", stringService.longestSubstring("GEEKSFORGEEKS"));
	}
	
}
