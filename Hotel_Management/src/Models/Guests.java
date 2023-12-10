
package Models;

public class Guests {
    private int bookingId;
    private String name;
    private String phone;
    private String identityNumber;
    private int room;

    public Guests(int bookingId, String name, String phone, String identityNumber, int room) {
        this.bookingId = bookingId;
        this.name = name;
        this.phone = phone;
        this.identityNumber = identityNumber;
        this.room = room;
    }
    
    public int getBookingId() {
        return bookingId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getIdentityNumber() {
        return identityNumber;
    }
    
    public int getRoom() {
        return room;
    }
}


