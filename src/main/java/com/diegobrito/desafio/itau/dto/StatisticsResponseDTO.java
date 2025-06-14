package com.diegobrito.desafio.itau.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsResponseDTO {
    private final Long count;
    private final Double avg;
    private final Double sum;
    private final Double max;
    private final Double min;

    public StatisticsResponseDTO(DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.avg = statistics.getAverage();
        this.sum = statistics.getSum();
        this.max = statistics.getMax();
        this.min = statistics.getMin();
    }

    public Long getCount() {
        return count;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getSum() {
        return sum;
    }

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
    }
}
