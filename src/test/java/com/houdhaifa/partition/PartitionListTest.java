package com.houdhaifa.partition;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PartitionListTest {

    static List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 6, 7, 5, 2, 1, 4, 7, 5);
    static List<String> stringList = Arrays.asList("c", "f", "g", "k", "d", "a","k");
    static List<Integer> emptyList = Arrays.asList();


    @Test
    public void should_throw_exception_when_taille_is_0() {
        try {
            PartitionList.transform(numberList, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("La valuer de taille doit être supérieur à 0", e.getMessage());
        }
    }

    @Test
    public void should_throw_exception_when_list_is_empty() {
        try {
            PartitionList.transform(emptyList, 2);
        } catch (IllegalArgumentException e) {
            assertEquals("initialList ne peut pas être vide", e.getMessage());
        }
    }

    @Test
    public void should_throw_exception_when_list_is_empty_and_taille_is_0() {
        try {
            PartitionList.transform(emptyList, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("initialList ne peut pas être vide et La valuer de taille doit être supérieur à 0", e.getMessage());
        }
    }

    @Test
    public void should_return_a_list_of_1_list_with_same_length() {
        List<List<Integer>> partition0 = Arrays.asList(Arrays.asList(1, 2, 3, 4, 6, 7, 5, 2, 1, 4, 7, 5));

        assertEquals(partition0, PartitionList.transform(numberList, 13));
    }

    @Test
    public void should_return_a_list_of_6_list_with_length_2_each() {
        List<List<Integer>> partition1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(6, 7), Arrays.asList(5, 2), Arrays.asList(1, 4), Arrays.asList(7, 5));

        assertEquals(partition1, PartitionList.transform(numberList, 2));
    }

    @Test
    public void should_return_a_list_of_4_list_with_length_3_each() {
        List<List<Integer>> partition2 = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 6, 7), Arrays.asList(5, 2, 1), Arrays.asList(4, 7, 5));

        assertEquals(partition2, PartitionList.transform(numberList, 3));
    }

    @Test
    public void should_return_a_list_of_3_list_with_length_5_of_2_first_list_and_length_2_of_last_list() {
        List<List<Integer>> partition3 = Arrays.asList(Arrays.asList(1, 2, 3, 4, 6), Arrays.asList(7, 5, 2, 1, 4), Arrays.asList(7,5));

        assertEquals(partition3, PartitionList.transform(numberList, 5));
    }


    @Test
    public void should_return_a_list_of_3_list_with_length_3_of_2_first_list_and_length_1_of_last_list() {
        List<List<String>> partition4 = Arrays.asList(Arrays.asList("c", "f", "g"), Arrays.asList("k", "d", "a"), Arrays.asList("k"));

        assertEquals(partition4, PartitionList.transform(stringList, 3));
    }

    @Test
    public void should_return_a_list_of_4_list_with_length_2_of_3_first_list_and_length_1_of_last_list() {
        List<List<String>> partition5 = Arrays.asList(Arrays.asList("c", "f"), Arrays.asList( "g", "k"), Arrays.asList("d", "a"),Arrays.asList("k"));

        assertEquals(partition5, PartitionList.transform(stringList, 2));
    }



}