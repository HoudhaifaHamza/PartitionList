package com.houdhaifa.partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PartitionList {

    public static <T> List<List<T>> transform(List<T> initialList, int taille) {
        final AtomicInteger counter = new AtomicInteger();


        if ((initialList == null || initialList.isEmpty()) && taille <= 0)
            throw new IllegalArgumentException("initialList ne peut pas être vide et La valuer de taille doit être supérieur à 0");
        if (taille <= 0)
            throw new IllegalArgumentException("La valuer de taille doit être supérieur à 0");
        if (initialList == null || initialList.isEmpty())
            throw new IllegalArgumentException("initialList ne peut pas être vide");

        if( taille >= initialList.size()) {
            List<List<T>> result1 = Arrays.asList(initialList);
            return result1;
        }

        List<List<T>> result = initialList.stream()
                .collect(Collectors.groupingBy(x -> counter.getAndIncrement() / taille))
                .values()
                .stream()
                .collect(Collectors.toList());

        return result;

    }


}
