package com.hackathon.wildfire.constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PredictorConstants {

    /**
     * Series of relative days count.
     */
    public static List<Long> YEARLY = LongStream.range(360, 370).boxed().collect(Collectors.toList());
    public static List<Long> HALF_YEARLY = LongStream.range(170, 190).boxed().collect(Collectors.toList());
    public static List<Long> QUARTERLY = LongStream.range(80, 100).boxed().collect(Collectors.toList());
    public static List<Long> MONTHLY = LongStream.range(25, 35).boxed().collect(Collectors.toList());
    public static List<Long> BI_MONTHLY = LongStream.range(14, 17).boxed().collect(Collectors.toList());
    public static List<Long> DAILY = List.of(1L);

}
