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
		assertEquals(stringService.reverse("andy"), "ydna");
		assertEquals(stringService.reverse("yo"), "oy");
		assertEquals(stringService.reverse("andy tran"), "nart ydna");
	}
	
	@Test
	public void testIsPalidrome(){
		assertEquals(stringService.isPalindrome("racecar"), true);
		assertEquals(stringService.isPalindrome("hello"), false);
	}
	
	@Test
	public void testPigLatin(){
		assertEquals(stringService.pigLatin("pig"), "igpay");
		assertEquals(stringService.pigLatin("glove"), "oveglay");
		assertEquals(stringService.pigLatin("eat"), "eatway");
		assertEquals(stringService.pigLatin("omelet"), "omeletway");
	}
	
}
