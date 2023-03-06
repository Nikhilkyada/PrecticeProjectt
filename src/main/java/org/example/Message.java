package org.example;

public class Message {

    private String message;

    public String getMessage(){
        return message;
    }

    public void setMessage (String message){
        this.message = message;
        System.out.println(message);
    }

    public static void main(String[] args) {

        Message m = new Message();
        m.setMessage("Hello");
        System.out.println(m.getMessage());

    }
    //json response
    //{"message" : "m"}
}

