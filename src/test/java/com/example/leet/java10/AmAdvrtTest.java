package com.example.leet.java10;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class AmAdvrtTest {

  @Test
  public void testCheckPowerOfTwo(){
    assertThat(AmAdvrt.checkPowerOfTwo(31), is(false));
    assertThat(AmAdvrt.checkPowerOfTwo(32), is(true));
    assertThat(AmAdvrt.checkPowerOfTwo(88), is(false));
    assertThat(AmAdvrt.checkPowerOfTwo(0), is(false));
    assertThat(AmAdvrt.checkPowerOfTwo(1), is(true));
  }

  @Test
  public void testCheckPowerOfTwo1(){
    assertThat(AmAdvrt.checkPowerOfTwo1(31), is(false));
    assertThat(AmAdvrt.checkPowerOfTwo1(32), is(true));
    assertThat(AmAdvrt.checkPowerOfTwo1(88), is(false));
    assertThat(AmAdvrt.checkPowerOfTwo1(0), is(false));
    assertThat(AmAdvrt.checkPowerOfTwo1(1), is(true));
  }

  @Test
  public void anagramTest(){
    AmAdvrt am = new AmAdvrt();

    assertThat(am.anagrams("A man’s rag", "anagrams"), is(true));
    assertThat(am.anagrams("below", "elbow"), is(true));
    assertThat(am.anagrams("A man’s rag", "anagram"), is(false));
  }

}