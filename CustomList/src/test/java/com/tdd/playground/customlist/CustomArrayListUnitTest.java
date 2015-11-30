package com.tdd.playground.customlist;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class CustomArrayListUnitTest {

    private CustomArrayList sut;

    @Before
    public void setUp() {

        sut = new CustomArrayList();
    }

    @Test
    public void shouldAddElement() {

        sut.add("element");

        assertThat(sut.size()).isEqualTo(1);
    }

    @Test
    public void shouldAddAsManyElementsAndSize() {

        sut.add("element");
        sut.add("element");
        sut.add("element");
        sut.add("element");

        assertThat(sut.size()).isEqualTo(4);
    }

    @Test
    public void shouldReturnEmptyWhenIsEmpty() {

        final boolean isEmpty = sut.isEmpty();

        assertThat(isEmpty).isTrue();
    }

    @Test
    public void shouldReturnNotEmptyWhenIsNotEmpty() {

        sut.add("element");

        final boolean isEmpty = sut.isEmpty();

        assertThat(isEmpty).isFalse();
    }

    @Test
    public void shouldDeleteElementAndKeepSizeUpToDate() {

        sut.add("element1");
        sut.add("element2");

        sut.delete("element2");

        assertThat(sut.size()).isEqualTo(1);
    }

    @Test
    public void shouldNotDeleteElementThatDoesntExistAndKeepSizeUpToDate() {

        sut.add("element1");

        sut.delete("element2");

        assertThat(sut.size()).isEqualTo(1);
    }

    @Test
    public void shouldReturnExpectedElementUsingGet() {

        sut.add("element1");

        final Object element = sut.get(0);

        assertThat(element).isEqualTo("element1");
        assertThat(sut.size()).isEqualTo(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExpectedExceptionWhenIndexOutOfBounds() {

        sut.add("element1");

        sut.get(1);

        fail("it shouldn't reach here!");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExpectedExceptionWhenIndexOutOfBoundsNegative() {

        sut.add("element1");

        sut.get(-1);

        fail("it shouldn't reach here!");
    }

    @Test
    public void shouldReturnFalseWhenElementIsNotContained() {

        final boolean contains = sut.contains("element");

        assertThat(contains).isFalse();
    }

    @Test
    public void shouldReturnTrueWhenElementIsContained() {

        sut.add("element");

        final boolean contains = sut.contains("element");

        assertThat(contains).isTrue();
    }

    @Test
    public void shouldReturnValidIndexWhenNotFound() {

        final int indexOf = sut.indexOf("element");

        assertThat(indexOf).isEqualTo(-1);
    }

    @Test
    public void shouldReturnValidIndexWhenFound() {

        sut.add("element1");
        sut.add("element2");
        sut.add("element3");
        sut.add("element4");

        final int indexOf = sut.indexOf("element4");

        assertThat(indexOf).isEqualTo(3);
    }

    @Test
    public void shouldClearAllListWhenClear() {

        sut.add("element");

        sut.clear();

        assertThat(sut.isEmpty()).isTrue();
    }

    @Test
    public void shouldInitializeListWithInitialCapacity() {

        sut = new CustomArrayList(10);

        assertThat(sut.size()).isEqualTo(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptinGivenIllegalInitialCapacity() {

        sut = new CustomArrayList(-1);

        fail("it shouldn't reach here");
    }

    @Test
    public void shouldAddAllElements() {

        sut.addAll(new Object[]{"element1", "element2"});
    }
}
