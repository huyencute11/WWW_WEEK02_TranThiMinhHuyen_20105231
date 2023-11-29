package www.week2.www_lab02.converters;

import java.time.LocalDate;

public class ReportDTO {
    private LocalDate time;
    private double revenue;

    public ReportDTO(LocalDate time, double revenue) {
        this.time = time;
        this.revenue = revenue;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "time=" + time +
                ", revenue=" + revenue +
                '}';
    }
}
