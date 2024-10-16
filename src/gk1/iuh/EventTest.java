package gk1.iuh;

import java.time.LocalDate;

public class EventTest {
    public static void main(String[] args) {
        EventList ds = new EventList(5);
        Event emp1 = new Event("E001","Hội thảo công nghệ", LocalDate.of(2024,11,10),"Hà Nội",100,20000000);
        Event emp2 = new Event("E002","Triển lãm nghệ thuật", LocalDate.of(2024,12,5),"Đà Nẵng",160,30000000);
        Event emp3 = new Event("E003","Buổi gặp mặt doanh nghiệp", LocalDate.of(2025,1,15),"TP Hồ Chí Minh",200,50000000);
        Event emp4 = new Event("E004","Lễ hội âm nhạc", LocalDate.of(2024,9,20),"Nha Trang",160,40000000);
        Event emp5 = new Event("E005","Hội thảo giáo dục", LocalDate.of(2025,3,30),"Cần Thơ",120,15000000);

        ds.addDs(emp1);
        ds.addDs(emp2);
        ds.addDs(emp3);
        ds.addDs(emp4);
        ds.addDs(emp5);

        for (Event e: ds.getDs()) {
            System.out.println(e);
        }
        emp3 = new Event("E003","Buổi gặp mặt", LocalDate.of(2025,1,15),"TP Hồ Chí Minh",200,50000000);
        System.out.println("Cập nhật sự kiện " + emp3.getEventCode() + ": " + ds.update(emp3));
        for (Event e: ds.getDs()) {
            System.out.println(e);
//        System.out.println("Cập nhật sự kiện đã diễn ra " + emp4.getEventCode() + ": " + ds.update(emp4));
//
//        System.out.println("Danh sách sự kiện có số người tham gia đông nhất trong năm 2024: ");
//        for (Event e: ds.getEventsWithMaxParsInYear(2024)) {
//            System.out.println(e);
//        }
//
//        System.out.println("Xoa su kien: " + ds.remove("E003"));
//        for (Event e: ds.getDs()) {
//            System.out.println(e);
//        }
//        ds.sort();
//        for (Event e: ds.getDs()) {
//            System.out.println(e);
        }
    }
}
